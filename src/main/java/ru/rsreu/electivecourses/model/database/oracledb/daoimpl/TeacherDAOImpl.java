package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.database.dao.TeacherDAO;

import java.sql.Connection;

public class TeacherDAOImpl implements TeacherDAO {

    private final Connection connection;
    private final Resourcer resourcer;

    public TeacherDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }
}
