package application;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println(" ----------- Test 1º: Department Insertion -----------");
        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
        Department department = new Department(7, "Food");
        departmentDAO.insert(department);
        System.out.println("Inserted! New id: " + department.getId());

        System.out.println(" ----------- Test 2º: Department FindById -----------");
        department = departmentDAO.findById(1);
        System.out.println(department);

        System.out.println(" ----------- Test 3º: Department Update -----------");
        department = departmentDAO.findById(2);
        department.setName("Eletronics");
        departmentDAO.update(department);
        System.out.println("Update finished!");

        System.out.println(" ----------- Test 4º: Department FindALl -----------");
        List<Department> list;
        list = departmentDAO.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }

        System.out.println(" ----------- Test 5º: Department DeleteById -----------");
        System.out.println("Insert the department id for deletion: ");
        int idToBeDeleted = sc.nextInt();
        departmentDAO.deleteById(idToBeDeleted);
        System.out.println("Deleted successfully");

        sc.close();
    }
}
