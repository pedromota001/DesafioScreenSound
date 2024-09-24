package br.com.pedro.screensound.repository;

import br.com.pedro.screensound.modelos.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistaRepository extends JpaRepository<Artista, Long> {
}
