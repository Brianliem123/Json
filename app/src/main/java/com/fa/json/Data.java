package com.fa.json;

public class Data {
    String name,gender;
    int age;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Data(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
