package br.edu.unichristus.livros;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="TB_LIVRO")
@Data
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIVRO_ID")
	private Long livroID;
	
	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "DATA_PUBLICACAO")
	private LocalDate dataPublicacao;
	
	@Column(name = "NUMERO_PAGINAS")
	private int numeroPaginas;
	
	@Column(name = "PRECO")
	private BigDecimal preco;
	
	public Long getLivroID() {
		return livroID;
	}



	public void setLivroID(Long livroID) {
		this.livroID = livroID;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}



	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}



	public int getNumeroPaginas() {
		return numeroPaginas;
	}



	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}



	public BigDecimal getPreco() {
		return preco;
	}



	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}



	public Livro(String titulo, LocalDate dataPublicacao, int numeroPaginas, BigDecimal preco) {
		super();
		this.titulo = titulo;
		this.dataPublicacao = dataPublicacao;
		this.numeroPaginas = numeroPaginas;
		this.preco = preco;
	}
	
	

	

	

}
