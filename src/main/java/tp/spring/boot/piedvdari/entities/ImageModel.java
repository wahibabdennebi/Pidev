package tp.spring.boot.piedvdari.entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "image_table")
public class ImageModel {
		 @Id
	     @Column(name = "id")
	     @GeneratedValue(strategy = GenerationType.IDENTITY)
	     private Long id;
	     @Column(name = "name")
	     private String name;
	     @Column(name = "type")
	     private String type;
	     @Column(name = "picByte", length = 1000)
	     private byte[] picByte;
	     @JsonIgnore
	     @ManyToOne(cascade = CascadeType.PERSIST)
	     private Furniture furnitures;
		public Long getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getType() {
			return type;
		}
		public byte[] getPicByte() {
			return picByte;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setType(String type) {
			this.type = type;
		}
		public void setPicByte(byte[] picByte) {
			this.picByte = picByte;
		}
	     
	 public Furniture getFurnitures() {
			return furnitures;
		}
		public void setFurnitures(Furniture furnitures) {
			this.furnitures = furnitures;
		}
	public ImageModel() {
			  super();
				   }
	public ImageModel(String name, String type, byte[] picByte, Furniture furnitures) {
		super();
		this.name = name;
		this.type = type;
		this.picByte = picByte;
		this.furnitures = furnitures;
	}
	public ImageModel(String name, String type, byte[] picByte) {
		super();
		this.name = name;
		this.type = type;
		this.picByte = picByte;
		
	}
	  
}
