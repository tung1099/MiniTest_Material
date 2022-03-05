package view;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ArrayList<Material> materials = new ArrayList<>();
        CrispyFlour crispyFlour1 = new CrispyFlour("C1", "CrispyFlour 1", LocalDate.of(2021, 8, 1), 10, 1);
        CrispyFlour crispyFlour2 = new CrispyFlour("C2", "CrispyFlour 2", LocalDate.of(2021, 6, 2), 10, 10);
        CrispyFlour crispyFlour3 = new CrispyFlour("C3", "CrispyFlour 3", LocalDate.of(2021, 5, 3), 10, 100);
        CrispyFlour crispyFlour4 = new CrispyFlour("C4", "CrispyFlour 4", LocalDate.of(2021, 4, 4), 10, 20);
        CrispyFlour crispyFlour5 = new CrispyFlour("C5", "CrispyFlour 5", LocalDate.of(2021, 2, 5), 10, 50);
        materials.add(crispyFlour1);
        materials.add(crispyFlour2);
        materials.add(crispyFlour3);
        materials.add(crispyFlour4);
        materials.add(crispyFlour5);

        Meat meat1 = new Meat("M1", "Meat 1", LocalDate.of(2022, 2, 25), 100, 1200);
        Meat meat2 = new Meat("M2", "Meat 2", LocalDate.of(2022, 2, 2), 100, 20);
        Meat meat3 = new Meat("M3", "Meat 3", LocalDate.of(2022, 2, 22), 100, 2000);
        Meat meat4 = new Meat("M4", "Meat 4", LocalDate.of(2022, 2, 23), 100, 400);
        Meat meat5 = new Meat("M5", "Meat 5", LocalDate.of(2022, 2, 24), 100, 500);
        materials.add(meat1);
        materials.add(meat2);
        materials.add(meat3);
        materials.add(meat4);
        materials.add(meat5);


        int choice = -1;
        Scanner inputChoice = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("________Menu_________");
            System.out.println("1. Hiển thị tất cả sản phẩm");
            System.out.println("2. Thêm mới sản phẩm Cripsy Flour");
            System.out.println("3. Thêm mới sản phẩm Meat");
            System.out.println("4. Xóa sản phẩm theo tên");
            System.out.println("5. Sửa sản phẩm Meat");
            System.out.println("6. Sửa sản phẩm Cripsy Flour");
            System.out.println("0. Exit");
            System.out.print("Lựa chọn của bạn: ");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    MaterialManager.displayMaterials(materials);
                    break;
                case 2:
                    MaterialManager.addProduct(materials, MaterialManager.createNewCrispyFlour());
                    break;
                case 3:
                    MaterialManager.addProduct(materials, MaterialManager.createNewMeat());
                    break;
                case 4:
                    MaterialManager.deleteProductByName(materials);
                    break;
                case 5:
                    MaterialManager.editMeatByName(materials);
                    break;
                case 6:
                    MaterialManager.editCrispyFlourByName(materials);
                    break;
                case 0:
                    System.exit(0);

                default:
                    System.out.println("Nhập sai ! Mời nhập lại...");
            }
            double totalPrice = 0;
            double totalPriceAfterDiscount = 0;
            for (Material material:materials
            ) {
                totalPrice += material.getCost();
                totalPriceAfterDiscount += material.getRealMoney();
            }
            double totalDifference = totalPrice - totalPriceAfterDiscount;
            System.out.println("Tổng chênh lệch giữa chiết khấu và không chiết khấu là: " + totalDifference);
        }
    }
}

