package com.riverspain.batidas.service;

import java.util.List;

import com.riverspain.batidas.dto.BatidaDTO;

public interface BatidaService {

	void crearBatida(BatidaDTO batida);
	
	List<BatidaDTO> verBatidas();
	
	List<BatidaDTO> verBatidasZona(List<Long> ids);
	
	void insertarVoluntariosBatida(Long id, String voluntariosbatida);
	
	List<BatidaDTO> verBatidasVoluntario(String numerovoluntario);
}
