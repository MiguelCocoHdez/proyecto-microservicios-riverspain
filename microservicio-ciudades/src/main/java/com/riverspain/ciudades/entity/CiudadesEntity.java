package com.riverspain.ciudades.entity;

import com.riverspain.ciudades.dto.CiudadDTO;

import jakarta.persistence.Column;
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

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ciudades")
public class CiudadesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private double latitud;
	
	@Column 
	private double longitud;
	
	public static CiudadesEntity parse(CiudadDTO c) {
		CiudadesEntity cN = new CiudadesEntity();
		
		cN.setId(c.getId());
		cN.setNombre(c.getNombre());
		cN.setLatitud(c.getLatitud());
		cN.setLongitud(c.getLongitud());
		
		return cN;
	}
}
