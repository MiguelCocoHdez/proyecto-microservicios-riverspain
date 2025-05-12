package com.riverspain.ciudades.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riverspain.ciudades.dto.CiudadDTO;
import com.riverspain.ciudades.entity.CiudadesEntity;
import com.riverspain.ciudades.repository.CiudadRepository;
import com.riverspain.ciudades.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService {
	
	@Autowired
	CiudadRepository cr;

	@Override
	public List<CiudadDTO> verCiudades() {
		List<CiudadDTO> ciudades = new ArrayList<CiudadDTO>();
		
		for(CiudadesEntity ciudad : cr.verCiudades()) {
			ciudades.add(CiudadDTO.parse(ciudad));
		}
		
		return ciudades;
	}

	@Override
	public CiudadDTO verCiudadId(Long id) {
		return CiudadDTO.parse(cr.verCiudadId(id));
	}

}
