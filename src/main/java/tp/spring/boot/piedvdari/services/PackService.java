package tp.spring.boot.piedvdari.services;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import tp.spring.boot.piedvdari.entities.Pack;
import tp.spring.boot.piedvdari.repositories.PackRepository;

@Service

public class PackService implements IPackService {
	@Autowired
	 PackRepository packrep;
	@Override
	public void ajouterPack(Pack pack)
	{
		packrep.save(pack);
	}
	public void supprimerPack(Pack pack){
		
		packrep.deleteById(pack.getId_pack());
	}
	public Pack modiferPack(Pack pack ){
	return packrep.save(pack);
	}
	public Optional<Pack> id_pac(Pack pack){
		
		return (packrep.findById(pack.getId_pack()));
	}
	public void sendEmailWithAttachment(Pack pack) throws MailException, MessagingException {
		
		 JavaMailSender javaMailSender = null;

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(pack.getCostumer().getEmail());
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Please find the attached document below.");

		
		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(message);
	}
	public  Optional<Pack> findPackById(int id) {

	     return packrep.findById(id);
	 }


}
