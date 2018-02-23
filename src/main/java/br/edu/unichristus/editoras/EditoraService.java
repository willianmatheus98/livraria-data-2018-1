package br.edu.unichristus.editoras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	public void salvarEditora(Editora e) {
		System.out.println("SALVANDO EDITORA " + e.getNome());
		this.repo.save(e);
	}

}
