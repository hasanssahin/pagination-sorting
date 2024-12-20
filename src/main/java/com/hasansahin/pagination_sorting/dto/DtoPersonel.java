package com.hasansahin.pagination_sorting.dto;

public class DtoPersonel {
    private String firstName;
    private String lastName;
    private DtoDepartment department;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DtoDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DtoDepartment department) {
        this.department = department;
    }
}
