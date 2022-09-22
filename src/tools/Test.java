package tools;

import daos.concretes.RegionDAO;
import models.Region;

public class Test {

    public static void main(String[] args) {
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConncetion());

        RegionDAO regConn = new RegionDAO(connection.getConncetion());


//        Region region = regConn.getById(3);

//        System.out.println("id : "  +region.getRegionId());
//        System.out.println("memiliki name : " + region.getRegionName());

//        System.out.println(regConn.delete(11));

//        Region region = new Region(11, "Jombang Terus");
//        System.out.println(regConn.update(region));


//        Region region = new Region(0, "Kota kota");
//        System.out.println(regConn.insert(region));


//        for (Region region : regConn.getAll()) {
//            System.out.println(region.getRegionId());
//            System.out.println(region.getRegionName());
//        }

    }
}
