package com.riverspain.zonas.entity;

import java.util.List;

import com.riverspain.zonas.dto.ZonaDTO;

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
@Table(name = "zonas")
public class ZonasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private double latitud;
	
	@Column
	private double longitud;
	
	@Column
	private String voluntarioszona;
	
	@Column
	private Long ciudadid;
	
	@ElementCollection
	@Column
	private List<Long> batidaid;
	
	public static ZonasEntity parse(ZonaDTO z) {
		ZonasEntity zN = new ZonasEntity();
		
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
