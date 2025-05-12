package com.riverspain.rios.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class PezRioDTO {

	private Long id;
	private String nombrecomun;
	private String nombrecientifico;
	private String origen;
	private String taxonomia;
	private String descripcion;
	private String distribucion;
	private String biologiaecologia;
	private String urlimagen;
}
