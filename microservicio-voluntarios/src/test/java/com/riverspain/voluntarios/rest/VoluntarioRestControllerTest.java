package com.riverspain.voluntarios.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.riverspain.voluntarios.dto.VoluntarioDTO;
import com.riverspain.voluntarios.service.VoluntarioService;

public class VoluntarioRestControllerTest {

	@Mock
	private VoluntarioService voluntarioService;

	@InjectMocks
	private VoluntarioRestController voluntarioRestController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testVerVoluntarios() {
		List<VoluntarioDTO> mockList = List.of(new VoluntarioDTO(), new VoluntarioDTO());

		when(voluntarioService.verVoluntarios()).thenReturn(mockList);

		List<VoluntarioDTO> resultado = voluntarioRestController.verVoluntarios();

		assertEquals(2, resultado.size());
	}
	
	@Test
	void testInsertarVoluntario() {
		VoluntarioDTO vol = new VoluntarioDTO();
		
		when(voluntarioService.insertarVoluntario(vol)).thenReturn(vol);
	}

	@Test
	void testObtenerNumeroVoluntario() {
		when(voluntarioService.obtenerNumeroVoluntario("70962956K")).thenReturn("Mi70962956");

		String resultado = voluntarioRestController.obtenerNumeroVoluntario("70962956K");
		
		assertEquals("Mi70962956", resultado);
	}
	
	@Test
    void testObtenerRol() {
        when(voluntarioService.obtenerRol("riverspainproyecto@gmail.com")).thenReturn("Administrador");

        String rol = voluntarioRestController.obtenerRol("riverspainproyecto@gmail.com");
        
        assertEquals("Administrador", rol);
    }
	
	@Test
    void testVerVoluntarioNum() {
        VoluntarioDTO v = new VoluntarioDTO();
        v.setNombre("Miguel");

        Map<String, String> map = new HashMap<>();
        map.put("numerovoluntario", "Mi70962956");

        when(voluntarioService.verVoluntarioNum("Mi70962956")).thenReturn(v);

        VoluntarioDTO result = voluntarioRestController.verVoluntarioNum(map);
        assertEquals("Miguel", result.getNombre());
    }
}
