package br.com.cadadocodigo.capitulo3;

/**
 * Created by heitorh3 on 15/05/2017.
 */
public class CapturadeVariaveis {

    // Capiturando variáveis locais
    public static void main(String[] args) {

        // a variável não precisa necessáriamente ser final. Mas você não pode auterala se estiver utilizando-a no lambda.
        int numero = 8;

        new Thread(()-> {
            System.out.println("Número: " + numero);
        }).start();

        //Isso não é permitido pois a variável esta sendo utilizada pelo lambda
        //numero ++;

        //System.out.println("Número: "+ numero);
    }
}
