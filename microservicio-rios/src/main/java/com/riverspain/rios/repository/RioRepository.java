package com.riverspain.rios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riverspain.rios.entity.RiosEntity;

import jakarta.transaction.Transactional;

@Repository
public interface RioRepository extends JpaRepository<RiosEntity, Long> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO rios (nombre, descripcion, imagen) VALUES (:#{#rio.nombre}, :#{#rio.descripcion}, :#{#rio.imagen})", nativeQuery = true)
	void agregarRio(@Param("rio") RiosEntity rio);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO rios_entity_pezid (rios_entity_id, pezid) VALUES (:rioid, :pezid)", nativeQuery = true)
	void agregarPezRio(@Param("pezid") Long pezid, @Param("rioid") Long rioid);
	
	@Query(value = "SELECT * FROM rios", nativeQuery = true)
	List<RiosEntity> verRios();
	
	@Query(value = "SELECT * FROM rios WHERE id = :id", nativeQuery = true)
	RiosEntity verRioId(@Param("id") Long id);
}
