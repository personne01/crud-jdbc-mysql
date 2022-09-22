package tools;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private Connection con;

    public Connection getConncetion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection("jdbc:mysql:///db_hr", "root", "");
        } catch (Exception e) {
            System.err.println("Error  "+ e.getMessage());
        }
        return con;
    }
}