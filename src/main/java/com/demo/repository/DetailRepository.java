package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Detail;
import com.demo.entity.Master;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long>{

}
