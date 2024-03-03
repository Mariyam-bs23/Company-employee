package model;

import enums.CompanyType;
import enums.SkillType;

import java.util.*;

public class Company {
    private String companyId;
    private String companyTitle;
    private List<Employee> employeeList;
    private List<Client> clientList;
    private List<Project> projectList;
    private CompanyType type;

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId='" + companyId + '\'' +
                ", companyTitle='" + companyTitle + '\'' +
                ", employeeList=" + employeeList +
                ", clientList=" + clientList +
                ", projectList=" + projectList +
                ", type=" + type +
                '}' + "\n";
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    // employee add / remove
    public void addEmployee(Employee employee) {
        // if employee id contains  - print
        if (employeeList.contains(employee)) {
            System.out.println("Employee already exists!");
        } else {
            employeeList.add(employee);
        }
    }

    public void removeEmployee(Employee employee) {
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
        } else {
            System.out.println("Employee doesn't exist!");
        }

    }

    public void removeEmployeeById(String id) {
        Iterator<Employee> it = employeeList.iterator();
        while (it.hasNext()) {
            Employee employee = it.next();
            if (employee.getEmployeeId().equals(id)) {
                it.remove();
                return;
            }
        }
    }

    public int getCompanySize() {
        return employeeList.size();
    }

    // client add/remove,
    public void addClient(Client client) {
        if (clientList.contains(client)) {
            System.out.println("Client already exists!");
        } else {
            clientList.add(client);
        }
    }

    public void removeClient(Client client) {
        if (clientList.contains(client)) {
            clientList.remove(client);
        } else {
            System.out.println("Client doesn't exist!");
        }

    }

    public void removeClientById(String id) {
        Iterator<Client> it = clientList.iterator();
        while (it.hasNext()) {
            Client client = it.next();
            if (client.getId().equals(id)) {
                it.remove();
                return;
            }
        }
    }

    // project add/remove,
    public void addProject(Project project) {
        if (projectList.contains(project)) {
            System.out.println("Project already exists!");
        } else {
            projectList.add(project);
        }
    }

    public void removeProject(Project project) {
        if (projectList.contains(project)) {
            projectList.remove(project);
        } else {
            System.out.println("Project doesn't exist!");
        }

    }

    public void removeProjectById(String id) {
        Iterator<Project> it = projectList.iterator();
        while (it.hasNext()) {
            Project project = it.next();
            if (project.getId().equals(id)) {
                it.remove();
                return;
            }
        }
    }

    public Map<SkillType, Integer> countEmployeeBasedOnSkill() {
        List<EmployeeSkill> employeeSkills = new ArrayList<>();
        Map<SkillType, Integer> counterMap = new HashMap<>();
        getEmployeeList().forEach(employee -> {
            employeeSkills.addAll(employee.getEmployeeSkillList());
        });
        employeeSkills.forEach(employeeSkill -> {
            if (counterMap.containsKey(employeeSkill.getSkill())) {
                counterMap.put(employeeSkill.getSkill(), counterMap.get(employeeSkill.getSkill()) + 1);
            } else {
                counterMap.put(employeeSkill.getSkill(), 1);
            }
        });

        System.out.println(counterMap + " countermap");
        return counterMap;
    }

    public Set getUniqueSkills() {
        Set<SkillType> skillSet = new HashSet<>();
        for (Employee employee : getEmployeeList()) {
            for (EmployeeSkill skill : employee.getEmployeeSkillList()) {
                skillSet.add(skill.getSkill());
            }
        }
        return skillSet;
    }

    public static boolean checkEmployeeDuplicates(Company company1, Company company2, String name) {
        boolean hasSameEmployee = false;
        for (Employee employee1 : company1.getEmployeeList()) {
            for (Employee employee2 : company2.getEmployeeList()) {
                if (employee1.getName().equals(name) && employee2.getName().equals(name)) {
                    hasSameEmployee = true;
                    break;
                }
            }
            if (hasSameEmployee) {
                break;
            }
        }
        return hasSameEmployee;
    }
}