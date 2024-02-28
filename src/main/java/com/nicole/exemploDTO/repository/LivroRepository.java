package com.nicole.exemploDTO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicole.exemploDTO.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
