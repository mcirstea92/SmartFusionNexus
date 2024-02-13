CREATE DATABASE [keycloakauth];
GO

CREATE DATABASE [smartqhub];
GO

USE [smartqhub];
GO

CREATE TABLE clients(id bigint primary key unique, firstName varchar(30) not null, lastName varchar(30) not null);
