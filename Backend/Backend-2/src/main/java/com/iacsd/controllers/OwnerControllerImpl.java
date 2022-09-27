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

import com.iacsd.dtos.Credentials;
import com.iacsd.dtos.OwnerDTO;
import com.iacsd.dtos.Response;
import com.iacsd.dtos.SocietyFlatDTO;
import com.iacsd.entities.Owner;
import com.iacsd.entities.SocietyFlat;
import com.iacsd.services.OwnerServiceImpl;

@CrossOrigin
@RestController
public class OwnerControllerImpl {

	@Autowired
	private OwnerServiceImpl ownerService;
	
	@Autowired
	private OwnerDTO ownerDto;
	
	@Autowired
	private SocietyFlatDTO societyFlatDto;

	@GetMapping("/owner/details/{id}")
	public ResponseEntity<?> findOwnerById(@PathVariable("id") int id) {
		Owner result = ownerService.findOwnerById(id);
		
		if(result!=null) {
			result.setPassword("**********");
			return Response.success(ownerDto.toOwnerDto(result));
		}
		else return Response.success("Owner not found");
	}
	
	@GetMapping("/owner/flats/{id}")
	public ResponseEntity<?> findOwnerFlatsById(@PathVariable("id") int id) {
		Owner result = ownerService.findOwnerById(id);
		
		if(result!=null) {
			List<SocietyFlatDTO> flatDto = new ArrayList<SocietyFlatDTO>();
			for(SocietyFlat flat : result.getFlat()) {
				flatDto.add(societyFlatDto.toSocietyFlatDto(flat));
			}
			if(flatDto.size()==0)
				return Response.success("Dont have Flat");
			return Response.success(flatDto);
		}
		else return Response.success("Owner not found");
	}
	
	@GetMapping("/owner/ownerlist")
	public ResponseEntity<?> getAllOwner()
	{
		List<Owner> result = ownerService.findAllOwner();
		if(result.isEmpty()) return Response.success("There are no owners!!!");
		List<OwnerDTO> ownerList = new ArrayList();
		for(Owner o : result) {
			OwnerDTO owner = ownerDto.toOwnerDto(o);
			owner.setPassword("**********");
			ownerList.add(owner);
		}
		return Response.success(ownerList);
	}

	@GetMapping("/owner/getbyemail/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable ("email") String email)
	{
		OwnerDTO result = ownerService.findOwnerByemail(email);
		if(result!=null) {
			result.setPassword("**********");
			return Response.success(result);
		}
		else return Response.success("Invalid Email");
	}
	
	@GetMapping("/owner/flatno/{flatno}")
	public ResponseEntity<?> getOwnerByFlatNo(@PathVariable("flatno") int flatNo) {
		OwnerDTO owner = ownerDto.toOwnerDto(ownerService.getOwnerFlatNo(flatNo));
		owner.setPassword("**********");
		return Response.success(owner);
		}
	
	@GetMapping("/owner/floorandwing")
	public ResponseEntity<?> getOwnerByFloorNoAndWingNo(@RequestParam int floor,@RequestParam String wing) {
		List<OwnerDTO> owner = ownerService.getOwnerFloorNo(floor,wing);
		if(owner.isEmpty())
			return Response.success("Owners not found");
		return Response.success(owner);
	}
	
	@PostMapping("/owner/signin")
	public ResponseEntity<?> signIn( @RequestBody Credentials cred) {
		OwnerDTO ownerDto = ownerService.findUserByEmailAndPassword(cred);
		if(ownerDto == null)
			return Response.error("user not found");
		return Response.success(ownerDto);
	}
	
	@PostMapping("/owner/signup")
	public ResponseEntity<?> signUp(@RequestBody OwnerDTO ownerDto) {
		OwnerDTO result = ownerService.saveOwner(ownerDto);
		return Response.success(result);
	}
	
	@PutMapping("/owner/update/{id}")
	public ResponseEntity<?> updateByOwner(@PathVariable("id") int id,@RequestBody OwnerDTO ownerDto) {
		OwnerDTO result = ownerService.updateOwner(id,ownerDto);
		return Response.success(result);
	}
	
	@PutMapping("/owner/changepassword/{id}")
	public ResponseEntity<?> changePassword(@PathVariable("id") int id,@RequestBody OwnerDTO ownerDto) {
		OwnerDTO result = ownerService.changePassword(id,ownerDto);
		return Response.success(result);
	}
	
	@PutMapping("/owner/updateadmin/{id}")
	public ResponseEntity<?> updateByAdmin(@PathVariable("id") int id,@RequestBody OwnerDTO ownerDto) {
		OwnerDTO result = ownerService.updateOwnerByAdmin(id,ownerDto);
		return Response.success(result);
	}

	
	@DeleteMapping("/owner/delete/{id}")
	public ResponseEntity<?> deleteBlog(@PathVariable("id") int id) {
		Map<String, Integer> result = ownerService.deleteOwner(id);
		if(result.get("affectedRows")==0) {
			return  Response.success("Invalid Id");
		}
		else return Response.success(result);
	}

	
	}

