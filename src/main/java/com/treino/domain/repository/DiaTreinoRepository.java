// src/main/java/com/treino/domain/repository/DiaTreinoRepository.java
package com.treino.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treino.domain.model.DiaTreino;
@Repository
public interface DiaTreinoRepository extends JpaRepository<DiaTreino, Long> {}
