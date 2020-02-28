package com.testproj.dockertest.dto;

public class EmployeeDto {

    private int employeeId;
    private String name;
    private String surname;
    private int age;
    private int department;

    public EmployeeDto(int employeeId, String name, String surname, int age, int department) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
