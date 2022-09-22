package tools;

import controllers.RegionController;
import models.Region;

import java.sql.Connection;

public class TestController {
    public static void main(String[] args) {
        Connection connection = new DbConnection().getConncetion();
        RegionController rc = new RegionController(connection);

//        System.out.println(rc.insert("0", "Cawang gunung"));

//        System.out.println(rc.update("13", "Banyu Pitu"));

//        System.out.println(rc.delete("8"));

        Region region = rc.getById("2");
        System.out.println("{id : "+region.getRegionId()+" , region : "+region.getRegionName()+"}" );


//        System.out.println(rc.getAll());
    }
}