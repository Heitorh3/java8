package br.com.casadocodigo.capitulo2;

import br.com.casadocodigo.domain.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by heitorh3 on 23/06/2016.
 */
public class Capitulo2 {

    public static void main(String args []){

        final int numero = 5;

        Usuario user1 = new Usuario("Heitor Neto",150);
        Usuario user2 = new Usuario("João de Deus",110);
        Usuario user3 = new Usuario("Zé das Couves",50);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        System.out.println("########### Via Forma normal ##################");

        for (Usuario u: usuarios){
            System.out.println(u.toString());
        }

        System.out.println("############ Via Mostrador #################");

        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);

        System.out.println("############ Via Consumer #################");

        Consumer<Usuario> consumer = new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println("Via Consumer: " + usuario.getNome());
            }
        };

        usuarios.forEach(consumer);

        System.out.println("############ Via Lambda #################");

        Consumer<Usuario> consumerLambda = u -> System.out.println("Consumer via Lambda: " + u.getNome());

        usuarios.forEach(u -> System.out.println("Via Lambda: " + u.getNome()));

        System.out.println("############ Executando ações com Lambda #################");
        usuarios.forEach(user -> user.tornarModerador());

        System.out.println("############ Interface funcional com lambda e sem lambda #################");
        //Interface funcional com lambda e sem lambda
        Validator<String> validarCEP = new Validator<String>() {
            @Override
            public boolean validar(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }
        };

        Validator<String> validarCep = valor -> valor.matches("[0-9]{5}-[0-9]{3}");

        new Thread(()-> {
           System.out.println(numero);
        }).start();
    }
}
