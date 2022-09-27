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
import com.iacsd.dtos.OwnerDTO;
import com.iacsd.dtos.Response;
import com.iacsd.dtos.VehicleDTO;
import com.iacsd.entities.Complaint;
import com.iacsd.entities.Owner;
import com.iacsd.entities.Vehicle;
import com.iacsd.services.SocietyFlatServiceImpl;
import com.iacsd.services.VehicleServiceImpl;
@CrossOrigin
@RestController
public class VehicleControllerImpl {
	@Autowired
	private VehicleServiceImpl vehicleService;
	
	@Autowired
	private VehicleDTO vehicleDto;
	
	@Autowired
	private SocietyFlatServiceImpl societyFlatService;
	
	
	   @GetMapping("vehicle/vehiclelist")
			public ResponseEntity<?> getAllVehicle()
			{
				List<Vehicle> result = vehicleService.findAllVehicle();
				List<VehicleDTO> vehicleList = new ArrayList();
				for(Vehicle v : result) {
					vehicleList.add(vehicleDto.toVehicleDto(v));
				}
				return Response.success(vehicleList);
			}
		    
		    @GetMapping("/vehicle/byflatandwing")
		    public ResponseEntity<?> getVehicleByFlatNoAndWing(@RequestParam int flat,@RequestParam String wing){
		    	Vehicle result = vehicleService.VehicleByFlatNo(flat,wing);
		    	return Response.success(vehicleDto.toVehicleDto(result));
		    }
		    
		    
	@PostMapping("vehicle/addvehicle")
	public ResponseEntity<?> addVehicle (@RequestBody VehicleDTO vehicleDto) {
		Vehicle result = vehicleService.saveVehicle(vehicleDto.toVehicleEntity(vehicleDto, societyFlatService.findAllFlat(vehicleDto.getFlatId())));
		return Response.success(vehicleDto.toVehicleDto(result));
	}
		
	 
		
		@PutMapping("/vehicle/changevehicleno/{id}")
		public ResponseEntity<?> changeVehicle(@PathVariable("id") int id,@RequestBody VehicleDTO vehicleDto) {
			VehicleDTO result = vehicleService.updateVehicleNo(id,vehicleDto);
			return Response.success(result);
		}
		
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable("id") int id) {
		Map<String, Object> result = vehicleService.deleteVehicle(id);
		return Response.success(result);
	}

}
