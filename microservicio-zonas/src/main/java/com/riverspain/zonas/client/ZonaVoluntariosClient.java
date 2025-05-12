package com.riverspain.zonas.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riverspain.zonas.dto.VoluntarioZonaDTO;

@FeignClient(name = "msvc-voluntarios")
public interface ZonaVoluntariosClient {

	@GetMapping("/riverspain/voluntarios/verVoluntariosNum")
	List<VoluntarioZonaDTO> verVoluntariosNum(@RequestParam List<String> numeros);
}
