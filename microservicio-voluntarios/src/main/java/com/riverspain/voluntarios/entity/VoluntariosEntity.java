package com.riverspain.voluntarios.entity;

import java.time.LocalDate;

import com.riverspain.voluntarios.dto.VoluntarioDTO;

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

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "voluntarios")
public class VoluntariosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String email;
	
	@Column
	private String dni;
	
	@Column
	private String numerovoluntario;
	
	@Column
	private String rol;
	
	@Column
	private LocalDate fechacreacion;
	
	public static String generarNumeroVoluntario(String nombre, String dni) {
		String letra = nombre.substring(0, 2);
		String numerosDni = dni.substring(0, 8);
		return letra + numerosDni;
	}
	
	public static VoluntariosEntity parse(VoluntarioDTO voluntarioDto) {
		VoluntariosEntity nVoluntario = new VoluntariosEntity();
		
		nVoluntario.setNombre(voluntarioDto.getNombre());
		nVoluntario.setApellidos(voluntarioDto.getApellidos());
		nVoluntario.setEmail(voluntarioDto.getEmail());
		nVoluntario.setDni(voluntarioDto.getDni());
		nVoluntario.setNumerovoluntario(generarNumeroVoluntario(voluntarioDto.getNombre(), voluntarioDto.getDni()));
		nVoluntario.setRol(voluntarioDto.getRol());
		nVoluntario.setFechacreacion(voluntarioDto.getFechacreacion());
		
		return nVoluntario;
	}
}
