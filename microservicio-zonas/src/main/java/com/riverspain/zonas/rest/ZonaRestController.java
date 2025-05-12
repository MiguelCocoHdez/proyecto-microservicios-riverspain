package com.riverspain.zonas.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riverspain.zonas.dto.ZonaDTO;
import com.riverspain.zonas.dto.ZonaPatchDTO;
import com.riverspain.zonas.exception.VoluntarioExisteException;
import com.riverspain.zonas.response.BatidaZonaResponse;
import com.riverspain.zonas.response.ZonaCiudadVolResponse;
import com.riverspain.zonas.service.ZonaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/riverspain/zonas")
public class ZonaRestController {

	@Autowired
	ZonaService zs;
	
	@PostMapping("")
	@Operation(summary = "Crear una zona", description = "Crea una zona en la base de datos.")
	void insertarZona(@RequestBody ZonaDTO zona) {
		zs.insertarZona(zona);
	}
	
	@GetMapping("")
	@Operation(summary = "Obtener todas las zonas", description = "Devuelve una lista de todas las zonas disponibles en la base de datos.")
	List<ZonaDTO> verZonas() {
		return zs.verZonas();
	}
	
	@GetMapping("/verZonasCiudad")
	@Operation(summary = "Ver zonas de una ciudad", description = "Devuelve una lista de todas las zonas de esa ciudad.")
	public List<ZonaDTO> verZonasCiudad(@RequestParam Long idCiudad) {		
		return zs.verZonasCiudad(idCiudad);
	}
	
	@GetMapping("/verBatidasZona")
	@Operation(summary = "Obtener todas las zonas más sus batidas", description = "Devuelve una lista de todas las zonas disponibles en la base de datos junto con la info de todas sus batidas.")
	BatidaZonaResponse verBatidasZona(@RequestParam Long zonaid, @RequestParam List<Long> ids) {
		return zs.verBatidasZona(zonaid, ids);
	}
	
	@GetMapping("/verZonaInfo")
	@Operation(summary = "Obtener la zona por id con toda la info", description = "Devuelve la zona disponible en la base de datos junto con la info de su ciudad y los voluntarios que hay custodiándola.")
	ZonaCiudadVolResponse verZonaInfo(@RequestParam Long id) {
		return zs.verZonaInfo(id);
	}
	
	@PostMapping("/verZonasVoluntario")	//postmapping porque no se puede usar un get con un requestbody
	@Operation(summary = "Obtener todas las zonas custodiadas por un voluntario", description = "Devuelve una lista de todas las zonas custodiadas por el voluntario introducido. Método POST aun que retorne por más seguridad.")
	List<ZonaDTO> verZonasVoluntario(@RequestBody Map<String, String> voluntarioszona) {
		String nvoluntario = voluntarioszona.get("voluntarioszona");
		return zs.verZonasVoluntario(nvoluntario);
	}
	
	@PatchMapping("/insertarVoluntarioZona")
	@Operation(summary = "Inserta voluntarios a la zona", description = "Inserta el numero de voluntario a la zona deseada.")
	@ApiResponses(value = {
			 @ApiResponse(responseCode = "200", description = "Voluntario insertado correctamente"),
		     @ApiResponse(responseCode = "409", description = "El voluntario ya está en esta zona")
	})
	ResponseEntity<String> insertarVoluntarioZona(@RequestBody ZonaPatchDTO zona) {
		try {
            zs.insertarVoluntariosZona(zona.getNombre(), zona.getVoluntarioszona());
            
            return ResponseEntity.ok("Voluntario insertado correctamente.");
        } catch (VoluntarioExisteException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El voluntario ya está en esta zona.");
        }
	}
	
	@GetMapping("/zonaMasCustodiada")
	@Operation(summary = "Obtener la zona más custodiada", description = "Devuelve la zona que tiene más voluntarios asignados en la base de datos.")
	ZonaDTO zonaMasCustodiada() {
		return zs.zonaMasCustodiada();
	}
}
