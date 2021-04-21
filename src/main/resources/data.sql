/*insert default roles*/
INSERT INTO role(id, name)VALUES(1, 'admin');
INSERT INTO role(id, name)VALUES(2, 'innkeeper');
INSERT INTO role(id, name)VALUES(3, 'purchaser');

/*insert default users*/
INSERT INTO user(id, api_key, first_name, last_name)
VALUES (1, 'jijne82njddj29nd9nsn', 'Administrator', 'Administrator');

INSERT INTO user(id, api_key, first_name, last_name)
VALUES (2, 'hdgjshbe123456nnddnd', 'John', 'Doe');

INSERT INTO user(id, api_key, first_name, last_name)
VALUES (3, 'kjkxskxje44j3djnadke', 'Land Lord', 'Land Lord');

/*insert default user roles*/
INSERT INTO user_role(user_id, role_id)VALUES(1,1);
INSERT INTO user_role(user_id, role_id)VALUES(2,2);
INSERT INTO user_role(user_id, role_id)VALUES(3,3);

