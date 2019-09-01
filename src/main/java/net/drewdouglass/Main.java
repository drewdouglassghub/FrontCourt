package net.drewdouglass;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.query.NativeQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.provider.HibernateUtils;

import net.drewdouglass.Entity.Player;

@SpringBootApplication
public class Main  {
	
	public static void main(String[] args) {
		
		System.out.println("running main");		
		   
		SpringApplication.run(Main.class, args);
		
	
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	  public void run(String... arg0) throws Exception {
	    // image 1
	    ClassPathResource backImgFile = new ClassPathResource("image/jsa_about_img_black_background.png");
	    byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
	    backImgFile.getInputStream().read(arrayPic);
	    ImageModel blackImage = new ImageModel(1, "JSA-ABOUT-IMAGE-BLACK-BACKGROUND", "png", arrayPic);
	    
	    // image 2
	    ClassPathResource blueImgFile = new ClassPathResource("image/jsa_about_img_blue_background.png");
	    arrayPic = new byte[(int) blueImgFile.contentLength()];
	    blueImgFile.getInputStream().read(arrayPic);
	    ImageModel blueImage = new ImageModel(2, "JSA-ABOUT-IMAGE-BLUE-BACKGROUND", "png", arrayPic);
	    
	    // store image to MySQL via SpringJPA
	    imageRepository.save(blackImage);
	    imageRepository.save(blueImage);
	    
	    // retrieve image from MySQL via SpringJPA
	    for(ImageModel imageModel : imageRepository.findAll()){
	      Files.write(Paths.get("retrieve-dir/" + imageModel.getName() + "." + imageModel.getType()), imageModel.getPic());
	    }*/
	}

