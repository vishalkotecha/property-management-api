/*insert default roles*/
INSERT INTO role(id, name)VALUES(1, 'admin');
INSERT INTO role(id, name)VALUES(2, 'innkeeper');
INSERT INTO role(id, name)VALUES(3, 'purchaser');

/*insert default users*/
INSERT INTO user(id, api_key, first_name, last_name)
VALUES (1, 'tpetjfj27p', 'Administrator', 'Administrator');

INSERT INTO user(id, api_key, first_name, last_name)
VALUES (2, 'pg94l805y4', 'John', 'Doe');

INSERT INTO user(id, api_key, first_name, last_name)
VALUES (3, 'l8527a5tim', 'Land Lord', 'Land Lord');

/*insert default user roles*/
INSERT INTO user_role(user_id, role_id)VALUES(1,1);
INSERT INTO user_role(user_id, role_id)VALUES(2,2);
INSERT INTO user_role(user_id, role_id)VALUES(3,3);

