package com.riverspain.batidas.entity;

import com.riverspain.batidas.dto.BatidaDTO;

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
@Table(name = "batidas")
public class BatidasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private String fecha;
	
	@Column
	private String voluntariosbatida;
	
	@Column
	private Long zonaid;
	
	public static BatidasEntity parse(BatidaDTO b) {
		BatidasEntity bN = new BatidasEntity();
		
		bN.setId(b.getId());
		bN.setNombre(b.getNombre());
		bN.setDescripcion(b.getDescripcion());
		bN.setFecha(b.getFecha());
		bN.setVoluntariosbatida(b.getVoluntariosbatida());
		bN.setZonaid(b.getZonaid());
		
		return bN;
	}

}
