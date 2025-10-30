package com.treino.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treino.domain.model.Treino;





public interface TreinoRepository extends JpaRepository<Treino, Long> {
   
    
}
