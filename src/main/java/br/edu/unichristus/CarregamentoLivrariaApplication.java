package br.edu.unichristus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.domain.Autor;
import br.edu.unichristus.domain.Editora;
import br.edu.unichristus.domain.Livro;
import br.edu.unichristus.services.AutorService;
import br.edu.unichristus.services.EditoraService;
import br.edu.unichristus.services.LivroService;

//@SpringBootApplication
public class CarregamentoLivrariaApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;
	
	@Autowired
	private AutorService servicoAutores;

	public static void main(String[] args) {
		SpringApplication.run(CarregamentoLivrariaApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		// Cria e salva 2 livros
		Livro livro = new Livro("Java Como Programar", LocalDate.now(), 250, new BigDecimal("15.00"));
		Livro livro2 = new Livro("PHP Básico", LocalDate.now(), 100, new BigDecimal("145.00"));
		Livro livro3 = new Livro("Os Sinos Deixaram de Dobrar", LocalDate.now(), 999, new BigDecimal("145.00"));
		this.servicoLivros.salvar(livro);
		this.servicoLivros.salvar(livro2);
		this.servicoLivros.salvar(livro3);

		// Cria e salva duas editoras
		Editora editora = new Editora("Campus", "Rio de Janeiro", 2000);
		Editora editora2 = new Editora("Elsevier", "São Paulo", 1950);
		this.servicoEditoras.salvar(editora);
		this.servicoEditoras.salvar(editora2);
		
		livro.setEditora(editora);
		livro2.setEditora(editora);
		livro3.setEditora(editora2);
		
		this.servicoLivros.salvar(livro);
		this.servicoLivros.salvar(livro2);
		this.servicoLivros.salvar(livro3);
		
		List<Livro> livrosAntonio = new ArrayList<Livro>();
		livrosAntonio.add(livro2);
		
		List<Livro> livrosJose = new ArrayList<Livro>();
		livrosJose.add(livro);
		livrosJose.add(livro3);
		
		Autor a = new Autor("Antonio José", "Brasil");
		Autor j = new Autor("José Lira", "Brasil");
		
		a.setLivros(livrosAntonio);
		j.setLivros(livrosJose);
		
		this.servicoAutores.salvar(a);
		this.servicoAutores.salvar(j);
	}
}
