package model;

public class Livro {
    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponivel;

    public Livro(String titulo, String autor, String categoria, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

