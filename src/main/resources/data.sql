insert into roles(rolename) values ('USER'), ('ADMIN');

--   username: karel, password: appel
insert into users(username, password) values ('dd0gan', '$2a$12$v3hpM1z6mh.ITK9UdFeeiOHOaRzvrlLCCGQc9tyZi718XWXWmLub6');
insert into users(username, password) values ('karel', '$2a$12$v3hpM1z6mh.ITK9UdFeeiOHOaRzvrlLCCGQc9tyZi718XWXWmLub6');
-- tien / tien
insert into users(username, password) values ('tien', '$2a$10$parO5dy6Nqu5.5MoiBSdzeqemP.sjPwyLVVW/xmthSTJYT4r/bzf2');
insert into users(username, password) values ('tien2', '$2a$10$parO5dy6Nqu5.5MoiBSdzeqemP.sjPwyLVVW/xmthSTJYT4r/bzf2');

insert into users_roles values('dd0gan', 'ADMIN');
insert into users_roles values('karel', 'USER');
insert into users_roles values('tien', 'ADMIN');
insert into users_roles values('tien2', 'USER');


INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test1', 11.0, 'AMSTERDAM', 'OPEN', 'Casual', 15.0);
INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test2', 12.0, 'GRONINGEN', 'OPEN', 'Casual', 15.0);
INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test3', 13.0, 'ROTTERDAM', 'OPEN', 'Casual', 15.0);
INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test4', 14.0, 'DEN HAAG', 'OPEN', 'Casual', 15.0);

INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test5', 15.0, 'NEW YORK', 'OPEN', 'Casual', 15.0);
INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test6', 16.0, 'LOS ANGELES', 'OPEN', 'Casual', 15.0);
INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test7', 17.0, 'PARIJS', 'OPEN', 'Casual', 15.0);
INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test8', 18.0, 'ISTANBOEL', 'OPEN', 'Casual', 15.0);

INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test9', 19.0, 'BERLIJN', 'OPEN', 'Casual', 15.0);
INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test10', 20.0, 'ROME', 'OPEN', 'Casual', 15.0);
INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test11', 21.0, 'MADRID', 'OPEN', 'Casual', 15.0);
INSERT INTO vacancies
(description, hourly_rate, "location", status, "type", working_hour)
VALUES('test12', 22.0, 'TOKYO', 'OPEN', 'Casual', 15.0);


