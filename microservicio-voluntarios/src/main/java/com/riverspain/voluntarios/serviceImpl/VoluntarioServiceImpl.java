package com.riverspain.voluntarios.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riverspain.voluntarios.client.VoluntariosClient;
import com.riverspain.voluntarios.config.AdminConfig;
import com.riverspain.voluntarios.dto.VoluntarioDTO;
import com.riverspain.voluntarios.entity.VoluntariosEntity;
import com.riverspain.voluntarios.repository.VoluntarioRepository;
import com.riverspain.voluntarios.service.VoluntarioService;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {
	
	@Autowired
	VoluntarioRepository vr;
	
	@Autowired
	AdminConfig adminConfig;

	@Autowired
	VoluntariosClient vc;

	@Override
	public VoluntarioDTO insertarVoluntario(VoluntarioDTO voluntario) {
		asignarRolSegunEmail(voluntario);
		voluntario.setFechacreacion(LocalDate.now());;
		
		VoluntariosEntity entidadGuardada = vr.save(VoluntariosEntity.parse(voluntario));
		
		return VoluntarioDTO.parse(entidadGuardada);
	}

	@Override
	public List<VoluntarioDTO> verVoluntarios() {
		List<VoluntarioDTO> voluntarios = new ArrayList<VoluntarioDTO>();
		
		for(VoluntariosEntity v : vr.verVoluntarios()) {
			voluntarios.add(VoluntarioDTO.parse(v));
		}
		
		return voluntarios;
	}

	@Override
	public String obtenerNumeroVoluntario(String dni) {
		return vr.obtenerNumeroVoluntario(dni);
	}

	@Override
	public String obtenerRol(String email) {
		return vr.obtenerRol(email);
	}
	
	private void asignarRolSegunEmail(VoluntarioDTO voluntario) {
		if(voluntario.getEmail().equalsIgnoreCase(adminConfig.getAdminEmail())) {
			voluntario.setRol("Administrador");
		}
		else {
			voluntario.setRol("Voluntario");
		}
	}

	@Override
	public List<VoluntarioDTO> verVoluntariosId(List<Long> ids) {
		List<VoluntarioDTO> voluntarios = new ArrayList<VoluntarioDTO>();
		
		for(VoluntariosEntity v : vr.verVoluntariosId(ids)) {
			voluntarios.add(VoluntarioDTO.parse(v));
		}
		
		return voluntarios;
	}

	@Override
	public VoluntarioDTO verVoluntarioNum(String nvoluntario) {
		VoluntariosEntity vol = vr.verVoluntarioNum(nvoluntario);
		
		if(vol == null) {
			return null;
		}
		
		return VoluntarioDTO.parse(vol);
	}

	@Override
	public List<VoluntarioDTO> verVoluntariosNum(List<String> numeros) {
		List<VoluntarioDTO> voluntarios = new ArrayList<VoluntarioDTO>();
		
		for(VoluntariosEntity v : vr.verVoluntariosNum(numeros)) {
			voluntarios.add(VoluntarioDTO.parse(v));
		}
		
		return voluntarios;
	}

	@Override
	public void enviarEmailVoluntario(VoluntarioDTO voluntario) {
		vc.enviarEmailVoluntario(voluntario);
	}

}
