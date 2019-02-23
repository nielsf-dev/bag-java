<%@ Page Title="" Language="C#" MasterPageFile="~/BagSite.Master" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="website.Index" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <!-- home-section 
			================================================== -->
    <section id="home-section">

        <div class="slider-text">
            <div class="flexslider">
                <ul class="slides">
                    <li>
                        <div class="slider-caption">
                            <p>Welkom bij B.A.G.</p>
                            <br>
                            <!-- <p>Our template come with all packed pages</p> <br> -->
                        </div>
                    </li>
                    <%--<li>
							<div class="slider-caption">
								<h1>Architectuur die past</h1>
								<p>Voor ieder wat wils</p> <br>
								<!-- <p>There was never easier.</p> <br> -->
							</div>
						</li>--%>
                </ul>
            </div>
        </div>

    </section>
    <!-- End home section -->

    <!-- about-section 
			================================================== -->
    <section id="about-section">
        <div class="container">

            <div class="about-box">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="about-image">
                            <img src="upload/portfolio/WoonwerkGebouw/IMG0047.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="about-content">
                            <h2>Wie zijn wij?</h2>
                            <p>
                                B.A.G. Architecten is opgericht in 1991.
                                   Met een hecht team maken wij ontwerpen op het gebied van architectuur,
                                stedenbouw en interieur.
                            </p>
                            <br />
                            <h2>Onze missie</h2>
                            <p>
                                Heldere, frisse en goed functionerende duurzame gebouwen maken waarbij gebruikers zich goed
en veilig voelen.
Gebouwen die passen in hun omgeving en daar positief aan bijdragen door hun verschijning.
                                B.A.G. heeft veel ervaring met duurzaam bouwen. Al in 2001 zijn door ons nul energie woningen gemaakt in Amstelveen.
                            </p>
                            <p>
                                <%--								<div class="progress-box">--%>
                                <%--									<p>HTML &amp; Css</p>--%>
                                <%--									<div class="meter nostrips developer">--%>
                                <%--										<p style="width: 67%"><span>99%</span></p>--%>
                                <%--									</div>--%>
                                <%--									<p>WordPress</p>--%>
                                <%--									<div class="meter nostrips developer">--%>
                                <%--										<p style="width: 87%"><span>87%</span></p>--%>
                                <%--									</div>--%>
                                <%--									<p>Web Design</p>--%>
                                <%--									<div class="meter nostrips branding">--%>
                                <%--										<p style="width: 70%"><span>70%</span></p>--%>
                                <%--									</div>--%>
                                <%--								</div>--%>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>
    <!-- End about section -->

    <!-- about-section 
			================================================== -->
    <%--	<section id="about-section2">
			<div class="container">
				<div class="title-section">
					<span></span>
					<h1>we create only quality products</h1>
					<p>We are Best Creative Agency in USA. We can make everything to make you happy.</p>
				</div>

				<div class="about-box">
					<div class="row">
						<div class="col-md-4">
							<div class="about-post">
								<a href="#"><i class="fa fa-location-arrow"></i></a>
								<h2>Creative Solutions</h2>
								<p>Mauris eros tortor, tristique cursus porttitor et, luctus sed urna. Quisque id libero risus.</p>
							</div>
						</div>
						<div class="col-md-4">
							<div class="about-post">
								<a href="#"><i class="fa fa-laptop"></i></a>
								<h2>Web Design</h2>
								<p>Mauris eros tortor, tristique cursus porttitor et, luctus sed urna. Quisque id libero risus.</p>
							</div>
						</div>
						<div class="col-md-4">
							<div class="about-post">
								<a href="#"><i class="fa fa-html5"></i></a>
								<h2>Web Development</h2>
								<p>Mauris eros tortor, tristique cursus porttitor et, luctus sed urna. Quisque id libero risus.</p>
							</div>
						</div>
					</div>
				</div>

			</div>
		</section>--%>
    <!-- End about section -->

    <!-- statistic-section 
			================================================== -->
    <%--	<section class="statistic-section">
			<div class="container">
				<div class="statistic-box">
					<div class="row">
						<div class="col-lg-3 col-md-6">
							<div class="statistic-post">
								<p><span class="timer" data-from="0" data-to="125"></span></p>
								<h2>Completed Projects</h2>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="statistic-post">
								<p><span class="timer" data-from="0" data-to="100"></span></p>
								<h2>Awards Received</h2>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="statistic-post">
								<p><span class="timer" data-from="0" data-to="542"></span></p>
								<h2>Happy Client</h2>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="statistic-post">
								<p><span class="timer" data-from="0" data-to="430"></span></p>
								<h2>Coffee Consumed</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>--%>
    <!-- End statistic section -->

    <%--		<!-- team-section 
			================================================== -->
		<section id="team-section">
			<div class="container">
				<div class="title-section">
					<span></span>
					<h1>meet our professional team</h1>
					<p>We are Best Team in the World that bring your Ideas to life.</p>
				</div>

				<div class="team-box">
					<div class="row">
						<div class="col-md-4">
							<div class="team-post">
								<div class="team-gal">
									<img src="upload/others/mem1.jpg" alt="">
									<div class="hover-box">
										<a href="#" class="default-button" data-toggle="modal" data-target="#mem1Modal">Details</a>
									</div>
								</div>
								<h2>John Doe</h2>
								<p>Web Developer</p>

								<!-- Mem1 Modal -->
								<div class="modal fade" id="mem1Modal" tabindex="-1" role="dialog" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-body">
												<div class="row">
													<div class="col-sm-6">
														<img src="upload/others/mem1.jpg" alt="">
													</div>
													<div class="col-sm-6">
														<h2>John Doe</h2>
														<span>Web Developer</span>
														<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
														tempor incididunt ut labore et dolore magna aliqua. </p>

														<p>Duis aute irure dolor in reprehenderit in voluptate velit esse
														cillum dolore eu fugiat nulla pariatur.</p>

														<h3>Social Icons</h3>
														<ul class="social-list">
															<li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
															<li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
															<li><a class="google" href="#"><i class="fa fa-google-plus"></i></a></li>
															<li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
															<li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>
														</ul>		
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- End Mem1 Modal -->

							</div>
						</div>
						<div class="col-md-4">
							<div class="team-post">
								<div class="team-gal">
									<img src="upload/others/mem2.jpg" alt="">
									<div class="hover-box">
										<a href="#" class="default-button" data-toggle="modal" data-target="#mem2Modal">Details</a>
									</div>
								</div>
								<h2>Michael Smith</h2>
								<p>Web Designer</p>

								<!-- Mem2 Modal -->
								<div class="modal fade" id="mem2Modal" tabindex="-1" role="dialog" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-body">
												<div class="row">
													<div class="col-sm-6">
														<img src="upload/others/mem2.jpg" alt="">
													</div>
													<div class="col-sm-6">
														<h2>Michael Smith</h2>
														<span>Web Designer</span>
														<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
														tempor incididunt ut labore et dolore magna aliqua. </p>

														<p>Duis aute irure dolor in reprehenderit in voluptate velit esse
														cillum dolore eu fugiat nulla pariatur.</p>

														<h3>Social Icons</h3>
														<ul class="social-list">
															<li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
															<li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
															<li><a class="google" href="#"><i class="fa fa-google-plus"></i></a></li>
															<li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
															<li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>
														</ul>		
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- End Mem2 Modal -->

							</div>
						</div>
						<div class="col-md-4">
							<div class="team-post">
								<div class="team-gal">
									<img src="upload/others/mem3.jpg" alt="">
									<div class="hover-box">
										<a href="#" class="default-button" data-toggle="modal" data-target="#mem3Modal">Details</a>
									</div>
								</div>
								<h2>Sara Gomez</h2>
								<p>Marketing Specialist</p>

								<!-- Mem3 Modal -->
								<div class="modal fade" id="mem3Modal" tabindex="-1" role="dialog" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-body">
												<div class="row">
													<div class="col-sm-6">
														<img src="upload/others/mem3.jpg" alt="">
													</div>
													<div class="col-sm-6">
														<h2>Sara Gomez</h2>
														<span>Marketing Specialist</span>
														<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
														tempor incididunt ut labore et dolore magna aliqua. </p>

														<p>Duis aute irure dolor in reprehenderit in voluptate velit esse
														cillum dolore eu fugiat nulla pariatur.</p>

														<h3>Social Icons</h3>
														<ul class="social-list">
															<li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
															<li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
															<li><a class="google" href="#"><i class="fa fa-google-plus"></i></a></li>
															<li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
															<li><a class="instagram" href="#"><i class="fa fa-instagram"></i></a></li>
														</ul>		
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- End Mem3 Modal -->

							</div>
						</div>
					</div>
				</div>

			</div>
		</section>
		<!-- End team section -->--%>

    <!-- portfolio-section 
			================================================== -->
    <section id="portfolio-section">
        <div class="container">
            <div class="title-section">
                <span></span>
                <p>B.A.G. heeft circa 80 projecten gerealiseerd. Een selectie</p>
            </div>

            <div class="portfolio-box iso-call">
                <div class="project-item design branding">
                    <img src="upload/portfolio/CityGarden/citygardenkop.jpg" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="CityGarden.aspx">City Garden</a></h2>
                            <p>Amstelveen</p>
                        </div>
                    </div>
                </div>
                <div class="project-item design">
                    <img src="upload/portfolio/KSH/DSCF3620.jpg" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="KSH.aspx">KSH Kinderservice hotel</a></h2>
                            <p>Amsterdam</p>
                        </div>
                    </div>
                </div>
                <div class="project-item illustration">
                    <img src="upload/portfolio/WoonwerkGebouw/IMG0047.jpg" alt="" />
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="WoonwerkGebouw.aspx">Woon werk gebouw</a></h2>
                            <p>Amsterdam</p>
                        </div>
                    </div>
                </div>

                <div class="project-item illustration logo">
                    <img src="/upload/portfolio/Starterswoningen/DSCF9671.JPG" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="Starterswoningen.aspx">Starterswoningen</a></h2>
                            <p>Amstelveen</p>
                        </div>
                    </div>
                </div>
                <div class="project-item photography">
                    <img src="upload/portfolio/Saendelft/saendelft%2002.jpg" alt="" />
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="Saendelft.aspx">Saendelft</a></h2>
                            <p>deelplan 6</p>
                        </div>
                    </div>
                </div>

                <div class="project-item design branding">
                    <img src="upload/portfolio/Westwijk/DSCF9936.JPG" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="Westwijk.aspx">Westwijk deelplan 18</a></h2>
                            <p>Amstelveen</p>
                        </div>
                    </div>
                </div>

                <div class="project-item design branding">
                    <img src="upload/portfolio/AZ/DSCF4318.JPG" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="AZ.aspx">AZ Stadion</a>
                            </h2>
                            <p>Alkmaar</p>
                        </div>
                    </div>
                </div>
                <div class="project-item design branding">
                    <img src="upload/portfolio/coop/2.JPG" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="coop.aspx">COOP</a></h2>
                            <p>Amstelveen</p>
                        </div>
                    </div>
                </div>
                <div class="project-item design branding">
                    <img src="upload/portfolio/ZhangHao/1.JPG" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="ZhangHao.aspx">Paviljoen Zhang Hao</a>
                            </h2>
                            <p>Amstelveen</p>
                        </div>
                    </div>
                </div>

                <div class="project-item illustration logo">
                    <img src="/upload/portfolio/Deelplan4/unnamed.jpg" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="Deelplan4.aspx">Appartementen</a></h2>
                            <p>deelplan 4</p>
                        </div>
                    </div>
                </div>
                <div class="project-item illustration logo">
                    <img src="/upload/portfolio/Gooisepoort/DSCF0106.JPG" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="Gooisepoort.aspx">Gooise poort</a></h2>
                            <p>Amstelveen</p>
                        </div>
                    </div>
                </div>
                <div class="project-item illustration logo">
                    <img src="/upload/portfolio/WestwijkZuidoost/DSC_0265.jpeg" alt="">
                    <div class="hover-box">
                        <div class="inner-hover">
                            <h2><a href="WestwijkZuidoost.aspx">Westwijk Zuidoost</a></h2>
                            <p>Amstelveen</p>
                        </div>
                    </div>
                </div>

            </div>
            <%-- <div class="center-button"> --%>
            <%--     <a href="#" class="default-button load-post-container" data-load="posts-container.html" data-number="3">Meer projecten..</a> --%>
            <%-- </div> --%>
        </div>
    </section>
    <!-- End portfolio section -->

    <!-- banner-section 
			================================================== -->
    <section class="banner-section">
        <div class="container">
            <%--            <blockquote>--%>
            <%--                <h1>“there is no design without discipline. there is no discipline without intelligence”</h1>--%>
            <%--                <span>- Masimo Vigneli -</span>--%>
            <%--            </blockquote>--%>
        </div>
    </section>
    <!-- End banner section -->

    <!-- services-section 
			================================================== -->
    <section id="services-section">
        <div class="container">
            <div class="title-section">
                <span></span>
                <h1>Onze diensten</h1>
                <p>Wat kunnen wij voor u doen ?</p>
            </div>

            <div class="services-box">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="ser-image">
                            <img src="upload/others/DSCF9671.JPG" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="services-post right-post">
                            <h2>Ontwerp</h2>
                            <p>
                                B.A.G. stelt de context altijd voorop. 
In Amstelveen moet Amstelveens gebouw worden.  
Bij elke opgave wordt een passende metafoor gezocht. Vervolgens wordt op een eigentijdse duurzame manier vorm gegeven aan de gebouwde omgeving. Stedenbouw en Architectuur gaan bij ons altijd hand in hand.
Het belang van de gebruiker staat daarbij altijd voorop. 
                            </p>
                        </div>
                        <div class="services-post right-post">
                            <h2>Bouwtechniek</h2>
                            <p>
                                B.A.G. beschikt over specifieke expertise op het gebied van bouwtechniek.
Daarom zijn onze gebouwen niet alleen duurzaam, maar ook functioneel en onderhoudsarm.
                            </p>
                        </div>
                        <div class="services-post right-post">
                            <h2>Ontwikkeling</h2>
                            <p>
                                B.A.G. is in voorkomende gevallen een ontwikkelende architect. Onze 
96 starterswoningen op basis van MGE (maatschappelijk gebonden eigendom) ontwikkeld voor de gemeente Amstelveen zijn daarvan een uitstekend voorbeeld.
Ook hebben wij Yisheng geadviseerd bij de ontwikkeling van de City Garden.
Als u een optimaal rendement wilt op uw grondpositie, bent u bij ons aan het juiste adres.
                            </p>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>
    <!-- End services section -->

    <!-- blog-section 
			================================================== -->
    <%--<section id="blog-section">
			<div class="container">
				<div class="title-section">
					<span></span>
					<h1>latest blog posts</h1>
					<p>Our team created best opportunities for your business.</p>
				</div>

				<div class="blog-box">

					<div class="owl-wrapper">
						<div class="owl-carousel" data-num="3">
						
							<div class="item">
								<div class="blog-post">
									<div class="post-image">
										<a href="single-post.html">
											<img src="upload/blog/1.jpg" alt="">
										</a>
										<span class="date">
											10 August, 2018
										</span>
									</div>
									<div class="post-content">
										<h2><a href="single-post.html">Life in San Francisco</a></h2>
										<p>Duis aute irure dolor sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
									</div>
								</div>
							</div>
						
							<div class="item">
								<div class="blog-post">
									<div class="post-image">
										<a href="single-post.html">
											<img src="upload/blog/2.jpg" alt="">
										</a>
										<span class="date">
											13 August, 2018
										</span>
									</div>
									<div class="post-content">
										<h2><a href="single-post.html">Charts and Tables</a></h2>
										<p>Duis aute irure dolor sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
									</div>
								</div>
							</div>
						
							<div class="item">
								<div class="blog-post">
									<div class="post-image">
										<a href="single-post.html">
											<img src="upload/blog/3.jpg" alt="">
										</a>
										<span class="date">
											31 July, 2018
										</span>
									</div>
									<div class="post-content">
										<h2><a href="single-post.html">How to be Productive</a></h2>
										<p>Duis aute irure dolor sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
									</div>
								</div>
							</div>
						
							<div class="item">
								<div class="blog-post">
									<div class="post-image">
										<a href="single-post.html">
											<img src="upload/blog/4.jpg" alt="">
										</a>
										<span class="date">
											20 June, 2018
										</span>
									</div>
									<div class="post-content">
										<h2><a href="single-post.html">Working in Office</a></h2>
										<p>Duis aute irure dolor sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
									</div>
								</div>
							</div>
						
							<div class="item">
								<div class="blog-post">
									<div class="post-image">
										<a href="single-post.html">
											<img src="upload/blog/5.jpg" alt="">
										</a>
										<span class="date">
											27 May, 2018
										</span>
									</div>
									<div class="post-content">
										<h2><a href="single-post.html">Life in San Francisco</a></h2>
										<p>Duis aute irure dolor sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>

			</div>
		</section>--%>
    <!-- End blog section -->

    <!-- tweets-section 
			================================================== -->
    <section class="tweets-section">
        <div class="container">

            <div class="tweets-box">

                <%--                <p><i class="fa fa-twitter"></i></p>--%>

                <div class="owl-wrapper">
                    <div class="owl-carousel" data-num="1">

                        <div class="item">
                            <div class="tweet-post">
                                <%--                                <h1>Created couple new skins <a href="#">http://t.co/ubl3HWNexC</a></h1>--%>
                                <%--                                <span>-  Gred Binner  11 minutes ago  -</span>--%>
                            </div>
                        </div>

                        <div class="item">
                            <div class="tweet-post">
                                <%--                                <h1>Nullam fermentum nisl diam <a href="#">http://t.co/ubl3HWNexC</a></h1>--%>
                                <%--                                <span>-  Nunforest  14 minutes ago  -</span>--%>
                            </div>
                        </div>

                        <div class="item">
                            <div class="tweet-post">
                                <%--                                <h1>faucibus justo aliquam <a href="#">http://t.co/ubl3HWNexC</a></h1>--%>
                                <%--                                <span>-  Quan Ngyen  53 minutes ago  -</span>--%>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </section>
    <!-- End tweets section -->

    <!-- testimonial-section 
			================================================== -->
    <%--<section id="testimonial-section">
			<div class="container">
				<div class="title-section">
					<span></span>
					<h1>what others say for us</h1>
					<p>Our team created best opportunities for your business.</p>
				</div>

				<div class="testimonial-box">

					<div class="owl-wrapper">
						<div class="owl-carousel" data-num="3">
						
							<div class="item">
								<div class="testimonial-post">
									<div class="inner-testimonial">
										<img src="upload/others/avatar1.jpg" alt="">
										<div class="testimonial-content">
											<h2>John Doe</h2>
											<span>Ceo Mobile company</span>
											<p>Dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
											proident, sunt in culpa qui.</p>
										</div>
									</div>
								</div>
							</div>
						
							<div class="item">
								<div class="testimonial-post">
									<div class="inner-testimonial">
										<img src="upload/others/avatar2.jpg" alt="">
										<div class="testimonial-content">
											<h2>Micheal Smith</h2>
											<span>Web Developer</span>
											<p>Duis aute irure dolor in reprehenderit in voluptate velit esse
											cillum dolore eu fugiat nulla pariatur.</p>
										</div>
									</div>
								</div>
							</div>
						
							<div class="item">
								<div class="testimonial-post">
									<div class="inner-testimonial">
										<img src="upload/others/avatar3.jpg" alt="">
										<div class="testimonial-content">
											<h2>Helena Doe</h2>
											<span>Architect</span>
											<p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
											deserunt mollit anim id est laborum. </p>
										</div>
									</div>
								</div>
							</div>
						
							<div class="item">
								<div class="testimonial-post">
									<div class="inner-testimonial">
										<img src="upload/others/avatar1.jpg" alt="">
										<div class="testimonial-content">
											<h2>John Simth</h2>
											<span>Menager</span>
											<p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
											deserunt mollit anim id est laborum. </p>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>

			</div>
		</section>--%>
    <!-- End testimonial section -->

    <!-- contact-section 
			================================================== -->
    <section id="contact-section">

        <div class="contact-info-box">
            <div class="container">
                <div class="contact-box">
                    <div class="row">

                        <div class="col-lg-6">
                            <div id="contact-form">
                                <h2>Schrijf ons een bericht</h2>
                                <div class="row">
                                    <div class="col-md-6">
                                        <asp:TextBox ID="name" runat="server" placeHolder="Name"></asp:TextBox>
                                    </div>
                                    <div class="col-md-6">
                                        <asp:TextBox ID="mail" runat="server" placeHolder="Your e-mail"></asp:TextBox>
                                    </div>
                                </div>
                                <asp:TextBox ID="comment" runat="server" TextMode="MultiLine" placeHolder="Message"></asp:TextBox>

                                <asp:Button ID="submit" runat="server" Text="send message" CssClass="my-button" OnClick="submit_OnClick" />
                                <asp:Label runat="server" ID="Label1"></asp:Label>
                                <div id="msg" class="message"></div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="contact-info">
                                <ul class="contact-list">
                                    <li>
                                        <span><i class="fa fa-info"></i></span>
                                        <p>
                                            Adres &amp;
                                            <br>
                                            Contact informatie
                                        </p>
                                    </li>
                                    <li>
                                        <span><i class="fa fa-map-marker"></i></span>
                                        <p>
                                            Maria Snelplantsoen 1,
                                            <br>
                                            1106 WN Amsterdam
                                        </p>
                                    </li>
                                    <li>
                                        <span><i class="fa fa-phone"></i></span>
                                        <p>020-6968001</p>
                                    </li>
                                    <li>
                                        <span><i class="fa fa-envelope-o"></i></span>
                                        <p>info@bagarchitecten.nl</p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </section>
    <!-- End contact section -->
</asp:Content>
