#!/usr/bin/env bash

curl -i -X POST -d username=user -d password=onzin -c ./bag-cookie.txt http://localhost:5000/login 

curl -i --header "Accept:application/json" -X GET -b ./bag-cookie.txt http://localhost:5000/secret/project
