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
                .map(employee -> employee.getFirstName() + " " + employee.getLastname())
                .collect(Collectors.toList());
    }

    public List<Employee> findOldestEmployees(List<Employee> employees, int numberOfEmployees) {
        return employees.stream()
                .sorted((e1, e2) -> e2.getAge() - e1.getAge())
                .limit(numberOfEmployees)
                .collect(Collectors.toList());
    }

    public Optional<Employee> findFirstEmployeeByAge(List<Employee> employees, int age) {
        return employees.stream()
                .filter(e -> e.getAge() > age)
                .findFirst();
    }

    public Double findAverageSalary(List<Employee> employees) {
        return employees.stream()
                .mapToInt(e -> e.getSalary())
                .average()
                .getAsDouble();
    }

    public List<String> findCommonNames(List<Employee> firstDepartment, List<Employee> secondDepartment) {

        List<String> commonNames = firstDepartment.stream()
                .filter(e2 -> secondDepartment.stream()
                        .anyMatch(e1 -> e1.getFirstName().equals(e2.getFirstName())))
                .map(employee -> employee.getFirstName())
                .collect(Collectors.toList());

        HashSet<String> newListNames = new HashSet<>(commonNames);

        return newListNames.stream().toList();
    }
}