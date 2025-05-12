package com.riverspain.peces.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riverspain.peces.entity.PecesEntity;

import jakarta.transaction.Transactional;

@Repository
public interface PezRepository extends JpaRepository<PecesEntity, Long> {

	@Query(value = "SELECT * FROM peces", nativeQuery = true)
	List<PecesEntity> verPeces();
	
	@Query(value = "SELECT * FROM peces WHERE rioid = :rioid", nativeQuery = true)
	List<PecesEntity> verPecesRio(@Param("rioid") Long rioid);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO peces (nombrecomun, nombrecientifico, origen) VALUES (:#{#pez.nombrecomun}, :#{#pez.nombrecientifico}, :#{#pez.origen})", nativeQuery = true)
	void insertarPez(@Param("pez") PecesEntity pez);
	/*
	@Query(value = "SELECT * FROM peces INNER JOIN peces_entity_rioid on peces.id = peces_entity_rioid.peces_entity_id where peces_entity_rioid.rioid IN (:ids)", nativeQuery = true)
	List<PecesEntity> verPecesId(@Param("ids") List<Long> ids);
	*/
	
	@Query(value = "SELECT * FROM peces where id IN (:ids)", nativeQuery = true)
	List<PecesEntity> verPecesId(@Param("ids") List<Long> ids);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO peces_entity_rioid (peces_entity_id, rioid) VALUES (:pezid, :rioid)", nativeQuery = true)
	void agregarRioPez(@Param("pezid") Long pezid, @Param("rioid") Long rioid);
	
	@Query(value = "SELECT * FROM peces WHERE id = :id", nativeQuery = true)
	PecesEntity verPezId(@Param("id") Long id);
}
