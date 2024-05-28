package projectuas;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
//import org.apache.pdfbox.pdmodel.common.PDRectangle;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
/**
 *
 * @author ardhy
 */
    public class homePage extends javax.swing.JFrame {
    private static String usernameUser;
    private static String [] data = new String[7];
    private ArrayList<String> seat;
    private String [] jurusan_asal;
    private boolean isProgrammaticChange = false;
    private DefaultComboBoxModel<String> asalModel;
    private DefaultComboBoxModel<String> tujuanModel;
    private ArrayList<String> selectedSeats = new ArrayList<>();
    private static int Total;
    private static int harga_seat;
    private static String tanggalBerangkat;
    private static String KodeKendaraan;
    private static String CIF;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/travel";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static int value_seat;
    private static String nama;
    private static String Email;
    private static String notlp;
    private static String jam_berangkat;
    private static String[] data_info = new String[5];
    DefaultListModel<String> listModel = new DefaultListModel<>();
    private static int Harga;
    private static String Jam;
    private static byte [] imageData;
    private static ImageIcon image;
    private static String [] data_update;
   
    


      
    /**
     * Creates new form homePage
     */
    CardLayout cardLayout;
    public homePage() {
        
        initComponents();
        user_username.setText(usernameUser);
        photo.setIcon(image);
        setupUsernameListener();
        String[] jamBerangkat = Query.getJamBerangkat(tanggal.getText());
        sendRemindersForAllJam(jamBerangkat);

        // Buat array dari JCheckBox
    JCheckBox[] seatCheckboxes = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14};

    // Tambahkan ActionListener untuk setiap JCheckBox
    for (int i = 0; i < seatCheckboxes.length; i++) {
        String seatNumber = String.valueOf(i + 1);
        seatCheckboxes[i].addActionListener(new SeatCheckBoxListener(seatNumber));
    }
        
       Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mendapatkan waktu saat ini
                Date now = new Date();
                // Membuat format waktu
                SimpleDateFormat sdf_tanggal = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat sdfTanggalBerangkat = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat sdf_jam = new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat sdf_jam1 = new SimpleDateFormat("HH:mm");
                // Menetapkan waktu yang diformat ke label
                tanggal.setText(sdf_tanggal.format(now));
                Jam = sdf_jam.format(now);
                jam.setText(sdf_jam.format(now));
                Date date = tanggal_berangkat.getDate();
                tanggalBerangkat = sdfTanggalBerangkat.format(date);
                tanggal_label.setText(tanggalBerangkat);
                tanggal_label1.setText(tanggalBerangkat);
                int total = 10;
//                
//                ImageIcon imageuser = Utility.resizeImage(image, WIDTH, HEIGHT);
//                
                
                
            }
        });
       timer.start();
        
        Component [] components = this.getContentPane().getComponents();
        for(Component component : components){
            if (component instanceof  JButton jButton) {
                jButton.setUI(new BasicButtonUI());
                jButton.setFocusPainted(false);
            }
        }
       
        Date date = new Date();
        tanggal_berangkat.getDayChooser().setMinSelectableDate(date);
        Query getData = new Query();
        
        getData.data_jurusan();
        jurusan_asal = getData.getjursan();
        
        
        
//        String [] item = {"JAKARTA","BANDUNG","YOGYAKARTA"};
        asalModel = new DefaultComboBoxModel<>(jurusan_asal);
        asalTXT.setModel(asalModel);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Add ItemListener to both asalTXT and tujuanTXT
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Qris = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        selectPhoto = new javax.swing.JFrame();
        photoPicker = new javax.swing.JFileChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jam = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        user_username = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ticket = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        keberangkatan = new javax.swing.JPanel();
        asalTXT = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        tanggal_berangkat = new com.toedter.calendar.JCalendar();
        jLabel7 = new javax.swing.JLabel();
        tujuanTXT = new javax.swing.JComboBox<>();
        reset = new javax.swing.JButton();
        tanggal_label = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jadwal_Berangkat = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        s1 = new javax.swing.JCheckBox();
        s3 = new javax.swing.JCheckBox();
        s4 = new javax.swing.JCheckBox();
        s5 = new javax.swing.JCheckBox();
        s7 = new javax.swing.JCheckBox();
        s6 = new javax.swing.JCheckBox();
        s2 = new javax.swing.JCheckBox();
        s8 = new javax.swing.JCheckBox();
        s9 = new javax.swing.JCheckBox();
        s10 = new javax.swing.JCheckBox();
        s11 = new javax.swing.JCheckBox();
        s13 = new javax.swing.JCheckBox();
        s14 = new javax.swing.JCheckBox();
        s12 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        list_pilihan = new javax.swing.JList<>();
        jButton9 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tanggal_label1 = new javax.swing.JLabel();
        Kode_kendaraan = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Nama_penumpang = new javax.swing.JTextField();
        No_nik = new javax.swing.JTextField();
        Kelamin = new javax.swing.JComboBox<>();
        comboBoxSeat = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_penumpang = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        pembayaranCbbox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        LabelTotalBayar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        booked_ticket = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel_tiket = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tiket_info = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        myProfile = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        editProfile = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        namaUpdate = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        noTlpUpdate = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        UsernameUpdate = new javax.swing.JTextField();
        browse = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        fotoPath = new javax.swing.JTextField();
        StatusUsername = new javax.swing.JLabel();

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/qris.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout QrisLayout = new javax.swing.GroupLayout(Qris.getContentPane());
        Qris.getContentPane().setLayout(QrisLayout);
        QrisLayout.setHorizontalGroup(
            QrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        QrisLayout.setVerticalGroup(
            QrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        photoPicker.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        photoPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoPickerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectPhotoLayout = new javax.swing.GroupLayout(selectPhoto.getContentPane());
        selectPhoto.getContentPane().setLayout(selectPhotoLayout);
        selectPhotoLayout.setHorizontalGroup(
            selectPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(photoPicker, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        selectPhotoLayout.setVerticalGroup(
            selectPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(photoPicker, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Red Yellow Simple Tour Bus Rental Travel Logo (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1329, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home (1).png"))); // NOI18N
        jButton1.setText("HOME");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bus.png"))); // NOI18N
        jButton2.setText("TICKET");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 153, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/information-button (1).png"))); // NOI18N
        jButton3.setText("ABOUT");
        jButton3.setBorder(new javax.swing.border.MatteBorder(null));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 153, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/booked ticket.png"))); // NOI18N
        jButton4.setText("MY TICKET");
        jButton4.setBorder(new javax.swing.border.MatteBorder(null));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jam.setBackground(new java.awt.Color(204, 204, 204));
        jam.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jam.setForeground(new java.awt.Color(0, 0, 0));
        jam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tanggal.setBackground(new java.awt.Color(255, 255, 255));
        tanggal.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        tanggal.setForeground(new java.awt.Color(0, 0, 0));
        tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clock.png"))); // NOI18N

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Calendar.png"))); // NOI18N

        user_username.setBackground(new java.awt.Color(255, 255, 255));
        user_username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        user_username.setForeground(new java.awt.Color(0, 0, 0));

        jButton6.setBackground(new java.awt.Color(51, 153, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/information-button (1).png"))); // NOI18N
        jButton6.setText("PROFILE INFO");
        jButton6.setBorder(new javax.swing.border.MatteBorder(null));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(user_username, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jam, tanggal});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(user_username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jam, tanggal});

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.CardLayout());

        home.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Red Yellow Simple Tour Bus Rental Travel Logo.gif"))); // NOI18N

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(home, "home");

        ticket.setBackground(new java.awt.Color(255, 204, 102));

        asalTXT.setFocusCycleRoot(true);
        asalTXT.setFocusable(false);
        asalTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asalTXTActionPerformed(evt);
            }
        });

        jLabel1.setText("Asal");

        jLabel3.setText("Tanngal : ");

        jLabel5.setText("Tanggal Keberangkatan");

        jButton5.setText("Cari");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Tujuan");

        tujuanTXT.setFocusable(false);
        tujuanTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tujuanTXTActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/placeholder.gif"))); // NOI18N

        javax.swing.GroupLayout keberangkatanLayout = new javax.swing.GroupLayout(keberangkatan);
        keberangkatan.setLayout(keberangkatanLayout);
        keberangkatanLayout.setHorizontalGroup(
            keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keberangkatanLayout.createSequentialGroup()
                .addGroup(keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keberangkatanLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(keberangkatanLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asalTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(keberangkatanLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tujuanTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keberangkatanLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(keberangkatanLayout.createSequentialGroup()
                        .addComponent(tanggal_berangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(tanggal_label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        keberangkatanLayout.setVerticalGroup(
            keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keberangkatanLayout.createSequentialGroup()
                .addGroup(keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keberangkatanLayout.createSequentialGroup()
                        .addGroup(keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(keberangkatanLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tanggal_label))
                            .addGroup(keberangkatanLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(122, 122, 122)
                        .addGroup(keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(reset)))
                    .addGroup(keberangkatanLayout.createSequentialGroup()
                        .addGroup(keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(keberangkatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggal_berangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(keberangkatanLayout.createSequentialGroup()
                                .addComponent(asalTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tujuanTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 388, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Keberangkatan", keberangkatan);

        jadwal_Berangkat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KODE PERJALANAN", "TUJUAN", "ASAL", "NOMOR PLAT KENDARAAAN", "STATUS", "JAM BERANGKAT", "ESTIMASI TIBA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jadwal_Berangkat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jadwal_BerangkatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jadwal_BerangkatMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jadwal_Berangkat);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        s1.setText("1");
        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });

        s3.setText("3");
        s3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3ActionPerformed(evt);
            }
        });

        s4.setText("4");
        s4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4ActionPerformed(evt);
            }
        });

        s5.setText("5");
        s5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5ActionPerformed(evt);
            }
        });

        s7.setText("7");
        s7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s7ActionPerformed(evt);
            }
        });

        s6.setText("6");
        s6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s6ActionPerformed(evt);
            }
        });

        s2.setText("2");
        s2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2ActionPerformed(evt);
            }
        });

        s8.setText("8");
        s8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s8ActionPerformed(evt);
            }
        });

        s9.setText("9");
        s9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s9ActionPerformed(evt);
            }
        });

        s10.setText("10");
        s10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s10ActionPerformed(evt);
            }
        });

        s11.setText("11");
        s11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s11ActionPerformed(evt);
            }
        });

        s13.setText("13");
        s13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s13ActionPerformed(evt);
            }
        });

        s14.setText("14");
        s14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s14ActionPerformed(evt);
            }
        });

        s12.setText("12");
        s12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s12ActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SEAT");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(s1)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(s11)
                        .addGap(18, 18, 18)
                        .addComponent(s12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(s13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(s14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(s2)
                                    .addComponent(s5))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(s6))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(s3)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(s8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(s9)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(s10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(s7)
                            .addComponent(s4)))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(s1))
                    .addComponent(jLabel8))
                .addGap(46, 46, 46)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s4)
                        .addComponent(s3))
                    .addComponent(s2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s5)
                    .addComponent(s6)
                    .addComponent(s7))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s8)
                    .addComponent(s9)
                    .addComponent(s10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s11)
                    .addComponent(s13)
                    .addComponent(s14)
                    .addComponent(s12))
                .addContainerGap())
        );

        jLabel9.setText("TERPILIH : ");

        jLabel11.setText("HARGA");

        harga.setText("0");

        list_pilihan.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane4.setViewportView(list_pilihan);

        jButton9.setText("Konfirmasi");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel10.setText("Tanngal : ");

        Kode_kendaraan.setForeground(new java.awt.Color(0, 0, 0));
        Kode_kendaraan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Kode_kendaraan.setText(" ");

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/kutsi.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tanggal_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kode_kendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(148, 148, 148))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggal_label1)
                            .addComponent(jLabel9)
                            .addComponent(jButton9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(harga)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Kode_kendaraan)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Jadwal", jPanel4);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Nama");

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Data Pemesanan");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("NIK");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Kelamin");

        Nama_penumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nama_penumpangActionPerformed(evt);
            }
        });

        Kelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenis Kelamin", "Pria", "Wanita", " " }));

        comboBoxSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSeatActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Seat");

        jButton7.setText("Tambahkan");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(comboBoxSeat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nama_penumpang)
                    .addComponent(No_nik)
                    .addComponent(Kelamin, 0, 150, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Nama_penumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(No_nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        tabel_penumpang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal Berangkat", "Nama", "NIK", "Kelamin", "No kursi", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabel_penumpang);

        jPanel9.setBackground(new java.awt.Color(153, 204, 255));

        pembayaranCbbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transfer Bank", "QRIS", " " }));
        pembayaranCbbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pembayaranCbboxActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Jenis Pembayaran");

        jButton8.setText("Bayar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        LabelTotalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabelTotalBayarActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Total Harga");

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("TOTAL BAYAR");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addGap(144, 144, 144)
                                    .addComponent(LabelTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(88, 88, 88)
                                    .addComponent(pembayaranCbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pembayaranCbbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(LabelTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(jButton8)
                .addGap(23, 23, 23))
        );

        confirm.setText("Selesai");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(246, 246, 246)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirm)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Data pemesanan", jPanel3);

        javax.swing.GroupLayout ticketLayout = new javax.swing.GroupLayout(ticket);
        ticket.setLayout(ticketLayout);
        ticketLayout.setHorizontalGroup(
            ticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ticketLayout.setVerticalGroup(
            ticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(ticket, "Ticket");

        booked_ticket.setBackground(new java.awt.Color(255, 153, 153));

        Tabel_tiket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal Pesanan", "Kode Kendaraan", "Jam Berangkat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabel_tiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabel_tiketMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabel_tiket);

        tiket_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "NIK", "No Seat", "Jenis Kelamin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tiket_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tiket_infoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tiket_info);

        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Detail Tiket yang di pesan");

        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Tiket yang di pesan");

        javax.swing.GroupLayout booked_ticketLayout = new javax.swing.GroupLayout(booked_ticket);
        booked_ticket.setLayout(booked_ticketLayout);
        booked_ticketLayout.setHorizontalGroup(
            booked_ticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booked_ticketLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(booked_ticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        booked_ticketLayout.setVerticalGroup(
            booked_ticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booked_ticketLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel31)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(booked_ticket, "card3");

        myProfile.setBackground(new java.awt.Color(255, 153, 153));
        myProfile.setPreferredSize(new java.awt.Dimension(1271, 763));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Instagram.png"))); // NOI18N
        jLabel4.setText("jLabel1");

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("@ardhyair10");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Letter With Email Sign.png"))); // NOI18N
        jLabel22.setText("jLabel3");

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("prodigytravel62@gmail.com");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(18, 18, 18))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Company_1.png"))); // NOI18N
        jLabel24.setText("jLabel2");

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("TRILOKA VI BLOK D NO 6");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel30)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel11, jPanel12, jPanel13});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout myProfileLayout = new javax.swing.GroupLayout(myProfile);
        myProfile.setLayout(myProfileLayout);
        myProfileLayout.setHorizontalGroup(
            myProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        myProfileLayout.setVerticalGroup(
            myProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myProfileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        jPanel2.add(myProfile, "card4");

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));

        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Data Pribadi");

        namaUpdate.setText("jTextField1");

        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Nama");

        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("No Telp");

        noTlpUpdate.setText("jTextField1");

        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Username");

        UsernameUpdate.setText("jTextField1");

        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Foto Profil");

        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        fotoPath.setText("jTextField1");
        fotoPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fotoPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StatusUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(namaUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addComponent(noTlpUpdate, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(UsernameUpdate, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fotoPath, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(browse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(618, 618, 618))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noTlpUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(fotoPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusUsername)
                .addGap(35, 35, 35)
                .addComponent(browse)
                .addGap(42, 42, 42)
                .addComponent(jButton10)
                .addGap(0, 178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editProfileLayout = new javax.swing.GroupLayout(editProfile);
        editProfile.setLayout(editProfileLayout);
        editProfileLayout.setHorizontalGroup(
            editProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProfileLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        editProfileLayout.setVerticalGroup(
            editProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(editProfile, "card6");

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1329, 684));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private class SeatCheckBoxListener implements ActionListener {
    private String seatName;

    public SeatCheckBoxListener(String seatName) {
        this.seatName = seatName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox checkBox = (JCheckBox) e.getSource();

        // Periksa apakah checkbox terpilih
        if (checkBox.isSelected()) {
            // Jika terpilih, tambahkan ke dalam daftar kursi terpilih dan atur warna latar hijau
            selectedSeats.add(seatName);
            checkBox.setBackground(Color.GREEN);

            // Hapus semua elemen dari model sebelum menambahkannya kembali
            listModel.clear();

            // Tambahkan kembali semua kursi terpilih ke dalam model
            for (String seat : selectedSeats) {
                listModel.addElement(seat);
            }

            // Set the model for the JList
            list_pilihan.setModel(listModel);

            // Update other components based on selected seats
            Total = selectedSeats.size()*harga_seat;
            harga.setText(String.valueOf(Total));
        } else {
            // Jika tidak terpilih, hapus dari daftar kursi terpilih
            selectedSeats.remove(seatName);

            // Hapus semua elemen dari model
            listModel.clear();

            // Tambahkan kembali semua kursi terpilih ke dalam model
            for (String seat : selectedSeats) {
                listModel.addElement(seat);
            }

            // Set the model for the JList
            list_pilihan.setModel(listModel);

            // Update other components based on selected seats
            Total = selectedSeats.size()*harga_seat;
            harga.setText(String.valueOf(Total));
        }
    }
}
    public static String GetEmail(){
    return Email;
    }
    
    public String[] getSchedule() {
    String tanggalPesan = tanggal.getText(); // Assuming tanggal is a JTextField or similar
    
    // Assuming you have a method to get the jamBerangkat array
    String[] dataJam = Query.getJamBerangkat(tanggalPesan);

    // Assuming you have a loop to print the array
    for (String jam : dataJam) {
        System.out.println(jam);
    }

    return dataJam;
}
    void sendRemindersForAllJam(String[] jamBerangkat) {
    for (String jam : jamBerangkat) {
        sendReminder(jam);
    }
}
    private boolean isCurrentTimeMatching(String targetTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String currentTime = sdf.format(new Date());

        return currentTime.equals(targetTime);
    }
    
    public void sendReminder(String jam) {
        String tanggal = this.tanggal.getText();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT DISTINCT u.CIF, u.NAMA, u.EMAIL " +
                         "FROM `user` u " +
                         "JOIN `order` o ON u.CIF = o.CIF " +
                         "WHERE o.TANGGAL_PESANAN = ? AND o.JAM_BERANGKAT = ? " +
                         "AND TIMEDIFF(CONCAT(o.TANGGAL_PESANAN, ' ', o.JAM_BERANGKAT), NOW()) BETWEEN '00:00:00' AND '00:30:00'";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set the parameters
                preparedStatement.setString(1, tanggal);
                preparedStatement.setString(2, jam);

                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        // Retrieve CIF, NAMA, and EMAIL for each user
                        String cif = resultSet.getString("CIF");
                        String nama = resultSet.getString("NAMA");
                        String email = resultSet.getString("EMAIL");

                        // Check if the current time matches the specified time
                        if (isCurrentTimeMatching(jam)) {
                            // Use the CIF, NAMA, and EMAIL to send reminders
                            Utility.sendEmailReminder(cif, email, nama);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setUsername(String username){
        System.out.println(username);
        this.usernameUser = username;
        tanggal.setText(username);
        System.out.println(usernameUser);
        get_data_to_homepage(username);       
    }
    void get_data_to_homepage(String username) {
    String url = "jdbc:mysql://localhost:3306/travel";
    String dbUsername = "root";
    String dbPassword = "";
    Utility function = new Utility();
    try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
        String sql = "SELECT * FROM user WHERE USERNAME = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if there is at least one row in the result set
                if (resultSet.next()) {
                    // For the first row, create a UserData object and add it to the list
                    this.CIF = resultSet.getString("CIF");
                    String Nama = resultSet.getString("NAMA");
                    String email = resultSet.getString("EMAIL");
                    String noTLP = resultSet.getString("NO_HP");
                    String tanggalLahir = resultSet.getString("TANGGAL_LAHIR");
                    String tanggalRegistrasi = resultSet.getString("TANGGAL_REGISTRASI");
                    String point = String.valueOf(resultSet.getInt("POINTS"));
                    imageData = resultSet.getBytes("PROFILE_PICTURE");
                    ImageIcon image1 = Utility.createImageIcon(imageData);
                    image = Utility.resizeImage(image1, 50, 50);
                    
                    // Initialize the userData array and assign values
                    String[] userData = new String[7];
                    userData[0] = CIF;
                    userData[1] = Nama;
                    userData[2] = username;
                    userData[3] = email;
                    userData[4] = tanggalLahir;
                    userData[5] = tanggalRegistrasi;
                    userData[6] = point;
                    // Now you can use the userData array as needed
                    this.data = userData;
                    this.Email = email;
                    this.nama = Nama;
                    this.notlp = noTLP;
                    
                    System.out.println("Berhasil");
                    System.out.println(CIF);
                } else {
                    // Handle the case where no matching user is found
                    System.out.println("No user found with the given username and password.");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    private void setBookedSeats(List<String> seatsInDatabase) {
    JCheckBox[] seatCheckboxes = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14};

    for (int i = 0; i < seatCheckboxes.length; i++) {
        String seatNumber = String.valueOf(i + 1);

        // Cek apakah tempat duduk sudah dipesan
        if (seatsInDatabase.contains(seatNumber)) {
            // Jika sudah dipesan, set JCheckBox sebagai tercentang dan tidak dapat diubah
            seatCheckboxes[i].setSelected(true);
            seatCheckboxes[i].setEnabled(false);
        }else{
            seatCheckboxes[i].setSelected(false);
            seatCheckboxes[i].setEnabled(true);
        }
    }
}
    private List<String> getSeatsFromDatabase(String kodeKnedarann) {
    List<String> seatsInDatabase = new ArrayList<>();
        System.out.println("Ini kepanggil");

    // Mengasumsikan Anda memiliki koneksi JDBC ke database Anda
    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement statement = connection.prepareStatement("SELECT NO_SEAT FROM `order` WHERE TANGGAL_PESANAN = ? AND KODE_KENDARAAN = ?")) {

        statement.setString(1, tanggalBerangkat);
        statement.setString(2, kodeKnedarann);

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String bookedSeat = resultSet.getString("NO_SEAT");
                seatsInDatabase.add(bookedSeat);
            }
        }
    } catch (SQLException e) {
        // Biarkan pengecualian terjadi tanpa tindakan tambahan
        e.printStackTrace();
    }

    return seatsInDatabase;
}

 public ArrayList<ArrayList<String>> getData(String now, String jam) {
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    
    String url = "jdbc:mysql://localhost:3306/travel";
    String username = "root";
    String password = "";
    String tujuan = String.valueOf(tujuanTXT.getSelectedItem());
    String asal = String.valueOf(asalTXT.getSelectedItem());
    LocalDate harini = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String hari = harini.format(formatter);

    
    try {
        Connection connection = DriverManager.getConnection(url, username, password);
        String query;
        PreparedStatement preparedStatement;

        // Jika tanggal keberangkatan sama dengan hari ini
        if (now.equals(hari)) {
            query = "SELECT * FROM kendaraan WHERE TUJUAN = ? AND ASAL = ? AND JAM_BERANGKAT > ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(3, jam); // Parameter jam di sini sesuai dengan urutan tanda tanya yang ketiga
        } else {
            // Jika tidak, ambil semua data
            query = "SELECT * FROM kendaraan WHERE TUJUAN = ? AND ASAL = ?";
            preparedStatement = connection.prepareStatement(query);
        }

        preparedStatement.setString(1, tujuan);
        preparedStatement.setString(2, asal);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ArrayList<String> row = new ArrayList<>();
            row.add(resultSet.getString("KODE_KENDARAAN"));
            row.add(resultSet.getString("TUJUAN"));
            row.add(resultSet.getString("ASAL"));
            row.add(resultSet.getString("PLAT_NOMER_KENDARAAN"));
            row.add(resultSet.getString("STATUS"));
            row.add(resultSet.getString("JAM_BERANGKAT"));
            row.add(resultSet.getString("JAM_TIBA"));
            row.add(resultSet.getString("HARGA"));

            data.add(row);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return data;
}

    public static void orderChecker(String tanggal, String kodeKendaraan) {
        int maxOrderCount = 14;
        int orderCount = Query.getOrderCount(tanggal, kodeKendaraan);

        if (orderCount >= maxOrderCount) {
            System.out.println("Kursi sudah penuh untuk tanggal " + tanggal + " dan kode kendaraan " + kodeKendaraan);
            JOptionPane.showMessageDialog(null, "Kursi sudah penuh untuk tanggal " + tanggal + " dan kode kendaraan " + kodeKendaraan, "NOTIFICATION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Masih tersedia kursi untuk tanggal " + tanggal + " dan kode kendaraan " + kodeKendaraan);
        }
    }
   public ArrayList<ArrayList<String>> getUserTicket(String CIF) {
    ArrayList<ArrayList<String>> data_ticket = new ArrayList<>();

    String url = "jdbc:mysql://localhost:3306/travel";
    String username = "root";
    String password = "";

    try {
        Connection connection = DriverManager.getConnection(url, username, password);

        // Corrected SQL query with placeholders and aliases
        String query = "SELECT KODE_KENDARAAN, MAX(TANGGAL_PESANAN) AS max_tanggal, MAX(JAM_BERANGKAT) AS max_jam_berangkat FROM `order` WHERE CIF = ? GROUP BY KODE_KENDARAAN ORDER BY max_tanggal DESC";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, CIF);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ArrayList<String> row = new ArrayList<>();
            // Use aliases in getString() to retrieve values
            row.add(resultSet.getString("max_tanggal"));
            row.add(resultSet.getString("KODE_KENDARAAN"));
            row.add(resultSet.getString("max_jam_berangkat"));

            data_ticket.add(row);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return data_ticket;
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayout dynamicCardLayout = (CardLayout)(jPanel2.getLayout());
        dynamicCardLayout.show(jPanel2, "home");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       CardLayout dynamicCardLayout = (CardLayout)(jPanel2.getLayout());
        dynamicCardLayout.show(jPanel2, "Ticket");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ArrayList<ArrayList<String>> tiket_user = getUserTicket(CIF);
        CardLayout dynamicCardLayout = (CardLayout)(jPanel2.getLayout());
        dynamicCardLayout.show(jPanel2, "card3");
        DefaultTableModel tabel = (DefaultTableModel) Tabel_tiket.getModel();
       
        tabel.setRowCount(0);

// Isi tabel dengan data dari fungsi getData
        for (ArrayList<String> row : tiket_user) {
            tabel.addRow(row.toArray());
        }
      
    }//GEN-LAST:event_jButton4ActionPerformed
    private void setupUsernameListener() {
       
       
       

    // Add a listener to the username text field
    UsernameUpdate.getDocument().addDocumentListener(new DocumentListener() {
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
    private void asalTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asalTXTActionPerformed
    tujuanModel = new DefaultComboBoxModel<>();
    String asal = String.valueOf(asalTXT.getSelectedItem());
    String[] jurusan_asal = this.jurusan_asal;
    System.out.println("Selected tujuan: " + asal);
    System.out.println("Jurusan_asal before switch: " + Arrays.toString(jurusan_asal));
    int indexToRemove = -1;
    int harga = 0;
    if (asal != null) {  // Check if tujuan is not null
        switch (asal) {
            case "JAKARTA":
                harga = 125000;
                this.Harga = 125000;
                for (int i = 0; i < jurusan_asal.length; i++) {
                    if (jurusan_asal[i].equals("JAKARTA")) {
                        indexToRemove = i;
                        System.out.println(Harga);
                        break; // Exit the loop once a match is found
                    }
                }
                break; // Exit the switch block after processing this case
            case "BANDUNG":
                harga = 125000;
                for (int i = 0; i < jurusan_asal.length; i++) {
                    if (jurusan_asal[i].equals("BANDUNG")) {
                        indexToRemove = i;
                        break; // Exit the loop once a match is found
                    }
                }
                break; // Exit the switch block after processing this case
            case "YOGYAKARTA":
                harga = 220000;
                for (int i = 0; i < jurusan_asal.length; i++) {
                    if (jurusan_asal[i].equals("YOGYAKARTA")) {
                        indexToRemove = i;
                        break; // Exit the loop once a match is found
                    }
                }
                break; // Exit the switch block after processing this case
            default:
                System.out.println("Invalid tujuan value: " + asal);
        }
        this.harga_seat = harga;
    } else {
        System.out.println("Tujuan is null.");
    }
    if (indexToRemove != -1) {
        String[] newJurusan = new String[jurusan_asal.length - 1];
        int newIndex = 0;
        for (int i = 0; i < jurusan_asal.length; i++) {
            if (i != indexToRemove) {
                newJurusan[newIndex] = jurusan_asal[i];
                newIndex++;
            } else {
                System.out.println("Value not found in the array.");
            }
        }
        // Update the original array reference
        jurusan_asal = newJurusan;
        // Print the updated array
        // Update the combo box model and set it to the combo box
        tujuanModel = new DefaultComboBoxModel<>(newJurusan);
        tujuanTXT.setModel(tujuanModel);
    } else {
        System.out.println("Value not found in the array.");
    }
    }//GEN-LAST:event_asalTXTActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        selectedSeats.clear();
        //set tabel ticket xyz      
        ArrayList<ArrayList<String>>user = getData(tanggalBerangkat,Jam);
        String value = String.valueOf(value_seat);
      

        // Ambil model tabel dari JTable (jadwal_Berangkat)
        DefaultTableModel tbl = (DefaultTableModel) jadwal_Berangkat.getModel();

        // Bersihkan tabel sebelum mengisi dengan data baru
        tbl.setRowCount(0);

        // Isi tabel dengan data dari fungsi getData
        for (ArrayList<String> row : user) {
            tbl.addRow(row.toArray());
        }
    

    }//GEN-LAST:event_jButton5ActionPerformed

    private void tujuanTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tujuanTXTActionPerformed

    }//GEN-LAST:event_tujuanTXTActionPerformed

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
    }//GEN-LAST:event_s1ActionPerformed

    private void s3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3ActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_s3ActionPerformed

    private void s4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4ActionPerformed

    private void s5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5ActionPerformed

    private void s7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s7ActionPerformed

    private void s6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s6ActionPerformed

    private void s2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2ActionPerformed

    private void s8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s8ActionPerformed

    private void s9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s9ActionPerformed

    private void s10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s10ActionPerformed

    private void s11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s11ActionPerformed

    private void s13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s13ActionPerformed

    private void s14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s14ActionPerformed

    private void s12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s12ActionPerformed

    private void Nama_penumpangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nama_penumpangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nama_penumpangActionPerformed

    private void LabelTotalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelTotalBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelTotalBayarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

    }//GEN-LAST:event_resetActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) comboBoxSeat.getModel();
        comboBoxModel.removeAllElements();
        for (String seat : selectedSeats) {
            comboBoxModel.addElement(seat);
        }
        LabelTotalBayar.setText(String.valueOf(Total));
//         String travelCode = (String) jadwal_Berangkat.getValueAt(selectedRow, 0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void comboBoxSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSeatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSeatActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    // Ambil nilai yang diperlukan dari komponen GUI
    String namaPenumpang = Nama_penumpang.getText();
    String selectedSeat = String.valueOf(comboBoxSeat.getSelectedItem());
    String NIK = No_nik.getText();
    String kelamin = String.valueOf(Kelamin.getSelectedItem());
    
    // Validasi input
    if (namaPenumpang.isEmpty() || NIK.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Harap isi Nama dan NIK terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Keluar dari metode jika validasi tidak terpenuhi
    }
    // Lakukan validasi atau operasi lainnya sesuai kebutuhan
    // Tambahkan data penumpang ke dalam tabel
    DefaultTableModel model = (DefaultTableModel) tabel_penumpang.getModel();
    model.addRow(new Object[]{tanggalBerangkat, namaPenumpang, NIK, kelamin, selectedSeat, harga_seat});
    // Perbarui combo box dengan menghapus kursi yang dipilih
    DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) comboBoxSeat.getModel();
    comboBoxModel.removeElement(selectedSeat);
    // Cek apakah combo box telah kosong, jika ya, nonaktifkan tombol
//    if (comboBoxModel.getSize() == 0) {
//        jButton7.setEnabled(false);
//        confirm.setEnabled(false);
//    }else{
//        jButton7.setEnabled(true);
//        confirm.setEnabled(true);
//    
//    }
    // Kosongkan kolom input setelah data ditambahkan
    Nama_penumpang.setText("");
    No_nik.setText("");
    // Tambahan: Anda mungkin ingin memperbarui data lain sesuai kebutuhan.}
    }//GEN-LAST:event_jButton7ActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        
    }//GEN-LAST:event_confirmActionPerformed

    private void jadwal_BerangkatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jadwal_BerangkatMouseClicked
       int row = jadwal_Berangkat.getSelectedRow();

        if (row != -1) {  // Pastikan ada baris yang dipilih
            DefaultTableModel model = (DefaultTableModel) jadwal_Berangkat.getModel();
            Kode_kendaraan.setText(model.getValueAt(row, 0).toString());
            jam_berangkat =  model.getValueAt(row, 5).toString();
            this.KodeKendaraan = model.getValueAt(row, 0).toString();
            System.out.println("Kode Kendaraan: " + KodeKendaraan);
            System.out.println("Username User: " + usernameUser);
            System.out.println(jam_berangkat);
            orderChecker( tanggalBerangkat,KodeKendaraan);

            // Eksekusi fungsi getSeatsFromDatabase setelah mendapatkan nilai KodeKendaraan
            getSeatsFromDatabase(KodeKendaraan);
        } else {
            KodeKendaraan = "";
            jam_berangkat= "";
            System.out.println("Tidak ada baris yang dipilih.");
        }
        List<String> seatsInDatabase = getSeatsFromDatabase(KodeKendaraan);
        setBookedSeats(seatsInDatabase);
        value_seat = seatsInDatabase.size();
        System.out.println(value_seat);
        listModel.clear();
//        selectedSeats.clear();
    }//GEN-LAST:event_jadwal_BerangkatMouseClicked

    private void pembayaranCbboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pembayaranCbboxActionPerformed
       
    }//GEN-LAST:event_pembayaranCbboxActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       DefaultTableModel model = (DefaultTableModel) tabel_penumpang.getModel();
       List<String> noSeatList = new ArrayList<>();
       List<List<String>> dataList = new ArrayList<>();
        for (int row = 0; row < model.getRowCount(); row++) {
            List<String> rowData = new ArrayList<>();
            
            // Adjust column indices based on your actual table structure
            String tanggalValue = model.getValueAt(row, 0).toString();
            String kodeKendaraan = KodeKendaraan;
            String namaPenumpang = model.getValueAt(row, 1).toString();
            String NIK = model.getValueAt(row, 2).toString();
            String gender = model.getValueAt(row, 3).toString();
            String noSeat = model.getValueAt(row, 4).toString();

            // Add data to the list
            rowData.add(tanggalValue);
            rowData.add(kodeKendaraan);
            rowData.add(namaPenumpang);
            rowData.add(NIK);
            rowData.add(gender);
            rowData.add(noSeat);

            // Add the row data to the main list
            dataList.add(rowData);
        }
        String[]userInfo = {nama,CIF,Email};
        PDFGenerator.generatePDF(dataList,userInfo);
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Loop through each row and perform an insert operation into the database
            for (int row = 0; row < model.getRowCount(); row++) {
                String cifValue = data[0]; // Replace 0 with the desired column index or name
                String tanggalValue = model.getValueAt(row, 0).toString();
                String kode_kendaraan = KodeKendaraan;
                String nama_penumpang = model.getValueAt(row, 1).toString();
                String NIK = model.getValueAt(row,2).toString();
                String gender = model.getValueAt(row, 3).toString();
                String no_seat = model.getValueAt(row, 4).toString();
                noSeatList.add(no_seat);

                // Use PreparedStatement to avoid SQL injection
                String sql = "INSERT INTO `order` (CIF, TANGGAL_PESANAN, KODE_KENDARAAN,JAM_BERANGKAT,NIK, NAMA_PENUMPANG, GENDER, NO_SEAT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, cifValue);
                    preparedStatement.setString(2, tanggalValue);
                    preparedStatement.setString(3, kode_kendaraan);
                    preparedStatement.setString(4, jam_berangkat);
                    preparedStatement.setString(5, NIK);
                    preparedStatement.setString(6, nama_penumpang);
                    preparedStatement.setString(7, gender);
                    preparedStatement.setString(8, no_seat);
                    // Execute the insertion
                    preparedStatement.executeUpdate();
                    
                }
            }
            System.out.println("Data successfully inserted into the database.");
            listModel.clear();
            list_pilihan.clearSelection();
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
            }
            harga.setText("0");
            JOptionPane.showMessageDialog(null, "Pembayaran Berhasil!", "Notification", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        
        
       
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CardLayout dynamicCardLayout = (CardLayout)(jPanel2.getLayout());
        dynamicCardLayout.show(jPanel2, "card4");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Tabel_tiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabel_tiketMouseClicked
//    ArrayList<ArrayList<String>> tiket_user = getUserTicket(CIF);
      int selectedRow = Tabel_tiket.getSelectedRow();
//    int baris = Tabel_tiket.getSelectedRow();
    DefaultTableModel tbl_info = (DefaultTableModel) tiket_info.getModel();

//
    if (selectedRow != -1) {
        tbl_info.setRowCount(0);
        String selectDate = Tabel_tiket.getValueAt(selectedRow, 0).toString();
        String kodeKendaraan = Tabel_tiket.getValueAt(selectedRow, 1).toString();
        ArrayList<ArrayList<String>> infoPenumpang = get_info_passanger(selectDate, kodeKendaraan);
        for (ArrayList<String> row : infoPenumpang) {
        tbl_info.addRow(row.toArray());
            System.out.println(CIF);
            System.out.println(selectDate + kodeKendaraan);
}
    }else{
    
    }
    
//        DefaultTableModel tabel = (DefaultTableModel) tiket_info.getModel();
//        
//        String tanggal_Tiket_Info = tabel.getValueAt(baris, 0).toString();
//        String kode_kendaraan = tabel.getValueAt(baris, 1).toString();
//        System.out.println("Kode Kendaraan: " + kode_kendaraan);
//        System.out.println("Username User: " + usernameUser);
//        System.out.println(jam_berangkat);
//
//        // Eksekusi fungsi getSeatsFromDatabase setelah mendapatkan nilai KodeKendaraan
//        List<String> seatsInDatabase = getSeatsFromDatabase(kode_kendaraan);
//        setBookedSeats(seatsInDatabase);
//        value_seat = seatsInDatabase.size();
//        System.out.println(value_seat);
//
//        tabel.setRowCount(0);
//        
//        // Isi tabel dengan data dari fungsi getData
//       
//        for (ArrayList<String> row : info_tiket) {
//            tabel.addRow(row.toArray());
//        }
//    } else {
//        System.out.println("Tidak ada baris yang dipilih.");
//    }
       

    }//GEN-LAST:event_Tabel_tiketMouseClicked

    private static ArrayList<ArrayList<String>> get_info_passanger(String TANGGAL_BERANGKAT,String Kode_kendaraan){
    ArrayList<ArrayList<String>> data_ticket = new ArrayList<>();

    String url = "jdbc:mysql://localhost:3306/travel";
    String username = "root";
    String password = "";

    try {
        Connection connection = DriverManager.getConnection(url, username, password);

        // Corrected SQL query with placeholders and aliases
        String query= "SELECT * FROM `order` WHERE CIF = ? AND KODE_KENDARAAN = ? AND TANGGAL_PESANAN = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, CIF);
        preparedStatement.setString(2, Kode_kendaraan);
        preparedStatement.setString(3, TANGGAL_BERANGKAT);
        

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ArrayList<String> row = new ArrayList<>();
            // Use aliases in getString() to retrieve values
            row.add(resultSet.getString("NAMA_PENUMPANG"));
            row.add(resultSet.getString("NIK"));
            row.add(resultSet.getString("NO_SEAT"));
            row.add(resultSet.getString("GENDER"));

            data_ticket.add(row);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return data_ticket;
}
    
    
    private void tiket_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tiket_infoMouseClicked
        String Selected_code;
        String Selected_date;
        int row = Tabel_tiket.getSelectedRow();
        if (row != -1) {  // Pastikan ada baris yang dipilih
            DefaultTableModel model = (DefaultTableModel) Tabel_tiket.getModel();
            Selected_code = model.getValueAt(row, 1).toString();
            Selected_date =  model.getValueAt(row, 0).toString();
            

            // Eksekusi fungsi getSeatsFromDatabase setelah mendapatkan nilai KodeKendaraan
        } else {
            System.out.println("Tidak ada baris yang dipilih.");
        }
        
    }//GEN-LAST:event_tiket_infoMouseClicked

    private void jadwal_BerangkatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jadwal_BerangkatMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jadwal_BerangkatMouseEntered

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       CardLayout dynamicCardLayout = (CardLayout)(jPanel2.getLayout());
        dynamicCardLayout.show(jPanel2, "card6");
        namaUpdate.setText(nama);
        noTlpUpdate.setText(notlp);
        UsernameUpdate.setText(usernameUser);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
      photoPicker.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
String path = photoPicker.getName();
System.out.println(path);
int result = photoPicker.showOpenDialog(null);

if (result == photoPicker.APPROVE_OPTION) {
    File selectedFile = photoPicker.getSelectedFile();

    // Get the file path
    String filePath = selectedFile.getAbsolutePath();
    System.out.println("File Path: " + filePath);

    // Get the file name
    String fileName = selectedFile.getName();
    System.out.println("File Name: " + fileName);

    // Construct the complete file object
    File completeFile = new File(filePath);

    // Display the complete file path in the text field
    fotoPath.setText(completeFile.getAbsolutePath());

    // Check if the file exists
    if (completeFile.exists()) {
        try {
            // Read the image data from the file
            imageData = Utility.readImage(completeFile.getAbsolutePath());
        } catch (Exception ex) {
            // Handle exception
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        System.err.println("File does not exist: " + completeFile.getAbsolutePath());
    }
}



    }//GEN-LAST:event_browseActionPerformed
    private void checkUsername() {
    String enteredUsername = UsernameUpdate.getText();
    if (Query.isUsernameRegistered(enteredUsername)) {
        StatusUsername.setText("Username Sudah terdaftar");
        StatusUsername.setForeground(Color.red);
    } else {
        StatusUsername.setText("");
    }
    }
    private void photoPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoPickerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_photoPickerActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String namaBaruUser = namaUpdate.getText();
        String UsernameBaru = UsernameUpdate.getText();
        String noTelpBaru   = noTlpUpdate.getText();
        data_update = new String[]{namaBaruUser, UsernameBaru, noTelpBaru};
        Query.updateusername(UsernameBaru, CIF);
        Query.update_user(data_update, CIF, imageData);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void fotoPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotoPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fotoPathActionPerformed
//  public static void generatePDF(DefaultTableModel model, String outputFileName) {
//        try (PDDocument document = new PDDocument()) {
//            PDPage page = new PDPage(PDRectangle.A4);
//            document.addPage(page);
//
//            PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true);
//
//            float margin = 50;
//            float yStart = page.getMediaBox().getHeight() - margin;
//            float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
//            float yPosition = yStart;
//
//            float rowHeight = 30f;
//            float tableHeight = rowHeight * (model.getRowCount() + 1); // Header row + data rows
//
//            // Draw the table header
//            drawTableHeader(contentStream, margin, yStart, tableWidth, rowHeight, model);
//
//            // Draw the table rows
//            drawTableRows(contentStream, margin, yStart, tableWidth, rowHeight, model);
//
//            contentStream.close();
//
//            // Save the PDF document
//            document.save(outputFileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void drawTableHeader(PDPageContentStream contentStream, float margin, float yStart, float tableWidth, float rowHeight, DefaultTableModel model) throws IOException {
//        float yPosition = yStart;
//
//        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 14);
//        contentStream.setNonStrokingColor(Color.BLACK);
//
//        // Draw the table header row
//        for (int col = 0; col < model.getColumnCount(); col++) {
//            contentStream.beginText();
//            contentStream.newLineAtOffset(margin + (col * tableWidth / model.getColumnCount()), yPosition - 15);
//            contentStream.showText(model.getColumnName(col));
//            contentStream.endText();
//        }
//    }
//
//    private static void drawTableRows(PDPageContentStream contentStream, float margin, float yStart, float tableWidth, float rowHeight, DefaultTableModel model) throws IOException {
//        float yPosition = yStart - rowHeight;
//
//        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 14);
//
//        // Draw the table rows
//        for (int row = 0; row < model.getRowCount(); row++) {
//            for (int col = 0; col < model.getColumnCount(); col++) {
//                contentStream.beginText();
//                contentStream.newLineAtOffset(margin + (col * tableWidth / model.getColumnCount()), yPosition);
//                contentStream.showText(model.getValueAt(row, col).toString());
//                contentStream.endText();
//            }
//
//            yPosition -= rowHeight;
//        }
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
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
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
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
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Kelamin;
    private javax.swing.JLabel Kode_kendaraan;
    private javax.swing.JTextField LabelTotalBayar;
    private javax.swing.JTextField Nama_penumpang;
    private javax.swing.JTextField No_nik;
    private javax.swing.JFrame Qris;
    private javax.swing.JLabel StatusUsername;
    private javax.swing.JTable Tabel_tiket;
    private javax.swing.JTextField UsernameUpdate;
    private javax.swing.JComboBox<String> asalTXT;
    private javax.swing.JPanel booked_ticket;
    private javax.swing.JButton browse;
    private javax.swing.JComboBox<String> comboBoxSeat;
    private javax.swing.JButton confirm;
    private javax.swing.JPanel editProfile;
    private javax.swing.JTextField fotoPath;
    private javax.swing.JLabel harga;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jadwal_Berangkat;
    private javax.swing.JLabel jam;
    private javax.swing.JPanel keberangkatan;
    private javax.swing.JList<String> list_pilihan;
    private javax.swing.JPanel myProfile;
    private javax.swing.JTextField namaUpdate;
    private javax.swing.JTextField noTlpUpdate;
    private javax.swing.JComboBox<String> pembayaranCbbox;
    private javax.swing.JLabel photo;
    private javax.swing.JFileChooser photoPicker;
    private javax.swing.JButton reset;
    private javax.swing.JCheckBox s1;
    private javax.swing.JCheckBox s10;
    private javax.swing.JCheckBox s11;
    private javax.swing.JCheckBox s12;
    private javax.swing.JCheckBox s13;
    private javax.swing.JCheckBox s14;
    private javax.swing.JCheckBox s2;
    private javax.swing.JCheckBox s3;
    private javax.swing.JCheckBox s4;
    private javax.swing.JCheckBox s5;
    private javax.swing.JCheckBox s6;
    private javax.swing.JCheckBox s7;
    private javax.swing.JCheckBox s8;
    private javax.swing.JCheckBox s9;
    private javax.swing.JFrame selectPhoto;
    private javax.swing.JTable tabel_penumpang;
    private javax.swing.JLabel tanggal;
    private com.toedter.calendar.JCalendar tanggal_berangkat;
    private javax.swing.JLabel tanggal_label;
    private javax.swing.JLabel tanggal_label1;
    private javax.swing.JPanel ticket;
    private javax.swing.JTable tiket_info;
    private javax.swing.JComboBox<String> tujuanTXT;
    private javax.swing.JLabel user_username;
    // End of variables declaration//GEN-END:variables
}
