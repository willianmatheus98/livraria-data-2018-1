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
	
	public Editora() {
		
	}

}
