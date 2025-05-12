package com.riverspain.zonas.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.riverspain.zonas.dto.ZonaDTO;
import com.riverspain.zonas.dto.ZonaPatchDTO;
import com.riverspain.zonas.exception.VoluntarioExisteException;
import com.riverspain.zonas.service.ZonaService;

public class ZonaRestControllerTest {

	@Mock
    private ZonaService zonaService;
	
	 @InjectMocks
	 private ZonaRestController zonaRestController;
	 
	 @BeforeEach
	 void setUp() {
       MockitoAnnotations.openMocks(this);
	 }
	 
    @Test
    void testVerZonas() {
        ZonaDTO zona = new ZonaDTO(1L, "Zona A", 1.0, 1.0, "", null, null);
        when(zonaService.verZonas()).thenReturn(List.of(zona));

        List<ZonaDTO> resultado = zonaRestController.verZonas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Zona A", resultado.get(0).getNombre());
    }
    
    @Test
    void testInsertarVoluntarioNoRepe() {
    	ZonaPatchDTO zona = new ZonaPatchDTO();
    	
    	zona.setNombre("Zona A");
    	zona.setVoluntarioszona("Mi70962956");
    	
    	doNothing().when(zonaService).insertarVoluntariosZona("Zona A", "Mi70962956");
    	
    	ResponseEntity<String> respuesta = zonaRestController.insertarVoluntarioZona(zona);
    	
    	assertEquals(HttpStatus.OK, respuesta.getStatusCode());
    	assertEquals("Voluntario insertado correctamente.", respuesta.getBody());
    }
    
    @Test
    void testInsertarVoluntarioRepe() {
    	ZonaPatchDTO zona = new ZonaPatchDTO();
    	
    	zona.setNombre("Zona A");
    	zona.setVoluntarioszona("Mi70962956");
    	
    	doThrow(new VoluntarioExisteException("El voluntario ya está en esta zona.")).when(zonaService).insertarVoluntariosZona("Zona A", "Mi70962956");
    	
    	ResponseEntity<String> respuesta = zonaRestController.insertarVoluntarioZona(zona);
    	
    	assertEquals(HttpStatus.CONFLICT, respuesta.getStatusCode());
    	assertEquals("El voluntario ya está en esta zona.", respuesta.getBody());
    	
    }
    
    @Test
    void testVerZonaMasCustodiada() {
    	ZonaDTO zona = new ZonaDTO(1L, "Zona A", 1.0, 1.0, "Mi70962956,Ca70962346", null, null);
    	
    	when(zonaService.zonaMasCustodiada()).thenReturn(zona);
    	
    	ZonaDTO respuesta = zonaRestController.zonaMasCustodiada();
    	
    	assertNotNull(respuesta);
    	assertEquals(1L, respuesta.getId());
    	assertEquals("Zona A", respuesta.getNombre());
    }
    
    @Test
    void testVerZonasCiudad() {
    	ZonaDTO zona1 = new ZonaDTO(1L, "Zona Norte", 40.0, -3.0, null, 1L, null);
        ZonaDTO zona2 = new ZonaDTO(2L, "Zona Sur", 41.0, -4.0, null, 1L, null);
        
        List<ZonaDTO> zonasMock = List.of(zona1, zona2);
        
        when(zonaService.verZonasCiudad(1L)).thenReturn(zonasMock);
        
        List<ZonaDTO> respuesta = zonaRestController.verZonasCiudad(1L);
        
        assertEquals(2, respuesta.size());
        assertEquals("Zona Norte", respuesta.get(0).getNombre());
        assertEquals("Zona Sur", respuesta.get(1).getNombre());
    }
    
    @Test
    void testVerZonasVoluntario() {
    	ZonaDTO zona1 = new ZonaDTO(1L, "Zona Norte", 40.0, -3.0, "Mi70962956", 1L, null);
        ZonaDTO zona2 = new ZonaDTO(2L, "Zona Sur", 41.0, -4.0, "Mi70962956", 1L, null);
        
        List<ZonaDTO> zonas = List.of(zona1, zona2);
        
        when(zonaService.verZonasVoluntario("Mi70962956")).thenReturn(zonas);
        
        String nombreVoluntario = "Mi70962956";
        Map<String, String> body = new HashMap<>();
        body.put("voluntarioszona", nombreVoluntario);
        List<ZonaDTO> respuesta = zonaRestController.verZonasVoluntario(body);
        
        assertEquals(2, respuesta.size());
        assertEquals("Mi70962956", respuesta.get(0).getVoluntarioszona());
        assertEquals("Mi70962956", respuesta.get(1).getVoluntarioszona());
    }
}
