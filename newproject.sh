#!/usr/bin/env bash
curl -i -X PUT localhost:5000/project -H 'Content-Type:application/json' -d '{
  "id": 0,
  "titel_en": "titel asdfasdf",
  "titel_zh": "city gasdfarden chinees",
  "locatie_en": "Locatioasdfn man",
  "locatie_nl": "Amstelvasdfeen",
  "locatie_zh": "ook iets plaates",
  "text_en": "Cool blablasdfa",
  "text_zh": "sjingie sjasdfongie",
  "titel_nl": "City Garasdfden",
  "text_nl": "Dit is dus asdfnieuwe sheisse vanuit putproject.sh",
  "images": [
  {"id": 0, "url": "https://stichtingspots.nl/wp-content/uploads/2017/06/Poema-ondersoort-Florida-P.c.coryi_-800x600.jpg", "isFrontend": false, "isBanner": true},
  {"id": 0, "url": "https://m.media-amazon.com/images/M/MV5BOWE3MWI1NDktNGUxOS00YzRlLTkwYTEtMjFlMWNmNjc3MzY5XkEyXkFqcGdeQXVyNjg2NDc2ODA@._V1_UY1200_CR751,0,630,1200_AL_.jpg", "isFrontend": true, "isBanner": false}]
}'
