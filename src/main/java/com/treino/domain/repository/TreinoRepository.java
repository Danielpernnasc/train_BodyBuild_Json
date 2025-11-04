package com.treino.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treino.domain.model.Treino;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {
   
    
}
