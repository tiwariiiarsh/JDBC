import java.sql.*;

public class Main {

    private static  final String url="jdbc:mysql://localhost:3306/jdbc";
    private static  final String userName="root";
    private static  final String password="Arsh@1106";

    public static void main(String[] args) {

//       1) This part loads teh Drivers
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,userName,password);
//            query will execute through statement interface
            Statement statement = connection.createStatement();
            String query = "SELECT*FROM Students";
//            when we retrieve data from DB through query--> use executeQuery
//            retrieve  data stored in the form of tables  and ResultSet used to store data in tableform
            ResultSet resultSet =    statement.executeQuery(query);

            while(resultSet.next()){  //resultSet.next()--> boolean type --> return true if next row is available in row
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age  = resultSet.getInt("age");
                Double marks = resultSet.getDouble("marks");
                System.out.println("ID:  "+ id);
                System.out.println("name:  "+ name);
                System.out.println("Age:  "+  age);
                System.out.println("Marks:  "+ marks);
            }
//            when we insert,delete,update data from DB through query--> use executeUpdate
//            statement.executeUpdate(query);


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}