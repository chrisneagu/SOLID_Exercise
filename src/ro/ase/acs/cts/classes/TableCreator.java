package ro.ase.acs.cts.classes;

import ro.ase.acs.cts.interfaces.Creator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator implements Creator {

    @Override
    public void createTable(Connection connection) throws SQLException {
        String sqlDrop = "DROP TABLE IF EXISTS employees";
        String sqlCreate = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
                + "name TEXT, address TEXT, salary REAL)";

        Statement statement = null;

        statement = connection.createStatement();
        statement.executeUpdate(sqlDrop);
        statement.executeUpdate(sqlCreate);
        statement.close();
        connection.commit();
    }
}
