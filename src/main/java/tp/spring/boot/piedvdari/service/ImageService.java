package tp.spring.boot.piedvdari.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.ImageModel;
import tp.spring.boot.piedvdari.repository.ImageRepository;
@Service
public class ImageService implements IimageService {
@Autowired
public ImageRepository imageRepository;

@Override
public void uplaodImage(MultipartFile file,Furniture f) throws IOException{
	 System.out.println("Original Image Byte Size - " + file.getBytes().length);
	 ImageModel img = new ImageModel(file.getOriginalFilename(),file.getContentType(),compressBytes(file.getBytes()));
	 img.setFurnitures(f);
	 imageRepository.save(img);
}

@Override
public void uplaodImage2(MultipartFile file) throws IOException{
	 System.out.println("Original Image Byte Size - " + file.getBytes().length);
	 ImageModel img = new ImageModel(file.getOriginalFilename(),file.getContentType(),compressBytes(file.getBytes()));
	
	 imageRepository.save(img);
}

		@Override
		public ImageModel getImage(String imageName) throws IOException {
			final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
			 ImageModel img=new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),decompressBytes(retrievedImage.get().getPicByte()));
	        return img;
		}

	//compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		 Deflater deflater = new Deflater();
		 deflater.setInput(data);
		 deflater.finish();
		 //to write common data into multiple files
		 ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		 //The ByteArrayOutputStream class stream creates a buffer in memory and all the data sent to the stream is stored in the buffer.
		 byte[] buffer = new byte[1024];
		  while (!deflater.finished()) {
			  int count = deflater.deflate(buffer);
			  outputStream.write(buffer, 0, count);
				          }
		  try {	  outputStream.close();
			  } catch (IOException e) {
			  			   }
		  System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
			   return outputStream.toByteArray();
	}

	 // uncompress the image bytes before returning it to the angular application
	 public static byte[] decompressBytes(byte[] data) {
		 Inflater inflater = new Inflater();
		 inflater.setInput(data);
		 ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		 byte[] buffer = new byte[1024];
		 try {
			 while (!inflater.finished()) {
				 int count = inflater.inflate(buffer);
				 outputStream.write(buffer, 0, count);
			 }
			 outputStream.close();
		 } catch (IOException ioe) {
		 } catch (DataFormatException e) {
		 }
		 return outputStream.toByteArray();
			 }

	
		 
		 
	 
}
