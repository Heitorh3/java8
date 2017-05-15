package br.com.cadadocodigo.capitulo6;

import br.com.cadadocodigo.domain.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by heitorh3 on 15/05/2017.
 */
public class Capitulo6 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("João de Deus", 55);
        Usuario user2 = new Usuario("Edgar Antônio", 98);
        Usuario user3 = new Usuario("Marta Oliveira", 76);

        List<Usuario> usuarios = Arrays.asList(user1,user2,user3);

        //Forma convêncional com lambda
        System.out.println("Forma convêncional com lambda");
        usuarios.forEach(u -> u.tornarModerador());

        //Forma com Method References
        System.out.println("Forma com Method References");
        usuarios.forEach(Usuario::tornarModerador);

        //Essa forma de fazer é a mesma coisa que fazendo com lambda convêncional
        System.out.println("Forma realizada com o consumer");
        Consumer<Usuario> consumer = Usuario::tornarModerador;
        usuarios.forEach(consumer);

        //Realizando comparando de uma forma ainda mais enxuta
        //Forma convêncional
        System.out.println("Comparação na forma convêncional");
        usuarios.sort(Comparator.comparing(u -> u.getNome()));


        //Utilizando method references
        System.out.println("Comparando utilizando method reference");
        usuarios.sort(Comparator.comparing(Usuario::getNome));

        //Utilizando o static import do comparing
        System.out.println("Comparando utilizando o static import comparing");
        Function<Usuario, String> byName = Usuario::getNome;
        usuarios.sort(comparing(byName));

        //Compondo comparators
        //Comparators utilizando lambda
        System.out.println("Compondo comparators utilizando lambda");
        usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));

        //Usando a nova sintaxe, podemos fazer:
        System.out.println("Usando a nova sintaxe, podemos fazer");
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));

        //Por exemplo: orde-nar pelos pontos e, no caso de empate, ordenar pelo nome.
        Comparator<Usuario> c = Comparator.comparingInt(Usuario::getPontos)
                                            .thenComparing(Usuario::getNome);

        //Uma forma um pouco menos verbosa
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos)
                                .thenComparing(Usuario::getNome));

        //Todos os usuários nulos da nossa lista estarão posicionados no fim, e o restante ordenado pelo nome!
        usuarios.sort(Comparator.nullsLast(Comparator.comparingInt(Usuario::getPontos)
                                                     .thenComparing(Usuario::getNome)));

        System.out.println("Todos os usuários nulos da nossa lista estarão posicionados no fim, e\n" +
                            "o restante ordenado pelo nome!");
        usuarios.forEach(System.out::println);

        //Ordenar por pontos, porém na ordem decrescente
        System.out.println("Ordenar por pontos, porém na ordem decrescente");
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed());
        usuarios.forEach(System.out::println);


        //Referenciando métodos de instância

        Usuario heitor = new Usuario("Heitor", 120);
        Runnable bloco = heitor::tornarModerador;
        bloco.run();

        /*
        *
        * Runnable bloco1 = heitor::tornaModerador;
        * Runnable bloco2 = () -> heitor.tornaModerador();
        *
        * */

        //Referenciando métodos que recebem argumen-tos

    }
}
