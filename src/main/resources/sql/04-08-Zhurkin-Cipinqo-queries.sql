--��� ��������������:
--�������� ������ �������������, �������������� � ��� � ���������� � ���
SELECT users.*
FROM users
WHERE users.is_authorized = 1;

--��� �����������
--�������� ������ ������������ ������������� � �������� � ���
SELECT users.login
FROM users
WHERE users.is_active = 1;

--��� ��������������
--�������� ������ ���� �������������� ������, ������� ���� ������������� � ���������� � ���
SELECT elective_course.*
FROM elective_course
WHERE teacher_id = ?;

--�������� ��������� ���������� �� ������, ������� ���� �������������
SELECT course_details.*
FROM elective_course
INNER JOIN course_details ON course_details.course_id = elective_course.id
WHERE elective_course.teacher_id = ?;

--�������� ������������� ������ �� ������, ������� ���� �������������
SELECT intermediate_mark.*
FROM elective_course
INNER JOIN intermediate_mark ON intermediate_mark.course_id = elective_course.id
WHERE elective_course.teacher_id = ?;

--�������� ������������ ������, ������� ���� �������������
SELECT attendance.*
FROM elective_course
INNER JOIN attendance ON attendance.course_id = elective_course.id
WHERE elective_course.teacher_id = ?;

--��� ���������
--�������� ������������� ������ �����, �� ������� ������� �������
SELECT intermediate_mark.*
FROM course_details
INNER JOIN intermediate_mark ON intermediate_mark.course_id = course_details.course_id
WHERE course_details.student_id = ?;

--�������� ������������ ��������� �����, �� ������� ������� �������
SELECT attendance.*
FROM course_details
INNER JOIN attendance ON attendance.course_id = course_details.course_id
WHERE course_details.student_id = ?;

--�������� ������� ����� � ��������� ������
SELECT course_details.*
FROM course_details
WHERE course_details.student_id = ?;

--��� ����
--�����������
UPDATE users
SET is_authorized = 1
WHERE users.id = ?;

--�����
UPDATE users
SET is_authorized = 0
WHERE users.id = ?;

--��� ���������������
--���������� ����� �������������
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES (?, ?, ?, ?, ?, ?);

--�������� �������������
DELETE FROM users
WHERE users.id = ?;

--��������� ���� ������������
UPDATE users
SET role_id = ?
WHERE users.id = ?;

--��� �����������
--������������ �������������
UPDATE users
SET users.is_active = 0
WHERE users.id = ?;

--��������������� �������������
UPDATE users
SET users.is_active = 1
WHERE users.id = ?;

--��� ��������������
--���������� �� �������������� �����
INSERT INTO elective_course(teacher_id, title, description)
VALUES (?, ?, ?);

--����������� ������������� ������
INSERT INTO intermediate_mark(course_id, student_id, mark)
VALUES (?, ?, ?);

--������� ������������
INSERT INTO attendance(course_id, student_id, lesson_number, is_visited)
VALUES (?, ?, ?, ?);

--����������� ��������� ������
UPDATE course_details
SET course_details.mark = ?
WHERE course_id = ? AND student_id = ?;

--��� ���������
--������ �� �������������� ����
INSERT INTO course_details(course_id, student_id, start_date)
VALUES (?, ?, TO_DATE(?));

--��� ��������� � ��������������
--���������� � ��������������� �����
DELETE FROM course_details
WHERE course_details.student_id = ? AND course_details.course_id = ?;
