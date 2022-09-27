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
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dtos.Credentials;
import com.iacsd.dtos.OwnerDTO;
import com.iacsd.dtos.Response;
import com.iacsd.dtos.VisitorDTO;
import com.iacsd.dtos.WorkStaffDTO;
import com.iacsd.entities.Visitor;
import com.iacsd.entities.WorkStaff;
import com.iacsd.services.WorkStaffServiceImpl;
@CrossOrigin
@RestController
public class WorkStaffControllerImpl {
	
	@Autowired
	private WorkStaffServiceImpl workStaffService;
	
	@Autowired
	private WorkStaffDTO workStaffDto;
	
	
	@GetMapping("/WorkStaff/workstafflist")
	public ResponseEntity<?> getAllWorkStaff()
	
	{
		List<WorkStaff> workStaffList = workStaffService.listOfWorkStaff();
		List<WorkStaffDTO> workStaffdtoList = new ArrayList();
		for(WorkStaff workStaff:workStaffList) {
			workStaffdtoList.add(workStaffDto.toWorkStaffDto(workStaff));
		}
		return Response.success(workStaffdtoList);
	}
	
	
	@PostMapping("/staff/signin")
	public ResponseEntity<?> signIn( @RequestBody Credentials cred) {
		WorkStaffDTO staffDto = workStaffService.findStaffByEmailAndPassword(cred);
		if(staffDto == null)
			return Response.error("user not found");
		return Response.success(staffDto);
	}
	
	
	@PostMapping("WorkStaff/addWorkStaff")
	public ResponseEntity<?> addWorkStaff (@RequestBody WorkStaffDTO workStaff) {
		WorkStaff result = workStaffService.saveWorkStaff(workStaffDto.toWorkStaffEntity(workStaff));
		return Response.success((workStaffDto.toWorkStaffDto(result)));
	}
		
	
		
		@PutMapping("/WorkStaff/updateworkstaff/{id}")
		public ResponseEntity<?> updateWokStaffDetails(@PathVariable("id") int id,@RequestBody WorkStaffDTO workStaff) {
			WorkStaff result = workStaffService.updateWorkStaff(id, workStaff);
			return Response.success(workStaffDto.toWorkStaffDto(result));
		}
		
	@DeleteMapping("/WorkStaff/deleteworkstaff/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable("id") int id) {
		Map<String, Object> result = workStaffService.deleteWorkStaff(id);
		return Response.success(result);
	}

}
