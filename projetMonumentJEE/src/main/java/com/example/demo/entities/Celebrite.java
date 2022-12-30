package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;


@Entity @Table(name="Celebrite")
public class Celebrite {
	
	@ManyToMany (mappedBy = "celebrites")
	private List<Monument> monuments= new ArrayList <Monument>();
    @Id
    private String numCelebrite;
    private String nom;
    private String prenom;
    private String nationalite;
    private String epoque;
   
    public Celebrite() {
	}

	public String getNumCelebrite() {
		return numCelebrite;
	}

	public void setNumCelebrite(String numCelebrite) {
		this.numCelebrite = numCelebrite;
	}

	public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNationalite() {
        return nationalite;
    }
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
    public String getEpoque() {
        return epoque;
    }
    public void setEpoque(String epoque) {
        this.epoque = epoque;
    }
    


	public List<Monument> getMonuments() {
		return monuments;
	}

	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}

	@Override
	public String toString() {
		return "Celebrite [monuments=" + monuments + ", numCelebrite=" + numCelebrite + ", nom=" + nom + ", prenom="
				+ prenom + ", nationalite=" + nationalite + ", epoque=" + epoque + "]";
	}

	
   
    
    
    

}
