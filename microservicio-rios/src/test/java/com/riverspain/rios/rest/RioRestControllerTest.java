package com.riverspain.rios.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.riverspain.rios.dto.PezRioDTO;
import com.riverspain.rios.dto.RioDTO;
import com.riverspain.rios.response.PezRioResponse;
import com.riverspain.rios.service.RioService;

public class RioRestControllerTest {

	@Mock
    private RioService rioService;
	
	@InjectMocks
    private RioRestController rioRestController;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
    void testVerRios() {
        List<RioDTO> rios = List.of(new RioDTO(1L, "Rio Amazonas", null, null, null), new RioDTO(2L, "Rio Nilo", null, null, null));

        when(rioService.verRios()).thenReturn(rios);

        List<RioDTO> resultado = rioRestController.verRios();

        assertEquals(2, resultado.size());
        assertEquals("Rio Amazonas", resultado.get(0).getNombre());
        assertEquals("Rio Nilo", resultado.get(1).getNombre());
    }
	
	@Test
	void testVerPecesRios() {
		PezRioResponse respuesta = new PezRioResponse(1L, "Rio Amazonas", null, null, List.of(new PezRioDTO(1L, "Pez1", "Pez Científico 1", "Brasil", "Taxonomia 1", "Descripción 1", "Distribución 1", "Biología 1", "http://urlimagen1.com")));
		
		when(rioService.verRiosPeces(1L, List.of(1L))).thenReturn(respuesta);
		
		PezRioResponse resultado = rioRestController.verRiosPeces(1L, List.of(1L));
		
		assertNotNull(resultado);
		assertEquals("Rio Amazonas", resultado.getNombre());
		assertEquals("Pez1", resultado.getPeces().get(0).getNombrecomun());
	}
}
