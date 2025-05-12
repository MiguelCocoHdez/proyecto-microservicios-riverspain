package com.riverspain.voluntarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riverspain.voluntarios.entity.VoluntariosEntity;

import jakarta.transaction.Transactional;

@Repository
public interface VoluntarioRepository extends JpaRepository<VoluntariosEntity, Long> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO voluntarios (nombre, apellidos, email, dni, numerovoluntario, rol, fechacreacion) VALUES (:#{#voluntario.nombre}, :#{#voluntario.apellidos}, :#{#voluntario.email}, :#{#voluntario.dni}, :#{#voluntario.numerovoluntario}, :#{#voluntario.rol}, :#{#voluntario.fechacreacion})", nativeQuery = true)
	void insertarVoluntario(@Param("voluntario") VoluntariosEntity voluntario);
	
	@Query(value = "SELECT * from voluntarios", nativeQuery = true)
	List<VoluntariosEntity> verVoluntarios();
	
	@Query(value = "SELECT numerovoluntario FROM voluntarios WHERE dni = :dni", nativeQuery = true)
	String obtenerNumeroVoluntario(@Param("dni") String dni);
	
	@Query(value = "SELECT rol FROM voluntarios WHERE email = :email", nativeQuery = true)
	String obtenerRol(@Param("email") String dni);
	
	@Query(value = "SELECT * FROM voluntarios WHERE id = :id", nativeQuery = true)
	VoluntariosEntity verVoluntarioId(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM voluntarios WHERE id IN (:ids)", nativeQuery = true)
	List<VoluntariosEntity> verVoluntariosId(@Param("ids") List<Long> ids);
	
	@Query(value = "SELECT * FROM voluntarios WHERE numerovoluntario = :nvoluntario", nativeQuery = true)
	VoluntariosEntity verVoluntarioNum(@Param("nvoluntario") String nvoluntario);
	
	@Query(value = "SELECT * FROM voluntarios WHERE numerovoluntario IN (:numeros)", nativeQuery = true)
	List<VoluntariosEntity> verVoluntariosNum(@Param("numeros") List<String> numeros);
	
}
