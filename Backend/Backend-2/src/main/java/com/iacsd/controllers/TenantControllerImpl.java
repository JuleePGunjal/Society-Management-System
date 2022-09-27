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

import com.iacsd.dtos.Response;
import com.iacsd.dtos.TenantDTO;
import com.iacsd.entities.Tenant;
import com.iacsd.services.SocietyFlatServiceImpl;
import com.iacsd.services.TenantServiceImpl;
@CrossOrigin(origins = "*")
@RestController
public class TenantControllerImpl {

	@Autowired
	private TenantServiceImpl tenantService;
	
	@Autowired
	private TenantDTO tenantDto;
	
	@Autowired
	private SocietyFlatServiceImpl societyFlatService;
	
    @GetMapping("tetnant/tenantlist")
	
	public ResponseEntity<?> getAllTenant()
	{
		List<Tenant> tenantList = tenantService.listOfTenant();
		List<TenantDTO> tenantdtoList = new ArrayList();
		for(Tenant tenant:tenantList) {
			tenantdtoList.add(tenantDto.toTenantDto(tenant));
		}
		return Response.success(tenantdtoList);
	}

	@PostMapping("tenant/addtenant")
	public ResponseEntity<?> addVehicle (@RequestBody TenantDTO tenantDto) {
		Tenant result = tenantService.saveTenant(tenantDto.toTenantEntity(tenantDto, societyFlatService.findAllFlat(tenantDto.getFlatId()) ));
		return Response.success(tenantDto.toTenantDto(result));
	}
	
	@PutMapping("/tenant/update/{id}")
	public ResponseEntity<?> updateTenantByUser(@PathVariable("id") int id,@RequestBody TenantDTO tenantDto) {
		TenantDTO result = tenantDto.toTenantDto(tenantService.updateTenant(id, tenantDto));
		return Response.success(result);
	}
	
	
	
	@DeleteMapping("/tenant/delete/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable("id") int id) {
		Map<String, Object> result = tenantService.deleteTenant(id);
		return Response.success(result);
	}
	
}

