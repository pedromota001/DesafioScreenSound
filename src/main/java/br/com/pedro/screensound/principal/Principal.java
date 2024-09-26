package br.com.pedro.screensound.principal;

import br.com.pedro.screensound.modelos.Artista;
import br.com.pedro.screensound.modelos.Musica;
import br.com.pedro.screensound.modelos.TipoCategoria;
import br.com.pedro.screensound.repository.IArtistaRepository;

import java.io.Serial;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private IArtistaRepository repositorioArtista;

    public Principal(IArtistaRepository repositorioArtista) {
        this.repositorioArtista = repositorioArtista;
    }
    private int resp = - 1;
    public void mainMenu(){
        do {
            System.out.println("""
                    MENU
                    1 - Cadastrar Artistas
                    2 - Cadastrar Musicas 
                    3 - Listar Musicas 
                    4 - Buscar musicas por artista
                   
               
                    
                    
                    0 - Sair
                    """);
            System.out.println("Digite sua opcao: ");
            resp = leitura.nextInt();
            leitura.nextLine();
            switch (resp){
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    //listaMusicas();
                    break;
                case 4:
                    //buscarMusicasPorArtistas();
                    break;
                case 0:
                    System.out.println("Encerrando");
                    break;
            }
        } while (resp != 0);
    }

    private void cadastrarArtistas() {
        System.out.println("Digite o nome do artista ");
        var nomeArtista = leitura.nextLine();
        Optional<Artista> artistaAchado = repositorioArtista.findByNomeContainingIgnoreCase(nomeArtista);
        if(artistaAchado.isPresent()){
            System.out.println("Artista ja cadastrado no banco de dados");
        }
        else{
            System.out.println("Digite a categoria desse artista (SOLO/BANDA/DUPLA)");
            var tipoCategoria = leitura.nextLine();
            TipoCategoria categoria = TipoCategoria.valueOf(tipoCategoria.toUpperCase());
            Artista artista = new Artista(nomeArtista, categoria);
            repositorioArtista.save(artista);
        }
    }
    private void cadastrarMusicas(){
        System.out.println("Digite o nome do artista dono da musica: ");
        var nomeArtista = leitura.nextLine();
        Optional<Artista> artistaEncontrado = repositorioArtista.findByNomeContainingIgnoreCase(nomeArtista);
        if(artistaEncontrado.isPresent()){
            System.out.println("Digite o nome da musica que sera cadastrada: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            var artistaAchado = artistaEncontrado.get();
            artistaAchado.getListaMusicas().add(musica);
            musica.setArtista(artistaAchado);
            repositorioArtista.save(artistaAchado);
        }
        else{
            System.out.println("Artista nao encontrado no banco");
        }
    }
}
