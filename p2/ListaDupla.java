package p2;

public class ListaDupla {
    private NoDuplo<Livro> primeiro;
    private NoDuplo<Livro> ultimo;

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void insereInicio(Livro livro) {
        NoDuplo<Livro> novo = new NoDuplo<Livro>(livro);
        if (estaVazia()) {
            ultimo = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public void insereFim(Livro livro) {
        NoDuplo<Livro> novo = new NoDuplo<Livro>(livro);
        if (estaVazia()) {
            primeiro = novo;
        } else {
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

    public Livro removePrimeiro() {
        if (estaVazia()) return null;
        Livro copia = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) // lista esvaziou
            ultimo = null;
        else
            primeiro.setAnterior(null);
        return copia;
        
    }

    public Livro removeUltimo() {
        if (estaVazia()) return null;
        Livro copia = ultimo.getInfo();
        ultimo = ultimo.getAnterior();
        if (ultimo == null) //esvaziou a lista
            primeiro = null;
        else
            ultimo.setProximo(null);
        return copia;
    }
}
