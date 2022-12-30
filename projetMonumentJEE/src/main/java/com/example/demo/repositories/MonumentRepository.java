package com.example.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Monument;

public interface MonumentRepository extends JpaRepository<Monument,String> {
	
	@Query("select m from Monument m where m.nom like :x")
	public Page <Monument> chercher(@Param("x")String mc,Pageable pageable);
	
	
	

}
