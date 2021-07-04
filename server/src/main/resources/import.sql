INSERT INTO subject (subject_name) VALUES ('TSW');
INSERT INTO subject (subject_name) VALUES ('Java');

INSERT INTO lesson (lesson_name, subject_id) VALUES ('Swing', 2);
INSERT INTO lesson (lesson_name, subject_id) VALUES ('Java FX', 2);
INSERT INTO lesson (lesson_name, subject_id) VALUES ('Spring', 2);
INSERT INTO lesson (lesson_name, subject_id) VALUES ('React', 1);
INSERT INTO lesson (lesson_name, subject_id) VALUES ('Angular', 1);
INSERT INTO lesson (lesson_name, subject_id) VALUES ('Svelte', 1);

INSERT INTO task (task_name, lesson_id) VALUES ('Swing', 1);
INSERT INTO task (task_name, lesson_id) VALUES ('Swing 2', 1);
INSERT INTO task (task_name, lesson_id) VALUES ('Basic Layout', 2);
INSERT INTO task (task_name, lesson_id) VALUES ('Advanced Layout', 2);
INSERT INTO task (task_name, lesson_id) VALUES ('Basic Spring', 3);
INSERT INTO task (task_name, lesson_id) VALUES ('Microservices', 3);

INSERT INTO code (code_content) VALUES ('Lorem ipsum');
INSERT INTO code (code_content) VALUES ('Era - Ameno');
INSERT INTO code (code_content) VALUES ('Excalibur');
INSERT INTO code (code_content) VALUES ('King Arthur');


