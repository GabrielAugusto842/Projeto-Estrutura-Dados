public class CentralAtendimento {
    PilhaProcesso pilhaPrincipal; //Atendimentos pendentes
    PilhaProcesso pilhaAuxiliar; // histórico para desfazer

    public CentralAtendimento() {
        this.pilhaPrincipal = new PilhaProcesso();
        this.pilhaAuxiliar = new PilhaProcesso();
    }

    public void abrirProcesso(Processo processo) {
        pilhaPrincipal.push(processo);
        while (!pilhaAuxiliar.estaVazia()) {
            pilhaAuxiliar.pop();
        }
    }

    public String atenderProximo() {
        if (!pilhaPrincipal.estaVazia()) {
            Processo processo = pilhaPrincipal.pop();
            pilhaAuxiliar.push(processo);
            return ("Atendendo agora: \n" + processo);
        } else {
            return "Não há nenhum atendimento pendente!\n";
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
        System.out.println("Pendentes:");
        return pilhaPrincipal.imprimir();
    }

    public String listarHistorico() {
        System.out.println("Histórico:");
        return pilhaAuxiliar.imprimir();
    }
}
