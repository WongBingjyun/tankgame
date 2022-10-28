package example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DataBaseCreate {
    public static Connection getConnection() throws SQLException, java.lang.ClassCastException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/bingchat";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String userName = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, userName, password);
        return con;
    }
    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            Statement sql = con.createStatement();
            sql.executeUpdate("drop table if exists f100");
            sql.executeUpdate("create table f100 (Id varchar(20) not null, primary key(Id));");
            sql.executeUpdate("insert f100 values('101')");
            sql.close();
            con.close();
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex) {
            System.err.println("SQLException:"+ex.getMessage());
        }
    }
}
