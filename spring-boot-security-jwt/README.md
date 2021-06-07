# Spring Security Example

Sample project demonstrating configuration and usage of Spring Security framework

Please see the article [here](https://www.toptal.com/spring/spring-security-tutorial)

# Used Core Libraries

- [spring-boot](https://spring.io/projects/spring-boot)
- [spring-data-mongodb](https://spring.io/projects/spring-data-mongodb)
- [spring-security](https://spring.io/projects/spring-security)
- [mapstruct](https://mapstruct.org)

# Project Demonstrates

- Spring Security Configuration
- [JWT](https://jwt.io) Based Stateless Authentication
- Role Based Authorization
- Integration Testing


The application has three roles:
- USER_ADMIN allows us to manage application users.
- AUTHOR_ADMIN allows us to manage authors.
- BOOK_ADMIN allows us to manage books.

Now, we need to apply them to the corresponding URLs:

- api/public is publicly accessible.
- api/admin/user can access users with the USER_ADMIN role.
- api/author can access users with the AUTHOR_ADMIN role.
- api/book can access users with the BOOK_ADMIN role.


#### Generate Token

curl --location --request POST 'localhost:8080/api/public/login' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "mohsink@aliftech.xyz",
    "password": "Test12345_"
}'
