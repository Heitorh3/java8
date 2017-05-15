package br.com.cadadocodigo.capitulo5;

import br.com.cadadocodigo.domain.Usuario;

import javax.print.DocFlavor;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by heitorh3 on 24/06/2016.
 * Ordenando no Java8
 */
public class Capitulo5 {

    public static void main (String args[]){

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario user1, Usuario user2) {
                return user1.getNome().compareTo(user2.getNome());
            }
        };

        Comparator<Usuario> comp = (u1 ,u2) -> u1.getNome().compareTo(u2.getNome());

        Collections.sort(usuarios, (usr1 ,usr2) -> String.CASE_INSENSITIVE_ORDER.compare(usr1.getNome(), usr2.getNome()));

        usuarios.sort((u1, u2)-> u1.getNome().compareTo(u2.getNome()));

        usuarios.forEach(usuario -> System.out.println(usuario.getNome()));

        Collections.sort(usuarios, comparator);

        //Simplificando ainda mais a comparação

        Comparator<Usuario> comparator1 = Comparator.comparing(u -> u.getNome());
        usuarios.sort(comparator1);

        // ou assim

        usuarios.sort(Comparator.comparing(usuario -> usuario.getNome()));

        List<String> palavras =
                Arrays.asList("Casa do Código", "Alura", "Caelum");

        palavras.sort(Comparator.naturalOrder());

        System.out.println(palavras);

        usuarios.forEach(usuario -> usuario.tornarModerador());
        usuarios.forEach(Usuario::tornarModerador);

        Comparator<Usuario> c = Comparator.comparingInt(Usuario::getPontos)
                                            .thenComparing(Usuario::getNome);

        usuarios.forEach(System.out::println);

        System.out.println("*****************************");

        //Usuario heitor = Usuario::new;

        Supplier<Usuario> geradorDeUsuario = Usuario::new;
        Usuario heitor = geradorDeUsuario.get();

        BiFunction<String, Integer, Usuario> criadorDeUsuarios = Usuario::new;
        Usuario joao =  criadorDeUsuarios.apply("João de Deus", 25);

        usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
        usuarios.subList(0,1)
                .forEach(Usuario::tornarModerador);
        usuarios.forEach(System.out::println);

        Stream<Usuario> stream = usuarios.stream();
        stream.filter(u -> u.getPontos() > 100);

        System.out.println("*****************************");
        Stream<Usuario> streamU = usuarios.stream().filter(u -> u.getPontos() > 100);
        streamU.forEach(System.out::println);

        System.out.println("*****************************");
        usuarios.stream().filter(usuario -> usuario.getPontos() > 100)
                        .forEach(System.out::println);

        List<Usuario> maisQue100 = new ArrayList<>();
        usuarios.stream().filter(usuario -> usuario.getPontos() > 100)
                .forEach(u -> maisQue100.add(u));

        //metodo simplificado
        usuarios.stream().filter(u -> u.getPontos() > 100)
                .forEach(maisQue100::add);

        System.out.println("************ Metodo simplificado *****************");
        usuarios.stream().filter(u -> u.getPontos() > 125)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Double media = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .orElse(0.0);

        System.out.println(media);

    }
}
