package tp.spring.boot.piedvdari.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.ImageModel;
import tp.spring.boot.piedvdari.service.IimageService;
import tp.spring.boot.piedvdari.service.ImageService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/image")
public class ImageResource {
	
	@Autowired
 public IimageService imageService;
	
	
	public ImageResource(ImageService imageService) {
		super();
		this.imageService=imageService;
	}
	 

	@PostMapping("/upload")
	 public ResponseEntity<?>uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException{
		 imageService.uplaodImage2(file);
		 return new ResponseEntity<>(HttpStatus.OK);
		 
	 }
	@GetMapping("/get/{imageName}")
	public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
		 ImageModel img=imageService.getImage(imageName);
		 return img;
		
	}

}
