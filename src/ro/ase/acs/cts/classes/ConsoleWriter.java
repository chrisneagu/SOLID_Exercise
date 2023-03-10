package ro.ase.acs.cts.classes;

import ro.ase.acs.cts.interfaces.ValueWriter;

import java.util.List;

public class ConsoleWriter implements ValueWriter {
    @Override
    public void display(List<Employee> list) {
        for(Employee employee : list){
            System.out.println("id: " + employee.getId());
            System.out.println("name: " + employee.getName());
            System.out.println("address: " + employee.getAddress());
            System.out.println("salary: " + employee.getSalary());
        }
    }
}