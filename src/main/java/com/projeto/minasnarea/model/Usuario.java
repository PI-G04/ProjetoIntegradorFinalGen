package com.projeto.minasnarea.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatorio, por favor preencha!")
	@Size(min= 5, max= 30 , message = "O nome deve conter no minimo 5 caracteres")
	private String nome;
	
	@NotBlank(message = "Usuario é obrigatorio, por favor preencha(Exemplo: minasnaarea@email.com)")
	@Size(min= 5, max= 100 , message = "O usuario deve conter no minimo 5 caracteres")
	private String usuario;
	
	@NotBlank(message = "Senha é obrigatorio, por favor preencha!")
	@Size(min= 8, max= 100 , message = "A senha deve conter no minimo 8 caracteres")
	private String senha;
	
	private String foto;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "usuario"  )
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
