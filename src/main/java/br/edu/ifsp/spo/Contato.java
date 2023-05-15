package br.edu.ifsp.spo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contato {

	private int id;
	private String nome;
	private String endereco;
	private String email;
	private LocalDate dataNascimento;
	
	public Contato(String nome, String email, String endereco, LocalDate dataNascimento) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Contato(int id, String nome, String email, String endereco, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getDataNascimentoFormatada() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataNascimento.format(formatter);
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
