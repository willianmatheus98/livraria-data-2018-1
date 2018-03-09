package br.edu.unichristus.autores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.editoras.Editora;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	

}
