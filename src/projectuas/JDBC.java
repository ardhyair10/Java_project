//package projectuas;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class JDBC{
//    private Connection connection;
//    public JDBC(String url,String username,String password){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            this.connection = DriverManager.getConnection(url,username,password);
//            
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//        public ResultSet executeQuery(String query){
//            try {
//                Statement statement = connection.createStatement();
//                return statement.executeQuery(query);
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//        public void closeConnection(){
//            try {
//                if (connection != null && !connection.isClosed()) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        
//        
//        
//}