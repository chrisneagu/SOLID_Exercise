package ro.ase.acs.cts.main;

import ro.ase.acs.cts.classes.Orchestrator;
import ro.ase.acs.cts.classes.ServiceLocator;

import ro.ase.acs.cts.interfaces.Creator;
import ro.ase.acs.cts.interfaces.ValueInserter;
import ro.ase.acs.cts.interfaces.ValueReader;
import ro.ase.acs.cts.interfaces.ValueWriter;

public class Main {

    public static void main(String[] args) {
        ServiceLocator serviceLocator = new ServiceLocator();
        Orchestrator orchestrator = new Orchestrator(serviceLocator.get(Creator.class), serviceLocator.get(ValueInserter.class),
                serviceLocator.get(ValueReader.class), serviceLocator.get(ValueWriter.class));
        orchestrator.runFlow();
    }
}