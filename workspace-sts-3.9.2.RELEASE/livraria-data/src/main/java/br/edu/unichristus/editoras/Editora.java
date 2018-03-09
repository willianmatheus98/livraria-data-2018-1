package br.edu.unichristus.editoras;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.unichristus.livros.Livro;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_EDITORA")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EDITORA_ID")
	private Long editoraID;

	@Column(name="NOME")
	private String nome;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name= "ANO_FUNDACAO")
	private int anoFundacao;
	
	@OneToMany(mappedBy="editora")
	private List<Livro> livros;
	
	public Editora(String nome, String cidade) {
		super();
		this.nome = nome;
		this.cidade = cidade;
	}
	
	public Editora() {
		
	}

}
