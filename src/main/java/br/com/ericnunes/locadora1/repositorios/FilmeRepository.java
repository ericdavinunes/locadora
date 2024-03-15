package br.com.ericnunes.locadora1.repositorios;

import br.com.ericnunes.locadora1.entidades.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
