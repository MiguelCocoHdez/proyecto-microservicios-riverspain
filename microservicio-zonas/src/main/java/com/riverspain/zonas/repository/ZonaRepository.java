package com.riverspain.zonas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riverspain.zonas.entity.ZonasEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ZonaRepository extends JpaRepository<ZonasEntity, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO zonas (nombre, latitud, longitud, ciudadid) VALUES (:#{#zona.nombre}, :#{#zona.latitud}, :#{#zona.longitud}, :#{#zona.ciudadid})", nativeQuery = true)
	void insertarZona(@Param("zona") ZonasEntity zona);

	@Query(value = "SELECT * from zonas", nativeQuery = true)
	List<ZonasEntity> verZonas();
	
	@Query(value = "SELECT * FROM zonas WHERE nombre = :nombre", nativeQuery = true)
	ZonasEntity verZonaNombre(@Param("nombre") String nombre);
	
	@Query(value = "SELECT * from zonas WHERE ciudadid = :idciudad", nativeQuery = true)
	List<ZonasEntity> verZonasCiudad(@Param("idciudad") Long idCiudad);
	
	@Query(value = "SELECT * from zonas WHERE id = :id", nativeQuery = true)
	ZonasEntity verZonaId(@Param("id") Long id);
	
	@Query(value = "SELECT * from zonas WHERE FIND_IN_SET(:voluntarioszona, voluntarioszona)", nativeQuery = true)
	List<ZonasEntity> verZonasVoluntario(@Param("voluntarioszona") String voluntarioszona);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE zonas SET voluntarioszona = CASE " +
            "WHEN voluntarioszona IS NOT NULL AND voluntarioszona != '' " +
            "THEN CONCAT(voluntarioszona, ',', :voluntarioszona) " +
            "ELSE :voluntarioszona END WHERE nombre = :nombre", nativeQuery = true) 
	void insertarVoluntariosZona(@Param("nombre") String nombre,@Param("voluntarioszona") String voluntarioszona);
	
	@Query(value = "SELECT * FROM zonas WHERE voluntarioszona IS NOT NULL AND voluntarioszona <> '' ORDER BY LENGTH(voluntarioszona) - LENGTH(REPLACE(voluntarioszona, ',', '')) + 1 DESC LIMIT 1", nativeQuery = true)
	ZonasEntity zonaMasCustodiada();
}
