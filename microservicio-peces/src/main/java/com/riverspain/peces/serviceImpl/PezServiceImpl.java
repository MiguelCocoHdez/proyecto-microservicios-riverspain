package com.riverspain.peces.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riverspain.peces.dto.PezDTO;
import com.riverspain.peces.entity.PecesEntity;
import com.riverspain.peces.repository.PezRepository;
import com.riverspain.peces.service.PezService;

@Service
public class PezServiceImpl implements PezService {

	@Autowired
	PezRepository pr;

	@Override
	public List<PezDTO> verPeces() {
		List<PezDTO> peces = new ArrayList<PezDTO>();
		
		for(PecesEntity pez : pr.verPeces()) {
			peces.add(PezDTO.parse(pez));
		}
		
		return peces;
	}

	@Override
	public List<PezDTO> verPecesRio(Long rioid) {
		List<PezDTO> pecesRio = new ArrayList<PezDTO>();
		
		for(PecesEntity pez : pr.verPecesRio(rioid)) {
			pecesRio.add(PezDTO.parse(pez));
		}
		
		return pecesRio;
	}

	@Override
	public void insertarPez(PezDTO pez) {
		pr.insertarPez(PecesEntity.parse(pez));
	}

	@Override
	public List<PezDTO> verPecesId(List<Long> listaid) {
		List<PezDTO> listaPecesId = new ArrayList<PezDTO>();
		
		for(PecesEntity p : pr.verPecesId(listaid)) {
			listaPecesId.add(PezDTO.parse(p));
		}
		
		return listaPecesId;
	}

	@Override
	public void agregarRioPez(Long pezid, Long rioid) {
		pr.agregarRioPez(pezid, rioid);
	}

	@Override
	public PezDTO verPezId(Long id) {
		return PezDTO.parse(pr.verPezId(id));
	}
}
