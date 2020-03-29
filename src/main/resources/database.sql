CREATE TABLE user
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL ,
    password VARCHAR(255) NOT NULL
);

-- Table: role
CREATE TABLE role
(
    id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Table for mapping user and roles: user_roles
CREATE TABLE user_role
(
    user_id   INT          NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (role_id) REFERENCES role(id),

    UNIQUE (user_id, role_id)
);

-- Insert data
# INSERT INTO user VALUES (2, 'Rishat', '$2a$10$rnn9kFvfISN2bsGmp.N9V.Gz.WJ6m1RZbMMgxPJHVTKjar5vJ4kKW');

INSERT INTO user VALUES (2, 'Rishat', '88888888');


INSERT INTO role VALUES (1, 'ROLE_USER');
INSERT INTO role VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_role VALUES (1, 2);

# SET FOREIGN_KEY_CHECKS=0