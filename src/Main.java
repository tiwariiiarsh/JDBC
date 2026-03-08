import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Main {

    private static  final String url="jdbc:mysql://localhost:3306/jdbc_Bank";
    private static  final String userName="root";
    private static  final String password="Arsh@1106";

    public static void main(String[] args) {

//       1) This part loads teh Drivers
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

//  ================= execution of CRUD Operation through Statement Interface===========================================
//      try{
//            Connection connection = DriverManager.getConnection(url,userName,password);
////            query will execute through statement interface
//            Statement statement = connection.createStatement();

//   --------------------------------Retrieval  query-------------------------------------
//            String query = "SELECT*FROM Students";
////            when we retrieve data from DB through query--> use executeQuery
////            retrieve  data stored in the form of tables  and ResultSet used to store data in tableform
//            ResultSet resultSet =    statement.executeQuery(query);
//
//            while(resultSet.next()){  //resultSet.next()--> boolean type --> return true if next row is available in row
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age  = resultSet.getInt("age");
//                Double marks = resultSet.getDouble("marks");
//                System.out.println("ID:  "+ id);
//                System.out.println("name:  "+ name);
//                System.out.println("Age:  "+  age);
//                System.out.println("Marks:  "+ marks);
//            }
//---------------------------------------Insertion query----------------------------------------
//            String query = String.format("INSERT INTO Students(name,age,marks) VALUES('%s', %o, %f)","Alan",21,99.8);
////            when we insert,delete,update data from DB through query--> use executeUpdate
//            int rowsAffected = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data inserted successfully !!");
//            }else{
//                System.out.println("Data not inserted ");
//            }


//  ===================================Update query==============================================

//            String query = String.format("UPDATE Students SET marks = %f WHERE id = %d",98.8,3);
////            when we insert,delete,update data from DB through query--> use executeUpdate
//            int rowsAffected = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data updated successfully !!");
//            }else{
//                System.out.println("Data not updated ");
//            }
//
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }


//  =========================== Delete query ============================================

//            String query = String.format("DELETE FROM Students WHERE id=%d",3);
////            when we insert,delete,update data from DB through query--> use executeUpdate
//            int rowsAffected = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("deleted successfully !!");
//            }else{
//                System.out.println("Not deleted updated !");
//            }
//
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }


//===================CRUD Operation through PreparedStatement Interface====================================
//

//   ----------------------------Insertion Operation---------------------------------
//        try{
//            Connection connection = DriverManager.getConnection(url,userName,password);
////            query will execute through statement interface
//            String query = "INSERT INTO Students(name,age,marks) VALUES(?,?,?)";
////            Statement statement = connection.createStatement();   //query is complied every time before run
//            PreparedStatement preparedStatement = connection.prepareStatement(query);   //query is compiled once here throughout code
//            preparedStatement.setString(1,"Ankita");
//            preparedStatement.setInt(2,20);
//            preparedStatement.setDouble(3,93.3);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            if(rowsAffected>0){
//                System.out.println("Data inserted successfully !!");
//            }else{
//                System.out.println("Data not inserted ");
//            }
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }


//  -----------------------------Retrieval Operation-------------------------------------------------

//        try{
//            Connection connection = DriverManager.getConnection(url,userName,password);
////            query will execute through statement interface
//            String query = "SELECT*FROM Students WHERE id = ?";
////            Statement statement = connection.createStatement();   //query is complied every time before run
//            PreparedStatement preparedStatement = connection.prepareStatement(query);   //query is compiled once here throughout code
//            preparedStatement.setInt(1,1);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()){
//                double marks = resultSet.getDouble("marks");
//                System.out.println("Marks:  "+marks);
//            }else{
//                System.out.println("Marks not found !");
//            }
//
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }


//  -------------------------Update query---------------------------------------
//        try{
//            Connection connection = DriverManager.getConnection(url,userName,password);
////            query will execute through statement interface
//            String query = "UPDATE Students SET marks = ? WHERE id = ?";
////            Statement statement = connection.createStatement();   //query is complied every time before run
//            PreparedStatement preparedStatement = connection.prepareStatement(query);   //query is compiled once here throughout code
//            preparedStatement.setDouble(1,89);
//            preparedStatement.setInt(2,4);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if(rowsAffected>0){
//                System.out.println("Data updated successfully !!");
//            }else{
//                System.out.println("Data not updated ! ");
//            }
//
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }


// ========================= Batch Operation with Statement interface ============================================
//
//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            Scanner sc = new Scanner(System.in);
//            Statement statement = connection.createStatement();
//            while (true){
//                System.out.println("Enter name:  ");
//                String name = sc.next();
//                System.out.println("Enter age:  ");
//                int age = sc.nextInt();
//                System.out.println("Enter Marks:  ");
//                double marks = sc.nextDouble();
//                System.out.println("Enter more data(Y/N):  ");
//                String choice = sc.next();
//                String query = String.format("INSERT INTO Students(name,age,marks) VALUES('%s', %d, %f)",name,age,marks);
//                statement.addBatch(query);
//                if (choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//            int[] arr = statement.executeBatch();
//            for (int i=0;i<arr.length;i++){
//                if (arr[i]==0){
//                    System.out.println("Query "+i+" is not executed successfully !");
//                }
//            }
//
//
//        }catch (SQLException  e){
//            System.out.println(e.getMessage());
//        }

//  =================Batch Operation with PreparedStatement interface============================


//        try {
//            Connection connection = DriverManager.getConnection(url, userName, password);
//            Scanner sc = new Scanner(System.in);
//            String query = String.format("INSERT INTO Students(name,age,marks) VALUES(?,?,?)");
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            while (true){
//                System.out.println("Enter name:  ");
//                String name = sc.next();
//                System.out.println("Enter age:  ");
//                int age = sc.nextInt();
//                System.out.println("Enter Marks:  ");
//                double marks = sc.nextDouble();
//                System.out.println("Enter more data(Y/N):  ");
//                String choice = sc.next();
//                preparedStatement.setString(1,name);
//                preparedStatement.setInt(2,age);
//                preparedStatement.setDouble(3,marks);
//                preparedStatement.addBatch();
//                if (choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//            int[] arr = preparedStatement.executeBatch();
//            for (int i=0;i<arr.length;i++){
//                if (arr[i]==0){
//                    System.out.println("Query "+i+" is not executed successfully !");
//                }
//            }
//
//
//        }catch (SQLException  e){
//            System.out.println(e.getMessage());
//        }


//  ========================= COMMIT  &&  ROLLBACK =====================================

        Connection connection;
        try {

            connection = DriverManager.getConnection(url, userName, password);

            connection.setAutoCommit(false);

            double amount = 1000;

            if (is_Sufficient(connection, 1102, amount)) {

                String debit_query =
                        "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";

                String credit_query =
                        "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

                PreparedStatement debit_ps =
                        connection.prepareStatement(debit_query);

                PreparedStatement credit_ps =
                        connection.prepareStatement(credit_query);

                debit_ps.setDouble(1, amount);
                debit_ps.setInt(2, 1102);

                credit_ps.setDouble(1, amount);
                credit_ps.setInt(2, 1106);

                int row1 = debit_ps.executeUpdate();
                int row2 = credit_ps.executeUpdate();

                if (row1 > 0 && row2 > 0) {
                    connection.commit();
                    System.out.println("Transaction Successful");
                } else {
                    connection.rollback();
                    System.out.println("Transaction Failed");
                }

            } else {
                System.out.println("Insufficient Balance");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean is_Sufficient (Connection connection,
                                         int account_number,
                                         double amount){

        try {

            String query =
                    "SELECT balance FROM accounts WHERE account_number = ?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, account_number);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");

                return balance >= amount;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}