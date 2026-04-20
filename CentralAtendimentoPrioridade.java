public class CentralAtendimentoPrioridade {
    PilhaPrioridade pilhaPrincipal; //Atendimentos pendentes por prioridade
    PilhaProcesso pilhaAuxiliar; // histórico para desfazer por prioridade

    public CentralAtendimentoPrioridade() {
        this.pilhaPrincipal = new PilhaPrioridade();
        this.pilhaAuxiliar = new PilhaProcesso();
    }

    public void abrirProcesso(Processo processo) {
        pilhaPrincipal.push(processo);
        while (!pilhaAuxiliar.estaVazia()) {
            pilhaAuxiliar.pop();
        }
    }

    public String atenderProximo() {
        try {
             Processo processo = pilhaPrincipal.pop();
            pilhaAuxiliar.push(processo);
            return ("Atendendo agora: \n" + processo);
        } catch (PilhaVaziaException e) {
            return "Nenhum processo na pilha.\n";
        }
    }

    public String desfazerUltimoAtendimento() {
        if (!pilhaAuxiliar.estaVazia()) {
            Processo processo = pilhaAuxiliar.pop();
            pilhaPrincipal.push(processo);
            return "Processo desfeito e novamente pendente!\n";
        } else {
            return "Erro: Não há atendimentos para desfazer!\n";
        }
        
    }

    public String listarPendentes() {
        return "Pendentes:\n" + pilhaPrincipal.listar();
    }

    public String listarHistorico() {
        return "Histórico:\n" + pilhaAuxiliar.imprimir();
    }

}
