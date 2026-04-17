public class VetorDinamico {
    private int capacidade;
    private Processo[] processos;
    private int ocupacao;

    public VetorDinamico(int capacidade) {
        processos = new Processo[capacidade];
        this.capacidade = capacidade;
    }

    public VetorDinamico() {
        this(4);
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public boolean estaCheio() {
        return capacidade == ocupacao;
    }

    public boolean estaVazio() {
        return ocupacao == 0;
    }

    private void redimensiona(int novaCapacidade) {
        Processo[] novosProcessos = new Processo[novaCapacidade];
        for (int i = 0; i < ocupacao; i++) {
            novosProcessos[i] = processos[i];
        }
        processos = novosProcessos;
        capacidade = novaCapacidade;
    }

    public void adiciona(Processo novoProcesso) {
        if (estaCheio()) {
            redimensiona(capacidade * 2);
        }
        processos[ocupacao++] = novoProcesso;
    }

    public Processo remove() {
        if (estaVazio()) return null;
        Processo processo = processos[--ocupacao];
        if (capacidade >= 4 && ocupacao < capacidade / 4) {
            int novaCapacidade = capacidade / 2;
            if (novaCapacidade < 4) novaCapacidade = 4;
            redimensiona(novaCapacidade);
        }
        return processo;
    }

    public Processo[] listar() {
        return processos;
    }

    public int buscarPorProtocolo(int protocolo) {
        int indice = 0;
        for (int i = 0; i < ocupacao; i++) {
            indice = processos[i].comparaProtocolo(protocolo);
        }
        return indice;
    }

}
