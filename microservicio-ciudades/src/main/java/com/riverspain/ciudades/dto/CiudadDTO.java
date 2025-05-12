package com.riverspain.ciudades.dto;

import com.riverspain.ciudades.entity.CiudadesEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

public class CiudadDTO {
	private Long id;
	private String nombre;
	private double latitud;
	private double longitud;
	
	public static CiudadDTO parse(CiudadesEntity c) {
		CiudadDTO cN = new CiudadDTO();
		
		cN.setId(c.getId());
		cN.setNombre(c.getNombre());
		cN.setLatitud(c.getLatitud());
		cN.setLongitud(c.getLongitud());
		
		return cN;
	}
}
