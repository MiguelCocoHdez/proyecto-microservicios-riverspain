package com.riverspain.zonas.response;

import java.util.List;

import com.riverspain.zonas.dto.CiudadZonaDTO;
import com.riverspain.zonas.dto.VoluntarioZonaDTO;

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
public class ZonaCiudadVolResponse {

	private Long id;
	private String nombre;
	private double latitud;
	private double longitud;
	private CiudadZonaDTO ciudad;
	private List<VoluntarioZonaDTO> voluntarioszona;
}
