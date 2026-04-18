public class PilhaProcesso {
    private VetorDinamico vetor;

    public PilhaProcesso() {
        this.vetor = new VetorDinamico(4);
    }

    public Boolean estaVazia() {
        return vetor.estaVazio();
    }

    public void push(Processo processo) {
        vetor.adiciona(processo);
    }

    public Processo pop() {
        if (vetor.estaVazio()) {
            throw new PilhaVaziaException("Não é possível remover, pois a pilha está vazia.");
        }
        return vetor.remove();
    }

    public Processo peek() {
        if (vetor.estaVazio()) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }
        return vetor.listar()[vetor.getOcupacao() - 1];
    }

    public void imprimir() {
        if (vetor.estaVazio()) {
            System.out.println("Pilha vazia.");
            return;
        }

        //System.out.println("Pilha de processos:");
        Processo[] vetorProcesso = vetor.listar();
        
        for (int i = vetor.getOcupacao() - 1; i >= 0; i--) {
            System.out.println(vetorProcesso[i]);
        }
    }

}
