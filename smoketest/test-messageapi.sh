#!/bin/bash

sleep 80

base_url="#{url_base}#"
username="#{user}#"
password="#{password}#"

endpoint_token=$base_url"/token"
responsetoken=$(curl -X POST -d -k 'user=$username&password=$password' "$endpoint_token")
access_token=$(echo "$responsetoken" | jq -r '.access_token' )

url_api=$base_url"/devops" 

header1="X-Parse-REST-API-Key: 2f5ae96c-b558-4c7b-a590-a501ae1c3f6c"
header2="Content-Type: application/json"
header3="X-JWT-KWY: "$access_token

data="{\"msg\":\"This is a test\",\"to\":\"Juan Perez\",\"from\":\"Rita Asturia\",\"timeToLifeSec\":45}"

status=$(curl -s -o -k /dev/null -w "%{http_code}" -X POST -H "$header1" -H "$header2" -H "$header3" -d "$data" "$url_api")

if [ "$status" -eq 200 ]; then
  echo "Smoketest se realizó con éxito. El status code es $status"
  exit 0
else
  echo "Se produjo un error al realizar la solicitud. El status code es $status"
  exit 1
fi






