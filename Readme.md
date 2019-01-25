# Hibernate One to Many Mapping Example with Spring Boot and JPA

Read the Tutorial - https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

## Setup the Application

1. Create a database named `hibernate_one_to_many_demo`.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.

//////////////

DROP SCHEMA IF EXISTS trends;
CREATE SCHEMA trends;
USE trends;
SET AUTOCOMMIT=1;

create table metrics
(
  id         bigint auto_increment PRIMARY KEY,
  name        varchar(100) not null,
  description varchar(1000)
)
;

create table technologies
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

create table statistic
(
  metric_id     bigint not null,
  repository_id bigint not null,
  technology_id   bigint not null,
  report_date          date not null,
  value         DECIMAL(12,4)
)
;

create index METRIC_IDX on statistic(metric_id);
create index REPOSITORY_IDX on statistic(repository_id);
create index TECHNOLOGY_IDX on statistic(technology_id);
create index REPORT_DATA_IDX on statistic(report_date);

alter table statistic
  add constraint STATISTIC_PK primary key (METRIC_ID, REPOSITORY_ID, TECHNOLOGY_ID, REPORT_DATE);
alter table statistic
  add constraint REPOSITORY_FK foreign key (REPOSITORY_ID)
  references repositories(ID) on delete RESTRICT;
alter table statistic
  add constraint TECHNOLOGY_FK foreign key (TECHNOLOGY_ID)
  references technologies(ID) on delete RESTRICT;
alter table statistic
  add constraint METRIC_FK foreign key (METRIC_ID)
  references metrics(ID) on delete RESTRICT;

/////////////////////////////////////