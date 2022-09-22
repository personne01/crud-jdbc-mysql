package daos.concretes;

import daos.interfaces.IRegionDAO;
import models.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionDAO implements IRegionDAO{
    private Connection connection;
    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM REGION";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                regions.add(new Region(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }

    public Region getById(int regionID) {
        Region region = null;
        String query = "SELECT name FROM region WHERE id ="
                + regionID;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT id,name FROM REGION WHERE id=?");
            ps.setInt(1, regionID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                region = new Region(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return region;
    }

    public boolean insert(Region region) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO REGION(id, name) VALUES(?,?)");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            boolean rows = preparedStatement.execute();

            if (rows == true ) {
                System.out.println("Data berhasil Ditambahkan");
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(Region region){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE region " + "SET name = ? " + "WHERE id = ?");
            preparedStatement.setString(1, region.getRegionName());
            preparedStatement.setInt(2, region.getRegionId());
            preparedStatement.execute();

            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(int regionId){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `region` WHERE `region`.`id` = ?");
            preparedStatement.setInt(1, regionId);
            preparedStatement.execute();

            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
