package com.demo.api.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.demo.api.dto.MasterData;
import com.demo.api.exception.DuplicateRecordException;
import com.demo.api.exception.NotFoundRecordException;
import com.demo.entity.Master;
import com.demo.repository.MasterRepository;
import com.demo.utils.DateUtil;


@Service
public class MasterService {

	@Autowired
	private MasterRepository masterRepository;
	

	
	public List<MasterData> lists() {

		return masterRepository.findAll().stream()
				.map(this::mappingToMasterData)
				.collect(Collectors.toList());

	}

	private MasterData mappingToMasterData(Master master) {
		MasterData masterData = new MasterData();
		masterData.setMasterName(master.getName());
		masterData.setCreateDate(master.getCreateDate());
		return masterData;
	}
	
	
	@Transactional
	public MasterData createMaster(MasterData newMaster) {
		

		Assert.hasLength(newMaster.getMasterName(), "Master Name is required!");
		
		if(masterRepository.existsByName(newMaster.getMasterName())) {
			throw new DuplicateRecordException(String.format("Duplicated Data for master name [%s]", newMaster.getMasterName()));
		}	

		Master master = new Master();
		
		master.setName(newMaster.getMasterName());
		Date now = DateUtil.now();
		master.setCreateDate(now);
		master.setDisabled(false);
		
		master = masterRepository.saveAndFlush(master);
		
		return mappingToMasterData(master);
	}

	public MasterData findById(Long masterId) {
		return masterRepository.findById(masterId)
		.map(this::mappingToMasterData)
		.orElseThrow(() -> new NotFoundRecordException("Not Found ..."));
	}
	
}
