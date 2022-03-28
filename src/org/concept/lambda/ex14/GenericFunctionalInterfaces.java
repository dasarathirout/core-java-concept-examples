package org.concept.lambda.ex14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class GenericFunctionalInterfaces {
    private static final Logger LOG = Logger.getLogger(GenericFunctionalInterfaces.class.getName());

    interface GeneralOperation<T> {
        T[] change(T T1, T T2);
    }

    interface UserActions<T> {
        List<T> change(T T);
    }

    public static void main(String[] args) {
        executeLEX41();
        executeLEX42();
        executeLEX43();
    }

    public static void executeLEX41() {
        GeneralOperation<String> operation;
        operation = (String S1, String S2) -> {
            String[] array = new String[3];
            array[0] = S1;
            array[1] = S2;
            array[2] = S1 + S2;
            LOG.info(Arrays.toString(array));
            return array;
        };
        operation.change("ABC", "123");
    }

    public static void executeLEX42() {
        UserActions<String> action;
        action = (inStr) -> {
            char[] chars = inStr.toCharArray();
            List<String> list = new LinkedList<>();
            for (int i = 0; i < chars.length; i++) {
                list.add(chars[i] + "" + chars[i]);
            }
            LOG.info(inStr + " => " + list);
            return list;
        };
        action.change("ABC123");
    }

    public static void executeLEX43() {
        UserActions<Integer> actions;
        actions = (number) -> {
            Integer inPut = number;
            LinkedList stack = new LinkedList();
            while (number > 0) {
                stack.push(number % 10);
                number = number / 10;
            }
            List list = new ArrayList<>();
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            LOG.info(inPut + " => " + list);
            return list;
        };
        actions.change(12345);
    }

}
