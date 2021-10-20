package hotelmanagement.company;

import java.sql.*;

public  class conn {


    public static void main(String[] args) {
        String localhost="jdbc:mysql://localhost:3306/mohit";
        String username="root";
        String password="Mohit*123";
        try (
                Connection connection = DriverManager.getConnection(localhost, username, password)) {

            Statement s= connection.createStatement();
            String str="Select * from login ";
            ResultSet  rs= s.executeQuery(str);


   } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}





