package org.concept.lambda.ex20;

import java.util.Arrays;
import java.util.function.*;
import java.util.logging.Logger;

public class PredefinedFunctionalInterfaces {
    private static final Logger LOG = Logger.getLogger(PredefinedFunctionalInterfaces.class.getName());

    public static void main(String[] args) {
        executeUnaryOperator();
        executeBinaryOperator();
        executeConsumer();
        executeSupplier();
        executeFunction();
        executePredicate();
    }

    public static void executeUnaryOperator() {
        UnaryOperator<String> stringUnaryOperator = String::toUpperCase;
        String value = stringUnaryOperator.apply("Dasarathi Rout");
        LOG.info("UnaryOperator<String>.apply() : " + value);
        stringUnaryOperator = String::new;
        LOG.info(stringUnaryOperator.apply("Hi, WhatsApp!"));
        stringUnaryOperator = UserDefined::apply;
        LOG.info(stringUnaryOperator.apply("1234567890"));
    }

    public static void executeBinaryOperator() {
        BinaryOperator<Integer> integerBinaryOperator;
        integerBinaryOperator = (I1, I2) -> 2 * (I1 + I2);
        LOG.info("BinaryOperator<Integer> : " + integerBinaryOperator.apply(11, 22));
        integerBinaryOperator = UserDefined::apply;
        LOG.info("(a+b)^2 : 7^2 " + integerBinaryOperator.apply(3, 4));
    }

    public static void executeConsumer() {
        Consumer<Employee> employeeConsumer;
        employeeConsumer = employee -> {
            employee.setEid(employee.getEid() << 2);
            employee.setUname(employee.getUname().toUpperCase());
            LOG.info(employee.toString());
        };
        employeeConsumer.accept(new Employee(12345, "user-name"));
    }

    public static void executeSupplier() {
        Supplier<Employee> employeeSupplier;
        employeeSupplier = () -> {
            return new Employee(1111, "SUPPLIER");
        };
        LOG.info(employeeSupplier.get().toString());
    }

    public static void executeFunction() {
        Function<Integer, String> integerStringFunction;
        integerStringFunction = integer -> Arrays.toString(String.valueOf(integer).toCharArray());
        LOG.info(integerStringFunction.apply(12345));
    }

    public static void executePredicate() {
        Predicate<Integer> integerPredicate;
        integerPredicate= integer -> integer>99;
        LOG.info(""+integerPredicate.test(100));
        LOG.info(""+integerPredicate.test(90));
    }
}

