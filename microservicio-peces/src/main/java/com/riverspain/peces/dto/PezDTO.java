package com.riverspain.peces.dto;

import java.util.List;

import com.riverspain.peces.entity.PecesEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

public class PezDTO {

	private Long id;
	private String nombrecomun;
	private String nombrecientifico;
	private String origen;
	private String taxonomia;
	private String descripcion;
	private String distribucion;
	private String biologiaecologia;
	private String urlimagen;
	private List<Long> rioid;
	
	public static PezDTO parse(PecesEntity p) {
		PezDTO pN = new PezDTO();
		
		pN.setId(p.getId());
		pN.setNombrecomun(p.getNombrecomun());
		pN.setNombrecientifico(p.getNombrecientifico());
		pN.setOrigen(p.getOrigen());
		pN.setTaxonomia(p.getTaxonomia());
		pN.setDescripcion(p.getDescripcion());
		pN.setDistribucion(p.getDistribucion());
		pN.setBiologiaecologia(p.getBiologiaecologia());
		pN.setUrlimagen(p.getUrlimagen());
		pN.setRioid(p.getRioid());
		
		return pN;
	}
}
