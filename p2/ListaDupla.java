package p2;

public class ListaDupla {
    private NoDuplo primeiro;
    private NoDuplo ultimo;

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void insereInicio(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
        if (estaVazia()) {
            ultimo = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public void insereFim(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);
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

    public Livro buscarPorIsbn(String isbn) {
        if (estaVazia()) return null;
        NoDuplo runner = primeiro;
        while (runner != null && !runner.getInfo().comparaIsbn(isbn)) {
            runner = runner.getProximo();
        }
        if (runner == null) {
            return null; 
        }
        
        return runner.getInfo();
    }

    public String listarDoInicio() {
        if (estaVazia()) return "Lista vazia";
        StringBuilder sBuilder = new StringBuilder();
        NoDuplo runner = primeiro;
        while (runner != null) {
            sBuilder.append(runner + " ");
            runner = runner.getProximo();
        }
        sBuilder.append("//");
        return new String(sBuilder);
    }

    public String listarDoFim() {
        if (estaVazia()) return "Lista vazia";
        StringBuilder sBuilder = new StringBuilder();
        NoDuplo runner = ultimo;
        while (runner != null) {
            sBuilder.append(runner + " ");
            runner = runner.getAnterior();
        }
        sBuilder.append("//");
        return new String(sBuilder);
    }

    public int tamanho() {
        if (estaVazia()) return 0;
        NoDuplo runner = primeiro;
        int tamanho = 0;
        while (runner != null) {
            tamanho++;
            runner = runner.getProximo();
        }
        return tamanho;
    }
}
