package application;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        System.out.println("\n === TEST nº04: seller insertion ===");
        Seller newSeller = new Seller(null, "Greg", "gre@gmail.com", new Date(), 4000.0, department);
        sellerDAO.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());

        System.out.println("\n === TEST 05: seller update ===");
        seller = sellerDAO.findById(1);
        seller.setName("Bob Yellowstone");
        sellerDAO.update(seller);
        System.out.println("Update finished!");

        System.out.println("\n === TEST 06: seller delete ===");
        System.out.println("Insert the seller id for deletion: ");
        int idToBeDeleted = sc.nextInt();
        sellerDAO.deleteById(idToBeDeleted);
        System.out.println("Deleted!");

        sc.close();
    }
}