--
-- PostgreSQL database dump
--

-- Dumped from database version 15.10
-- Dumped by pg_dump version 16.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: _heroku; Type: SCHEMA; Schema: -; Owner: heroku_admin
--

CREATE SCHEMA _heroku;


ALTER SCHEMA _heroku OWNER TO heroku_admin;

--
-- Name: heroku_ext; Type: SCHEMA; Schema: -; Owner: u2m96f8s5m4e6c
--

CREATE SCHEMA heroku_ext;


ALTER SCHEMA heroku_ext OWNER TO u2m96f8s5m4e6c;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: u2m96f8s5m4e6c
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO u2m96f8s5m4e6c;

--
-- Name: pg_stat_statements; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS pg_stat_statements WITH SCHEMA public;


--
-- Name: EXTENSION pg_stat_statements; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pg_stat_statements IS 'track planning and execution statistics of all SQL statements executed';


--
-- Name: create_ext(); Type: FUNCTION; Schema: _heroku; Owner: heroku_admin
--

CREATE FUNCTION _heroku.create_ext() RETURNS event_trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$

DECLARE

  schemaname TEXT;
  databaseowner TEXT;

  r RECORD;

BEGIN

  IF tg_tag = 'CREATE EXTENSION' and current_user != 'rds_superuser' THEN
    FOR r IN SELECT * FROM pg_event_trigger_ddl_commands()
    LOOP
        CONTINUE WHEN r.command_tag != 'CREATE EXTENSION' OR r.object_type != 'extension';

        schemaname = (
            SELECT n.nspname
            FROM pg_catalog.pg_extension AS e
            INNER JOIN pg_catalog.pg_namespace AS n
            ON e.extnamespace = n.oid
            WHERE e.oid = r.objid
        );

        databaseowner = (
            SELECT pg_catalog.pg_get_userbyid(d.datdba)
            FROM pg_catalog.pg_database d
            WHERE d.datname = current_database()
        );
        --RAISE NOTICE 'Record for event trigger %, objid: %,tag: %, current_user: %, schema: %, database_owenr: %', r.object_identity, r.objid, tg_tag, current_user, schemaname, databaseowner;
        IF r.object_identity = 'address_standardizer_data_us' THEN
            PERFORM _heroku.grant_table_if_exists(schemaname, 'SELECT, UPDATE, INSERT, DELETE', databaseowner, 'us_gaz');
            PERFORM _heroku.grant_table_if_exists(schemaname, 'SELECT, UPDATE, INSERT, DELETE', databaseowner, 'us_lex');
            PERFORM _heroku.grant_table_if_exists(schemaname, 'SELECT, UPDATE, INSERT, DELETE', databaseowner, 'us_rules');
        ELSIF r.object_identity = 'amcheck' THEN
            EXECUTE format('GRANT EXECUTE ON FUNCTION %I.bt_index_check TO %I;', schemaname, databaseowner);
            EXECUTE format('GRANT EXECUTE ON FUNCTION %I.bt_index_parent_check TO %I;', schemaname, databaseowner);
        ELSIF r.object_identity = 'dict_int' THEN
            EXECUTE format('ALTER TEXT SEARCH DICTIONARY %I.intdict OWNER TO %I;', schemaname, databaseowner);
        ELSIF r.object_identity = 'pg_partman' THEN
            PERFORM _heroku.grant_table_if_exists(schemaname, 'SELECT, UPDATE, INSERT, DELETE', databaseowner, 'part_config');
            PERFORM _heroku.grant_table_if_exists(schemaname, 'SELECT, UPDATE, INSERT, DELETE', databaseowner, 'part_config_sub');
            PERFORM _heroku.grant_table_if_exists(schemaname, 'SELECT, UPDATE, INSERT, DELETE', databaseowner, 'custom_time_partitions');
        ELSIF r.object_identity = 'pg_stat_statements' THEN
            EXECUTE format('GRANT EXECUTE ON FUNCTION %I.pg_stat_statements_reset TO %I;', schemaname, databaseowner);
        ELSIF r.object_identity = 'postgis' THEN
            PERFORM _heroku.postgis_after_create();
        ELSIF r.object_identity = 'postgis_raster' THEN
            PERFORM _heroku.postgis_after_create();
            PERFORM _heroku.grant_table_if_exists(schemaname, 'SELECT', databaseowner, 'raster_columns');
            PERFORM _heroku.grant_table_if_exists(schemaname, 'SELECT', databaseowner, 'raster_overviews');
        ELSIF r.object_identity = 'postgis_topology' THEN
            PERFORM _heroku.postgis_after_create();
            EXECUTE format('GRANT USAGE ON SCHEMA topology TO %I;', databaseowner);
            EXECUTE format('GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA topology TO %I;', databaseowner);
            PERFORM _heroku.grant_table_if_exists('topology', 'SELECT, UPDATE, INSERT, DELETE', databaseowner);
            EXECUTE format('GRANT USAGE, SELECT, UPDATE ON ALL SEQUENCES IN SCHEMA topology TO %I;', databaseowner);
        ELSIF r.object_identity = 'postgis_tiger_geocoder' THEN
            PERFORM _heroku.postgis_after_create();
            EXECUTE format('GRANT USAGE ON SCHEMA tiger TO %I;', databaseowner);
            EXECUTE format('GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA tiger TO %I;', databaseowner);
            PERFORM _heroku.grant_table_if_exists('tiger', 'SELECT, UPDATE, INSERT, DELETE', databaseowner);

            EXECUTE format('GRANT USAGE ON SCHEMA tiger_data TO %I;', databaseowner);
            EXECUTE format('GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA tiger_data TO %I;', databaseowner);
            PERFORM _heroku.grant_table_if_exists('tiger_data', 'SELECT, UPDATE, INSERT, DELETE', databaseowner);
        END IF;
    END LOOP;
  END IF;
END;
$$;


ALTER FUNCTION _heroku.create_ext() OWNER TO heroku_admin;

--
-- Name: drop_ext(); Type: FUNCTION; Schema: _heroku; Owner: heroku_admin
--

CREATE FUNCTION _heroku.drop_ext() RETURNS event_trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$

DECLARE

  schemaname TEXT;
  databaseowner TEXT;

  r RECORD;

BEGIN

  IF tg_tag = 'DROP EXTENSION' and current_user != 'rds_superuser' THEN
    FOR r IN SELECT * FROM pg_event_trigger_dropped_objects()
    LOOP
      CONTINUE WHEN r.object_type != 'extension';

      databaseowner = (
            SELECT pg_catalog.pg_get_userbyid(d.datdba)
            FROM pg_catalog.pg_database d
            WHERE d.datname = current_database()
      );

      --RAISE NOTICE 'Record for event trigger %, objid: %,tag: %, current_user: %, database_owner: %, schemaname: %', r.object_identity, r.objid, tg_tag, current_user, databaseowner, r.schema_name;

      IF r.object_identity = 'postgis_topology' THEN
          EXECUTE format('DROP SCHEMA IF EXISTS topology');
      END IF;
    END LOOP;

  END IF;
END;
$$;


ALTER FUNCTION _heroku.drop_ext() OWNER TO heroku_admin;

--
-- Name: extension_before_drop(); Type: FUNCTION; Schema: _heroku; Owner: heroku_admin
--

CREATE FUNCTION _heroku.extension_before_drop() RETURNS event_trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$

DECLARE

  query TEXT;

BEGIN
  query = (SELECT current_query());

  -- RAISE NOTICE 'executing extension_before_drop: tg_event: %, tg_tag: %, current_user: %, session_user: %, query: %', tg_event, tg_tag, current_user, session_user, query;
  IF tg_tag = 'DROP EXTENSION' and not pg_has_role(session_user, 'rds_superuser', 'MEMBER') THEN
    -- DROP EXTENSION [ IF EXISTS ] name [, ...] [ CASCADE | RESTRICT ]
    IF (regexp_match(query, 'DROP\s+EXTENSION\s+(IF\s+EXISTS)?.*(plpgsql)', 'i') IS NOT NULL) THEN
      RAISE EXCEPTION 'The plpgsql extension is required for database management and cannot be dropped.';
    END IF;
  END IF;
END;
$$;


ALTER FUNCTION _heroku.extension_before_drop() OWNER TO heroku_admin;

--
-- Name: grant_table_if_exists(text, text, text, text); Type: FUNCTION; Schema: _heroku; Owner: heroku_admin
--

CREATE FUNCTION _heroku.grant_table_if_exists(alias_schemaname text, grants text, databaseowner text, alias_tablename text DEFAULT NULL::text) RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$

BEGIN

  IF alias_tablename IS NULL THEN
    EXECUTE format('GRANT %s ON ALL TABLES IN SCHEMA %I TO %I;', grants, alias_schemaname, databaseowner);
  ELSE
    IF EXISTS (SELECT 1 FROM pg_tables WHERE pg_tables.schemaname = alias_schemaname AND pg_tables.tablename = alias_tablename) THEN
      EXECUTE format('GRANT %s ON TABLE %I.%I TO %I;', grants, alias_schemaname, alias_tablename, databaseowner);
    END IF;
  END IF;
END;
$$;


ALTER FUNCTION _heroku.grant_table_if_exists(alias_schemaname text, grants text, databaseowner text, alias_tablename text) OWNER TO heroku_admin;

--
-- Name: postgis_after_create(); Type: FUNCTION; Schema: _heroku; Owner: heroku_admin
--

CREATE FUNCTION _heroku.postgis_after_create() RETURNS void
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
DECLARE
    schemaname TEXT;
    databaseowner TEXT;
BEGIN
    schemaname = (
        SELECT n.nspname
        FROM pg_catalog.pg_extension AS e
        INNER JOIN pg_catalog.pg_namespace AS n ON e.extnamespace = n.oid
        WHERE e.extname = 'postgis'
    );
    databaseowner = (
        SELECT pg_catalog.pg_get_userbyid(d.datdba)
        FROM pg_catalog.pg_database d
        WHERE d.datname = current_database()
    );

    EXECUTE format('GRANT EXECUTE ON FUNCTION %I.st_tileenvelope TO %I;', schemaname, databaseowner);
    EXECUTE format('GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE %I.spatial_ref_sys TO %I;', schemaname, databaseowner);
END;
$$;


ALTER FUNCTION _heroku.postgis_after_create() OWNER TO heroku_admin;

--
-- Name: validate_extension(); Type: FUNCTION; Schema: _heroku; Owner: heroku_admin
--

CREATE FUNCTION _heroku.validate_extension() RETURNS event_trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$

DECLARE

  schemaname TEXT;
  r RECORD;

BEGIN

  IF tg_tag = 'CREATE EXTENSION' and current_user != 'rds_superuser' THEN
    FOR r IN SELECT * FROM pg_event_trigger_ddl_commands()
    LOOP
      CONTINUE WHEN r.command_tag != 'CREATE EXTENSION' OR r.object_type != 'extension';

      schemaname = (
        SELECT n.nspname
        FROM pg_catalog.pg_extension AS e
        INNER JOIN pg_catalog.pg_namespace AS n
        ON e.extnamespace = n.oid
        WHERE e.oid = r.objid
      );

      IF schemaname = '_heroku' THEN
        RAISE EXCEPTION 'Creating extensions in the _heroku schema is not allowed';
      END IF;
    END LOOP;
  END IF;
END;
$$;


ALTER FUNCTION _heroku.validate_extension() OWNER TO heroku_admin;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: u2m96f8s5m4e6c
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.hibernate_sequence OWNER TO u2m96f8s5m4e6c;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: image; Type: TABLE; Schema: public; Owner: u2m96f8s5m4e6c
--

CREATE TABLE public.image (
    id integer NOT NULL,
    url character varying(255)
);


ALTER TABLE public.image OWNER TO u2m96f8s5m4e6c;

--
-- Name: project; Type: TABLE; Schema: public; Owner: u2m96f8s5m4e6c
--

CREATE TABLE public.project (
    id integer NOT NULL,
    locatie_en text,
    locatie_nl text,
    locatie_zh text,
    text_en text,
    text_nl text,
    text_zh text,
    titel_en text,
    titel_nl text,
    titel_zh text,
    banner_image_id integer,
    front_page_image_id integer,
    "order" integer DEFAULT 1 NOT NULL
);


ALTER TABLE public.project OWNER TO u2m96f8s5m4e6c;

--
-- Name: project_images; Type: TABLE; Schema: public; Owner: u2m96f8s5m4e6c
--

CREATE TABLE public.project_images (
    project_id integer NOT NULL,
    images_id integer NOT NULL
);


ALTER TABLE public.project_images OWNER TO u2m96f8s5m4e6c;

--
-- Data for Name: image; Type: TABLE DATA; Schema: public; Owner: u2m96f8s5m4e6c
--

COPY public.image (id, url) FROM stdin;
1	http://res.cloudinary.com/bag187/image/upload/v1553278411/zkyui9kbkrprb302k5h3.jpg
2	http://res.cloudinary.com/bag187/image/upload/v1553278413/x1crsxkyen1rajjanvor.jpg
3	http://res.cloudinary.com/bag187/image/upload/v1553278415/f6n5ksvmur7f5pe9kq6c.jpg
5	http://res.cloudinary.com/bag187/image/upload/v1553278416/scbwm2rcpbyftgfeemfh.jpg
6	http://res.cloudinary.com/bag187/image/upload/v1553278417/mwdsuq5fzwcxsmlueyd9.jpg
8	http://res.cloudinary.com/bag187/image/upload/v1553278419/y8sc9utdv1tjutfvplqm.jpg
9	http://res.cloudinary.com/bag187/image/upload/v1553278420/xpj3sedwjonj9ktjzen8.jpg
10	http://res.cloudinary.com/bag187/image/upload/v1553278421/fxlgr3fs9akltyfvhybs.jpg
12	http://res.cloudinary.com/bag187/image/upload/v1553278423/bytn9yzrftk8t3c1dt1j.jpg
13	http://res.cloudinary.com/bag187/image/upload/v1553278425/ifoyg7gc8n3dqobyn09f.jpg
14	http://res.cloudinary.com/bag187/image/upload/v1553278427/y6hsqkrxp7rmn5vdktp6.jpg
15	http://res.cloudinary.com/bag187/image/upload/v1553278429/uaycliffxym1fxjhwqra.jpg
16	http://res.cloudinary.com/bag187/image/upload/v1553278431/possfetlclbtq6rxqc4v.jpg
17	http://res.cloudinary.com/bag187/image/upload/v1553278433/gxkklwmhehztifmkj8h5.jpg
18	http://res.cloudinary.com/bag187/image/upload/v1553278435/pfgcoph0rvo6ic4l96of.jpg
19	http://res.cloudinary.com/bag187/image/upload/v1553278436/wqh81genasfbxevvvhuj.jpg
20	http://res.cloudinary.com/bag187/image/upload/v1553278438/pmo4vruhirgbqminyabv.jpg
21	http://res.cloudinary.com/bag187/image/upload/v1553278440/vq6qmarpcjfiy7lupc0y.jpg
23	http://res.cloudinary.com/bag187/image/upload/v1553278443/judhogjpp3bfhy4itnqt.jpg
24	http://res.cloudinary.com/bag187/image/upload/v1553278444/tze8l9qdob7qkfnhbsyu.jpg
26	http://res.cloudinary.com/bag187/image/upload/v1553278446/qn74al5upaw0ded4mh90.jpg
27	http://res.cloudinary.com/bag187/image/upload/v1553278448/ynmfsvggzr0m8ryvpgnm.jpg
29	http://res.cloudinary.com/bag187/image/upload/v1553278450/sfpico9iw9b5ofjj8jri.jpg
30	http://res.cloudinary.com/bag187/image/upload/v1553278452/mwywnd6ofrgnqjcfhj8d.jpg
31	http://res.cloudinary.com/bag187/image/upload/v1553278453/qyfxvxv8mnoabkpwehx7.jpg
33	http://res.cloudinary.com/bag187/image/upload/v1553278455/zg4t1t04lsjuh8ojr80q.jpg
34	http://res.cloudinary.com/bag187/image/upload/v1553278457/oy3wmvjgpn2to4ovxzot.jpg
36	http://res.cloudinary.com/bag187/image/upload/v1553278459/zstk5m96dfedao6ilwmq.jpg
37	http://res.cloudinary.com/bag187/image/upload/v1553278461/t1nsneygs66prlevehxk.jpg
38	http://res.cloudinary.com/bag187/image/upload/v1553278463/gsvgwn8dqekqv0gegzsp.jpg
40	http://res.cloudinary.com/bag187/image/upload/v1553278464/je4liontasdqiso1fwut.jpg
41	http://res.cloudinary.com/bag187/image/upload/v1553278465/nh6muxcbt37sildpwbhg.jpg
43	http://res.cloudinary.com/bag187/image/upload/v1553278467/dyvfefrwpxmi8d8kfmxp.jpg
44	http://res.cloudinary.com/bag187/image/upload/v1553278469/fzhlcpwo7owpjv63ukbe.jpg
45	http://res.cloudinary.com/bag187/image/upload/v1553278472/vuxh0tbj5wep048s6n1k.jpg
46	http://res.cloudinary.com/bag187/image/upload/v1553278474/qmviircr8o3bwwlpczgp.jpg
47	http://res.cloudinary.com/bag187/image/upload/v1553278475/oulorlp6xacbzhc76eq6.jpg
49	http://res.cloudinary.com/bag187/image/upload/v1553278476/y5bjqttbzaraq4lvnwvr.jpg
50	http://res.cloudinary.com/bag187/image/upload/v1553278478/cpbgy3hewppj3fj5vyag.jpg
51	http://res.cloudinary.com/bag187/image/upload/v1553278479/rbg5ugpo8e3cvxoeflxr.jpg
53	https://verkenjegeest.com/wp-content/uploads/2016/08/23.-Liefde-die-te-mooi-was-om-waar-te-zijn.jpg
54	http://res.cloudinary.com/bag187/image/upload/v1553443912/lskikwfqtkl5ks0j8a1o.jpg
55	http://res.cloudinary.com/bag187/image/upload/v1553443912/lskikwfqtkl5ks0j8a1o.jpg
56	http://res.cloudinary.com/bag187/image/upload/v1553717094/dfatzmxtfx7zhz0j1b3r.jpg
57	http://res.cloudinary.com/bag187/image/upload/v1553717166/jxst9uiuceq1lyfwylsv.jpg
58	http://res.cloudinary.com/bag187/image/upload/v1554067423/lonvtbsalj0f6m9huld0.jpg
59	http://res.cloudinary.com/bag187/image/upload/v1554911315/ah7jcdq672ambpm1betz.jpg
60	http://res.cloudinary.com/bag187/image/upload/v1554978947/r9eaooodz1u5i7cllqk3.jpg
\.


--
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: u2m96f8s5m4e6c
--

COPY public.project (id, locatie_en, locatie_nl, locatie_zh, text_en, text_nl, text_zh, titel_en, titel_nl, titel_zh, banner_image_id, front_page_image_id, "order") FROM stdin;
7	ENRISH\t	Amsterdam	asdf	asdf	In opdracht van KSH is een kinderdag verblijf ontworpen met een BSO. Als metafoor is gekozen voor een ‘blokkendoos’. Het gebouw is gebaseerd op een module van 600 x 600 mm. Alle groepen hebben een eigen identiteit door de toepassing van gekleurd glas. Uitvoering ism de Meeuw bouwsystemen. 550 m2 wind en waterdicht in twee dagen. 	asdf	English	KSH Kinderservice hotel	erty	6	5	2
11		Amsterdam			In Gein III te Amsterdam zijn voor eigen gebruik twee woningen ontwikkeld en een kantoorruimte. Op de begane grond bevindt zich een kleine woning op het noorden en een kantoor op zuidwest. Op de verdieping een grote eengezinswoning op het zuiden. Een voornaam eigentijds gebouw. De gevel is vrijwel onderhoudsvrij en bestaat uit keramische tegels en onbehandelde iroko kozijnen.			Woon werk gebouw		8	10	3
22		Amstelveen			Door B.A.G. zijn 96 starterswoningen ontwikkeld op basis van MGE (maatschappelijk gebonden eigendom) Hierdoor is wonen in Amstelveen bereikbaar geworden voor een grote groep mensen die maatschappelijk gebonden zijn aan Amstelveen. Docenten, brandweerlieden, verpleegsters etc. Kwalitatief hoogwaardige woningen met een zuidorientatie, een heldere uitstraling en een eigen identiteit die tot uitdrukking komt in de kleur van de voordeuren.			Starterswoningen		19	14	4
25		Deelplan 6			In opdracht van AM zijn 174 woningen ontworpen in diverse types. Thema tuinstad. Voorname woningen met stoere kappen.			Saendelft		23	23	5
28		Amsterdam			Voor Netjes beheer en Trebbe bv is een stedenbouwkundige prijsvraag gewonnen en zijn op basis hiervan 72 herenhuizen ontworpen te Amstelveen. Het betreft ruime statige woningen, afgeleid van het prarie huis van FLW. Het metselwerk is hilversums formaat met een doorgestreken voeg. De woningen hadden als optie een kelder (prefab). Ca 50 % heeft deze optie gekozen.			Westwijk deelplan 18		26	26	6
32	EAlkmear	Alkmaar		This is the place to be	In opdracht van Hillen en Roosen is van 1998 t/m 2000 gewerkt aan een nieuw multifunctioneel voetbalstadion voor AZ te Alkmaar. De plannen die steeds op basis van de metafoor ‘De kroon op Alkmaar’ zijn uitgewerkt, zijn zonder uitzondering zeer goed ontvangen.		The AZ Stadion BABYYY	AZ		30	29	7
35		Amstelveen			Voor Netjes beheer is een supermarkt ontworpen aan de van der Hooplaan te Amstelveen. Het bestaande woongebouw en de winkelstrip zijn feitelijk verlengd om dit programma mogelijk te maken. In de langswand van de supermarkt, uitgevoerd in metselwerk met een bijzonder verband, is een ‘poort’ gemaakt als entree naar het winkelgebied. Op het dak van de supermarkt wordt geparkeerd.			Coop		33	33	8
39		Amstelveen			Voor een particuliere opdrachtgever is door BAG een tuinpaviljoen ontworpen. Het paviljoen heeft vier volledig glazen wanden. De noordwand is dicht, alle overige wanden kunnen volledig geopend worden. In het midden bevindt zich de filiofocus open haard die speciaal is ontworpen voor dit project.			Paviljoen Zhang Hao		36	36	9
42		deelplan 4			Voor RABO vastgoed is een stedenbouwkundige prijsvraag gewonnen voor deelplan 4 in Amstelveen, het voormalig A3 trace. Als onderdeel daarvan zijn vier urban villa’s ontworpen. Stoere blokken met een Amstelveense uitstraling. De plattegronden zijn georiënteerd op het aansluitende landschap.			Appartamenten		40	40	10
48		Amstelveen			Voor Recul bv is in de Gooise poort een bedrijfsgebouw ontworpen dat expliciet voor zowel een als drie gebruikers geschikt moet zijn. Elk bedrijf moet een eigen uitstraling kunnen genereren.			Gooise poort		43	43	11
52		Amstelveen			Voor bouwfonds zijn is in Amstelveen voor westwijk ZO een stedenbouwkundig plan gemaakt voor de bouw van ruim 800 woningen. Daarvan zijn er 180 door BAG gemaakt in diverse typen, maar zonder uitzondering met een Amstelveens karakter.			Westwijk Zuidoost		49	51	12
4	Amstelveen Netherlands	Amstelveen	locatie chinees	Amstelveen is VERY COOL	Yisheng group te Amstelveen is vanaf de initiatief fase door B.A.G. geadviseerd en begeleid bij de ontwikkeling van dit project. B.A.G. is een samenwerking aangegaan met Mulderblauw en deze combinatie is ook de architect geworden voor het plan. Het betreft een gebouw met 77 appartementen in de vrije sector, een hotel met in aanvang 140 kamers en een commerciele plint. Totaal BVO is 25.000 m2.	Amstelveen SJING SJONG	City Garden	City Garden	titel chinees	2	1	1
\.


--
-- Data for Name: project_images; Type: TABLE DATA; Schema: public; Owner: u2m96f8s5m4e6c
--

COPY public.project_images (project_id, images_id) FROM stdin;
11	8
11	9
11	10
22	12
22	13
22	14
22	15
22	16
22	17
22	18
22	19
22	20
22	21
25	23
25	24
28	26
28	27
32	29
32	30
32	31
35	33
35	34
39	36
39	37
39	38
42	40
42	41
48	43
48	44
48	45
48	46
48	47
52	49
52	50
52	51
7	5
7	6
4	1
4	2
4	3
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: u2m96f8s5m4e6c
--

SELECT pg_catalog.setval('public.hibernate_sequence', 60, true);


--
-- Name: image image_pkey; Type: CONSTRAINT; Schema: public; Owner: u2m96f8s5m4e6c
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id);


--
-- Name: project project_pkey; Type: CONSTRAINT; Schema: public; Owner: u2m96f8s5m4e6c
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_pkey PRIMARY KEY (id);


--
-- Name: project_images uk_jfn42vljn77je7wjdo09q5msf; Type: CONSTRAINT; Schema: public; Owner: u2m96f8s5m4e6c
--

ALTER TABLE ONLY public.project_images
    ADD CONSTRAINT uk_jfn42vljn77je7wjdo09q5msf UNIQUE (images_id);


--
-- Name: project_images fk2q3t5hox31wehrad2xoybj96c; Type: FK CONSTRAINT; Schema: public; Owner: u2m96f8s5m4e6c
--

ALTER TABLE ONLY public.project_images
    ADD CONSTRAINT fk2q3t5hox31wehrad2xoybj96c FOREIGN KEY (project_id) REFERENCES public.project(id);


--
-- Name: project fkat3qmss024ceinpfja2j87qqb; Type: FK CONSTRAINT; Schema: public; Owner: u2m96f8s5m4e6c
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT fkat3qmss024ceinpfja2j87qqb FOREIGN KEY (front_page_image_id) REFERENCES public.image(id);


--
-- Name: project_images fki3jle20e60of8o58tp8swdvc7; Type: FK CONSTRAINT; Schema: public; Owner: u2m96f8s5m4e6c
--

ALTER TABLE ONLY public.project_images
    ADD CONSTRAINT fki3jle20e60of8o58tp8swdvc7 FOREIGN KEY (images_id) REFERENCES public.image(id);


--
-- Name: project fkowx8ryunwvb7oytea2hy192d8; Type: FK CONSTRAINT; Schema: public; Owner: u2m96f8s5m4e6c
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT fkowx8ryunwvb7oytea2hy192d8 FOREIGN KEY (banner_image_id) REFERENCES public.image(id);


--
-- Name: SCHEMA _heroku; Type: ACL; Schema: -; Owner: heroku_admin
--

GRANT ALL ON SCHEMA _heroku TO u2m96f8s5m4e6c;


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: u2m96f8s5m4e6c
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;


--
-- Name: FUNCTION pg_stat_statements_reset(userid oid, dbid oid, queryid bigint); Type: ACL; Schema: public; Owner: rdsadmin
--

GRANT ALL ON FUNCTION public.pg_stat_statements_reset(userid oid, dbid oid, queryid bigint) TO u2m96f8s5m4e6c;


--
-- Name: extension_before_drop; Type: EVENT TRIGGER; Schema: -; Owner: heroku_admin
--

CREATE EVENT TRIGGER extension_before_drop ON ddl_command_start
   EXECUTE FUNCTION _heroku.extension_before_drop();


ALTER EVENT TRIGGER extension_before_drop OWNER TO heroku_admin;

--
-- Name: log_create_ext; Type: EVENT TRIGGER; Schema: -; Owner: heroku_admin
--

CREATE EVENT TRIGGER log_create_ext ON ddl_command_end
   EXECUTE FUNCTION _heroku.create_ext();


ALTER EVENT TRIGGER log_create_ext OWNER TO heroku_admin;

--
-- Name: log_drop_ext; Type: EVENT TRIGGER; Schema: -; Owner: heroku_admin
--

CREATE EVENT TRIGGER log_drop_ext ON sql_drop
   EXECUTE FUNCTION _heroku.drop_ext();


ALTER EVENT TRIGGER log_drop_ext OWNER TO heroku_admin;

--
-- Name: validate_extension; Type: EVENT TRIGGER; Schema: -; Owner: heroku_admin
--

CREATE EVENT TRIGGER validate_extension ON ddl_command_end
   EXECUTE FUNCTION _heroku.validate_extension();


ALTER EVENT TRIGGER validate_extension OWNER TO heroku_admin;

--
-- PostgreSQL database dump complete
--

