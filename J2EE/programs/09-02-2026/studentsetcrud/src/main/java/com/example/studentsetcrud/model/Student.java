package com.example.studentsetcrud.model;


public class Student {
    private long id;
    private String name;
    private String address;
    private int pinCode;

    public Student() {
    }

    public Student(long id, String name, String address, int pinCode) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pinCode = pinCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
