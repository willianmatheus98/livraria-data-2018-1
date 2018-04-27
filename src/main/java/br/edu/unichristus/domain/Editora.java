package br.edu.unichristus.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "TB_EDITORA")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EDITORA_ID")
	private Long editoraID;

	@Column(length = 30, nullable = false, unique = true)
	private String nome;

	@Column(length = 30, nullable = false)
	private String cidade;

	@Column(name = "ANO_FUNDACAO")
	private int anoFundacao;

	@OneToMany(mappedBy = "editora", fetch = FetchType.EAGER)
	private List<Livro> livros;

	public Editora(String nome, String cidade, int anoFundacao) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.anoFundacao = anoFundacao;
	}

	public Editora() {

	}

	@Override
	public String toString() {
		return "Editora [editoraID=" + editoraID + ", nome=" + nome + ", cidade=" + cidade + ", anoFundacao="
				+ anoFundacao + ", livros=" + listarLivros() + "]";
	}

	
	private String listarLivros() {
		String titulosLivros = "";
		for (Livro l: livros) {
			titulosLivros = titulosLivros + " " + l.getTitulo() + " ";
		}
		return titulosLivros;
	}

	public Long getEditoraID() {
		return editoraID;
	}

	public void setEditoraID(Long editoraID) {
		this.editoraID = editoraID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getAnoFundacao() {
		return anoFundacao;
	}

	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
