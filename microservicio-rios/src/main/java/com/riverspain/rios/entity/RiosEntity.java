package com.riverspain.rios.entity;

import java.util.List;

import com.riverspain.rios.dto.RioDTO;

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

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "rios")
public class RiosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private String imagen;
	
	@ElementCollection
	@Column
	private List<Long> pezid;
	
	public static RiosEntity parse(RioDTO r) {
		RiosEntity rN = new RiosEntity();
		
		rN.setId(r.getId());
		rN.setNombre(r.getNombre());
		rN.setDescripcion(r.getDescripcion());
		rN.setImagen(r.getImagen());
		rN.setPezid(r.getPezid());
		
		return rN;
	}
}
