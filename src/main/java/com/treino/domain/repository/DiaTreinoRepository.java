// src/main/java/com/treino/domain/repository/DiaTreinoRepository.java
package com.treino.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.treino.domain.model.DiaTreino;

public interface DiaTreinoRepository extends JpaRepository<DiaTreino, Long> {}
