package br.com.serratec.entity;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message= "Nome não pode ser nulo ou vazio.")
	@Size(max = 150, message = "O Nome não pode ter mais de 150 caracteres")
	@Size(min= 2, message = "O Nome não pode ter menos de 2 caracteres" )
	private String nome;
	
	private String telefone;
	@NotBlank
	
	private String senha;
	@Email
	private String email;
	@CPF
	private String cpf;
	
	
	@JoinColumn(name = "id_endereco")
	@ManyToOne
	@JsonBackReference
	private Endereco endereco;

/*
	@Override
	public String toString() {
		return "nome:" + nome +"email:" +email +"\n\n\n";
		
	*/
	
	
	public Long getId() {
		return id;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
