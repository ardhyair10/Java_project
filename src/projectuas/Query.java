package projectuas;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;



public class Query {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/travel";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
   private String [] jurusan;
   private String [] stringArray;
   
   public String [] getUserArray(){
       return stringArray;
   }
   public String[] getjursan() {
       return jurusan;
    }
   
    static void query_add_new_user(String[] array,String []array1,byte[] ImageData) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // The SQL Query with placeholders (?)
            String sql = "INSERT INTO user (CIF, NAMA, USERNAME, EMAIL, NO_HP, PASSWORD, TANGGAL_LAHIR, TANGGAL_REGISTRASI,POINTS,PROFILE_PICTURE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set values for the placeholders from the array
                for (int i = 0; i < array.length; i++) {
                    preparedStatement.setString(i + 1, array[i]);
                }
                // Execute the Query
                    preparedStatement.setBytes(10, ImageData);
                    
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected >0) {
                    System.out.println("Data inserted successfully.");
                    storeSalt(array1);
                } else {
                    System.out.println("Failed to insert data.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void update_user(String[] array, String CIF, byte[] ImageData) {
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        // The SQL Query with placeholders (?)
        String sql = "UPDATE user SET NAMA = ?, USERNAME = ?, NO_HP = ?, PROFILE_PICTURE = ? WHERE CIF = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for the placeholders from the array
            for (int i = 0; i < array.length; i++) {
                preparedStatement.setString(i + 1, array[i]);
            }
            // Set bytes for PROFILE_PICTURE (use index 5)
            preparedStatement.setBytes(4, ImageData);
            preparedStatement.setString(5, CIF);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("Failed to update data.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public static boolean get_data(String Username, String Password) {
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        // The SQL Query with placeholders (?)
        String sql = "SELECT * FROM user WHERE USERNAME = ? AND PASSWORD = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for the placeholders
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Password);

            // Execute the Query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if there is at least one row in the result set
                return resultSet.next();
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false; // Return false in case of an exception
}
    
 public static String select_oldPass(String Otp) {
    String password = null;

    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        // The SQL Query with placeholders (?)
        String sql = "SELECT PASSWORD FROM user WHERE VERIFICATION_CODE = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for the placeholders
            preparedStatement.setString(1, Otp);

            // Execute the Query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if there is at least one row in the result set
                if (resultSet.next()) {
                    // Retrieve the password from the result set
                    password = resultSet.getString("PASSWORD");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return password;
}

    
    public static boolean isEmailRegistered(String email) {
      
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // SQL Query dengan placeholder (?)
            String sql = "SELECT * FROM user WHERE EMAIL = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);

                // Eksekusi Query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Jika resultSet memiliki baris, artinya email sudah terdaftar
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void storeSalt(String[] data) {
    // Check the length of the input array
  
    // Initialize the connection outside the try-with-resources block for better error reporting
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        // Prepare the SQL Query
        String sql = "INSERT INTO password (CIF,USERNAME, CIF_PS) VALUES (?, ?, ?)";

        // Prepare the statement outside the try-with-resources block for better error reporting
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for the placeholders using a loop
            for (int i = 0; i < data.length; i++) {
                preparedStatement.setString(i + 1, data[i]);
            }

            // Execute the Query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        }
    } catch (SQLException e) {
        // Print the stack trace for detailed error information
        e.printStackTrace();
        // Log the error message
        System.err.println("SQLException: " + e.getMessage());
    }
}
    public static String retrieveSalt(String username) {
    String salt = null;

    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        String sql = "UPDATE SALT 'order' where";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    salt = resultSet.getString("CIF_PS");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("SQLException: " + e.getMessage());
    }

    return salt;
}
    public static String get_salt(String username) {
    String salt = null;

    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        // The SQL Query with placeholders (?)
        String sql = "SELECT CIF_PS FROM password WHERE USERNAME = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for the placeholders
            preparedStatement.setString(1, username);

            // Execute the Query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve the salt from the result set
                    salt = resultSet.getString("CIF_PS");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return salt;
}
    public static int getOrderCount(String tanggal, String kodeKendaraan) {
    int orderCount = 0;

    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        String sql = "SELECT COUNT(*) AS jumlah_order FROM `order` WHERE TANGGAL_PESANAN = ? AND KODE_KENDARAAN = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tanggal);
            preparedStatement.setString(2, kodeKendaraan);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    orderCount = resultSet.getInt("jumlah_order");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return orderCount;
}

    public static void updatePassword(String PASSWORD, String USERNAME){
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        // Prepare the SQL Query
        String sql = "UPDATE user SET PASSWORD = ? WHERE USERNAME = ?";

        // Prepare the statement outside the try-with-resources block for better error reporting
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for the placeholders
            preparedStatement.setString(1,PASSWORD );
            preparedStatement.setString(2, USERNAME);

            // Execute the Query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("No data updated. Username not found.");
            }
        }
    } catch (SQLException e) {
        // Print the stack trace for detailed error information
        e.printStackTrace();
        // Log the error message
        System.err.println("SQLException: " + e.getMessage());
    }
    
    }
   public static void updateSalt(String username, String newSalt) {
    // Initialize the connection outside the try-with-resources block for better error reporting
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        // Prepare the SQL Query
        String sql = "UPDATE password SET CIF_PS = ? WHERE USERNAME = ?";

        // Prepare the statement outside the try-with-resources block for better error reporting
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for the placeholders
            preparedStatement.setString(1, newSalt);
            preparedStatement.setString(2, username);

            // Execute the Query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("No data updated. Username not found.");
            }
        }
    } catch (SQLException e) {
        // Print the stack trace for detailed error information
        e.printStackTrace();
        // Log the error message
        System.err.println("SQLException: " + e.getMessage());
    }
   }
    public static void updateusername(String newUsername, String CIF) {
    // Initialize the connection outside the try-with-resources block for better error reporting
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
    String sql = "UPDATE password SET USERNAME = ? WHERE CIF = ?";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        // Set the new username and the old username
        preparedStatement.setString(1, newUsername); // Assuming newUsername is the new value
        preparedStatement.setString(2, CIF); // Assuming oldUsername is the old value

        // Execute the update
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Username updated successfully.");
        } else {
            System.out.println("Failed to update username.");
        }
    }
} catch (SQLException e) {
    e.printStackTrace();
}

        
    
    }
    public static boolean isUsernameRegistered(String usernameUser) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // SQL Query dengan placeholder (?)
            String sql = "SELECT * FROM user WHERE USERNAME = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, usernameUser);

                // Eksekusi Query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Jika resultSet memiliki baris, artinya email sudah terdaftar
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        public String[] data_jurusan() {

        Set<String> kendaraanSet = new HashSet<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT ASAL FROM kendaraan WHERE ASAL IS NOT NULL";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    // For each row, create a KendaraanData object and add it to the set
                    String asal = resultSet.getString("ASAL");
                    // Add more variables as needed

                    // Add the value to the set
                    kendaraanSet.add(asal);
                    // Add more values as needed
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.jurusan = kendaraanSet.toArray(new String[0]);
        return this.jurusan;  // Return the array
    

    }
    public static String[] getJamBerangkat(String tanggalBerangkat) {

        Set<String> jamBerangkat = new HashSet<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT DISTINCT JAM_BERANGKAT FROM `order` WHERE TANGGAL_PESANAN = ? ";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, tanggalBerangkat);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {
                        // For each row, create a KendaraanData object and add it to the set
                        String jamBerangkatValue = resultSet.getString("JAM_BERANGKAT");

                        // Parse the original time
                        

                        // Add the modified value to the set
                        jamBerangkat.add(jamBerangkatValue);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jamBerangkat.toArray(new String[0]);  // Return the array
    }


        

        public static void main(String[] args) {
            String Jam = "19-12-2023";
           String []jam = getJamBerangkat(Jam);
           for (String jamValue : jam) {
            System.out.println(jamValue);
            }
    }
}


    
    



//static void query_add(String[] userData) {
//    String DB_URL = "jdbc:mysql://localhost:3306/bioskop";
//    String username = "root";
//    String password = "";
//
//    try (Connection connection = DriverManager.getConnection(DB_URL, username, password)) {
//        // The SQL Query with placeholders (?)
//        String sql = "INSERT INTO user (CIF, Nama, Username, Password) VALUES (?, ?, ?, ?)";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            // Set values for the placeholders
//            for (int i = 0; i < userData.length; i++) {
//                preparedStatement.setString(i + 1, userData[i]);
//            }
//
//            // Execute the Query
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected > 0) {
//                System.out.println("Data inserted successfully.");
//            } else {
//                System.out.println("Failed to insert data.");
//            }
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}