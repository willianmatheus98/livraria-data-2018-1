package br.edu.unichristus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.unichristus.domain.Livro;
import br.edu.unichristus.services.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {
	@Autowired
	private LivroService servicoLivros;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getLivros(Model model) {
		List<Livro> livros = servicoLivros.buscarTodos();
		model.addAttribute("livros", livros);
		
		return "livros/listar";
	}
	
	@GetMapping("/inserir")
    String preInsert(Model model) {
		model.addAttribute("livro", new Livro());
        return "livros/inserir";
    }
	
	@GetMapping("/atualizar/{livroID}")
    String preUpdate(Model model, @PathVariable Long livroID) {
		Livro livro = servicoLivros.buscarPeloID(livroID);
		model.addAttribute("livro", livro);
		
        return "livros/atualizar";
    }
	
	@PostMapping("/save")
    String insert(@ModelAttribute Livro livro) {
		Livro nLivro = livro;
		
		servicoLivros.salvar(nLivro);
		
        return "livros/resultado";
    }
	
	@PostMapping("/save/{livroID}")
    String update(@ModelAttribute Livro livro, @PathVariable Long livroID) {
		Livro nLivro = livro;
		
		if(livroID != null) {
			nLivro = servicoLivros.buscarPeloID(livro.getLivroID());
			nLivro.setTitulo(livro.getTitulo());
			nLivro.setEditora(livro.getEditora());
			nLivro.setDataPublicacao(livro.getDataPublicacao());
			nLivro.setNumeroPaginas(livro.getNumeroPaginas());
			nLivro.setPreco(livro.getPreco());
		}
		
		servicoLivros.salvar(nLivro);
		
        return "livros/resultado";
    }
}
