package br.edu.unichristus;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_LIVRO")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIVRO_ID")
	private Long livroID;
	
	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "DATA_PUBLICACAO")
	private Date dataPublicacao;
	
	@Column(name = "NUMERO_PAGINAS")
	private int numeroPaginas;
	
	@Column(name = "PRECO")
	private BigDecimal preco;

	public Livro() {
	}

	public Livro(String titulo, Date dataPublicacao, int numeroPaginas, BigDecimal preco) {
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.numeroPaginas = numeroPaginas;
		this.preco = preco;
	}

}
