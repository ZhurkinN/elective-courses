--Для Администратора:
--Просмотр списка пользователей, авторизованных в СИС и информации о них
SELECT users.*
FROM users
WHERE users.is_authorized = 1;

--Для Модераторов
--Просмотр списка существующих пользователей и инфорции о них
SELECT users.login
FROM users
WHERE users.is_active = 1;

--Для Преподавателей
--Просмотр списка всех факультативных курсов, которые ведёт преподаватель и информации о них
SELECT elective_course.*
FROM elective_course
WHERE teacher_id = ?;

--Просмотр детальной информации по курсам, который ведёт преподаватель
SELECT course_details.*
FROM elective_course
INNER JOIN course_details ON course_details.course_id = elective_course.id
WHERE elective_course.teacher_id = ?;

--Просмотр промежуточных оценок по курсам, которые ведёт преподаватель
SELECT intermediate_mark.*
FROM elective_course
INNER JOIN intermediate_mark ON intermediate_mark.course_id = elective_course.id
WHERE elective_course.teacher_id = ?;

--Просмотр посещаемости курсов, которые ведёт преподаватель
SELECT attendance.*
FROM elective_course
INNER JOIN attendance ON attendance.course_id = elective_course.id
WHERE elective_course.teacher_id = ?;

--Для студентов
--Просмотр промежуточных оценок курса, на который записан студент
SELECT intermediate_mark.*
FROM course_details
INNER JOIN intermediate_mark ON intermediate_mark.course_id = course_details.course_id
WHERE course_details.student_id = ?;

--Просмотр посещаемости студентов курса, на который записан студент
SELECT attendance.*
FROM course_details
INNER JOIN attendance ON attendance.course_id = course_details.course_id
WHERE course_details.student_id = ?;

--Просмотр деталей курса и финальной оценки
SELECT course_details.*
FROM course_details
WHERE course_details.student_id = ?;

--Для всех
--Авторизация
UPDATE users
SET is_authorized = 1
WHERE users.id = ?;

--Выход
UPDATE users
SET is_authorized = 0
WHERE users.id = ?;

--Для администраторов
--Добавление новых пользователец
INSERT INTO users(login, password, role_id, name, surname, patronymic)
VALUES (?, ?, ?, ?, ?, ?);

--Удаление пользователей
DELETE FROM users
WHERE users.id = ?;

--Изменение роли пользователя
UPDATE users
SET role_id = ?
WHERE users.id = ?;

--Для модераторов
--Блокирование пользователей
UPDATE users
SET users.is_active = 0
WHERE users.id = ?;

--Разблокирование пользователей
UPDATE users
SET users.is_active = 1
WHERE users.id = ?;

--Для преподавателей
--Объявление об факультативном курсе
INSERT INTO elective_course(teacher_id, title, description)
VALUES (?, ?, ?);

--Выставление промежуточной оценки
INSERT INTO intermediate_mark(course_id, student_id, mark)
VALUES (?, ?, ?);

--Отметка посещаемости
INSERT INTO attendance(course_id, student_id, lesson_number, is_visited)
VALUES (?, ?, ?, ?);

--Выставление финальной оценки
UPDATE course_details
SET course_details.mark = ?
WHERE course_id = ? AND student_id = ?;

--Для студентов
--Запись на факультативный курс
INSERT INTO course_details(course_id, student_id, start_date)
VALUES (?, ?, TO_DATE(?));

--Для студентов и преподавателей
--Отчисление с факультативного курса
DELETE FROM course_details
WHERE course_details.student_id = ? AND course_details.course_id = ?;
