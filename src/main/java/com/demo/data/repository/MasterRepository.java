package com.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.data.entity.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long>{

	
	public boolean existsByName(String masterName); //byName => by name(field name)
}
