package com.tutsplus.javalessons;


public interface MyInterface {
    String getAuthor();
    int getAuthorId();

    default String getProjectOwner() {
        return "Tuts+";
    }

    static int getProjectId() {
        return 9;
    }
}
