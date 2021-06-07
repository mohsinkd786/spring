
# Generate Token
curl --location --request POST 'localhost:8080/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "mohsinkd786",
    "password": "password"
}'

# Secured Rest Api Call

curl --location --request GET 'http://localhost:8080/hello' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtb2hzaW5rZDc4NiIsImV4cCI6MTYyMzA4OTgwNywiaWF0IjoxNjIzMDcxODA3fQ.8fJsrnY5EYg6F909AJcGXIGqMe2nV_XcmUYGsj5ufr8GRBxob75EF0dveOfaW888T9geJe_VkQjNyojbJ8fw2A'
