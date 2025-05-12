package com.riverspain.peces.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riverspain.peces.dto.PezDTO;
import com.riverspain.peces.service.PezService;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/riverspain/peces")
@RestController
public class PezRestController {

	@Autowired
	PezService ps;
	
	@GetMapping("")
	@Operation(summary = "Obtener todos los peces", description = "Devuelve una lista con todos los peces registrados en la base de datos.")
	List<PezDTO> verPeces() {
		return ps.verPeces();
	}
	
	@GetMapping("/{rioid}")
	@Operation(summary = "Obtener peces por río", description = "Devuelve todos los peces asociados al río indicado por su ID.")
	List<PezDTO> verPecesRio(@PathVariable Long rioid) {
		return ps.verPecesRio(rioid);
	}
	
	@PostMapping("")
	@Operation(summary = "Insertar un pez", description = "Crea un nuevo registro de pez en la base de datos.")
	void insertarPez(@RequestBody PezDTO pez) {
		ps.insertarPez(pez);
	}
	
	@GetMapping("verPezId/{id}")
	@Operation(summary = "Obtener pez por ID", description = "Devuelve el pez correspondiente al ID proporcionado.")
	PezDTO verPezId(@PathVariable Long id) {
		return ps.verPezId(id);
	}
	
	//Cliente feign en rios
	@GetMapping("/ids")
	@Operation(summary = "Obtener varios peces por ID", description = "Devuelve una lista de peces correspondientes a una lista de IDs.Endpoint consumido por rios.")
	List<PezDTO> verPecesEnRios(@RequestParam List<Long> ids) {
		return ps.verPecesId(ids);
	}
	
	@PatchMapping("/{pezid}/{rioid}")
	@Operation(summary = "Asociar un río a un pez", description = "Vincula un río existente al pez especificado.")
	void agregarRioPez(@PathVariable Long pezid, @PathVariable Long rioid) {
		ps.agregarRioPez(pezid, rioid);
	}
}
