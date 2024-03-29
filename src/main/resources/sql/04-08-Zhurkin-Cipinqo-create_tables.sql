--�������� ������� role
CREATE TABLE role
(   id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    role_name VARCHAR(15),
    CONSTRAINT pk_role PRIMARY KEY (id)
)
/

--�������� ������� users
CREATE TABLE users
(   id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    login VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL,
    role_id NUMBER,
    name VARCHAR(30),
    surname VARCHAR(30),
    patronymic VARCHAR(35),
    is_authorized NUMBER DEFAULT 0,
    is_active NUMBER DEFAULT 1,
    CONSTRAINT unique_login UNIQUE (login),
    CONSTRAINT check_authorized CHECK (is_authorized IN (0, 1)),
    CONSTRAINT check_active CHECK (is_active IN (0, 1)),
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT fk_users_role
        FOREIGN KEY (role_id)
        REFERENCES role ON DELETE CASCADE
)
/

--�������� ������� elective_course
CREATE TABLE elective_course
(   id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    teacher_id NUMBER NOT NULL,
    title VARCHAR(30),
    description VARCHAR(100),
    start_date DATE,
    is_started NUMBER DEFAULT 0,
    CONSTRAINT pk_course PRIMARY KEY (id),
    CONSTRAINT check_started CHECK (is_started IN (0, 1)),
    CONSTRAINT fk_users_course
        FOREIGN KEY (teacher_id)
        REFERENCES users ON DELETE CASCADE
)
/
--�������� ������� course_details
CREATE TABLE course_details
(   course_id NUMBER NOT NULL,
    student_id NUMBER NOT NULL,
    final_mark VARCHAR(25) DEFAULT '��� ������',
    is_marked NUMBER DEFAULT 0,
    CONSTRAINT pk_course_details PRIMARY KEY (course_id, student_id),
    CONSTRAINT fk_users_details
        FOREIGN KEY (student_id)
        REFERENCES users ON DELETE CASCADE,
    CONSTRAINT fk_course_details
        FOREIGN KEY (course_id)
        REFERENCES elective_course ON DELETE CASCADE
)
/

--�������� ������� intermediate_mark
CREATE TABLE intermediate_mark
(   id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    course_id NUMBER NOT NULL,
    student_id NUMBER,
    mark NUMBER,
    mark_date DATE,
    CONSTRAINT pk_mark PRIMARY KEY (id),
    CONSTRAINT fk_course_mark
        FOREIGN KEY (course_id)
        REFERENCES  elective_course ON DELETE CASCADE
)
/

--�������� ������� attendance
CREATE TABLE attendance
(   id NUMBER GENERATED BY DEFAULT AS IDENTITY,
    course_id NUMBER NOT NULL,
    student_id NUMBER,
    lesson_number NUMBER,
    is_visited NUMBER,
    attendance_date DATE,
    CONSTRAINT check_visited CHECK (is_visited IN (0, 1)),
    CONSTRAINT pk_attendance PRIMARY KEY (id),
    CONSTRAINT fk_course_attendance
        FOREIGN KEY (course_id)
        REFERENCES  elective_course ON DELETE CASCADE
)
/
DROP TABLE attendance;
DROP TABLE intermediate_mark;
DROP TABLE course_details;
DROP TABLE elective_course;
DROP TABLE users;
DROP TABLE role;