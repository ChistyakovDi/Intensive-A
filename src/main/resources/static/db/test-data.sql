INSERT INTO student (firstname, lastname, age)
VALUES ('Dima', 'Dmitriev', 18),
       ('Vasya', 'Sidorov', 19),
       ('Ivan', 'Popov', 20);

INSERT INTO teacher (firstname, lastname, faculty)
VALUES ('Sergey', 'Alohin', 'Technical'),
       ('Dmitriy', 'Sergeev', 'Business');

INSERT INTO course (title, teacher_id)
VALUES ('Programming', 1),
       ('Mathematics', 1),
       ('Marketing', 2);

INSERT INTO student_course (student_id, course_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 1),
       (3, 2),
       (3, 3);