package p2;

public class Livro {
    private String isbn; //identificador do livro
    private String titulo;
    private String autor;
    private int anoPub;
    private boolean disponivel;

    public Livro(String isbn, String titulo, String autor, int anoPub) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
    }

    public String getIsbn() {
        return isbn;
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

    public int getAnoPub() {
        return anoPub;
    }

    /*public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }*/

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    //Formatar o texto: true -> DISPONIVEL
    public String formatarDisponibilidade() {
        if (disponivel) return "DISPONIVEL";
        else return "INDISPONIVEL";
    }

    @Override
    public String toString() {
        return "[" + isbn + "] " + titulo + " - " + autor + " (" + anoPub + ") " +
        "[" + formatarDisponibilidade() + "]";
    }

    //Método Equals
    public String comparaIsbn (String isbn) {
        if (isbn.equals(isbn)) return this.isbn;
        else return "ISBN diferente";
    }
    
}
