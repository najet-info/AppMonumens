package com.example.demo.services.Imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Monument;
import com.example.demo.repositories.MonumentRepository;
import com.example.demo.services.MonumentService;

@Service
public class MonumentServiceImp implements MonumentService {
	
	
	private MonumentRepository repoMonument;
	
	public MonumentServiceImp(MonumentRepository repoMonument) {
		super();
		this.repoMonument = repoMonument;
	}
	
	public MonumentServiceImp() {
		super();
	}
	
	
	@Override
	public List<Monument> getAllMonument() {
		
		return repoMonument.findAll();
	}




	/*
	public void SupprimerMonument(String nom) {
		List<Monument> listMonum = repoMonument.findAll();
		listMonum.removeIf(m ->m.getNom().equals(nom));
	} */

	


	

}
