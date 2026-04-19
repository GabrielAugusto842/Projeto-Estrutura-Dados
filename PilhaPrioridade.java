public class PilhaPrioridade {
    PilhaProcesso pilhaBaixa;
    PilhaProcesso pilhaNormal;
    PilhaProcesso pilhaUrgente;

    public PilhaPrioridade() {
        this.pilhaBaixa = new PilhaProcesso();
        this.pilhaNormal = new PilhaProcesso();
        this.pilhaUrgente = new PilhaProcesso();
    }

    public void push(Processo processo) {
        if (processo.getPrioridade() == 1) {
            pilhaBaixa.push(processo);
        } else if (processo.getPrioridade() == 2) {
            pilhaNormal.push(processo);
        } else {
            pilhaUrgente.push(processo);
        }
    }

    public Processo pop() {
        Processo processo;
        if (!pilhaUrgente.estaVazia()) {
            processo = pilhaUrgente.pop();
        } else if (!pilhaNormal.estaVazia()) {
            processo = pilhaNormal.pop();
        } else if (!pilhaBaixa.estaVazia()) {
            processo = pilhaBaixa.pop();
        } else {
            throw new PilhaVaziaException("Não é possível remover, pois não há processos.");
        }
        return processo;
    }

    public Processo peek() {
        Processo processo;
        if (!pilhaUrgente.estaVazia()) {
            processo = pilhaUrgente.peek();
        } else if (!pilhaNormal.estaVazia()) {
            processo = pilhaNormal.peek();
        } else if (!pilhaBaixa.estaVazia()) {
            processo = pilhaBaixa.peek();
        } else {
            throw new PilhaVaziaException("Não há processos cadastrados.");
        }
        return processo;
    }

    public int tamanho() {
        int tamanho = 0;
        tamanho = pilhaUrgente.pegarTamanho() + pilhaNormal.pegarTamanho() + pilhaBaixa.pegarTamanho();
        return tamanho;
    }

    public String listar() {
        String listagem = "Lista de processos por prioridade:\n";
        listagem += "Urgentes:\n" + pilhaUrgente.imprimir();
        listagem += "\nNormais:\n" + pilhaNormal.imprimir();
        listagem += "\nBaixas:\n" + pilhaBaixa.imprimir();
        return listagem;
    }
}
