package org.concept.design;

public class SingleResponsibility {
    /*
     * A class should only have one responsibility.
     * Furthermore, it should only have one reason to change.
     **/
}


class Book {
    //v1.0
    private String name;
    private String author;
    private String text;
    // Constructor Getters Setters

    //v1.1
    public String replaceWord(String word) {
        return text.replaceAll(word, text);
    }

    public boolean isContainsWord(String word) {
        return text.contains(word);
    }
}

class BookPrintService {
    //v2.0
    public void createPaperCopy() {
    }
    public void createHardCoverCopy() {
    }
    public void createSoftCopy() {
    }
}