ARG VERSION=23.0.5
FROM quay.io/keycloak/keycloak:${VERSION} as builder
#FROM jboss/keycloak:latest as builder
# Enable health and metrics support
ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true

# Configure a database vendor
ENV KC_DB=mssql

WORKDIR /opt/keycloak
# for demonstration purposes only, please make sure to use proper certificates in production instead
#RUN keytool -genkeypair -storepass password -storetype PKCS12 -keyalg RSA -keysize 2048 -dname "CN=server" -alias server -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore conf/server.keystore
#RUN /opt/keycloak/bin/kc.sh --verbose  build
#RUN /opt/keycloak/bin/kc.sh -Dkc.db.tx-type=enable -Dkc.db-driver=com.microsoft.sqlserver.jdbc.SQLServerDriver --db=mssql
COPY providers /opt/keycloak/providers/
COPY themes /opt/keycloak/themes/
# xa module  and quarkus configurations
RUN /opt/keycloak/bin/kc.sh build --db=mssql --transaction-xa-enabled=false -Dquarkus.debug.enabled=true -Dquarkus.debug.port=5005 --debug
COPY quarkus.properties /opt/keycloak/conf/
COPY keycloak.conf /opt/keycloak/conf/

FROM quay.io/keycloak/keycloak:${VERSION}

COPY --from=builder /opt/keycloak/ /opt/keycloak/
# change these values to point to a running postgres instance
ENV KC_DB=mssql
ENV KC_DB_URL="jdbc:sqlserver://sqlserver;databaseName=keycloakauth;encrypt=false;trustServerCertificate=false;loginTimeout=30"
ENV KC_DB_USERNAME="sa"
ENV KC_DB_PASSWORD="Admin123#"
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=admin1
ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true
ENV KC_HOSTNAME_STRICT=false
ENV KC_HOSTNAME_STRICT_HTTPS=false
ENV KC_FEATURES=token-exchange
#ENV KC_HOSTNAME=localhost
ENV KC_HTTP_PORT=8080
ENV KC_HTTP_ENABLED=true
ENV KC_HTTP_RELATIVE_PATH=/auth
ENV KC_TRANSACTION_XA_ENABLED=false

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
#CMD ["start-dev"]