# figker-keycloak
Figker's Docker Image for jboss/keycloak:latest to work with Figker MariaDB image. The CLI adding timeout 1800 seconds (30 minutes) to solve the problem of initialization of Keycloak database.

* Tested with jboss/keycloak:15.0.2

* To build image locally
> gradle docker

* To push to figker/figker-keycloak
> gradle dockerPush-latest

* To build and auto push
> gradle docker dockerPush-latest