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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dtos.OwnerDTO;
import com.iacsd.dtos.Response;
import com.iacsd.dtos.VisitorDTO;
import com.iacsd.entities.Vehicle;
import com.iacsd.entities.Visitor;
import com.iacsd.services.SocietyFlatServiceImpl;
import com.iacsd.services.VisitorServiceImpl;
@CrossOrigin
@RestController
public class VisitorControllerImpl {
	
	@Autowired
	private VisitorServiceImpl visitorService;
	
	@Autowired
	private VisitorDTO visitorDto;
	
	@Autowired
	private SocietyFlatServiceImpl societyFlatService;
	
	@GetMapping("visitor/visitorlist")
	public ResponseEntity<?> getAllVisitor()
	{
		List<Visitor> visitorList = visitorService.findAllVisitor();
		List<VisitorDTO> visitordtoList = new ArrayList();
		for(Visitor visitor:visitorList) {
			visitordtoList.add(visitorDto.toVisitorDto(visitor));
		}
		return Response.success(visitordtoList);
	}
	
	@GetMapping("/visitor/byname/{name}")
	public ResponseEntity<?> GetVisitorByName( @PathVariable ("name") String name){
		
		Visitor result = visitorService.VisByName(name);
		return Response.success(visitorDto.toVisitorDto(result));
	}
	
	 @GetMapping("/visitor/byflatandwing")
    public ResponseEntity<?> getVehicleByFlatNoAndWing(@RequestParam int flat,@RequestParam String wing){
    	Visitor result = visitorService.listOfVisitorByFlatNo(flat,wing);
    	return Response.success(visitorDto.toVisitorDto(result));
    }

	@PostMapping("/visitor/addvisitor")
	public ResponseEntity<?> addVisitor(@RequestBody VisitorDTO visitorDto){
		Visitor result=visitorService.saveVisitor(visitorDto.toVisitorEntity(visitorDto,societyFlatService.findAllFlat(visitorDto.getFlatId())));
		return Response.success(visitorDto.toVisitorDto(result));
		
	}

	@DeleteMapping("/visitor/{id}")
	public ResponseEntity<?> removeVisitor(@PathVariable("id") int id) {
		Map<String, Object> result = visitorService.deleteVisitor(id);
		return Response.success(result);
	}

}
