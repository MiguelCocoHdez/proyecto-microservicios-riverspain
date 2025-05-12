package com.riverspain.batidas.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riverspain.batidas.dto.BatidaDTO;
import com.riverspain.batidas.service.BatidaService;

@RestController
@RequestMapping("/riverspain/batidas")
public class BatidaRestController {

	@Autowired
	BatidaService bs;
	
	@GetMapping("")
	List<BatidaDTO> verBatidas() {
		return bs.verBatidas();
	}
	
	@PostMapping("")
	void crearBatida(@RequestBody BatidaDTO batida) {
		bs.crearBatida(batida);
	}
	
	//cliente feign en zonas
	@GetMapping("/verBatidasZona")
	List<BatidaDTO> verBatidasZona(@RequestParam List<Long> ids) {
		return bs.verBatidasZona(ids);
	}
	
	@PatchMapping("/insertarVoluntarioBatida")
	void insertarVoluntarioBatida(@RequestBody BatidaDTO batida) {
		bs.insertarVoluntariosBatida(batida.getId(), batida.getVoluntariosbatida());
	}
	
	@PostMapping("/verBatidasVoluntario")
	List<BatidaDTO> verBatidasVoluntario(@RequestBody Map<String, String> voluntariosbatida) {
		String numerovoluntario = voluntariosbatida.get("voluntariosbatida");
		
		return bs.verBatidasVoluntario(numerovoluntario);
	}
}
