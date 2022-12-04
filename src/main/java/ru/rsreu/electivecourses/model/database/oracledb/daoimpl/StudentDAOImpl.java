package ru.rsreu.electivecourses.model.database.oracledb.daoimpl;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;
import ru.rsreu.electivecourses.model.database.dao.StudentDAO;

import java.sql.Connection;

public class StudentDAOImpl implements StudentDAO {

    private final Connection connection;
    private final Resourcer resourcer;

    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
        this.resourcer = ProjectResourcer.getInstance();
    }
}
