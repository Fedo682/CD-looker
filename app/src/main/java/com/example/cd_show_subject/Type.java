package com.example.cd_show_subject;


import java.util.List;

public class Type {

    private String Name;
    private List<CD> cds;


    public Type(String name, List<CD> cds) {
        this.Name = name;
        this.cds = cds;
    }

    public String getName() {
        return this.Name;

    }

    public List<CD> getCds() {
        return this.cds;
    }

    public String PrintBooks() {
        StringBuilder strBuilder = new StringBuilder();
        for (CD book : cds) {
            strBuilder.append(book.toString()).append(" \n");
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }
}
