package com.projeto.minasnarea.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import com.projeto.minasnarea.model.Minas;

public interface TemaRepository extends JpaRepository<Minas, Long>  {
	
	public List <Minas> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);
}
