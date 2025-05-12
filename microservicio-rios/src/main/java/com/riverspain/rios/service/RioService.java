package com.riverspain.rios.service;

import java.util.List;

import com.riverspain.rios.dto.RioDTO;
import com.riverspain.rios.response.PezRioResponse;

public interface RioService {

	void agregarRio(RioDTO rio);
	
	List<RioDTO> verRios();
	
	void AgregarPezRio(Long pezid, Long rioid);
	
	PezRioResponse verRiosPeces(Long idRio, List<Long> ids);
}
