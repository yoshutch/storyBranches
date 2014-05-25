# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table story (
  story_id                  bigint auto_increment not null,
  story_name                varchar(255),
  author                    varchar(255),
  constraint pk_story primary key (story_id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table story;

SET FOREIGN_KEY_CHECKS=1;

