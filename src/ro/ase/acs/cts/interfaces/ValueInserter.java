package ro.ase.acs.cts.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface ValueInserter {
    void insertData(Connection connection) throws SQLException;
}
