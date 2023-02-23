package com.canddella.utility;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.FinalTeam;
import com.canddella.service.FinalTeamServiceImpl;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdfgenerate {
	public static void main(String[] args) {
		generatepdf();
		
	}
	public static void generatepdf(){
		
		String query = "SELECT  final_team.final_team_id as SERIAL_NO,players.player_name as PLAYER_NAME,final_team.player_roles as PLAYER_ROLE FROM final_team join players on final_team.player_id=players.player_id where year =2020";

        try {  
        	Connection connection = null;
    		PreparedStatement prepStmt = null;
        
            // Connect to the database
        	DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(query);
			ResultSet resultSet = prepStmt.executeQuery();

            // Create a new PDF document
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\JIJO\\eclipse-workspace\\Project\\Pdf\\demo.pdf"));
            document.open();
            
            
            Image image = Image.getInstance("C:\\Users\\JIJO\\Downloads\\cricketlogo.jpg");
            image.scaleAbsolute(550, 300);
            image.setAlignment(Element.ALIGN_CENTER);
            
           Paragraph paragraph = new Paragraph();
//            image.setAlignment(Element.ALIGN_TOP);
            paragraph.setSpacingBefore(5); // 20pt space before the paragraph
//           
            Paragraph paragraph1 = new Paragraph("*---------------------------------------------FINAL LIST---------------------------------------------*");
            // Create a table object in iText
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            Paragraph paragraph3 = new Paragraph(" ");
            PdfPTable table = new PdfPTable(3); // 3 columns

            // Add the table headers
            table.addCell("SERIAL_NO");
            table.addCell("PLAYER_NAME");
            table.addCell("PLAYER_ROLE");

            // Add the table data
            while (resultSet.next()) {
                table.addCell(resultSet.getString("SERIAL_NO"));
                table.addCell(resultSet.getString("PLAYER_NAME"));
                table.addCell(resultSet.getString("PLAYER_ROLE"));
            }

            // Add the table object to the PDF document
            document.add(image);
            document.add(paragraph);
            document.add(paragraph1);
            document.add(paragraph3);
            document.add(table);

            // Close the document and the database connection
            document.close();
            System.out.println("Print Generated!!!!!!");
            
        } catch (Exception e) {
            e.printStackTrace();
		
		
		
		
        }
        }	

	
		
}

