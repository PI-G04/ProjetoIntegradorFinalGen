package com.projeto.minasnarea.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.projeto.minasnarea.model.*;

public interface PostagemRepository extends JpaRepository<Postagem, Long>  {
	
	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	}
