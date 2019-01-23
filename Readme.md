# Hibernate One to Many Mapping Example with Spring Boot and JPA

Read the Tutorial - https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

## Setup the Application

1. Create a database named `hibernate_one_to_many_demo`.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.

//////////////

DROP SCHEMA IF EXISTS datacollector;
CREATE SCHEMA datacollector;
USE datacollector;
SET AUTOCOMMIT=1;

create table metrics
(
  id         bigint auto_increment PRIMARY KEY,
  name        varchar(100) not null,
  description varchar(1000)
)
;

create table languages
(
  id         bigint auto_increment PRIMARY KEY,
  name        varchar(100) not null
)
;

create table repositories
(
  id         bigint auto_increment PRIMARY KEY,
  name        varchar(100) not null,
  description varchar(1000)
)
;

create table data
(
  metric_id     bigint not null,
  repository_id bigint not null,
  language_id   bigint not null,
  report_date          date not null,
  value         DECIMAL(12,4)
)
;

create index METRIC_IDX on data(metric_id);
create index REPOSITORY_IDX on data(repository_id);
create index LANGUAGE_IDX on data(language_id);
create index DATA_IDX on data(report_date);
alter table data
  add constraint DATA_PK primary key (METRIC_ID, REPOSITORY_ID, LANGUAGE_ID, REPORT_DATE);
alter table data
  add constraint REPOSITORY_FK foreign key (REPOSITORY_ID)
  references repositories(ID) on delete RESTRICT;
alter table data
  add constraint LANGUAGE_FK foreign key (LANGUAGE_ID)
  references languages(ID) on delete RESTRICT;
alter table data
  add constraint METRIC_FK foreign key (METRIC_ID)
  references metrics(ID) on delete RESTRICT;

/////////////////////////////////////