package br.com.casadocodigo.capitulo7;

import br.com.casadocodigo.domain.Usuario;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Importe estático.
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by heitorh3 on 20/05/2017.
 */
public class Capitulo7 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);
        Usuario user4 = new Usuario("Anderson Lima", 280);

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
        usuarios.add(user4);

        //Tornando moderadores os 2 usuários com mais pontos
        usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
        usuarios
                .subList(0,2)
                .forEach(Usuario::tornarModerador);

        //Filtrando todos os usuários que tem mais de 100 pontos
        //Stream<Usuario> stream = usuarios.stream();
        //stream.filter(u -> u.getPontos() > 100);

        // ou assim
        usuarios.stream()
                .filter(u -> u.getPontos() > 200);
        //usuarios.forEach(System.out::println);

        usuarios.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .forEach(System.out::println);

        //Filtrando todos os usuários que tem mais de 100 pontos e tornando eles moderadores
        usuarios.stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .forEach(Usuario::tornarModerador);

        //Capturando o retorno do filter
        List<Usuario> maisQue100 = new ArrayList<>();
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .forEach(u -> maisQue100.add(u));

        // Ou pode ser feitor mais simplificado
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .forEach(maisQue100::add);

        //Collectors
        Supplier<ArrayList<Usuario>> supplier = ArrayList::new;
        BiConsumer<ArrayList<Usuario>, Usuario> accumulator=
                ArrayList::add;
        BiConsumer<ArrayList<Usuario>, ArrayList<Usuario>> combiner=
                ArrayList::addAll;
        List<Usuario> maisQue150 = usuarios.stream()
                .filter(u -> u.getPontos() > 150)
                .collect(supplier, accumulator, combiner);

        //Collector simplificado
        System.out.println("Collector simplificado");
        List<Usuario> maisQue120 = usuarios.stream()
                .filter(u -> u.getPontos() > 120)
                .collect(Collectors.toList());
        maisQue120.forEach(System.out::println);

        //Avançado: por que não há um toList em Stream?
        Set<Usuario> maisQue90 = usuarios.stream()
                                        .filter(u -> u.getPontos() > 90)
                                        .collect(toSet()); //Uso do import stático.

        /*
        Set<Usuario>set = Stream.collect(
                Collectors.toCollection(HashSet::new)
        );
        */
        /*
        List<Usuario> pontos = usuarios.stream()
                .map(Usuario::getPontos)
                .collect(toList());
        */
        IntStream intStream = usuarios.stream().mapToInt(Usuario::getPontos);

        /* Pontuação média*/

        double mediaD = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();
        System.out.println("Média: " + mediaD);

        OptionalDouble media = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average();
        double pontuacaoMedia = media.orElse(0.0);

        //versão simplificada
        double mediaPontuacao = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .orElse(0.0);

        Optional<String> maxNome = usuarios
                .stream()
                .max(Comparator.comparingInt(Usuario::getPontos))
                .map(Usuario::getNome);
    }
}
