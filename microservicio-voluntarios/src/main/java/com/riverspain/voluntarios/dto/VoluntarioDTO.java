package com.riverspain.voluntarios.dto;

import java.time.LocalDate;

import com.riverspain.voluntarios.entity.VoluntariosEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

public class VoluntarioDTO {

	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private String numerovoluntario;
	private String rol;
	private LocalDate fechacreacion;
		
	public static VoluntarioDTO parse(VoluntariosEntity voluntario) {
		VoluntarioDTO vN = new VoluntarioDTO();
		
		vN.setId(voluntario.getId());
		vN.setNombre(voluntario.getNombre());
		vN.setApellidos(voluntario.getApellidos());
		vN.setEmail(voluntario.getEmail());
		vN.setDni(voluntario.getDni());
		vN.setNumerovoluntario(voluntario.getNumerovoluntario());
		vN.setRol(voluntario.getRol());
		vN.setFechacreacion(voluntario.getFechacreacion());
		
		return vN;
	}
}
