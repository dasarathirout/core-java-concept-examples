package org.concept.lambda.ex18;

import java.util.logging.Logger;

public class MethodReferencesLEX {
    private static final Logger LOG = Logger.getLogger(MethodReferencesLEX.class.getName());

    static String stringProcess(StringOperations operationsLEX, String inData) {
        return operationsLEX.process(inData);
    }

    public static void main(String[] args) {
        String inData = "0123456789";
        // Static Method Reference
        stringProcess(Contents::reverseData, inData);

        // Non-Static Method Reference
        Contents contents = new Contents();
        inData = "Java, Python, Go.";
        stringProcess(contents::changeUC, inData);

        // Constructor Reference
        UpdateUser updateUser = User::new;
        User user = updateUser.setEmail("java.se@oracle.com");
        LOG.info(user.getEmail());
    }
}
// Functional Interface
interface StringOperations {
    String process(String inStr);
}

// Functional Interface
interface UpdateUser {
    User setEmail(String inStr);
}

class Contents {
    private static final Logger LOG = Logger.getLogger(Contents.class.getName());

    public static String reverseData(String inStr) {
        String reversed = "";
        for (int i = inStr.length() - 1; i >= 0; i--) {
            reversed += inStr.charAt(i);
        }
        LOG.info("REVERSED CONTENTS : " + reversed);
        return reversed;
    }

    public String changeUC(String inStr) {
        String changedData = inStr.toUpperCase();
        LOG.info("UPPER CASE : " + changedData);
        return changedData;
    }
}

class User {
    private String email;

    public User() {
        email = "NOT DEFINED";
    }
    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
