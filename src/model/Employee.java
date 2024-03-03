package model;

import enums.Department;

import java.time.LocalDate;
import java.util.*;

public class Employee {
    private String employeeId;
    private String name;
    private int age;
    private String designation;
    private int yearsOfExperience;
    private LocalDate joiningDate;
    Project project = new Project();
    Company company = new Company();
    Department department;

    Set<EmployeeSkill> employeeSkillList = new HashSet<>();

    public Employee(String name, int age, String designation, int yearsOfExperience, LocalDate joiningDate) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.yearsOfExperience = yearsOfExperience;
        this.joiningDate = joiningDate;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public Project getProject() {
        return project;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", joiningDate=" + joiningDate +
                '}' + "\n";
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDesignation() {
        return designation;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
    public void setEmployeeSkillList(Set<EmployeeSkill> employeeSkillList) {
        this.employeeSkillList = employeeSkillList;
    }
    public Set<EmployeeSkill> getEmployeeSkillList() {
        return employeeSkillList;
    }

    // assigning / removing project
    public void assignProject(Project project){
        if(this.getProject().getId()!=null){
            System.out.println("** Employee already assigned to a project **");
        } else {
            setProject(project);
        }
    }
    public void removeProject(Project project){
        if(this.getProject().getId() != null){
            if(this.getProject().equals(project)){
                setProject(null);
            } else {
                System.out.println("** Employee not assigned to this project **");
            }
        } else {
            System.out.println("** Employee not assigned to any project **");
        }
    }

    // adding / updating skill
    public void addSkill(EmployeeSkill skill){
        if(employeeSkillList.contains(skill)) {
            System.out.println("Skill already exists!");
        } else {
            employeeSkillList.add(skill);
        }
    }
    public void updateSkill(EmployeeSkill skill, int proficiency){
        if(employeeSkillList.contains(skill)) {
            skill.setProficiency(proficiency);
        } else {
            System.out.println("** This skill is not assigned to the employee **");
            System.out.println("===========================================");
        }
    }
}
