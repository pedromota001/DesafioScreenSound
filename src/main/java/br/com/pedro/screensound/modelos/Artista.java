package br.com.pedro.screensound.modelos;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoCategoria tipo;

    @OneToMany
    private List<Musica> listaMusicas;

}
