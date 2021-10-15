FROM jboss/keycloak:latest

USER root

RUN mkdir -p /config/
COPY --chown=jboss:jboss config/* /config/

USER jboss
WORKDIR /config/

RUN cd $JBOSS_HOME \
  && ./bin/jboss-cli.sh --file=/config/keycloak.cli \
  && rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history \
  && rm -rf $JBOSS_HOME/standalone/data \
  && rm -rf $JBOSS_HOME/standalone/tmp

# docker build  -t figker/figker-keycloak:1.0-SNAPSHOT .
# docker push figker/figker-keycloak:1.0-SNAPSHOT