package com.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.data.entity.Detail;
import com.demo.data.entity.Master;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long>{

}
