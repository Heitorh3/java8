package br.com.cadadocodigo.capitulo4;

import br.com.cadadocodigo.domain.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by heitorh3 on 24/06/2016.
 */
public class Capitulo4 {

    public static void main (String args []){
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        Consumer<Usuario> mostraMensagem = u -> System.out.println("Antes de imprimir os nomes");

        Consumer<Usuario> imprimeNomes = u -> System.out.println(u.getNome());

        usuarios.forEach(mostraMensagem.andThen(imprimeNomes));

        Predicate<Usuario> predicado = new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getPontos() > 160;
            }
        };

        usuarios.removeIf(predicado);
        usuarios.removeIf(u -> u.getPontos() > 160);
        usuarios.forEach(u -> System.out.println(u.toString()));
    }
}
