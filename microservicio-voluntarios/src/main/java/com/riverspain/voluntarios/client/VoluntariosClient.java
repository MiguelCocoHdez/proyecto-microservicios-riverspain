package com.riverspain.voluntarios.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.riverspain.voluntarios.dto.VoluntarioDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name = "msvc-batidas")
public interface VoluntariosClient {
	
	@PostMapping("/riverspain/utilidades/enviar_codigo")
    void enviarEmailVoluntario(@RequestBody VoluntarioDTO voluntario);
}
