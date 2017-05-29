package br.com.casadocodigo.capitulo2;

/**
 * Created by heitorh3 on 24/06/2016.
 *
 * Essa anotação (@FunctionalInterface) serve apenas para que ninguém torne essa interface em nãofuncional acidentalmente.
 * Ela é opcional justamente para que as interfaces das antigas bibliotecas possam também ser tratadas como lambdas,
 * independente da anotação, bastando a existência de um único método abstrato.
 *
 */

@FunctionalInterface
public interface Validator<T> {

    boolean validar(T t);
}
