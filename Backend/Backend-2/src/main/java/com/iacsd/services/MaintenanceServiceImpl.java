package com.iacsd.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.MaintenanceDao;
import com.iacsd.daos.SocietyFlatDao;
import com.iacsd.dtos.MaintenanceDTO;
import com.iacsd.entities.Maintenance;
import com.iacsd.entities.SocietyFlat;
import com.iacsd.entities.Vehicle;
@Transactional
@Service
public class MaintenanceServiceImpl {
	
	
	@Autowired
	private MaintenanceDao maintenaceDao;
	
	@Autowired
	private SocietyFlatDao societyFlatDao;
	
	public List<Maintenance> listOfMaintenance() {
		return maintenaceDao.findAll();
	}
	
	
	public Maintenance updateMaintenance(int id, MaintenanceDTO maintenancetDto) {
		Maintenance maintenance= maintenaceDao.findById(id);
		maintenance.setParkingBill(maintenancetDto.getParkingBill());
		maintenance.setFlatMaintenance(maintenancetDto.getFlatMaintenance());
		maintenance.setWaterBill(maintenancetDto.getWaterBill());
		maintenance.setOthers(maintenancetDto.getOthers());
		maintenance.setMonth(maintenancetDto.getMonth());
		return maintenaceDao.save(maintenance);
		
	}
	
	
	
	public Maintenance saveMaintenance(Maintenance maintenance) {
		SocietyFlat flat = societyFlatDao.findById(maintenance.getFlat().getId());
		if(flat.getMaintenance()==null)
			return maintenaceDao.save(maintenance);
		else {
			this.deleteMaintenance(flat.getMaintenance().getId());
			return maintenaceDao.save(maintenance);
		}
	}
	
	public Map<String, Object> deleteMaintenance(int ownerId) {
		if(maintenaceDao.existsById(ownerId)) {
			maintenaceDao.deleteById(ownerId);
			return Collections.singletonMap("affectedRows", 1);
		}
		return Collections.singletonMap("affectedRows", 0);
	}


	public List<Maintenance> listOfMaintenanceByFlatNo(int flatNo, String wing) {
		return maintenaceDao.findByFlat(societyFlatDao.findByFlatNoAndWing(flatNo, wing));
	}

}
