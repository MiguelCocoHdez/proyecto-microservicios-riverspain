package com.riverspain.zonas.dto;

import java.util.List;

import com.riverspain.zonas.entity.ZonasEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class ZonaDTO {
	

	private Long id;
	private String nombre;
	private double latitud;
	private double longitud;
	private String voluntarioszona;
	private Long ciudadid;
	private List<Long> batidaid;
	
	public static ZonaDTO parse(ZonasEntity z) {
		ZonaDTO zN = new ZonaDTO();
		
		zN.setId(z.getId());
		zN.setNombre(z.getNombre());
		zN.setLatitud(z.getLatitud());
		zN.setLongitud(z.getLongitud());
		zN.setVoluntarioszona(z.getVoluntarioszona());
		zN.setCiudadid(z.getCiudadid());
		zN.setBatidaid(z.getBatidaid());
		
		return zN;
	}
}
