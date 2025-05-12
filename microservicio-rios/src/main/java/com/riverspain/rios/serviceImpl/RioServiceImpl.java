package com.riverspain.rios.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riverspain.rios.client.RiosClient;
import com.riverspain.rios.dto.PezRioDTO;
import com.riverspain.rios.dto.RioDTO;
import com.riverspain.rios.entity.RiosEntity;
import com.riverspain.rios.repository.RioRepository;
import com.riverspain.rios.response.PezRioResponse;
import com.riverspain.rios.service.RioService;

@Service
public class RioServiceImpl implements RioService {

	@Autowired
	RioRepository rr;
	
	@Autowired
	RiosClient rc;

	@Override
	public void agregarRio(RioDTO rio) {
		rr.agregarRio(RiosEntity.parse(rio));
	}

	@Override
	public List<RioDTO> verRios() {
		List<RioDTO> rios = new ArrayList<RioDTO>();

		for (RiosEntity r : rr.verRios()) {
			rios.add(RioDTO.parse(r));
		}

		return rios;
	}

	@Override // patch porque actualizas parcialmente el recurso
	public void AgregarPezRio(Long pezid, Long rioid) {
		rr.agregarPezRio(pezid, rioid);
	}

	@Override
	public PezRioResponse verRiosPeces(Long idRio, List<Long> ids) {
		//lista de los peces en cada rio
		List<PezRioDTO> peces = rc.verPecesIds(ids);
		
		//Rio
		RioDTO rio = RioDTO.parse(rr.verRioId(idRio));
		
		return PezRioResponse.builder()
				.id(rio.getId())
				.nombre(rio.getNombre())
				.descripcion(rio.getDescripcion())
				.imagen(rio.getImagen())
				.peces(peces)
				.build();
	}

}
