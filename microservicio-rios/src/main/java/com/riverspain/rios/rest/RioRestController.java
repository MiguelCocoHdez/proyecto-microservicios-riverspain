package com.riverspain.rios.rest;

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

import com.riverspain.rios.dto.RioDTO;
import com.riverspain.rios.response.PezRioResponse;
import com.riverspain.rios.service.RioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/riverspain/rios")
public class RioRestController {

	@Autowired
	RioService rs;
	
	@GetMapping("")
	@Operation(summary = "Obtener todos los ríos", description = "Devuelve una lista con todos los ríos registrados en la base de datos.")
	List<RioDTO> verRios() {
		return rs.verRios();
	}
	
	@GetMapping("/verRiosPeces")
	@Operation(summary = "Obtener un río y los peces asociados", description = "Devuelve un río con la información detallada de los peces asociados a ese río.")
	PezRioResponse verRiosPeces(@RequestParam Long idRio, @RequestParam List<Long> ids) {
		return rs.verRiosPeces(idRio, ids);
	}
	
	@PostMapping("")
	@Operation(summary = "Agregar un nuevo río", description = "Inserta un nuevo río en la base de datos.")
	void agregarRio(@RequestBody RioDTO rio) {
		rs.agregarRio(rio);
	}
	
	@PatchMapping("/{pezid}/{rioid}")
	@Operation(summary = "Asociar un pez a un río", description = "Vincula un pez existente al río especificado.")
	void agregarPezRio(@PathVariable Long pezid, @PathVariable Long rioid) {
		rs.AgregarPezRio(pezid, rioid);
	}
}
