package com.riverspain.zonas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class BatidaZonaDTO {

	private Long id;
	private String nombre;
	private String descripcion;
	private String fecha;
	private String voluntariosbatida;
	private Long zonaid;
}
