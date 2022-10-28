package example;

import java.sql.*;

public class UpdateSample {
    public static Connection getConnection() throws SQLException, java.lang.ClassCastException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/studentinfo";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String userName = "root";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, userName, password);
        return con;
    }
    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT Sno, Sname, Sage, Sadd FROM student1");
            rs.first();
            rs.updateString("Sname", "Liu");
            rs.updateString("Sadd", "Shanghai");
            rs.updateRow();

            rs.moveToInsertRow();
            rs.updateString("Sno", "6");
            rs.updateString("Sname", "Zhang");
            rs.updateInt("Sage", 19);
            rs.updateString("Sadd", "Guangzhou");
            rs.insertRow();

            rs.absolute(3);
            rs.deleteRow();
            ResultSet result = stmt.executeQuery("SELECT Sno, Sname, Sage, Sadd FROM student1");
            System.out.println("Student1表中的数据如下：");
            System.out.println("--------------------");
            System.out.println("学号"+" "+"姓名"+" "+"年龄"+" "+"地址");
            System.out.println("--------------------");
            while(result.next()) {
                int nunber = result.getInt("Sno");
                String name = result.getString("Sname");
                int age = result.getInt("Sage");
                String add = result.getString("Sadd");
                System.out.println(" "+nunber+" "+name+" "+age+" "+add);
            }
            stmt.close();
            con.close();
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        } catch (SQLException ex) {
            System.err.println("SQLException:"+ex.getMessage());
        }
    }
}
