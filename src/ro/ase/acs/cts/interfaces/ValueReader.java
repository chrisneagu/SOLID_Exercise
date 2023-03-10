package ro.ase.acs.cts.interfaces;

import ro.ase.acs.cts.classes.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ValueReader {
    List<Employee> readData(Connection connection) throws SQLException;
}
