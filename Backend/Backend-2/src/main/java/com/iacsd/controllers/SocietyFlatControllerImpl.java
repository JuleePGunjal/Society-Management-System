package com.iacsd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dtos.Response;
import com.iacsd.dtos.SocietyFlatDTO;
import com.iacsd.entities.Owner;
import com.iacsd.entities.SocietyFlat;
import com.iacsd.services.OwnerServiceImpl;
import com.iacsd.services.SocietyFlatServiceImpl;
@CrossOrigin
@RestController
public class SocietyFlatControllerImpl {
	
	@Autowired
	private SocietyFlatServiceImpl societyFlatService;
	
	@Autowired
	private OwnerServiceImpl ownerService;
	
	@Autowired
	private SocietyFlatDTO flatDto;
	
	@GetMapping("/society/flatlist")
	public ResponseEntity<?> getAllFlats()
	{
		List<SocietyFlat> flatList = societyFlatService.findAllFlat();
		List<SocietyFlatDTO> societyFlatdtoList = new ArrayList();
		for(SocietyFlat societyFlat: flatList) {
			societyFlatdtoList.add(flatDto.toSocietyFlatDto(societyFlat));
		}
		return Response.success(societyFlatdtoList);
	}

	@GetMapping("/society/getFlat/{id}")
	public ResponseEntity<?> getAllFlatsByID(@PathVariable("id") int id)
	{
		 Owner owner = ownerService.findOwnerById(id);
		List<SocietyFlatDTO> societyFlatdtoList = new ArrayList();
		for(SocietyFlat societyFlat: owner.getFlat()) {
			societyFlatdtoList.add(flatDto.toSocietyFlatDto(societyFlat));
		}
		return Response.success(societyFlatdtoList);
	}
	
	@PostMapping("/society/addflat")
	public ResponseEntity<?> addOwnerToFlat(@RequestBody SocietyFlatDTO societyFlatDto){
		SocietyFlat flat=societyFlatService.addOwnerToFlat(societyFlatDto);
		return Response.success(flatDto.toSocietyFlatDto(flat));
	}
	
	@PostMapping("/society/deleteowner")
	public ResponseEntity<?> removeOwnerToFlat(@RequestBody SocietyFlatDTO societyFlatDto){
		SocietyFlat flat=societyFlatService.removeOwnerToFlat(societyFlatDto);
		return Response.success(flatDto.toSocietyFlatDto(flat));
	}
	
}
