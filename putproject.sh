#!/usr/bin/env bash
curl -i -X PUT localhost:5000/project/4 -H 'Content-Type:application/json' -d '{
  "id": 4,
  "titel_en": "titel engels",
  "titel_zh": "city garden chinees",
  "locatie_en": "Location man",
  "locatie_nl": "Amstelveen",
  "locatie_zh": "ook iets plaates",
  "text_en": "Cool blabla",
  "text_zh": "sjingie sjongie",
  "titel_nl": "City Garden",
  "text_nl": "Dit is dus nieuwe sheisse vanuit putproject.sh",
  "images": [{"url": "www.jemoer.nl"},{"url": "www.doenogmaar1.nl"}]
}'
