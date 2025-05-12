package com.riverspain.rios.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riverspain.rios.dto.PezRioDTO;

@FeignClient(name = "msvc-peces")
public interface RiosClient {

	@GetMapping("/riverspain/peces/ids")
	List<PezRioDTO> verPecesIds(@RequestParam List<Long> ids);
}
