package model;

import enums.ProjectStatus;

import java.util.ArrayList;
import java.util.List;

public class Project{
    private String name;
    private String id;
    private ProjectStatus status;
    List<Employee> employeeList = new ArrayList<>();
//    Client client = new Client();
    Company company = new Company();

    public Project(String name, String id, ProjectStatus status) {
        this.name = name;
        this.id = id;
        this.status = status;
    }
    public Project() {}

    @Override
    public String toString() {
        return "Project {" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", status=" + status +
                '}' + "\n";
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
//    public void setClient(Client client) {
//        this.client = client;
//    }
//    public Client getClient() {
//        return client;
//    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public Company getCompany() {
        return company;
    }

}
