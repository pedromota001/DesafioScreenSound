package br.com.pedro.screensound.repository;

import br.com.pedro.screensound.modelos.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);
}
