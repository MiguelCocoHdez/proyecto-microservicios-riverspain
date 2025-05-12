package com.riverspain.batidas.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riverspain.batidas.dto.BatidaDTO;
import com.riverspain.batidas.entity.BatidasEntity;
import com.riverspain.batidas.repository.BatidaRepository;
import com.riverspain.batidas.service.BatidaService;

@Service
public class BatidaServiceImpl implements BatidaService {

	@Autowired
	BatidaRepository br;

	@Override
	public void crearBatida(BatidaDTO batida) {
		br.crearBatida(BatidasEntity.parse(batida));
	}

	@Override
	public List<BatidaDTO> verBatidas() {
		List<BatidaDTO> batidas = new ArrayList<BatidaDTO>();
		
		for(BatidasEntity b : br.verBatidas()) {
			batidas.add(BatidaDTO.parse(b));
		}
		
		return batidas;
	}

	@Override
	public List<BatidaDTO> verBatidasZona(List<Long> ids) {
		List<BatidaDTO> batidas = new ArrayList<BatidaDTO>();
		
		for(BatidasEntity b : br.verBatidasZona(ids)) {
			batidas.add(BatidaDTO.parse(b));
		}
		
		return batidas;
	}

	@Override
	public void insertarVoluntariosBatida(Long id, String voluntariosbatida) {
		br.insertarVoluntariosBatida(id, voluntariosbatida);
	}

	@Override
	public List<BatidaDTO> verBatidasVoluntario(String numerovoluntario) {
		List<BatidaDTO> batidas = new ArrayList<BatidaDTO>();
		
		for(BatidasEntity b : br.verBatidasVoluntario(numerovoluntario)) {
			batidas.add(BatidaDTO.parse(b));
		}
		
		return batidas;
	}
}
