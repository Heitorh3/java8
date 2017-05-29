package br.com.casadocodigo.capitulo2;

import br.com.casadocodigo.domain.Usuario;

import java.util.function.Consumer;

/**
 * Created by heitorh3 on 23/06/2016.
 */
public class Mostrador implements Consumer<Usuario> {

    @Override
    public void accept(Usuario usuario) {
        System.out.println("Via mostrador: " + usuario.getNome());
    }
}
