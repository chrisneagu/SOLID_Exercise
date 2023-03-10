package ro.ase.acs.cts.classes;

import ro.ase.acs.cts.interfaces.Creator;
import ro.ase.acs.cts.interfaces.ValueInserter;
import ro.ase.acs.cts.interfaces.ValueReader;
import ro.ase.acs.cts.interfaces.ValueWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Orchestrator {
    private final Creator creator;
    private final ValueInserter valueInserter;
    private final ValueReader valueReader;
    private final ValueWriter valueWriter;

    public Orchestrator(Creator creator, ValueInserter valueInserter, ValueReader valueReader, ValueWriter valueWriter) {
        this.creator = creator;
        this.valueInserter = valueInserter;
        this.valueReader = valueReader;
        this.valueWriter = valueWriter;
    }

    public void runFlow(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);
            creator.createTable(connection);
            valueInserter.insertData(connection);
            List<Employee> list = valueReader.readData(connection);
            valueWriter.display(list);
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
