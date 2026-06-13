package p2;

public class Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    
    public boolean filaVazia () {
        return primeiro == null;
    }

    public void enfileira(T info) {
        No<T> novo = new No<>(info);
        if (filaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

     public T desenfileira () throws Exception {
        if (filaVazia())
            throw new FilaVaziaException();
        T copia = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) //esvaziou a fila
            ultimo = null;
        return copia;
    }

    public T primeiro() throws Exception {
        if (filaVazia())
            throw new FilaVaziaException();
        return primeiro.getInfo();
    }

    public int tamanho() {
        int tamanho = 0;
        if (filaVazia()) return tamanho;
        No<T> runner = primeiro;
        while (runner != null) {
            tamanho++;
            runner = runner.getProximo();
        }
        return tamanho;
    }

    @Override
    public String toString () {
        if (filaVazia()) return "fila vazia";
        String s = "";
        No<T> runner = primeiro;
        while (runner != null) {
            s += runner + "->";
            runner = runner.getProximo();
        }
        return s + "//";
    }
}
