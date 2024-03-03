package model;


import java.util.UUID;

import static enums.ProjectStatus.STARTED;

public class Client {
    private String name;
    private String id;
    Project project = new Project();
    Company company = new Company();

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}' + "\n";
    }

    public Client(String name , String id) {
        this.name = name;
        this.id = id;
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

    // assigning / removing project
    public void assignProject(Project project){
        if(this.getProject().getId()!=null){
            System.out.println("** Client already assigned to a project **");
        } else {
            setProject(project);
        }
    }
    public void removeProject(Project project){
        if(this.getProject().getId() != null){
            if(this.getProject().equals(project)){
                setProject(null);
            } else {
                System.out.println("** Client not assigned to this project **");
            }
        } else {
            System.out.println("** Client not assigned to any project **");
        }
    }

}
