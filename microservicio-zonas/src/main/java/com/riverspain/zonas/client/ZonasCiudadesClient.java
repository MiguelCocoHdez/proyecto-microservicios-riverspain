package com.riverspain.zonas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riverspain.zonas.dto.CiudadZonaDTO;

@FeignClient(name = "msvc-ciudades")
public interface ZonasCiudadesClient {

	@GetMapping("/riverspain/ciudades/verCiudadId")
	CiudadZonaDTO verCiudadId(@RequestParam Long id);
}
