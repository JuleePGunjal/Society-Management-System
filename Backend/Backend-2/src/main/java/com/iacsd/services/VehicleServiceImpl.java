package com.iacsd.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.SocietyFlatDao;
import com.iacsd.daos.VehicleDao;
import com.iacsd.dtos.VehicleDTO;
import com.iacsd.entities.Maintenance;
import com.iacsd.entities.SocietyFlat;
import com.iacsd.entities.Vehicle;


@Transactional
@Service
public class VehicleServiceImpl {
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@Autowired
	private SocietyFlatDao societyFlatDao;
	
	public List<Vehicle> findAllVehicle(){
		return vehicleDao.findAll();
	}
	
	public Map<String, Object> deleteVehicle(int id) {
		if(vehicleDao.existsById(id)) {
			vehicleDao.deleteById(id);
			return Collections.singletonMap("affectedRows", 1);
		}
		return Collections.singletonMap("affectedRows", 0);
	}
	
	public VehicleDTO updateVehicleNo(int id, VehicleDTO vehicleDto) {
		Vehicle vehicle= vehicleDao.findById(id);
		vehicle.setVehicleNo(vehicleDto.getVehicleNo());
		return vehicleDto;
		
	}
	
	public Vehicle VehicleByFlatNo(int flatNo, String wing) {
		return vehicleDao.findByFlat(societyFlatDao.findByFlatNoAndWing(flatNo, wing));
	}

	public Vehicle saveVehicle(Vehicle vehicle) {		
		SocietyFlat flat = societyFlatDao.findById(vehicle.getFlat().getId());
		if(flat.getVehicle()==null)
			return vehicleDao.save(vehicle);
		else {
			this.deleteVehicle(flat.getVehicle().getId());
			return vehicleDao.save(vehicle);
		}
	}

}
