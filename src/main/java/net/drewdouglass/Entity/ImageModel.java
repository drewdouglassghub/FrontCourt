package net.drewdouglass.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImageModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long imageid;
	private String imagename;
	private String imagetype;
	private byte[] image;
	
	
	
}
