import employee.Employee;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeAnalyzer {

    public long countEmployees(List<Employee> employees, int years) {
        return employees.stream()
                .filter(employee -> ((Year.now().getValue() - employee.getStartingYear()) > years))
                .count();
    }

    public List<String> findEmployeeBySalary(List<Employee> employees, int salary) {
        return employees.stream()
                .filter(employee -> employee.getSalary() > salary)
                .map(employee -> employee.getFirstName() + " " +  employee.getLastname())
                .collect(Collectors.toList());
    }

    public List<Employee> findOldestEmployees(List<Employee> employees, int numberOfEmployees) {
        return new ArrayList<>();
    }

    public Optional<Employee> findFirstEmployeeByAge(List<Employee> employees, int age) {


        return Optional.empty();
    }

    public Double findAverageSalary(List<Employee> employees) {
        return 0.0;
    }

    public List<String> findCommonNames(List<Employee> firstDepartment, List<Employee> secondDepartment) {


        return new ArrayList<>();
    }
}