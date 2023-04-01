INSERT INTO role(role_name)
VALUES ('Administrator');
INSERT INTO role(role_name)
VALUES ('Moderator');
INSERT INTO role(role_name)
VALUES ('Teacher');
INSERT INTO role(role_name)
VALUES ('Student');

INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES('alias', '1', 1, '������', '������', '���������');
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES('kurufin', '1', 1, '�������', '�������', '����������');
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES('moderator1', '1', 2, '����', '��������', '�����������');
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES('teacher1', '1', 3, '���������', '�������', '����������');
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES('teacher2', '1', 3, '����', '��������', '���������');
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES('vanya', '1', 4, '����', '�������', '�������');
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES('stud1', '1', 4, '������', '�������', '����������');
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES('stud2', '1', 4, '�����', '��������', '��������');
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES('stud3', '1', 4, '�������', '�����', '��������');

INSERT INTO elective_course(teacher_id, title, description, start_date, is_started)
VALUES (4, 'JavaEE', '��������', CURRENT_DATE, 1);

INSERT INTO elective_course(teacher_id, title, description, start_date, is_started)
VALUES (5, 'Python', '���������', CURRENT_DATE, 0);

INSERT INTO elective_course(teacher_id, title, description, start_date)
VALUES (4, '�����', '���������� ���������', CURRENT_DATE);

INSERT INTO course_details(course_id, student_id)
VALUES (1, 6);
INSERT INTO course_details(course_id, student_id)
VALUES (1, 7);
INSERT INTO course_details(course_id, student_id)
VALUES (1, 8);
INSERT INTO course_details(course_id, student_id)
VALUES (1, 9);

INSERT INTO intermediate_mark(course_id, student_id, mark, mark_date)
VALUES (1, 6, 5, CURRENT_DATE);
INSERT INTO intermediate_mark(course_id, student_id, mark, mark_date)
VALUES (1, 6, 3, CURRENT_DATE);
INSERT INTO intermediate_mark(course_id, student_id, mark, mark_date)
VALUES (1, 7, 5, CURRENT_DATE);
INSERT INTO intermediate_mark(course_id, student_id, mark, mark_date)
VALUES (1, 8, 3, CURRENT_DATE);
INSERT INTO intermediate_mark(course_id, student_id, mark, mark_date)
VALUES (1, 6, 4, CURRENT_DATE);

INSERT INTO attendance(course_id, student_id, lesson_number, is_visited, attendance_date)
VALUES (1, 6, 1, 1, CURRENT_DATE);
INSERT INTO attendance(course_id, student_id, lesson_number, is_visited, attendance_date)
VALUES (1, 6, 2, 0, CURRENT_DATE);
