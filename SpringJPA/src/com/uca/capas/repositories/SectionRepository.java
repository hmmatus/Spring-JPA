package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {
	
	public List<Section> findAll();

}
