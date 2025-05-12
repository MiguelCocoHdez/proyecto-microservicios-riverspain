package com.riverspain.peces.service;

import java.util.List;

import com.riverspain.peces.dto.PezDTO;

public interface PezService {

	List<PezDTO> verPeces();
	
	List<PezDTO> verPecesRio(Long rioid);
	
	void insertarPez(PezDTO pez);
	
	List<PezDTO> verPecesId(List<Long> listaid);
	
	void agregarRioPez(Long pezid, Long rioid);
	
	PezDTO verPezId(Long id);
}
