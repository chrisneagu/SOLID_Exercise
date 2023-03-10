package ro.ase.acs.cts.classes;

import ro.ase.acs.cts.interfaces.Creator;
import ro.ase.acs.cts.interfaces.ValueInserter;
import ro.ase.acs.cts.interfaces.ValueReader;
import ro.ase.acs.cts.interfaces.ValueWriter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private Map<Type, String> map = new HashMap<>();
    public ServiceLocator(){
        map.put(Creator.class, "ro.ase.acs.cts.classes.TableCreator");
        map.put(ValueInserter.class, "ro.ase.acs.cts.classes.DataInserter");
        map.put(ValueReader.class, "ro.ase.acs.cts.classes.DataReader");
        map.put(ValueWriter.class, "ro.ase.acs.cts.classes.ConsoleWriter");
    }
    public <T> T get(Type contract)  {
        String classname = map.get(contract);
        T instance = null;
        try {
            instance = (T) Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }
}
