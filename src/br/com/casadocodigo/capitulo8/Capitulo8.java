package br.com.casadocodigo.capitulo8;

import br.com.casadocodigo.domain.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by heitorh3 on 29/05/2017.
 */
public class Capitulo8 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Heitor Neto",150);
        Usuario user2 = new Usuario("João de Deus",110);
        Usuario user3 = new Usuario("Zé das Couves",50);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        List<Usuario> filtradosOrdenados = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());

        //filtradosOrdenados.forEach(System.out::println);

        // Muitas operações no Stream são lazy!
        Optional<Usuario> usuarioOptional = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .peek(System.out::println)
                .findAny();
        if (usuarioOptional.isPresent()){
            //System.out.println(usuarioOptional.get());
        }

        Optional<Usuario>usuario = usuarios.stream()
                .sorted(Comparator.comparing(Usuario::getNome))
                .peek(System.out::println)
                .findAny();

        //System.out.println(usuarioOptional.get());


        double pontuacaoMedia = usuarios.stream()
                    .mapToInt(Usuario::getPontos)
                    .average()
                    .getAsDouble();

        Optional<Usuario> max = usuarios.stream().max(Comparator.comparing(Usuario::getPontos));
        Usuario usu = max.get();

    }
}
