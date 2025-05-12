package com.riverspain.zonas.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riverspain.zonas.dto.BatidaZonaDTO;

@FeignClient(name = "msvc-batidas")
public interface ZonasClient {

	@GetMapping("/riverspain/batidas/verBatidasZona")
	List<BatidaZonaDTO> verBatidasZona(@RequestParam Long id_zona);
}
