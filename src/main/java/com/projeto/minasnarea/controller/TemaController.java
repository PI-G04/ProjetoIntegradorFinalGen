package com.projeto.minasnarea.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;


import com.projeto.minasnarea.model.Minas;
import com.projeto.minasnarea.repository.TemaRepository;

import jakarta.validation.Valid;

public class TemaController {
	@Autowired
	private TemaRepository temaRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Minas>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Minas> getById(@PathVariable Long id){
		
		return postagemRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Minas>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(postagemRepository.findAllByDescricaoContainingIgnoreCase(descricao));
		
	}
	
	@PostMapping	
	public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem){
		if(temaRepository.existsById(postagem.getTema().getId()))
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(postagemRepository.save(postagem));
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tema não existe!", null);
	}
	@PutMapping
	public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem){
		if(postagemRepository.existsById(postagem.getId())) {
		
			if(temaRepository.existsById(postagem.getTema().getId()))
		return ResponseEntity.status(HttpStatus.OK)
				.body(postagemRepository.save(postagem));
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tema não existe", null);
				
	}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Postagem> postagem = postagemRepository.findById(id);
		
		if (postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		postagemRepository.deleteById(id);
	}
	
}

}
