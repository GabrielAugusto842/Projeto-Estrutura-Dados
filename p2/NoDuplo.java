package p2;

public class NoDuplo<Livro> {
    private Livro info;
    private NoDuplo<Livro> proximo;
    private NoDuplo<Livro> anterior;

    public NoDuplo(Livro info) {
        this.info = info;
        this.proximo = null;
        this.anterior = null;
    }

    public Livro getInfo() {
        return info;
    }

    public NoDuplo<Livro> getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo<Livro> proximo) {
        this.proximo = proximo;
    }

    public NoDuplo<Livro> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo<Livro> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "[" + info + "]";
    }

}
