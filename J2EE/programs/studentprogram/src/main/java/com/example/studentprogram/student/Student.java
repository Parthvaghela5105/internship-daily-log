package com.example.studentprogram.student;

public class Student {
    private String name;
    private String rollno;
    private String address;
    private int pincode;
    private String statusMessage;

    public Student() {
    }

    public Student(String name, String rollno, String address, int pincode, String statusMessage) {
        this.name = name;
        this.rollno = rollno;
        this.address = address;
        this.pincode = pincode;
        this.statusMessage = statusMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollno='" + rollno + '\'' +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
