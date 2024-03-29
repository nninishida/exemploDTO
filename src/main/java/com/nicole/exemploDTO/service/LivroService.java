package com.nicole.exemploDTO.service;

import java.util.List;
import java.util.Optional;

import com.nicole.exemploDTO.dto.LivroDTO;
import com.nicole.exemploDTO.entities.Livro;
import com.nicole.exemploDTO.repository.LivroRepository;

public class LivroService {

	private final LivroRepository livroRepository;
	
	public LivroService (LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public LivroDTO salvar(Livro livro) {
		Livro salvarLivro = livroRepository.save(livro);
		return new LivroDTO(salvarLivro.getId(), salvarLivro.getTitulo(), salvarLivro.getAutor());
	}
	
	public LivroDTO atualizar(Long id,Livro livro) {
		Livro existeLivro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
		existeLivro.setTitulo(livro.getTitulo());
		existeLivro.setAutor(livro.getAutor());
		Livro updatedLivro = livroRepository.save(existeLivro);
		return new LivroDTO(updatedLivro.getId(), updatedLivro.getTitulo(), updatedLivro.getAutor());
	}
	
	public boolean deletar(Long id) {
		Optional <Livro> existeCliente = livroRepository.findById(id);
		if (existeCliente.isPresent()) {
			livroRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Livro> buscarTodos() {
		return livroRepository.findAll();
	}
	
	public Livro buscarPorId(Long id) {
		Optional <Livro> Livro = livroRepository.findById(id);
		return Livro.orElse(null);
	}

}
