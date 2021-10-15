# figker-keycloak
Figker's Docker Image for jboss/keycloak:latest to work with Figker MariaDB image. The CLI adding timeout 900 seconds (15 minutes) to solve the problem of initialization of Keycloak database.


* To build image locally
> gradle docker

* To push to figker/figker-keycloak
> gradle dockerPush