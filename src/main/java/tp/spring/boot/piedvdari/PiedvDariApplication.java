package tp.spring.boot.piedvdari;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;





@EnableWebMvc
//@ComponentScan({"tp.spring.boot.piedvdari.services","tp.spring.boot.piedvdari.entities"})


@SpringBootApplication
@ComponentScan(basePackages = {
	    "tp.spring.boot.piedvdari"})
public class PiedvDariApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiedvDariApplication.class, args);
	}

}

//public class PiedvDariApplication {
	
	

	/*public static void main(String[] args) {
		 Mail mail = new Mail();
	    mail.setMailFrom("souaimelek1900@gmail.com");
	    mail.setMailTo("souaimelek1900@gmail.com");
	    mail.setMailSubject("Spring Boot - Email Example");
	    mail.setMailContent("b "
	    		+ "");
		ApplicationContext ctx=SpringApplication.run(PiedvDariApplication.class, args);
		MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendEmail(mail);*/
	
	/*@ComponentScan(basePackages = {
    "com.technicalkeeda"
})
public class Application {
    public static void main(String[] args) {
 
        Mail mail = new Mail();
        mail.setMailFrom("yashwantchavan@gmail.com");
        mail.setMailTo("yashwantchavan@gmail.com");
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nwww.technicalkeeda.com");
 
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        MailService mailService = (MailService) ctx.getBean("mailService");
        mailService.sendEmail(mail);
 
    }
} */


