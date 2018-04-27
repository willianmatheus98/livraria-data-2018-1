package br.edu.unichristus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.domain.Editora;
import br.edu.unichristus.domain.Livro;
import br.edu.unichristus.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repo;

	public void salvar(Livro l) {
		System.out.println("GRAVANDO O LIVRO " + l.getTitulo());
		repo.save(l);
	}

	public Livro buscarPeloID(Long id) {
		return repo.findById(id).get();
	}

	public List<Livro> buscarTodos() {
		return repo.findAll();
	}

	public void remover(Long id) {
		System.out.println("REMOVENDO O LIVRO ID " + id);
		repo.deleteById(id);
	}

	public void remover(Livro l) {
		System.out.println("REMOVENDO O LIVRO ID " + l.getLivroID());
		repo.delete(l);
	}

	public Livro buscarPeloTitulo(String titulo) {
		return repo.findByTitulo(titulo);
	}

	public List<Livro> buscarTituloContendoString(String string) {
		return repo.findByTituloLike(string);
	}

	public List<Livro> buscarLivrosComPaginasIntervalo(int de, int ate) {
		return repo.findByNumeroPaginasBetween(de, ate);
	}

	public List<Livro> buscarLivrosEditora(Editora e) {
		return repo.findByEditora(e);
	}

	public List<Livro> buscarLivrosAutor(String nomeAutor) {
		return repo.findByAutoresNome(nomeAutor);
	}

	public List<Livro> buscarLivrosAutorEditora(String nomeAutor, String nomeEditora) {
		return repo.findByAutoresNomeAndEditoraNome(nomeAutor, nomeEditora);
	}

	public List<Livro> buscarLivrosAutorPais(String nomePais) {
		return repo.findByAutoresPais(nomePais);
	}

}
