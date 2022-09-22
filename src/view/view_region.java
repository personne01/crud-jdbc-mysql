package view;

import controllers.RegionController;
import models.Region;
import tools.DbConnection;

import java.sql.Connection;
import java.util.Scanner;

public class view_region {
    public static void main(String[] args) {

        Connection connection = new DbConnection().getConncetion();

        RegionController rc = new RegionController(connection);

        int a = 0;
        while(a == 0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("===== Pilih Menu ======");
            System.out.println("===== 1. insert =====");
            System.out.println("===== 2. update =====");
            System.out.println("===== 3. delete =====");
            System.out.println("===== 4. tampilkan menurut id =====");
            System.out.println("===== 5. Exit =====");
            System.out.println("Masukkan pilihan : ");
            int input = scanner.nextInt();
                if (input == 1){
                    System.out.println("Masukkan nama region : ");
                    String name = scanner.next();
                    System.out.println(rc.insert("0", name));
                } else if (input == 2) {
                    System.out.println("Maskkan id yang ingin diupdate : ");
                    String id = scanner.next();
                    System.out.println("Masukkan nama region baru : ");
                    String name = scanner.next();
                    System.out.println(rc.update(id, name));
                } else if (input == 3){
                    System.out.println("Masukkan id yang ingin didelete : ");
                    String id = scanner.next();
                    System.out.println(rc.delete(id));
                } else if (input == 4) {
                    System.out.println("Masukkan id yang ingin ditampilkan : ");
                    String id = scanner.next();
                    Region region = rc.getById(id);
                    System.out.println(region.getRegionId()+" : " + region.getRegionName());
                } else a = 1;
        }
    }
}
