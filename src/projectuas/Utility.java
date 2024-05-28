package projectuas;
// Provides functionality for creating hash functions.
import java.awt.Image;
import java.io.FileInputStream;
import java.security.MessageDigest;
// Exception thrown when a particular cryptographic algorithm is requested but not available.
import java.security.NoSuchAlgorithmException;
// Provides a cryptographically strong random number generator.
import java.security.SecureRandom;
// Formats and parses dates in a locale-sensitive manner.

// Represents a persistent set of properties or configuration settings.
import java.util.Properties;
// An integer value that may be updated atomically.
// Classes for sending emails using JavaMail API
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// JDBC classes for Java Database Connectivity (JDBC)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.text.Document;






/**
 *
 * @author ardhy
 */
    public class Utility {
    private String encryptedResult;
    private String newCIFNumber;
    private String otp;

    
    
            


    
public String getCIFNumber() {
    return newCIFNumber;
}
static String CheckOTP(String Username){
    String url = "jdbc:mysql://localhost:3306/travel";
        String username = "root";
        String password = "";
        String otp = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT VERIFICATION_CODE FROM user WHERE USERNAME = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, Username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        otp = resultSet.getString("VERIFICATION_CODE");
                        

                        System.out.println(otp);

                        // Schedule the deletion of OTP after 5 minutes
                        
                    } else {
                        System.out.println("Email not found in the database.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return otp;
}
        public static byte[] readImage(String imagePath) throws Exception {
                try (FileInputStream fileInputStream = new FileInputStream(imagePath)) {
                    return fileInputStream.readAllBytes();
                }
        }
        
public static ImageIcon resizeImage(ImageIcon imageIcon, int width, int height) {
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

 void lupa_password(String Username) {
        String url = "jdbc:mysql://localhost:3306/travel";
        String username = "root";
        String password = "";
        String OTP = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT EMAIL FROM user WHERE USERNAME = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, Username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String email = resultSet.getString("EMAIL");
                        

                        Utility utility = new Utility();
                        utility.generateAndPrintOTP(email);
                        OTP = utility.getOTP();
                        this.otp = OTP;
                        utility.update_OTPColumn(connection,email , OTP);
                        System.out.println(OTP);
                        System.out.println(email);

                        // Schedule the deletion of OTP after 5 minutes
                        scheduleOTPDeletion(email);
                    } else {
                        System.out.println("Email not found in the database.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void scheduleOTPDeletion(String email) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        // Schedule the deletion of OTP after 5 minutes
        executorService.schedule(() -> {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel", "root", "")) {
                // Hapus OTP dari database
                deleteOTPFromDatabase(connection, email);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, 3, TimeUnit.MINUTES);

        // Shutdown the executor service gracefully after all tasks are done
        executorService.shutdown();
    }

    static void deleteOTPFromDatabase(Connection connection, String email) throws SQLException {
        String deleteSql = "UPDATE user SET VERIFICATION_CODE = NULL WHERE EMAIL = ?";
        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
            deleteStatement.setString(1, email);

            int affectedRows = deleteStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("OTP deleted successfully!");
            } else {
                System.out.println("Failed to delete OTP. User not found or other error.");
            }
        }
    }
   public static String generateSalt() {
        // Panjang salt yang diinginkan (dalam byte)
        int saltLength = 16;

        // Menggunakan SecureRandom untuk mendapatkan nilai acak yang aman
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[saltLength];
        secureRandom.nextBytes(salt);

        // Mengubah byte salt menjadi string menggunakan Base64 encoding
        return Base64.getEncoder().encodeToString(salt);
    }
   public static ImageIcon createImageIcon(byte[] imageData) {
    if (imageData != null && imageData.length > 0) {
        return new ImageIcon(imageData);
    } else {
        // Return a default image icon or handle the case where no image is available
        return null;
    }
}


 public void encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA3-512");
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert to hexadecimal representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Update the encryptedResult field with the result
            encryptedResult = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEncryptedResult() {
        return encryptedResult;
    }
   
    void generateAndPrintOTP(String email) {
    int length = 6;
    // Range of characters used in OTP
    String characters = "0123456789";
    // SecureRandom to ensure randomness
    SecureRandom random = new SecureRandom();
    // StringBuilder to compose OTP
    StringBuilder otp = new StringBuilder();
    
    // Generate OTP with the specified length
    for (int i = 0; i < length; i++) {
        int index = random.nextInt(characters.length());
        otp.append(characters.charAt(index));
    }

    // Print the generated OTP
    System.out.println("Generated OTP: " + otp.toString());

    // Save the generated OTP to the instance variable
    this.otp = otp.toString();
    
    // Send the OTP via email
    sendEmail(email, this.otp);
}

public String getOTP() {
    return otp;
}
   

void update_OTPColumn(Connection connection, String email, String providedOTP) throws SQLException {
    // Assuming getOTP() is a method that generates a new OTP
    String newOTP = getOTP();
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    // Update the OTP in the database based on the user's email
    String updateSql = "UPDATE user SET VERIFICATION_CODE = ? WHERE EMAIL = ?";
    try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
        updateStatement.setString(1, newOTP);
        updateStatement.setString(2, email);

        int affectedRows = updateStatement.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("OTP updated successfully!");
            
        } else {
            System.out.println("Failed to update OTP. User not found or other error.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        
    }
    
  }
    
    static void sendEmail( String to, String content) {
        String sender = "prodigytravel62@gmail.com";
        String password = "ovcu vbbe cgyt vlkb";
        String subject = "Kode verifikasi";
        String body = "kode verfikasi anda : "+content;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sender,password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
    throw new RuntimeException("Failed to send email: " + e.getMessage(), e);
}
    } 
    public static void sendEmailReminder(String cif, String email,String nama) {
    // Implement your logic to send an email reminder here
    System.out.println("Sending reminder to CIF: " + nama + ", Email: " + email);

    // Add your email sending logic here
    String sender = "prodigytravel62@gmail.com";
    String password = "ovcu vbbe cgyt vlkb";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(sender, password);
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("Reminder: Jam keberangkatan Anda Sudah Dekat");
        message.setText("Dear"+nama+",\n\nThis is a reminder for your upcoming order.");

        Transport.send(message);

        System.out.println("Email sent successfully.");

    } catch (MessagingException e) {
        e.printStackTrace();
        System.err.println("Failed to send email.");
    }
}
    public void generateCIFNumber() {
    String url = "jdbc:mysql://localhost:3306/travel";
    String username = "root";
    String password = "";
    String cifValue ="";
//    List <String> cifList = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        // Query SQL untuk mendapatkan nomor CIF terakhir
        String sql = "SELECT CIF FROM user ORDER BY CIF DESC LIMIT 1;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                    cifValue = resultSet.getString("CIF");
                    System.out.println(cifValue);
                    long CIF =Long.parseLong(cifValue);
                        System.out.println(CIF);
                    long NewCIF = CIF+1;
                        System.out.println(NewCIF);
                    this.newCIFNumber = String.valueOf(NewCIF);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    

    
    
//    int uniqueSequence = Integer.parseInt(index);
//    this.newCIFNumber = Integer.toString(uniqueSequence);
 
//            this.newCIFNumber = currentDate + String.format("%03d", uniqueSequence);
////            this.newCIFNumber = Integer.toString(uniqueSequence);
//            System.out.println(uniqueSequence);
//            if (cifList.contains(newCIFNumber)&&uniqueSequence) {
//                System.out.println("CIF ada di list");
//                System.out.println(uniqueSequence);
//                uniqueSequence = uniqueSequence+1;
//                this.newCIFNumber =currentDate + String.format("%03d", uniqueSequence);
//       
//            } else {
//                System.out.println("CIF tidak ada di list");
//                uniqueSequence = uniqueSequence+1;
//                this.newCIFNumber =currentDate + String.format("%03d", uniqueSequence);
//            }
//            for (String name : cifList) {
//            System.out.println(name);
//        }
            
    
}

    public static void main(String[] args) {
     Utility funct = new Utility();
     funct.encrypt("031220");
        System.out.println(funct.getEncryptedResult());
    }
}
//static void lupa_password(String email) {
//        String url = "jdbc:mysql://localhost:3306/bioskop";
//        String username = "root";
//        String password = "";
//        String OTP = "";
//
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            String sql = "SELECT EMAIL FROM user WHERE EMAIL = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setString(1, email);
//
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    if (resultSet.next()) {
//                        email = resultSet.getString("EMAIL");
//                        function function = new function();
//                        function.generateAndPrintOTP(email);
//                        OTP = function.getOTP();
//                        function.update_OTPColumn(connection, email, OTP);
//                        System.out.println(OTP);
//                    } else {
//                        System.out.println("Email not found in the database.");
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//    }
//    
//
//    void update_OTPColumn(Connection connection, String email, String providedOTP) throws SQLException {
//    // Assuming getOTP() is a method that generates a new OTP
//    String newOTP = getOTP();
//    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//
//    // Update the OTP in the database based on the user's email
//    String updateSql = "UPDATE user SET VERIFICATION_CODE = ? WHERE EMAIL = ?";
//    try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
//        updateStatement.setString(1, newOTP);
//        updateStatement.setString(2, email);
//
//        int affectedRows = updateStatement.executeUpdate();
//
//        if (affectedRows > 0) {
//            System.out.println("OTP updated successfully!");
//            
//        } else {
//            System.out.println("Failed to update OTP. User not found or other error.");
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//        
//    }
//    
//  }

        
       

