# SmartQHub

### Project description

SmartQHub is an orchestrator that helps me connect various services

### Build

1. Set up MS SQL database - create 'auth' database
2. Set up Keycloak to use the created MS SQL 'auth' database (we can customize the realm that can be later imported in a
   production environment)
3. [Create Quarkus application](https://stephennimmo.com/2023/12/01/full-stack-development-quarkus-and-angular-with-quinoa/)
    1. Create Quarkus application and add resteasy-jackson and config-yaml extensions
   ```shell
   quarkus create app ro.builditsmart.solutions:quarkus-stock-analyzer-pro
   cd quarkus-stock-analyzer-pro
   quarkus ext add config-yaml resteasy-reactive-jackson
   mv src/main/resources/application.properties src/main/resources/application.yml
   ```
    2. Add Quinoa extension
   ```shell
   quarkus ext add quinoa
   yq -i '.quarkus.quinoa.enable-spa-routing = true' src/main/resources/application.yml
   yq -i '.quarkus.quinoa.build-dir = "dist/example-ng/browser"' src/main/resources/application.yml
   
   ```
    3. Create Angular application
   ```shell
   mkdir src/main/webui
   ng new --routing --style scss --directory src/main/webui -g --ssr false --standalone false ng-stock-analyzer-pro
   ```
4. [Add the Quarkus-POI extension](https://quarkus.io/extensions/io.quarkiverse.poi/quarkus-poi/) to be able to parse
   Excel files
5. [Add the Quarkus MS SQL Server extension](quarkus ext add io.quarkus:quarkus-jdbc-mssql) to be able to connect to
   database using JDBC