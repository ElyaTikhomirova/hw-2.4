package pro.sky.hw_2_5;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final List<Employee> employees = new ArrayList<>(10);

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();

    }
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException();
            }
            employees.remove(employee);
            return employee;
    }

    public Employee find (String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException();
            }
                return employee;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }

}
