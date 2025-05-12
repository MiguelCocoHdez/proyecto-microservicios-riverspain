package com.riverspain.batidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riverspain.batidas.entity.BatidasEntity;

import jakarta.transaction.Transactional;

@Repository
public interface BatidaRepository extends JpaRepository<BatidasEntity, Long> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO batidas (nombre, fecha, voluntariosbatida, zonaid) VALUES (:#{#batida.nombre}, :#{#batida.fecha}, :#{#batida.voluntariosbatida}, :#{#batida.zonaid})", nativeQuery = true)
	void crearBatida(@Param("batida") BatidasEntity batida);
	
	@Query(value = "SELECT * FROM batidas", nativeQuery = true)
	List<BatidasEntity> verBatidas();
	
	@Query(value = "SELECT * FROM batidas WHERE id IN (:ids)", nativeQuery = true)
	List<BatidasEntity> verBatidasZona(@Param("ids") List<Long> ids);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE batidas SET voluntariosbatida = CASE " +
            "WHEN voluntariosbatida IS NOT NULL AND voluntariosbatida != '' " +
            "THEN CONCAT(voluntariosbatida, ',', :voluntariosbatida) " +
            "ELSE :voluntariosbatida END WHERE id = :id", nativeQuery = true) 
	void insertarVoluntariosBatida(@Param("id") Long id,@Param("voluntariosbatida") String voluntariosbatida);
	
	@Query(value = "SELECT * from batidas WHERE FIND_IN_SET(:numerovoluntario, voluntariosbatida)", nativeQuery = true)
	List<BatidasEntity> verBatidasVoluntario(@Param("numerovoluntario") String numerovoluntario);
}
