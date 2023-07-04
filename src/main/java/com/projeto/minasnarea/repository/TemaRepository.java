package com.projeto.minasnarea.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.projeto.minasnarea.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>  {
	
	public List <Tema> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);
}
