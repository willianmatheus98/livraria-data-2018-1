package br.edu.unichristus.editoras;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EDITORA")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EDITORA_ID")
	private Long editoraID;

	private String nome;

	private String cidade;
	
	private int anoFundacao;

	public Editora(String nome, String cidade) {
		super();
		this.nome = nome;
		this.cidade = cidade;
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



	public Editora() {
		
	}

}
