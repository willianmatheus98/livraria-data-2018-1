package br.edu.unichristus;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Livro livro = new Livro("Java Como Programar", new Date(), 250, new BigDecimal("15.00"));
		Livro livro2 = new Livro("PHP Básico", new Date(), 100, new BigDecimal("145.00"));
		this.servicoLivros.salvarLivro(livro);
		this.servicoLivros.salvarLivro(livro2);

	}
}
