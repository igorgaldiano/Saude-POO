package br.edu.fatecfranca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// precisamos informar que esta classe é uma tabela no banco de dados
@Entity //decorator
@Table(name="paciente")

public class Paciente {
	
	@Id //chave primária
	@GeneratedValue(strategy=GenerationType.AUTO) //geração automática da chave
	
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="cpf")
	private String cpf;
	@Column(name="idade")
	private String idade;	
	@Column(name="peso")
	private float peso;
	@Column(name="altura")
	private float altura;
	
	public Paciente() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public Paciente(Long id,String nome, String cpf, String idade, float peso, float altura) {
		super();
		this.id = id;
		this.nome=nome;
		this.cpf = cpf;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
		
		
	}
	
	
	
}
