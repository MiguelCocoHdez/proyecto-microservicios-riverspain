package com.riverspain.zonas.response;

import java.util.List;

import com.riverspain.zonas.dto.BatidaZonaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Builder
public class BatidaZonaResponse {

	private Long id;
	private String nombre;
	private double latitud;
	private double longitud;
	private String voluntarioszona;
	private Long ciudadid;
	private List<BatidaZonaDTO> batidas;
}
