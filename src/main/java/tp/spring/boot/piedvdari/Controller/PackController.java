package tp.spring.boot.piedvdari.Controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tp.spring.boot.piedvdari.entities.Pack;
import tp.spring.boot.piedvdari.repositories.PackRepository;
import tp.spring.boot.piedvdari.repositories.UserRepository;
import tp.spring.boot.piedvdari.services.IPackService;
import tp.spring.boot.piedvdari.services.PackService;
import tp.spring.boot.piedvdari.services.PdfService;
import tp.spring.boot.piedvdari.services.TwillioService;


@RestController
@RequestMapping("/pack")
public class PackController {
		@Autowired
		IPackService ipackservice;
		@Autowired
		 UserRepository userrepository;
		@Autowired
		PackRepository packrep;
		@Autowired
		private JavaMailSender javaMailSender;
		 @Autowired
	    	TwillioService twillioService;
		SimpleMailMessage msg = new SimpleMailMessage();
		 private PackService packService;
		    private PdfService pdfService;
		    @Autowired
		    public  PackController(PackService packService, PdfService pdfService) {
		        this.packService = packService;
		        this.pdfService = pdfService;
		    }
	 //  http://localhost:8081/SpringMVC/servlet/ajouterPack #POST
		@PostMapping("/ajouterPack")
		
		public void ajouterPack(@RequestBody Pack pack) {
			
			pack.setCostumer(userrepository.findById(1).get());
			ipackservice.ajouterPack(pack);
			String mailadress = packrep.findById(pack.getId_pack()).get().getCostumer().getEmail();
			
			

	
			MimeMessage message = javaMailSender.createMimeMessage();
		    try {
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		        helper.setFrom("oussama.zaibi1@esprit.tn");
		        helper.setTo(mailadress);
		        helper.setSubject("Confirmation Abonement");
		        helper.setText("votre abonnement est activé");
		        byte[] content = Files.readAllBytes(Paths.get(pdfService.generatePdf(Optional.of(pack)).getAbsolutePath()));
		        helper.addAttachment("MyTestFile.pdf", new ByteArrayResource(content));
		        javaMailSender.send(message);
		    } catch (MessagingException | IOException | com.itextpdf.text.DocumentException e) {

		        e.printStackTrace();
		    }
		

			
			
		}
	//  http://localhost:8083/SpringMVC/servlet/supprimerPack #DELETE
			@DeleteMapping("/supprimerPack")
			
			public void supprimerPack(@RequestBody Pack pack) {
				ipackservice.supprimerPack(pack);
				}
	//  http://localhost:8083/SpringMVC/servlet/modiferPack #UPDATE
			@PutMapping
			@ResponseBody
			public void modiferPack(@RequestBody Pack pack) {
				this.ipackservice.modiferPack(pack);
				}

			@PostMapping("/Rappel")
			@ResponseBody
			public void Rappel(Pack pack){
				 LocalDateTime localDate = LocalDateTime.now();
				 float res=0;
				//Pack pack = null;
				 //ipackservice.id_pac(pack);
				 //pack.getDate(userrepository.findById(2).get());
				Date dateAvant=packrep.findById(5).get().getDate();		
				
				Date dateApres=Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
				 float diff = dateApres.getTime() - dateAvant.getTime();
				try{
			    res=(diff / (1000*60*60*24));
			    		
	           if (res <= 30.0){
	    			//String mailAdress=packRep.findById(pack.getId_pack()).get().getCustomer().getEmail();
	    			msg.setTo("oussama.zaibi1@esprit.tn"); 
	    			msg.setSubject("Rappel"); 
	    			msg.setText("votre abonnement va etre expiré");
	    			javaMailSender.send(msg);
	    			
	            }

		     } catch (Exception e) {
		         e.printStackTrace();
		     }
				
		  }
			 @GetMapping("/download-pdf")
			    public void downloadPDFResource(HttpServletResponse response) {
			        try {
			        	Optional<Pack> pack=packService.findPackById(5);
			        	
			        		Path file = Paths.get(pdfService.generatePdf(pack).getAbsolutePath());
				            if (Files.exists(file)) {
				                response.setContentType("application/pdf");
				                response.addHeader("Content-Disposition",
				                        "attachment; filename=" + file.getFileName());
				                Files.copy(file, response.getOutputStream());
				                response.getOutputStream().flush();
				            }
			        	
			            
			        } catch (IOException | com.itextpdf.text.DocumentException ex) {
			            ex.printStackTrace();}
			        }
			        
			       
		    	@Value("${app.twillio.fromPhoneNo}")
		    	private String from;
		    	
		    	@Value("${app.twillio.toPhoneNo}")
		    	private String to;


			    	@GetMapping("/sendSms")
			    	public float sendSms(Pack pack) {
						LocalDateTime localDate = LocalDateTime.now();
						 float res=0;
							Date dateAvant=packrep.findById(26).get().getDate();		
							
							Date dateApres=Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
							 float diff = dateApres.getTime() - dateAvant.getTime();
							try{
						    res=(diff / (1000*60*60*24));
				            if (res>=0){
					    		String body = "Hello. Good Morning!!";
					    		twillioService.sendSms(to, from, body);
					    		}}
				           	     
				            catch (Exception e) {
						         e.printStackTrace();
						     }
							return res;
			    	}
}
							
			    	

			    		
			


