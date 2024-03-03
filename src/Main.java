import enums.ProjectStatus;
import enums.SkillType;
import model.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Company companyA = new Company();
        companyA.setCompanyTitle("Company A");
        companyA.setCompanyId(UUID.randomUUID().toString().replace("-",""));
        System.out.println("Company details : "+ companyA.getCompanyTitle() +
                "\nCompany id : "+ companyA.getCompanyId() );
        System.out.println("*******************************");

        Employee employee1 = new Employee("Tom", 30, "manager", 5, LocalDate.of(2000, 2, 3));
        Employee employee2 = new Employee("Sam", 24, "developer", 5, LocalDate.of(2005, 2, 3));
        Employee employee3 = new Employee("Mary", 40, "lead engineer", 5, LocalDate.of(2012, 2, 3));
        employee1.setEmployeeId(UUID.randomUUID().toString().replace("-",""));
        employee2.setEmployeeId(UUID.randomUUID().toString().replace("-",""));
        employee3.setEmployeeId(UUID.randomUUID().toString().replace("-",""));
//        employee1.s

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);


        companyA.setEmployeeList(employeeList);
        System.out.println("Print all employees : " + companyA.getEmployeeList());
        System.out.println("===========================================");
        companyA.addEmployee(employee2);
        Employee employee4 = new Employee("Joe", 20, "Junior dev", 1, LocalDate.of(2022, 6, 3));
        companyA.addEmployee(employee4);
        System.out.println("Print all employees after adding new employee: " + companyA.getEmployeeList());
        System.out.println("Company size : " + companyA.getCompanySize());
        System.out.println("===========================================");
        companyA.removeEmployee(employee2);
        System.out.println("Print all employees after removing an employee: " + companyA.getEmployeeList());
        System.out.println("Company size : " + companyA.getCompanySize());
        System.out.println("===========================================");
        System.out.println("===========================================");


        List<Client> clientList = new ArrayList<>();
        Client client1 = new Client();
        client1.setId(UUID.randomUUID().toString().replace("-", ""));
        Client client2 = new Client("Clark", UUID.randomUUID().toString().replace("-", ""));
        Client client3 = new Client("Robert", UUID.randomUUID().toString().replace("-", ""));
        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        companyA.setClientList(clientList);
        System.out.println("Client list : " + companyA.getClientList());
        System.out.println("===========================================");
        companyA.removeClient(client1);
        System.out.println("Print all clients after removing a client : " + companyA.getClientList());
        System.out.println("===========================================");
        Client client4 = new Client("Mario", "04");
        companyA.addClient(client4);
        System.out.println("Client list after adding new client : " + companyA.getClientList());
        System.out.println("===========================================");
        System.out.println("===========================================");

        List<Project> projectList = new ArrayList<>();
        Project project1 = new Project("project 1", UUID.randomUUID().toString().replace("-", ""), ProjectStatus.DONE);
        Project project2 = new Project("project 2", UUID.randomUUID().toString().replace("-", ""), ProjectStatus.HOLD);
        projectList.add(project1);
        projectList.add(project2);
        companyA.setProjectList(projectList);
        System.out.println("Project list : " + companyA.getProjectList());
        System.out.println("===========================================");
        Project project3 = new Project("project 3", "03", ProjectStatus.STARTED);
        companyA.addProject(project3);
        System.out.println("Project list after adding new project: " + companyA.getProjectList());
        System.out.println("===========================================");
        companyA.removeProject(project1);
        System.out.println("Project list after removing DONE project: " + companyA.getProjectList());
        System.out.println("===========================================");
        companyA.removeProjectById("03");
        System.out.println("Project list after removing project using id: 03 " + companyA.getProjectList());
        System.out.println("===========================================");
        System.out.println("===========================================");

        employee1.assignProject(project1);
        System.out.println("Show "+ employee1.getName()+ "'s project : " + employee1.getProject());
        employee1.assignProject(project3);
        System.out.println("Show "+ employee1.getName()+ "'s project again : " + employee1.getProject());
        System.out.println("===========================================");
        employee1.removeProject(project1);
        System.out.println("Show "+ employee1.getName()+ "'s project after removing project : " + employee1.getProject());
        System.out.println("===========================================");
        System.out.println("===========================================");

        Set<EmployeeSkill> employeeSkillList = new HashSet<>();

        EmployeeSkill skill1 = new EmployeeSkill();
        skill1.setSkill(SkillType.WRITING);
        skill1.setProficiency(4);
        EmployeeSkill skill2 = new EmployeeSkill();
        skill2.setSkill(SkillType.AWS);
        skill2.setProficiency(10);
        EmployeeSkill skill3 = new EmployeeSkill();
        skill3.setSkill(SkillType.JAVA);
        EmployeeSkill skill4 = new EmployeeSkill();
        skill4.setSkill(SkillType.REACT);
        EmployeeSkill skill5 = new EmployeeSkill();
        skill5.setSkill(SkillType.READING);
        skill4.setProficiency(5);

        employeeSkillList.add(skill1);
        employeeSkillList.add(skill2);
        employeeSkillList.add(skill3);
        employee1.setEmployeeSkillList(employeeSkillList);
        System.out.println("Employee skill list : " + employeeSkillList);
        System.out.println("===========================================");
        employee1.addSkill(skill1);
        employee1.addSkill(skill4);
        System.out.println("Employee skill list after adding new skill : " + employeeSkillList);
        System.out.println("===========================================");

        employee3.addSkill(skill3);
        employee4.addSkill(skill3);
        employee4.addSkill(skill4);

//        employee1.updateSkill(skill4);
        employee1.updateSkill(skill1 , 10);
        System.out.println("Employee skill list with updated skill-1 : " + employeeSkillList);
        System.out.println("===========================================");
        System.out.println("===========================================");

        List <EmployeeSkill> employeeSkillList2 = new ArrayList<>();
        EmployeeSkill skill11 = new EmployeeSkill();
        skill11.setProficiency(2);
        skill11.setSkill(SkillType.WRITING);
//        employeeSkillList2.add(skill11);
        employee2.addSkill(skill11);


        System.out.println("employee 2 skill 1 : "+ employee2.getEmployeeSkillList());

        Client client = new Client();
        client.assignProject(project1);
        System.out.println("Client assigned to a project : " + client.getProject());
        System.out.println("===========================================");
        client.assignProject(project1);
        client.removeProject(project2);
        client.removeProject(project1);
        System.out.println("Client assigned to a project : " + client.getProject());
        System.out.println("===========================================");
        System.out.println("===========================================");

        // counting the number of skills an employee has
        System.out.print("Printing the number of skills " + companyA.getEmployeeList().get(0).getName() + " has : ");
        System.out.println(companyA.getEmployeeList().get(0).getEmployeeSkillList().size());
        System.out.println("Printing the skills set " + companyA.getEmployeeList().get(0).getName() + " has: ");
        System.out.println(companyA.getEmployeeList().get(0).getEmployeeSkillList());
        System.out.println("===========================================");
        System.out.println("*******************************************");
        System.out.println("===========================================");


        //      ============ DETAILS OF COMPANY B  ============
        Company companyB = new Company();
        List<Employee> employeeListB = new ArrayList<>();
        Employee employee01 = new Employee("Albert", 30, "manager", 5, LocalDate.of(2000, 2, 3));
        Employee employee02 = new Employee("Thomas", 24, "developer", 5, LocalDate.of(2005, 2, 3));
        Employee employee03 = new Employee("Ivy", 40, "lead engineer", 5, LocalDate.of(2012, 2, 3));
        Employee employee04 = new Employee("Mary", 40, "lead engineer", 5, LocalDate.of(2012, 2, 3));
        employee01.setEmployeeId(UUID.randomUUID().toString().replace("-",""));
        employee02.setEmployeeId(UUID.randomUUID().toString().replace("-",""));
        employee03.setEmployeeId(UUID.randomUUID().toString().replace("-",""));
        employee04.setEmployeeId(UUID.randomUUID().toString().replace("-",""));
        employeeListB.add(employee01);
        employeeListB.add(employee02);
        employeeListB.add(employee03);
        employeeListB.add(employee04);
        companyB.setEmployeeList(employeeListB);

        Set<EmployeeSkill> employeeSkillListB = new HashSet<>();

        EmployeeSkill skill001 = new EmployeeSkill();
        skill001.setSkill(SkillType.PRESENTATION);
        skill001.setProficiency(4);
        EmployeeSkill skill02 = new EmployeeSkill();
        skill02.setSkill(SkillType.AWS);
        skill02.setProficiency(10);
        EmployeeSkill skill03 = new EmployeeSkill();
        skill03.setSkill(SkillType.JAVA);
        skill03.setProficiency(5);
        EmployeeSkill skill04 = new EmployeeSkill();
        skill04.setSkill(SkillType.READING);
        skill04.setProficiency(5);

        employeeSkillListB.add(skill001);
        employeeSkillListB.add(skill02);
        employeeSkillListB.add(skill03);
        employee01.setEmployeeSkillList(employeeSkillListB);

        employee03.addSkill(skill001);
        employee02.addSkill(skill04);

        //       ================= ************* =======================
        //      ================= ************* =======================
        //       ================= ************* =======================

        // finding number of employees having java skills in company A
        System.out.println("Number of employees skilled in JAVA in company A : " + companyA.countEmployeeBasedOnSkill());
//
        System.out.println("===========================================");
        System.out.println("===========================================");

        System.out.println("Unique skillset of company A : " + companyA.getUniqueSkills());
        System.out.println("Unique skillset of company B : " + companyB.getUniqueSkills());

        Set companyASkills = companyA.getUniqueSkills();
        Set<SkillType> result = new HashSet<>(companyB.getUniqueSkills());
        result.removeAll(companyASkills);
        System.out.println("Skills in company B but not in A: " + result);

        System.out.println("Does Mary exist in both the companies ? " + Company.checkEmployeeDuplicates(companyA,companyB, "Mary"));
        System.out.println("Does Ivy exist in both the companies ? " + Company.checkEmployeeDuplicates(companyA,companyB, "Ivy"));

    }
}