package com.riverspain.ciudades.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.riverspain.ciudades.dto.CiudadDTO;
import com.riverspain.ciudades.service.CiudadService;

public class CiudadRestControllerTest {

	@Mock
	private CiudadService ciudadService;

	@InjectMocks
	private CiudadRestController ciudadRestController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
    void testVerCiudades() {
        List<CiudadDTO> ciudades = List.of(new CiudadDTO(), new CiudadDTO());

        when(ciudadService.verCiudades()).thenReturn(ciudades);

        List<CiudadDTO> resultado = ciudadRestController.verCiudades();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }
	
	@Test
	public void testVerCiudadId() {
	    CiudadDTO ciudad = new CiudadDTO(1L, "Ciudad1", 1.0, 1.0);

	    when(ciudadService.verCiudadId(1L)).thenReturn(ciudad);

	    CiudadDTO resultado = ciudadRestController.verCiudadId(1L);

	    assertNotNull(resultado);
	    assertEquals("Ciudad1", resultado.getNombre());
	}
}
