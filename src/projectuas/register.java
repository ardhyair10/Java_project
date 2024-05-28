/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectuas;

import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
/**
 *
 * @author ardhy
 */
public class register extends javax.swing.JFrame {
    private String CIF;
    private String generatedOTP;
    private String enteredOTP;
    private String Nama;
    private String Email;
    private String no_hp;
    private String Username;
    private String Password;
    private String tanggalLahir;
    private String tanggal_registrasi;
    private String [] array;
    private String [] array1;
    private String data;
    private final int points = 100;
    private byte[] imageData;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    Utility function = new Utility();
    User User = new User();
             
             
    public register() {
        initComponents();
       setupPasswordListener();
      
      try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
            // Handle the exception (e.g., show an error message) based on your application's requirements
        }
        
    }
    
    
    public String get_mail() {
    return email_user.getText();
}
    public String [] get_array(){
        return array1;
    } 


 
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        photo_chooser = new javax.swing.JFileChooser();
        jOptionPane1 = new javax.swing.JOptionPane();
        otp = new javax.swing.JPanel();
        otp_text = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        panel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nama_user = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email_user = new javax.swing.JTextField();
        no_hpUser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        password1 = new javax.swing.JPasswordField();
        password = new javax.swing.JPasswordField();
        Selesai = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tanggal_lahir = new com.toedter.calendar.JDateChooser();
        show_password = new javax.swing.JCheckBox();
        username = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        statuslabel = new javax.swing.JLabel();
        mailStatus = new javax.swing.JLabel();
        statuskolom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        photo_chooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        photo_chooser.setDialogTitle("");
        photo_chooser.setDragEnabled(true);
        photo_chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photo_chooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(photo_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(photo_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        otp_text.setText("jTextField1");

        jButton3.setText("jButton3");

        jButton4.setText("jButton3");

        jButton5.setText("jButton3");

        javax.swing.GroupLayout otpLayout = new javax.swing.GroupLayout(otp);
        otp.setLayout(otpLayout);
        otpLayout.setHorizontalGroup(
            otpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otpLayout.createSequentialGroup()
                .addGroup(otpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(otpLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(otp_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(otpLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        otpLayout.setVerticalGroup(
            otpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otpLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(otp_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(otpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setToolTipText("");
        panel1.setkEndColor(new java.awt.Color(255, 255, 255));
        panel1.setkGradientFocus(1000);
        panel1.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(102, 255, 51));
        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("New member registration");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nama");

        nama_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_userActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email");

        email_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_userActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Password");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("No Handphone");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tanggal Lahir");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ReType Password");

        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        Selesai.setText("Selesai");
        Selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelesaiActionPerformed(evt);
            }
        });

        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        show_password.setForeground(new java.awt.Color(0, 0, 0));
        show_password.setText("Show Password");
        show_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_passwordActionPerformed(evt);
            }
        });

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Username");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Red Yellow Simple Tour Bus Rental Travel Logo (1).png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(470, 470, 470)
                        .addComponent(email_user, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(470, 470, 470)
                        .addComponent(no_hpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(470, 470, 470)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(470, 470, 470)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(481, 481, 481)
                        .addComponent(tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addComponent(jButton2)
                        .addGap(249, 249, 249)
                        .addComponent(Selesai))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(statuskolom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mailStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(348, 348, 348)
                                .addComponent(show_password, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(30, 30, 30)))
                                .addGap(164, 164, 164))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(470, 470, 470)
                                .addComponent(nama_user, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(55, 55, 55)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(nama_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(email_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(no_hpUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(show_password))
                    .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statuskolom, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(statuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mailStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tanggal_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(Selesai))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed
    public String[] getdata(){
        return array1;
    
    }
    private void show_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_passwordActionPerformed
        if (show_password.isSelected()) {
            password.setEchoChar((char) 0); // Set echo char to 0 to show the password
            password1.setEchoChar((char) 0);
        } else {
            password.setEchoChar('*'); // Set echo char to '*' to hide the password
            password1.setEchoChar('*');
        }
        checkPassword();
    }//GEN-LAST:event_show_passwordActionPerformed

    private void SelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelesaiActionPerformed

        Nama = nama_user.getText();
        Email = email_user.getText();
        no_hp = no_hpUser.getText();
        Username = username.getText();
        Password = password.getText();
        function.encrypt(Password);
        String salt = function.generateSalt();
        data = function.getEncryptedResult();
        String newpass = salt + data;
        Date date = tanggal_lahir.getDate();
        // Print statements for debugging
        System.out.println("Salt: " + salt);
        System.out.println("Encrypted Password: " + data);
        System.out.println(newpass);
        // Memastikan semua kolom telah diisi
        if (Nama.isEmpty() || Email.isEmpty() || no_hp.isEmpty() || Username.isEmpty() || Password.isEmpty() || date == null) {
            JOptionPane.showMessageDialog(null, "Semua kolom harap di isi", "Error", JOptionPane.ERROR_MESSAGE);
            
            return;  // Keluar dari metode jika ada kolom yang belum diisi
        }else{
            function.generateAndPrintOTP(Email);
            generatedOTP = function.getOTP();
        }
        // Cek apakah email sudah terdaftar
        if (!Query.isEmailRegistered(Email)) {   
        } else {
            // Email sudah terdaftar, berikan pesan kesalahan atau lakukan tindakan lainnya
            statuskolom.setText("Email Sudah terdaftar");
            statuskolom.setForeground(Color.red);
        }
        tanggalLahir = sdf1.format(date);
        tanggal_registrasi = sdf.format(Calendar.getInstance().getTime());
        function.generateCIFNumber();
        CIF = function.getCIFNumber();
       // Path to the original image file
        String imagePath = "D:\\kuliah\\SMT 2\\Struktur data\\Project uas\\projectUAs\\src\\icon\\profle_pict.png";
        try {
            // Read the image data from the file
            imageData = Utility.readImage(imagePath);
        } catch (Exception ex) {
            // Log any exceptions that occur during image reading
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
        String point = String.valueOf(points);
        String [] arraypass ={CIF,Username,salt};
        String [] array_data= {CIF, Nama, Username, Email, no_hp ,newpass, tanggalLahir, tanggal_registrasi,point};
        this.array = array_data;
        this.array1 = arraypass;
        
        jOptionPane1.getDesktopPaneForComponent(otp);
        enteredOTP = otp_text.getText();
        
        optionPane();
        
        

    }//GEN-LAST:event_SelesaiActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed
    void optionPane(){
        generatedOTP = function.getOTP();
        jOptionPane1.showConfirmDialog(this,"Do you receive OTP in Your E-mail?");
        String enteredOTP = jOptionPane1.showInputDialog("");
        
        if (enteredOTP.equals(generatedOTP) ) {
           User.registrasi(array,array1,imageData);
            JOptionPane.showMessageDialog(null, "Anda Berhasil Terdaftar", "Notification", JOptionPane.INFORMATION_MESSAGE);
            new Login().show();
            this.dispose();
            
        } else {
            jOptionPane1.showConfirmDialog(this, "OTP SALAH");
            optionPane();
        }
    
    }
    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password1ActionPerformed
        password1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPassword();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPassword();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak relevan untuk plain text fields
            }
        });
    }//GEN-LAST:event_password1ActionPerformed
    
    private void nama_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_userActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Login().show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void email_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_userActionPerformed

    private void photo_chooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photo_chooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_photo_chooserActionPerformed
    
    private void setupPasswordListener() {
        password.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPassword();
                
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPassword();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak relevan untuk plain text fields
            }
        });
        password1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPassword();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPassword();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak relevan untuk plain text fields
            }
        });
         email_user.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            checkEmail();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkEmail();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not relevant for plain text fields
        }
    });

    // Add a listener to the username text field
    username.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            checkUsername();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            checkUsername();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not relevant for plain text fields
        }
    });
}

private void checkEmail() {
    String enteredEmail = email_user.getText();
    if (Query.isEmailRegistered(enteredEmail)) {
        mailStatus.setText("Email Sudah terdaftar");
        mailStatus.setForeground(Color.red);
    } else {
        mailStatus.setText("");
    }
}

private void checkUsername() {
    String enteredUsername = username.getText();
    if (Query.isUsernameRegistered(enteredUsername)) {
        statuskolom.setText("Username Sudah terdaftar");
        statuskolom.setForeground(Color.red);
    } else {
        statuskolom.setText("");
    }
    }

private void checkPassword() {
    String enteredPassword = new String(password.getPassword());
    String correctPassword = new String(password1.getPassword());

    if (enteredPassword.isEmpty()) {
        statuslabel.setText("");
    } else if (correctPassword.equals(enteredPassword)) {
        statuslabel.setText("Password match!");
        statuslabel.setForeground(Color.GREEN);
    } else {
        statuslabel.setText("Password incorrect. Try again.");
        statuslabel.setForeground(Color.RED);
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        System.out.println("hello");
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Selesai;
    private javax.swing.JTextField email_user;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mailStatus;
    private javax.swing.JTextField nama_user;
    private javax.swing.JTextField no_hpUser;
    private javax.swing.JPanel otp;
    private javax.swing.JTextField otp_text;
    private keeptoo.KGradientPanel panel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password1;
    private javax.swing.JFileChooser photo_chooser;
    private javax.swing.JCheckBox show_password;
    private javax.swing.JLabel statuskolom;
    private javax.swing.JLabel statuslabel;
    private com.toedter.calendar.JDateChooser tanggal_lahir;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
