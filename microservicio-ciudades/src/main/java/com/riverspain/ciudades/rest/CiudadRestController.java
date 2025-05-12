package com.riverspain.ciudades.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riverspain.ciudades.dto.CiudadDTO;
import com.riverspain.ciudades.service.CiudadService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/riverspain/ciudades")
public class CiudadRestController {

	@Autowired
	CiudadService cs;
	
	@GetMapping("")
	@Operation(summary = "Obtener todas las ciudades", description = "Devuelve una lista de todas las ciudades disponibles en la base de datos.")
	List<CiudadDTO> verCiudades() {
		return cs.verCiudades();
	}
	
	//Feign client para zonas
	@GetMapping("/verCiudadId")
	@Operation(summary = "Obtener ciudad por id", description = "Devuelve la ciudad con el id proporcionado.")
	CiudadDTO verCiudadId(@RequestParam Long id) {
		return cs.verCiudadId(id);
	}

}
