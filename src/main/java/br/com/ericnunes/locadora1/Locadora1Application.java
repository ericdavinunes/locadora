package br.com.ericnunes.locadora1;

import br.com.ericnunes.locadora1.entidades.Filme;
import br.com.ericnunes.locadora1.repositorios.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Locadora1Application implements CommandLineRunner {
    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    public void run(String... args) throws Exception {
        // MENU
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("MENU DE OPÇÕES");
            System.out.println("1. Adicionar um filme");
            System.out.println("2. Listar os filmes");
            System.out.println("3. Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = Integer.parseInt(teclado.nextLine());

            if (opcao == 1) { // ADICIONAR
                System.out.print("Digite o nome: ");
                String nome = teclado.nextLine();
                System.out.print("Digite o autor: ");
                String autor = teclado.nextLine();
                System.out.print("Digite a categoria: ");
                String categoria = teclado.nextLine();

                Filme novo = new Filme();
                novo.setNome(nome);
                novo.setAutor(autor);
                novo.setCategoria(categoria);

                filmeRepository.save(novo);
            } else if ( opcao == 2) { // LISTAR
                for (Filme f : filmeRepository.findAll()) {
                    System.out.println(f.getNome() + ", " + f.getAutor() + ", " + f.getCategoria());
                }
            } else if (opcao == 3) { // SAIR
                break;
            } else {
                System.out.println("Opção inválida!");
            }

        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Locadora1Application.class, args);
    }

}


