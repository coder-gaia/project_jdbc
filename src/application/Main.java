package application;


import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== TEST nº01: seller findById ===");
        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println("\n === TEST nº02: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDAO.findByDepartment(department);

        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n === TEST nº03: seller findAll ===");
        list = sellerDAO.findAll();

        for(Seller obj : list){
            System.out.println(obj);
        }
    }
}