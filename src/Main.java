import java.sql.*;

public class Main {

    private static  final String url="jdbc:mysql://localhost:3306/?user=root";
    private static  final String userName="root";
    private static  final String password="Arsh@1106";

    public static void main(String[] args) {

//       1) This part loads teh Drivers
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }



    }
}