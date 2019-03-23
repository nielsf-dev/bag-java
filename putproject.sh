#!/usr/bin/env bash
curl -i -X PUT localhost:5000/project/187 -H 'Content-Type:application/json' -d '{
  "id": 7,
  "titel_en": "",
  "titel_zh": "",
  "locatie_en": "",
  "locatie_zh": "",
  "text_en": "",
  "text_zh": "",
  "titel_nl": "KSH Kinderservice hotel",
  "locatie_nl": "Amsterdam",
  "text_nl": ""
}'
