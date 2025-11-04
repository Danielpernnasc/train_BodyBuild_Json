package com.treino.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treino.domain.model.Exercicio;
@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

	 @SuppressWarnings("null")
    @Override
	 Optional<Exercicio> findById(Long id);
}
