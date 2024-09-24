package br.com.pedro.screensound.principal;

import br.com.pedro.screensound.repository.IArtistaRepository;

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
                    //cadastrarMusicas();
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
        System.out.println();
    }
}
