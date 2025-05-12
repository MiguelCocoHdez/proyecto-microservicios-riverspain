package com.riverspain.zonas.service;

import java.util.List;

import com.riverspain.zonas.dto.ZonaDTO;
import com.riverspain.zonas.response.BatidaZonaResponse;
import com.riverspain.zonas.response.ZonaCiudadVolResponse;

public interface ZonaService {

	void insertarZona(ZonaDTO zona);
	
	List<ZonaDTO> verZonas();
	
	List<ZonaDTO> verZonasCiudad(Long idCiudad);
	
	BatidaZonaResponse verBatidasZona(Long zonaid, List<Long> ids);
	
	ZonaDTO verZonaId(Long id);
	
	List<ZonaDTO> verZonasVoluntario(String voluntarioszona);
	
	void insertarVoluntariosZona(String nombre, String voluntarioszona);
	
	ZonaCiudadVolResponse verZonaInfo(Long id);
	
	ZonaDTO zonaMasCustodiada();
}
