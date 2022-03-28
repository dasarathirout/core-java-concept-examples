package org.concept.streams.ex10;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCreationOperations {
    // Streams Creation & Parallel Execution.
    private static final Employee[] arrayEmployee = {
            new Employee(101, "EMP-101", 1000.0),
            new Employee(202, "EMP-202", 2000.0),
            new Employee(303, "EMP-303", 3000.0),
            new Employee(404, "EMP-404", 4000.0),
            new Employee(505, "EMP-505", 5000.0)
    };

    public static Employee searchEmployeeByEID(int empID) {
        for (Employee employee : arrayEmployee) {
            if (employee.getEmployeeID() == empID) {
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] arrays) {
        createStreamData();
        operateStreamData();
    }

    public static void createStreamData() {
        //(01)
        Stream.of(arrayEmployee);

        //(02)
        List<Employee> employeeList = Arrays.asList(arrayEmployee);
        employeeList.stream();

        //(03)
        Stream.of(arrayEmployee[0], arrayEmployee[1], arrayEmployee[2]);

        //(04)
        Stream.Builder<Employee> employeeStreamBuilder = Stream.builder();
        employeeStreamBuilder.accept(arrayEmployee[0]);
        employeeStreamBuilder.accept(arrayEmployee[1]);
        employeeStreamBuilder.accept(arrayEmployee[2]);
        Stream<Employee> employeeStream = employeeStreamBuilder.build();
    }

    public static void operateStreamData() {

        List<Employee> employeeList = Arrays.asList(arrayEmployee);

        // (01)
        // forEach() is a terminal operation, which means that, after the operation is performed,
        // the stream pipeline is considered consumed, and can no longer be used.
        employeeList.stream().forEach(e -> e.salaryIncrement(10.0));
        employeeList.forEach(employee -> System.out.println(employee));

        // (02)
        // map() produces a new stream after applying a function to each element of the original stream.
        Integer[] employeeIDs = {202, 303, 404};
        List<Employee> searchEmployees = Stream.of(employeeIDs)
                .map(StreamCreationOperations::searchEmployeeByEID)
                .collect(Collectors.toList());
        searchEmployees.forEach(employee -> System.out.println(employee));

        // (03)
        // collect() common ways to get stuff out of the stream once we are done with all the processing
        List<Employee> employeesCollected = employeeList.stream().collect(Collectors.toList());

        // (04)
        // filter() produces a new stream that contains elements of the original stream
        // which pass a given test (specified by a Predicate).

        Integer[] filterEIDS = {101, 202, 303, 404, 505};
        List<Employee> filterEmployees = Stream.of(filterEIDS)
                .map(StreamCreationOperations::searchEmployeeByEID)
                .filter(e -> e != null)
                .filter(e -> e.getEmployeeSalary() > 3000.00)
                .filter(e -> e.getEmployeeSalary() < 5000.00)
                .collect(Collectors.toList());
        System.out.println(filterEmployees);

        Employee employeeFirst = Stream.of(filterEIDS)
                .map(StreamCreationOperations::searchEmployeeByEID)
                .filter(e -> e != null)
                .filter(e -> e.getEmployeeSalary() > 3000.00)
                .filter(e -> e.getEmployeeSalary() < 5000.00)
                .findFirst()
                .orElse(null);
        System.out.println(employeeFirst);

        // (05)
        Employee[] employeesArray = employeeList.stream().toArray(Employee[]::new);

        // (06)
        employeeList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());

    }
}

class Employee {
    private int empID;
    private String empName;
    private double empSalary;

    public Employee() {
    }

    public Employee(int empID, String empName, double empSalary) {
        this.empID = empID;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public int getEmployeeID() {
        return this.empID;
    }

    public double getEmployeeSalary() {
        return this.empSalary;
    }

    public double salaryIncrement(double incrementPercentage) {
        this.empSalary = this.empSalary + this.empSalary / incrementPercentage;
        return this.empSalary;
    }

    @Override
    public String toString() {
        return "{ Employee : [ empID=" + empID + " , empName=" + empName + " , empSalary=" + empSalary + "] }";
    }
}
