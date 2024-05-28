package projectuas; 

import java.io.File;

public class User {
    Utility function = new Utility();
    void registrasi(String[] array,String[] array1, byte [] imageData) {
        
        
        Query.query_add_new_user(array,array1,imageData);
        
    }
}
class RegisteredUser extends User { // Assuming User is the parent class
 
    public static boolean login(String username, String password) {
    Utility function = new Utility();
    function.encrypt(password);

    // Retrieve salt from the database
    String retrievedSalt = Query.get_salt(username);

    if (retrievedSalt != null) {
        // Concatenate retrieved salt with encrypted password
        String combinedPassword = retrievedSalt + function.getEncryptedResult();

        // Call the get_data method and store its result in a boolean variable
        boolean userExists = Query.get_data(username, combinedPassword);

        // Return true if user exists, false otherwise
        return userExists;
    } else {
        // Salt not found for the username, login fails
        return false;
    }
}


    public static void main(String[] args) {
       Utility utility = new Utility();
        utility.generateCIFNumber();
        

         for (int i = 0; i < 5; i++) {
             String cifNumber = utility.getCIFNumber();
            System.out.println("Nomor CIF: " + cifNumber);
        }
    }
}


  

