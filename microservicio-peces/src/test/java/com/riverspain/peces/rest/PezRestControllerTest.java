package com.riverspain.peces.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.riverspain.peces.dto.PezDTO;
import com.riverspain.peces.service.PezService;

public class PezRestControllerTest {

	@Mock
    private PezService pezService;
	
	@InjectMocks
	private PezRestController pezRestController;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
    void testVerPeces() {
        List<PezDTO> peces = List.of(new PezDTO(), new PezDTO());

        when(pezService.verPeces()).thenReturn(peces);

        List<PezDTO> result = pezRestController.verPeces();

        assertNotNull(result);
        assertEquals(2, result.size());
    }
	
	@Test
	void testVerPecesRio() {
	    List<PezDTO> peces = List.of(new PezDTO());

	    when(pezService.verPecesRio(1L)).thenReturn(peces);

	    List<PezDTO> resultado = pezRestController.verPecesRio(1L);

	    assertNotNull(resultado);
	    assertEquals(1, resultado.size());
	}
	
	@Test
	void testVerPezId() {
		PezDTO pez = new PezDTO(1L, "Pez1", "Pez Científico 1", "Origen 1", "Taxonomia 1", "Descripción 1", "Distribución 1", "Biología 1", "http://urlimagen1.com", List.of(1L));
		
		when(pezService.verPezId(1L)).thenReturn(pez);
		
		PezDTO resultado = pezRestController.verPezId(1L);
		
		assertNotNull(resultado);
	    assertEquals("Pez1", resultado.getNombrecomun());
	}
	
}
