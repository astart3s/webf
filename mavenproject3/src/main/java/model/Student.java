package model;

import java.util.Date;

public class Student {
    private String id;
    private String name;
    private Date dob; // Assuming the use of java.util.Date
    private String department;
    private int selected;

    public Student() {
    }

    public Student(String id, String name, Date dob, String department, int selected) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.department = department;
        this.selected = selected;
    }
    
        public Student(String id, String name, Date dob, String department) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    
}