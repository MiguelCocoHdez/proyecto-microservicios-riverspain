package com.riverspain.rios.response;

import java.util.List;

import com.riverspain.rios.dto.PezRioDTO;

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
public class PezRioResponse {

	private Long id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private List<PezRioDTO> peces;
}
