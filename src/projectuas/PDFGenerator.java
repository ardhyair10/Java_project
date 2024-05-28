package projectuas;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class PDFGenerator {

    public static void generatePDF(List<List<String>> passengers,String[]data) {
        String path = "invoice.pdf";
        String Pemesan = data[0];
        String CIF = data[1];
        String Email = data[2];
        try (PdfWriter pdfWriter = new PdfWriter(path);
             PdfDocument pdfDocument = new PdfDocument(pdfWriter);
             Document document = new Document(pdfDocument)) {

            pdfDocument.setDefaultPageSize(PageSize.A4);
            Paragraph paragraph = new Paragraph("Nama : "+ Pemesan
                                              + "\nCIF: "+CIF
                                              + "\nEmail : "+Email);
            paragraph.setFontSize(16);
            paragraph.setMarginTop(20);    
            paragraph.setTextAlignment(TextAlignment.CENTER);
            // Add a logo to the header
            try {
                Image logo = new Image(ImageDataFactory.create("D:\\kuliah\\SMT 2\\Struktur data\\Project uas\\projectUAs\\src\\icon\\logo.png"));
                document.add(logo);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Create a table with 6 columns
            Table table = new Table(6);

            // Add headers to the table
            table.addCell("Tanggal");
            table.addCell("Kode Kendaraan");
            table.addCell("Nama Penumpang");
            table.addCell("NIK");
            table.addCell("Gender");
            table.addCell("No Seat");

            // Iterate over passengers and add rows to the table
            for (List<String> passenger : passengers) {
                table.addCell(passenger.get(0));  // Tanggal
                table.addCell(passenger.get(1));  // Kode Kendaraan
                table.addCell(passenger.get(2));  // Nama Penumpang
                table.addCell(passenger.get(3));  // NIK
                table.addCell(passenger.get(4));  // Gender
                table.addCell(passenger.get(5));  // No Seat
            }

            // Center the table
            table.setHorizontalAlignment(com.itextpdf.layout.property.HorizontalAlignment.CENTER);

            // Add the table to the document
            document.add(table);
            Paragraph paragraph1 = new Paragraph("Thank you for choosing our service. We hope you have a pleasant journey!");
            paragraph1.setFontSize(16);
            paragraph1.setMarginTop(20);    
            paragraph1.setTextAlignment(TextAlignment.CENTER);

        // Add spacing before the paragraph
       
        // Center the paragraph
        

        // Add the paragraph to the document
        document.add(paragraph);

        } catch (FileNotFoundException e) {
            // Handle file not found exception
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
        EmailSender.sendEmail(Email);
    }
    public static class EmailSender {
        public static void sendEmail(String recipientEmail) {
            // Your email sending logic here
            // ... // Your email and password
        final String from = "prodigytravel62@gmail.com";
        final String password = "ovcu vbbe cgyt vlkb";
        

       // Setup mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Get the Session object
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set Subject: header field
            message.setSubject("Email with PDF Attachment");

            // Create the message body
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Please find the attached PDF file.");

            // Create the attachment
            BodyPart attachmentBodyPart = new MimeBodyPart();
            String filename = "D:\\kuliah\\SMT 2\\Struktur data\\Project uas\\projectUAs\\invoice.pdf";
            DataSource source = new FileDataSource(filename);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName(filename);

            // Create the Multipart object and add the parts to it
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            // Set the Multipart object to the message object
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        }
    }
}
