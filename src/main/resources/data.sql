/*
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_email;
DROP TABLE IF EXISTS org;
DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS org_structure;
DROP TABLE IF EXISTS competencies;
DROP TABLE IF EXISTS survey;
DROP TABLE IF EXISTS survey_competencies;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS feedback;

CREATE TABLE IF NOT EXISTS user (
                                      id int(11)  NOT NULL AUTO_INCREMENT,
                                      name varchar(255) NOT NULL,
                                      key varchar(255) NOT NULL DEFAULT '',
                                      password varchar(225) NOT NULL,
                                      email varchar(255) NOT NULL UNIQUE,
                                      activation_token varchar(225) NOT NULL,
                                      last_activation_request int(11) NOT NULL,
                                      lost_password_request int(1) NOT NULL DEFAULT 0,
                                      active int(1) NOT NULL DEFAULT 0,
                                      role VARCHAR(30) NOT NULL DEFAULT 'member',
                                      sign_up_date datetime NOT NULL DEFAULT '2013-01-01 00:00:00',
                                      last_sign_in timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                      bio mediumtext,
                                      title varchar(100),
                                      organization varchar(200),
                                      PRIMARY KEY (id)
) ;

CREATE TABLE IF NOT EXISTS user_email (
                                            email varchar(150) NOT NULL,
                                            full_name varchar(255) NOT NULL,
                                            status varchar(10) NOT NULL DEFAULT 'active',
                                            time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                            PRIMARY KEY  (email)
);

CREATE TABLE IF NOT EXISTS org (
                                     id varchar(120) NOT NULL,
                                     name varchar(100) NOT NULL,
                                     owner varchar(255) NOT NULL,
                                     time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     PRIMARY KEY  (id)
) ;

CREATE TABLE IF NOT EXISTS team (
                                      id varchar(120) NOT NULL,
                                      name varchar(100) NOT NULL,
                                      time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      PRIMARY KEY  (id)
) ;

CREATE TABLE IF NOT EXISTS org_structure (
                                               org_id varchar(100) NOT NULL,
                                               team_id varchar(100) NOT NULL,
                                               role varchar(50) NOT NULL DEFAULT 'member',
                                               username varchar(255) NOT NULL,
                                               PRIMARY KEY  (username, org_id, team_id)
) ;

CREATE TABLE IF NOT EXISTS competencies (
                                              id int(11) NOT NULL AUTO_INCREMENT,
                                              name varchar(255) NOT NULL,
                                              description varchar(255) NOT NULL,
                                              use_count int DEFAULT 0 NOT NULL,
                                              created datetime NOT NULL DEFAULT '2015-01-01 00:00:00',
                                              updated timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                              PRIMARY KEY (id)
) ;

INSERT INTO competencies (name, description) VALUES
('Communication', 'Effectively transfers thoughts and expresses ideas orally or verbally in individual or group situations. Creates an atmosphere in which timely and high-quality information flows smoothly up and down, inside and outside of the team; encourages open express'),
('Customer Focus', 'Demonstrates strong commitment to meeting the needs of the customer, striving to ensure their full satisfaction. Considers the impact on the customer when taking action, or carrying out his/her own job responsibilities'),
('Influence', 'Asserts own ideas and persuades others, gaining support and commitment from others; mobilizes people to take action, using creative approaches to motivate others to meet organizational goals.'),
('Job Specific Skills', 'Applies and improves extensive or in-depth specialized knowledge, skills, and judgment to accomplish tasks and to perform his/her job effectively. Understands technical aspects of their job and continuously builds knowledge, keeping up-to-date on the tech'),
('Judgment', 'Makes decisions authoritatively and wisely, after adequately contemplating various available courses of action. Considers alternative available actions, resources, and constraints before selecting a method for accomplishing a task or project.'),
('Lives the Values', 'Follows and demonstrates ethical values which guide their choices and actions. Adheres to high standards of behavior, being consistently honest and trustworthy.'),
('Problem Solving', 'Builds a logical approach to address problems or opportunities or manage the situation at hand by drawing on his/her knowledge and experience base, and calling on other references and resources as necessary.'),
('Results Focus', 'Demonstrates concern for achieving or surpassing results against an internal or external standard of excellence. Shows a passion for improving the delivery of services with a commitment to continuous improvement.'),
('Teamwork', 'Demonstrates respect for the opinions of others. Identifies and pushes for win-win solutions to issues. Helps and supports fellow employees in their work to contribute to overall organizational success.');

CREATE TABLE IF NOT EXISTS survey (
                                        id int(11) NOT NULL AUTO_INCREMENT,
                                        name varchar(100) NOT NULL,
                                        org_id varchar(100) NOT NULL,
                                        team_id varchar(100) NOT NULL,
                                        aggregated_score BIT NOT NULL DEFAULT 1,
                                        username varchar(255) NOT NULL,
                                        created datetime NOT NULL DEFAULT '2015-01-01 00:00:00',
                                        updated timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                        PRIMARY KEY (id)
) ;

CREATE TABLE IF NOT EXISTS survey_competencies (
                                                     id int(11) NOT NULL AUTO_INCREMENT,
                                                     survey_id int(11) NOT NULL,
                                                     competency_id int(11) NOT NULL,
                                                     created timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                     PRIMARY KEY (id)
) ;

CREATE TABLE IF NOT EXISTS reviews (
                                         id int(11) NOT NULL AUTO_INCREMENT,
                                         survey_id int(11) NOT NULL,
                                         reviewer varchar(255) NOT NULL,
                                         reviewee varchar(255) NOT NULL,
                                         status VARCHAR(10) DEFAULT 'pending' NOT NULL,
                                         created datetime NOT NULL DEFAULT '2015-01-01 00:00:00',
                                         updated timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                         PRIMARY KEY (id)
) ;

CREATE TABLE IF NOT EXISTS feedback (
                                          id int(11) NOT NULL AUTO_INCREMENT,
                                          review_id int(11) NOT NULL,
                                          competency_id int(11) NOT NULL,
                                          rating int(2) NOT NULL,
                                          good MEDIUMTEXT,
                                          bad MEDIUMTEXT,
                                          status VARCHAR(10) DEFAULT 'draft' NOT NULL,
                                          created datetime NOT NULL DEFAULT '2015-01-01 00:00:00',
                                          updated timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                          PRIMARY KEY (id)
) ;*/
