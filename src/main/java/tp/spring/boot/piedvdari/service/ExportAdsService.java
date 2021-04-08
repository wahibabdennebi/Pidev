package tp.spring.boot.piedvdari.service;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tp.spring.boot.piedvdari.entities.Ads;
import tp.spring.boot.piedvdari.entities.Category;
@Service
public class ExportAdsService {
public static ByteArrayInputStream adsPDFReport(List <Ads> ads){
	Document document =new Document();
	ByteArrayOutputStream out =new ByteArrayOutputStream();
	 try {
	PdfWriter.getInstance(document, out);
	document.open();
	//ad text to pdf file 
	com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
	Paragraph para = new Paragraph("Ads List",font);
	para.setAlignment(Element.ALIGN_CENTER);
	document.add(para);
	document.add(Chunk.NEWLINE);
	
	PdfPTable table = new PdfPTable(4);
	 Stream.of( "adress", "area","description","category"/* "city", "creationdate", "description", "price", "room", "title", "type_ads"*/)
     .forEach(headerTitle -> {
           PdfPCell header = new PdfPCell();
           Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
           header.setBackgroundColor(BaseColor.LIGHT_GRAY);
           header.setHorizontalAlignment(Element.ALIGN_CENTER);
           header.setBorderWidth(2);
           header.setPhrase(new Phrase(headerTitle, headFont));
           table.addCell(header);
     });
	 for (Ads  ad : ads) {
     	/*PdfPCell idCell = new PdfPCell(new Phrase(ad.getId_ad()));
     	idCell.setPaddingLeft(4);;
     	idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
     	idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(idCell);*/

         PdfPCell adressCell = new PdfPCell(new Phrase(ad.getAdress()));
         adressCell.setPaddingLeft(4);
         adressCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         adressCell.setHorizontalAlignment(Element.ALIGN_LEFT);
         table.addCell(adressCell);

         PdfPCell areaCell = new PdfPCell(new Phrase(String.valueOf(ad.getArea())));
         areaCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         areaCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         areaCell.setPaddingRight(4);
         table.addCell(areaCell);
         
         PdfPCell descriptionCell = new PdfPCell(new Phrase(ad.getDescription()));
         descriptionCell.setPaddingLeft(4);
         descriptionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         descriptionCell.setHorizontalAlignment(Element.ALIGN_LEFT);
         table.addCell(descriptionCell);
         
         PdfPCell categoryCell = new PdfPCell(new Phrase(ad.getCategory().toString()));
         categoryCell.setPaddingLeft(4);
         categoryCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         categoryCell.setHorizontalAlignment(Element.ALIGN_LEFT);
         table.addCell(categoryCell);
         
         /*PdfPCell descriptionCell = new PdfPCell(new Phrase(String.valueOf(ad.getDescription())));
         descriptionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         descriptionCell.setHorizontalAlignment(Element.ALIGN_RIGHT);;
         descriptionCell.setPadding(4);
         descriptionCell.addElement(descriptionCell);
         table.addCell(descriptionCell);
        
        /* PdfPCell creationdateCell = new PdfPCell(new Phrase(Date.valueOf(ad.getCreationdate())));
         creationdateCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         creationdateCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         creationdateCell.setPaddingRight(4);
         creationdateCell.addElement(creationdateCell );
         table.addCell(creationdateCell);*/
         
         /*  PdfPCell categoryCell = new PdfPCell(new Phrase(String.valueOf(Category.office)));
         categoryCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         categoryCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         categoryCell.setPaddingRight(4);
         categoryCell.addElement(categoryCell );
         table.addCell(areaCell);*/
         
         /* PdfPCell cityCell = new PdfPCell(new Phrase(String.valueOf(ad.getCity())));
         cityCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cityCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         cityCell.setPaddingRight(4);
         cityCell.addElement(cityCell );
         table.addCell(cityCell);
         
         PdfPCell creationdateCell = new PdfPCell(new Phrase(String.valueOf(ad.getCreationdate())));
         creationdateCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         creationdateCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         creationdateCell.setPaddingRight(4);
         creationdateCell.addElement(creationdateCell );
         table.addCell(creationdateCell);
         
         PdfPCell descriptionCell = new PdfPCell(new Phrase(String.valueOf(ad.getDescription())));
         descriptionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         descriptionCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         descriptionCell.setPaddingRight(4);
         descriptionCell.addElement(descriptionCell);
         table.addCell(descriptionCell);
         
         PdfPCell priceCell = new PdfPCell(new Phrase(String.valueOf(ad.getPrice())));
         priceCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         priceCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         priceCell.setPaddingRight(4);
         priceCell.addElement(priceCell);
         table.addCell(priceCell);
         
         PdfPCell roomCell = new PdfPCell(new Phrase(String.valueOf(ad.getRoom())));
         roomCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         roomCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         roomCell.setPaddingRight(4);
         roomCell.addElement(roomCell);
         table.addCell(roomCell);
         
         PdfPCell titleCell = new PdfPCell(new Phrase(String.valueOf(ad.getTitle())));
         titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         titleCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         titleCell.setPaddingRight(4);
         titleCell.addElement(titleCell);
         table.addCell(titleCell);
         
         PdfPCell type_adsCell = new PdfPCell(new Phrase(String.valueOf(ad.getType_ads())));
         type_adsCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         type_adsCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         type_adsCell.setPaddingRight(4);
         type_adsCell.addElement(type_adsCell);
         table.addCell(type_adsCell);*/
     }
	 document.add(table);
     
     document.close();
 }catch(DocumentException e) {
 	e.printStackTrace();
 }
 
	return new ByteArrayInputStream(out.toByteArray());
}
}
