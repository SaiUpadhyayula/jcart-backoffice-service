# JCart BackOffice Service

### How to run?

To run with H2 embedded database : `./gradlew bootRun`

To run Postgres in docker and run application locally:

`jcart-backoffice-service> docker-compose up backofficedb`

`jcart-backoffice-service> SPRING_PROFILES_ACTIVE=local ./gradlew bootRun`

To run both postgres database and application in docker:

`jcart-backoffice-service> docker-compose up --build --force-recreate -d`

`jcart-backoffice-service> docker-compose logs -f`
