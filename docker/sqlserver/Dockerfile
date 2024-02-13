# Choose ubuntu version
FROM mcr.microsoft.com/azure-sql-edge:latest as builder

FROM builder
# Create app directory
WORKDIR /usr/src/app

# Copy initialization scripts
COPY . /usr/src/app

# Set environment variables, not have to write them with the docker run command
# Note: make sure that your password matches what is in the run-initialization script
ENV MSSQL_SA_PASSWORD Admin123#
ENV ACCEPT_EULA 1
#ENV MSSQL_PID Express
ENV TZ=Europe/Bucharest
RUN date

# Expose port 1433 in case accessing from other container
# Expose port externally from docker-compose.yml
EXPOSE 1433

# Run Microsoft SQL Server and initialization script (at the same time)
CMD /bin/bash ./entrypoint.sh