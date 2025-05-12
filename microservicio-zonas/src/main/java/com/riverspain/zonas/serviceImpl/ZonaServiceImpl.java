package com.riverspain.zonas.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riverspain.zonas.client.ZonaVoluntariosClient;
import com.riverspain.zonas.client.ZonasCiudadesClient;
import com.riverspain.zonas.client.ZonasClient;
import com.riverspain.zonas.dto.BatidaZonaDTO;
import com.riverspain.zonas.dto.CiudadZonaDTO;
import com.riverspain.zonas.dto.VoluntarioZonaDTO;
import com.riverspain.zonas.dto.ZonaDTO;
import com.riverspain.zonas.entity.ZonasEntity;
import com.riverspain.zonas.exception.VoluntarioExisteException;
import com.riverspain.zonas.repository.ZonaRepository;
import com.riverspain.zonas.response.BatidaZonaResponse;
import com.riverspain.zonas.response.ZonaCiudadVolResponse;
import com.riverspain.zonas.service.ZonaService;

@Service
public class ZonaServiceImpl implements ZonaService {

	@Autowired
	ZonaRepository zr;
	
	@Autowired
	ZonasClient zc;
	
	@Autowired
	ZonasCiudadesClient zcc;
	
	@Autowired
	ZonaVoluntariosClient zvc;
	
	@Override
	public void insertarZona(ZonaDTO zona) {
		zr.insertarZona(ZonasEntity.parse(zona));
	}

	@Override
	public List<ZonaDTO> verZonas() {
		List<ZonaDTO> zonas = new ArrayList<ZonaDTO>();
		
		for(ZonasEntity z : zr.verZonas()) {
			zonas.add(ZonaDTO.parse(z));
		}
		
		return zonas;
	}

	@Override
	public List<ZonaDTO> verZonasCiudad(Long idCiudad) {
		List<ZonaDTO> zonasCiudad = new ArrayList<ZonaDTO>();
		
		for(ZonasEntity z : zr.verZonasCiudad(idCiudad)) {
			zonasCiudad.add(ZonaDTO.parse(z));
		}
		
		return zonasCiudad;
	}

	@Override
	public BatidaZonaResponse verBatidasZona(Long zonaid, List<Long> ids) {
		ZonaDTO zona = ZonaDTO.parse(zr.verZonaId(zonaid));
		
		//Lista de batidas de la zona
		List<BatidaZonaDTO> batidas = zc.verBatidasZona(zonaid);
		
		return BatidaZonaResponse.builder()
				.id(zona.getId())
				.nombre(zona.getNombre())
				.latitud(zona.getLatitud())
				.longitud(zona.getLongitud())
				.voluntarioszona(zona.getVoluntarioszona())
				.ciudadid(zona.getCiudadid())
				.batidas(batidas)
				.build();
	}

	@Override
	public ZonaDTO verZonaId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ZonaDTO> verZonasVoluntario(String voluntarioszona) {
		List<ZonaDTO> zonasVoluntario = new ArrayList<ZonaDTO>();
		
		System.out.println(voluntarioszona);
		for(ZonasEntity z : zr.verZonasVoluntario(voluntarioszona)) {
			zonasVoluntario.add(ZonaDTO.parse(z));
		}
		
		return zonasVoluntario;
	}

	@Override
	public void insertarVoluntariosZona(String nombre, String voluntarioszona) {
		String numerosvoluntario = zr.verZonaNombre(nombre).getVoluntarioszona();
		if(numerosvoluntario == null) {
			numerosvoluntario = "";
		}
		
		String[] numerosVoluntarioArray = numerosvoluntario.split((","));
		
		for(String n : numerosVoluntarioArray) {
			if(n.equals(voluntarioszona)) {
				throw new VoluntarioExisteException("El voluntario ya esta en la zona");
			}
		}
		
		zr.insertarVoluntariosZona(nombre, voluntarioszona);
	}

	@Override
	public ZonaCiudadVolResponse verZonaInfo(Long id) {
		ZonaDTO zona = ZonaDTO.parse(zr.verZonaId(id));
		CiudadZonaDTO ciudad = zcc.verCiudadId(zona.getCiudadid());
		String numerosvoluntario = zona.getVoluntarioszona();
		List<VoluntarioZonaDTO> voluntarios = new ArrayList<VoluntarioZonaDTO>();
		
		if(numerosvoluntario == null) {
			numerosvoluntario = "";
		}
		else {
			voluntarios = zvc.verVoluntariosNum(Arrays.asList(numerosvoluntario.split(",")));
		}
		
		return ZonaCiudadVolResponse.builder()
				.id(zona.getId())
				.nombre(zona.getNombre())
				.latitud(zona.getLatitud())
				.longitud(zona.getLongitud())
				.ciudad(ciudad)
				.voluntarioszona(voluntarios)
				.build();
	}

	@Override
	public ZonaDTO zonaMasCustodiada() {
		return ZonaDTO.parse(zr.zonaMasCustodiada());
	}
}
