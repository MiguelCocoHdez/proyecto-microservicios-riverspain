package com.riverspain.voluntarios.service;

import java.util.List;

import com.riverspain.voluntarios.dto.VoluntarioDTO;

public interface VoluntarioService {

	public VoluntarioDTO insertarVoluntario(VoluntarioDTO voluntario);
	
	public List<VoluntarioDTO> verVoluntarios();
	
	public String obtenerNumeroVoluntario(String dni);
	
	public String obtenerRol(String email);
	
	public List<VoluntarioDTO> verVoluntariosId(List<Long> ids);
	
	public VoluntarioDTO verVoluntarioNum(String nvoluntario);
	
	List<VoluntarioDTO> verVoluntariosNum(List<String> numeros);
	
	void enviarEmailVoluntario(VoluntarioDTO voluntario);
}
