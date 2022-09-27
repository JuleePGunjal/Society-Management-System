package com.iacsd.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.SocietyFlatDao;
import com.iacsd.daos.TenantDao;
import com.iacsd.dtos.TenantDTO;
import com.iacsd.entities.SocietyFlat;
import com.iacsd.entities.Tenant;

@Transactional
@Service
public class TenantServiceImpl {

	@Autowired
	private TenantDao tenantDao;
	
	@Autowired
	private SocietyFlatDao societyFlatDao;
	
	public List<Tenant> listOfTenant() {
		return tenantDao.findAll();
	}
	
	
	public Tenant updateTenant(int id, TenantDTO tenantDto) {
		Tenant tenant= tenantDao.findById(id);
		tenant.setContactNo(tenantDto.getContactNo());
		tenant.setEmail(tenantDto.getEmail());
		return tenantDao.save(tenant);
		
	}
	
	public Tenant saveTenant(Tenant tenant) {
		SocietyFlat flat = societyFlatDao.findById(tenant.getFlat().getId());
		if(flat.getTenant()==null)
			return tenantDao.save(tenant);
		else {
			this.deleteTenant(flat.getTenant().getId());
			return tenantDao.save(tenant);
		}
	}
	
	public Map<String, Object> deleteTenant(int ownerId) {
		if(tenantDao.existsById(ownerId)) {
			tenantDao.deleteById(ownerId);
			return Collections.singletonMap("affectedRows", 1);
		}
		return Collections.singletonMap("affectedRows", 0);
	}
}
