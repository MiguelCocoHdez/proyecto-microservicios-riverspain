package com.riverspain.batidas.dto;

import com.riverspain.batidas.entity.BatidasEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class BatidaDTO {

	private Long id;
	private String nombre;
	private String descripcion;
	private String fecha;
	private String voluntariosbatida;
	private Long zonaid;
	
	public static BatidaDTO parse(BatidasEntity b) {
		BatidaDTO bN = new BatidaDTO();
		
		bN.setId(b.getId());
		bN.setNombre(b.getNombre());
		bN.setDescripcion(b.getDescripcion());
		bN.setFecha(b.getFecha());
		bN.setVoluntariosbatida(b.getVoluntariosbatida());
		bN.setZonaid(b.getZonaid());
		
		return bN;
	}
}