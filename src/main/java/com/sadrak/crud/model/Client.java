package com.sadrak.crud.model;

import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Client") //Define o nome da tabela que será criada no banco de dados
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "id", sequenceName = "id") //Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id") //Define que a tabela fará uso da sequence criada antes
	private Long id;

	@Column(nullable = false, length = 16) //Define propriedades da coluna
	@CPF
	@NotBlank(message = "Informe um CPF Válido") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String cpf;

	@Column(nullable = false, length = 80) //Define propriedades da coluna
	@NotBlank(message = "Informe seu nome") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String name;

	@Column(nullable = false, length = 200) //Define propriedades da coluna
	@NotBlank(message = "Informe sua cidade") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String city;

	@Column(nullable = false, length = 50) //Define propriedades da coluna
	@NotBlank(message = "Informe a Unidade Federativa onde você reside") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String uf;

  public Client() {
  }
  
  public Client(String name, String city, String uf, String cpf) {
      this.name = name;
      this.city = city;
      this.uf = uf;
      this.cpf = cpf;
  }

  public Client(Long id, String name, String city, String uf, String cpf) {
  	this.id = id;
  	this.name = name;
      this.city = city;
      this.uf = uf;
      this.cpf = cpf;
  }

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}