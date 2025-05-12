package com.riverspain.ciudades.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mcsv-zonas")
public interface CiudadClient {

	@GetMapping("/riverspain/zonas/{idciudad}")
	List<?> verZonasCiudad(@PathVariable Long idCiudad);
}
