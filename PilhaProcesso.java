public class PilhaProcesso {
    private VetorDinamico vetor;

    public PilhaProcesso() {
        this.vetor = new VetorDinamico(4);
    }

    public Boolean estaVazia() {
        return vetor.estaVazio();
    }

    public int pegarTamanho() {
        return vetor.getOcupacao();
    }

    public void push(Processo processo) {
        vetor.adiciona(processo);
    }

    public Processo pop() {
        if (vetor.estaVazio()) {
            throw new PilhaVaziaException("Não é possível remover, pois a pilha está vazia.\n");
        }
        return vetor.remove();
    }

    public Processo peek() {
        if (vetor.estaVazio()) {
            throw new PilhaVaziaException("A pilha está vazia.\n");
        }
        return vetor.listar()[vetor.getOcupacao() - 1];
    }

    public String imprimir() {
        String mensagem = ""; //Não colocar Sysout fora da view
        if (vetor.estaVazio()) {
            mensagem = "Pilha vazia.\n";
            return mensagem;
        }

        Processo[] vetorProcesso = vetor.listar();
        
        for (int i = vetor.getOcupacao() - 1; i >= 0; i--) {
            mensagem += vetorProcesso[i];
        }
        return mensagem;
    }

}
