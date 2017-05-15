package br.com.cadadocodigo.domain;

/**
 * Created by heitorh3 on 23/06/2016.
 */
public class Usuario {

    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario() {
    }

    public Usuario(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean isModerador() {
        return moderador;
    }

    public void setModerador(boolean moderador) {
        this.moderador = moderador;
    }

    public void tornarModerador(){
        this.setModerador(true);
        System.out.println("Virei moderador");
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
