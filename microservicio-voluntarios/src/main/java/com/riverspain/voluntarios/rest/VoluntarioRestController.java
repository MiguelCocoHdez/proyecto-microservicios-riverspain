package com.riverspain.voluntarios.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.riverspain.voluntarios.dto.VoluntarioDTO;
import com.riverspain.voluntarios.service.VoluntarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/riverspain/voluntarios")
public class VoluntarioRestController {

	@Autowired
	VoluntarioService vs;
	
	@GetMapping
	@Operation(summary = "Obtener todos los voluntarios", description = "Devuelve una lista con todos los voluntarios registrados.")
	public List<VoluntarioDTO> verVoluntarios() {
		return vs.verVoluntarios();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Insertar un nuevo voluntario", description = "Crea un nuevo voluntario en la base de datos y envía un correo de confirmación.")
	@ApiResponse(responseCode = "201", description = "Voluntario creado correctamente")
	public void insertarVoluntario(@RequestBody VoluntarioDTO voluntario) {
		VoluntarioDTO voluntarioInsertado = vs.insertarVoluntario(voluntario);
		
		vs.enviarEmailVoluntario(voluntarioInsertado);
	}
	
	@GetMapping("/password")
	@Operation(summary = "Obtener número de voluntario por DNI", description = "Devuelve el número identificador del voluntario correspondiente al DNI proporcionado.")
	public String obtenerNumeroVoluntario(@RequestParam String dni) {
		return vs.obtenerNumeroVoluntario(dni);
	}
	
	@GetMapping("/rol")
	@Operation(summary = "Obtener rol del voluntario", description = "Devuelve el rol (por ejemplo, ADMIN o USER) del voluntario según su correo electrónico.")
	public String obtenerRol(@RequestParam String email) {
		return vs.obtenerRol(email);
	}
	
	@GetMapping("/verVoluntariosId")
	@Operation(summary = "Obtener voluntarios por lista de IDs", description = "Devuelve los voluntarios cuyos IDs coincidan con los proporcionados.")
	public List<VoluntarioDTO> verVoluntariosId(@RequestParam List<Long> ids) {
		return vs.verVoluntariosId(ids);
	}
	
	@PostMapping("/verVoluntarioNum")
	@Operation(summary = "Obtener voluntario por número", description = "Devuelve la información del voluntario asociado al número proporcionado. POST para mayor seguridad.")
	public VoluntarioDTO verVoluntarioNum(@RequestBody Map<String, String> nvol) {
		String numerovoluntario = nvol.get("numerovoluntario");
		
		return vs.verVoluntarioNum(numerovoluntario);
	}
	
	//Feign client para zonas
	@GetMapping("/verVoluntariosNum")
	@Operation(summary = "Obtener voluntarios por lista de números", description = "Devuelve los voluntarios cuyos números coincidan con los proporcionados. Endpoint consumido por el servicio zonas.")
	List<VoluntarioDTO> verVoluntariosNum(@RequestParam List<String> numeros) {
		return vs.verVoluntariosNum(numeros);
	}
	
}
