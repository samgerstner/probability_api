#!/bin/bash

API_KEY="yourapikeyhere"
BASE_URL="http://localhost:8080" #Do NOT add a trailing slash to the URL
VALUE=1
UNIT="min"

#Send purge request for marbles
curl "$BASE_URL/api/purge/marbles" -X GET -H "x-api-key: $API_KEY" -H 'Content-Type: application/json' -d "{\"value\": $VALUE,\"unit\": \"$UNIT\"}"

#Send purge request for dice
curl "$BASE_URL/api/purge/dice" -X GET -H "x-api-key: $API_KEY" -H 'Content-Type: application/json' -d "{\"value\": $VALUE,\"unit\": \"$UNIT\"}"

#Send purge request for coins
curl "$BASE_URL/api/purge/coins" -X GET -H "x-api-key: $API_KEY" -H 'Content-Type: application/json' -d "{\"value\": $VALUE,\"unit\": \"$UNIT\"}"