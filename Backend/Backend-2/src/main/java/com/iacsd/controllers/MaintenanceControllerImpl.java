package com.iacsd.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dtos.MaintenanceDTO;
import com.iacsd.dtos.Response;
import com.iacsd.entities.Maintenance;
import com.iacsd.services.MaintenanceServiceImpl;
import com.iacsd.services.SocietyFlatServiceImpl;
@CrossOrigin
@RestController
public class MaintenanceControllerImpl {
	@Autowired
	private MaintenanceServiceImpl maintenanceService;
	
	@Autowired
	private SocietyFlatServiceImpl societyFlatService;
	
	@Autowired
	private MaintenanceDTO maintenanceDto;

	@GetMapping("/maintenance/maintenancelist")
	public ResponseEntity<?> getAllMaintenace()
	{
		List<Maintenance> result = maintenanceService.listOfMaintenance();
		List<MaintenanceDTO> maintenanceList = new ArrayList();
		for(Maintenance maintenance : result) {
			maintenanceList.add(maintenanceDto.toMaintenanceDto(maintenance));
		}
		return Response.success(maintenanceList);
	}
	
	@GetMapping("/maintenance/byflatandwing")
	public ResponseEntity<?> getAllMaintenace(@RequestParam int flat,@RequestParam String wing){
		List<Maintenance> result = maintenanceService.listOfMaintenanceByFlatNo(flat,wing);
		List<MaintenanceDTO> maintenanceList = new ArrayList();
		for(Maintenance maintenance : result) {
			maintenanceList.add(maintenanceDto.toMaintenanceDto(maintenance));
		}
		return Response.success(maintenanceList);
	}

	@PostMapping("/maintenance/addmaintenace")
	public ResponseEntity<?> addMaintenance(@RequestBody MaintenanceDTO maintenance){
		Maintenance result=maintenanceService.saveMaintenance(maintenanceDto.toMaintenanceEntity(maintenance,societyFlatService.findAllFlat(maintenance.getFlatId())));
		return Response.success(maintenanceDto.toMaintenanceDto(result));
		
	}

	@PutMapping("/maintenance/updatemaintenance/{id}")
	public ResponseEntity<?> updateMaintenance(@PathVariable("id") int id,@RequestBody MaintenanceDTO maintenance)
	{
	Maintenance result = maintenanceService.updateMaintenance(id,maintenance);
		return Response.success(maintenanceDto.toMaintenanceDto(result));
	}


	@DeleteMapping("/maintenance/deletebyid/{id}")
	public ResponseEntity<?> deleteComplaintById(@PathVariable("id") int id) {
		Map<String, Object> result = maintenanceService.deleteMaintenance(id);
		return Response.success(result);
	}
	}