package br.com.cadadocodigo.capitulo3;

/**
 * Created by heitorh3 on 15/05/2017.
 */
public class Capitulo3 {

    public static void main(String ... args){

        //"############ Thread sem Lambda #################"
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 3; i++){
                    System.out.println("Thread sem Lambda: " + i);
                }
            }
        };
        new Thread(runnable).start();

        //"############ Thread com Lambda #################"
        Runnable r = ()-> {
            for (int i = 0; i <= 3; i++){
                System.out.println("Thread comm Lambda: " + i);
            }
        };
        new Thread(r).start();

        //"############ Thread com Lambda de uma forma resumida #################"
        new Thread(()->{
            for (int i = 0; i <= 3; i++){
                System.out.println("Thread com Lambda de uma forma: " + i);
            }
        }).start();

        Runnable o = () -> {
            System.out.println("O que sou eu? Que lambda?");
        };

        System.out.println(o.getClass());
    }
}
