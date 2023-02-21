package com.example.tablebook;

public class modelclass {
    String name;
    String phone;
    String timing;
    String persons;

    public modelclass (String name, String phone, String timing,String persons) {
        this.name = name;
        this.phone = phone;
        this.timing = timing;
        this.persons=persons;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getTiming() {
        return timing;
    }

    public String getPersons() {
        return persons;
    }
}
