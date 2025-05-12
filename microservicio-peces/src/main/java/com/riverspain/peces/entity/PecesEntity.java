package com.riverspain.peces.entity;

import java.util.List;

import com.riverspain.peces.dto.PezDTO;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "peces")
public class PecesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String nombrecomun;
	
	@Column(columnDefinition = "TEXT")
	private String nombrecientifico;
	
	@Column(columnDefinition = "TEXT")
	private String origen;
	
	@Column(columnDefinition = "TEXT")
	private String taxonomia;
	
	@Column(columnDefinition = "TEXT") 
	private String descripcion;
	
	@Column(columnDefinition = "TEXT")
	private String distribucion;
	
	@Column(columnDefinition = "TEXT") 
	private String biologiaecologia;
	
	@Column(columnDefinition = "TEXT") 
	private String urlimagen;
	
	@ElementCollection
	@Column
	private List<Long> rioid;
	
	public static PecesEntity parse(PezDTO p) {
		PecesEntity pN = new PecesEntity();
		
		pN.setId(p.getId());
		pN.setNombrecomun(p.getNombrecomun());
		pN.setNombrecientifico(p.getNombrecientifico());
		pN.setOrigen(p.getOrigen());
		pN.setTaxonomia(p.getTaxonomia());
		pN.setDescripcion(p.getDescripcion());
		pN.setDistribucion(p.getDistribucion());
		pN.setBiologiaecologia(p.getBiologiaecologia());
		pN.setUrlimagen(p.getBiologiaecologia());
		pN.setRioid(p.getRioid());
		
		return pN;
	}
}
