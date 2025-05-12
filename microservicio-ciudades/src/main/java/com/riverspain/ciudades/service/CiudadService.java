package com.riverspain.ciudades.service;

import java.util.List;

import com.riverspain.ciudades.dto.CiudadDTO;

public interface CiudadService {

	List<CiudadDTO> verCiudades();
	
	CiudadDTO verCiudadId(Long id);
}
