package com.demo.api.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.dto.MasterData;
import com.demo.api.service.MasterService;


@RestController
@RequestMapping("/api")
public class MasterController {
	
	@Autowired
	private MasterService masterService;
	
	@GetMapping("/master")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<MasterData> getMasters(){
		return masterService.lists();
	}
	
	@GetMapping("/master/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public MasterData getMasterById(@PathParam("id") Long masterId){
		return masterService.findById(masterId);
	}
	
	@PostMapping("/master")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public MasterData saveMaster(@RequestBody MasterData newMaster) {
		return masterService.createMaster(newMaster);
	}
}
