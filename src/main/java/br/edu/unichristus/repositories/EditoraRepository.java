package br.edu.unichristus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.domain.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

	// Consultas com editoras
	// Buscar uma editora pelo nome
	public Editora findByNomeEquals(String nome);

	// Buscar editoras com ano de fundação dentro de um período
	public List<Editora> findByAnoFundacaoGreaterThanEqualAndAnoFundacaoLessThanEqual(int minimo, int maximo);

}
