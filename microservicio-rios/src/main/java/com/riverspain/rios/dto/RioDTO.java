package com.riverspain.rios.dto;

import java.util.List;

import com.riverspain.rios.entity.RiosEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class RioDTO {

	private Long id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private List<Long> pezid;
	
	public static RioDTO parse(RiosEntity r) {
		RioDTO rN = new RioDTO();
		
		rN.setId(r.getId());
		rN.setNombre(r.getNombre());
		rN.setDescripcion(r.getDescripcion());
		rN.setImagen(r.getImagen());
		rN.setPezid(r.getPezid());
		
		return rN;
	}
}
