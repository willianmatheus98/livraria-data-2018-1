package br.edu.unichristus.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_AUTOR")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTOR_ID")
	private Long autorID;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "PAIS")
	private String pais;

	// Autor é o proprietário da relação many to many
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_AUTORES_LIVROS")
	private List<Livro> livros;

	public Autor(String nome, String pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public Autor() {

	}

	@Override
	public String toString() {
		return "Autor [autorID=" + autorID + ", nome=" + nome + ", pais=" + pais + ", livros=" + listarLivros() + "]";
	}

	private String listarLivros() {
		String titulosLivros = "";
		for (Livro l: livros) {
			titulosLivros = titulosLivros + " " + l.getTitulo() + " ";
		}
		return titulosLivros;
	}

	public Long getAutorID() {
		return autorID;
	}

	public void setAutorID(Long autorID) {
		this.autorID = autorID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
