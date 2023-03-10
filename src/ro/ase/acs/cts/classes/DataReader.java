package ro.ase.acs.cts.classes;

import ro.ase.acs.cts.interfaces.ValueReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataReader implements ValueReader {
    @Override
    public List<Employee> readData(Connection connection) throws SQLException {
        String sqlSelect = "SELECT * FROM employees";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlSelect);
        List<Employee> list = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString(2);
            String address = rs.getString("address");
            double salary = rs.getDouble("salary");
            Employee employee = new Employee(id, name, address, salary);
            list.add(employee);
        }
        rs.close();
        statement.close();
        return list;
    }
}
