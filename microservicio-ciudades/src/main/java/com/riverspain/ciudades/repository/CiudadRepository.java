package com.riverspain.ciudades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riverspain.ciudades.entity.CiudadesEntity;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadesEntity, Long> {

	@Query(value = "SELECT * FROM ciudades", nativeQuery = true)
	List<CiudadesEntity> verCiudades();
	
	@Query(value = "SELECT * FROM ciudades WHERE id = :id", nativeQuery = true)
	CiudadesEntity verCiudadId(@Param("id") Long id);
}
