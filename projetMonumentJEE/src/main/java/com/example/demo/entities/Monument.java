package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity @Table(name="monument")//Lien entre la classe et la table
public class Monument {
	
		
	    @Id 
	    @NotNull
	    @Size(min=4 , max=10)
	    private String geohash;
	    @NotNull
	    @Size(min=4 , max=10)
	    private String nom;
	    @NotNull
	    @Size(min=4 , max=10)
	    private String proprietaire;
	    @NotNull
	    @Size(min=4 , max=10)
	    private String typeM;
	    @NotNull
	    private float longitude;
	    @NotNull
	    private float latitude;
	  
	     
	    
	    @ManyToMany 
	    @JoinTable( name = "associea",
        joinColumns = @JoinColumn( name = "codeM" ),
        inverseJoinColumns = @JoinColumn( name = "numCelebrite" ) )
	    private List<Celebrite> celebrites = new ArrayList<Celebrite>();
	    
	    
	    
	    public Monument(String geohash, String nom, String proprietaire, String typeM, float longitude,
				float latitude) {
			super();
			this.geohash = geohash;
			this.nom = nom;
			this.proprietaire = proprietaire;
			this.typeM = typeM;
			this.longitude = longitude;
			this.latitude = latitude;
		}
	    
	    
	    

		public Monument(String geohash, String nom, String proprietaire, String typeM, float longitude, float latitude,
				List<Celebrite> celebrites) {
			super();
			this.geohash = geohash;
			this.nom = nom;
			this.proprietaire = proprietaire;
			this.typeM = typeM;
			this.longitude = longitude;
			this.latitude = latitude;
			this.celebrites = celebrites;
		}




		public Monument() {
	 	}
	   
	    public String getGeohash() {
	        return geohash;
	    }
	    
	    public void setGeohash(String geohash) {
	        this.geohash = geohash;
	    }
	    public String getNom() {
			return nom;
		}
	       
	    public void setNom(String nom) {
	        this.nom = nom;
	    }
		
	    public String getProprietaire() {
			return proprietaire;
		}

		public void setProprietaire(String proprietaire) {
			this.proprietaire = proprietaire;
		}
	
		public String getTypeM() {
			return typeM;
		}

		public void setTypeM(String typeM) {
			this.typeM = typeM;
		}

		public float getLongitude() {
			return longitude;
		}

		public void setLongitude(float longitude) {
			this.longitude = longitude;
		}

		public float getLatitude() {
			return latitude;
		}

		public void setLatitude(float latitude) {
			this.latitude = latitude;
		}

		public List<Celebrite> getCelebrites() {
			return celebrites;
		}

		public void setCelebrites(List<Celebrite> celebrites) {
			this.celebrites = celebrites;
		}

		@Override
		public String toString() {
			return "Monument [geohash=" + geohash + ", nom=" + nom + ", proprietaire=" + proprietaire + ", typeM="
					+ typeM + ", longitude=" + longitude + ", latitude=" + latitude + ", celebrites=" + celebrites
					+ "]";
		}
		

	
		

}
