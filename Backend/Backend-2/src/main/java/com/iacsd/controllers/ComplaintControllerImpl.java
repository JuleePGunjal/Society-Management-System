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

import com.iacsd.dtos.ComplaintDTO;
import com.iacsd.dtos.Response;
import com.iacsd.entities.Complaint;
import com.iacsd.services.ComplaintServiceImpl;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ComplaintControllerImpl {
@Autowired
private ComplaintServiceImpl complaintService;

@Autowired
private ComplaintDTO complaintDto;



@GetMapping("/complaint/complaintlist")
public ResponseEntity<?> getAllComplaint()
{
	List<Complaint> complaintList = complaintService.findAllComplaint();
	if(complaintList.isEmpty()) return Response.success("There are no complaints!!!");
	List<ComplaintDTO> complaintdtoList = new ArrayList();
	for(Complaint complaint : complaintList) {
		complaintdtoList.add(complaintDto.toComplaintDto(complaint));
	}
	return Response.success(complaintdtoList);
}

@GetMapping("/complaint/byflatandwing")
public ResponseEntity<?> getComplaint(@RequestParam int flat,@RequestParam String wing){
	List<Complaint> result = complaintService.listOfMaintenanceByFlatNo(flat,wing);
	if(result.isEmpty()) return Response.success("There are no complaints!!!");
	List<ComplaintDTO> complaintList = new ArrayList();
	for(Complaint complaint : result) {
		complaintList.add(complaintDto.toComplaintDto(complaint));
	}
	
	return Response.success(complaintList);
}
	


@PostMapping("/complaint/addcomplaint")
public ResponseEntity<?> addComplaint(@RequestBody ComplaintDTO complaintDto){
	Complaint result=complaintService.saveComplaint(complaintDto);
	return Response.success(complaintDto.toComplaintDto(result));
	
	
}

@PutMapping("/complaint/updatestatus/{id}")

	public ResponseEntity<?> updateStatus(@PathVariable("id") int id,@RequestBody ComplaintDTO complaintDto)
	{
		ComplaintDTO result = complaintService.changeStatus(id, complaintDto);
		if(result!=null) {
		return Response.success(result);
		}
		else return  Response.success("Invalid Id");
	}


@DeleteMapping("/complaint/deletebyid/{id}")
public ResponseEntity<?> deleteComplaintById(@PathVariable("id") int id) {
	Map<String, Integer> result = complaintService.deleteComplaint(id);
	if(result.get("affectedRows")==0) {
		return  Response.success("Invalid Id");
	}
	else return Response.success(result);
}
}
