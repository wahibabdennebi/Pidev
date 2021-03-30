package tp.spring.boot.piedvdari.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.ImageModel;
public interface IimageService {

	public void uplaodImage(MultipartFile file,Furniture f) throws IOException;

	void uplaodImage2(MultipartFile file) throws IOException;
	public ImageModel getImage(String imageName) throws IOException;
}
