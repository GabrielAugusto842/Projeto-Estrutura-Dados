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
        //System.out.println("Processo " + processo.getProtocolo() + " adicionado a fila.");
    }

    public String atenderProximo() {
        if (!pilhaPrincipal.estaVazia()) {
            Processo processo = pilhaPrincipal.pop();
            pilhaAuxiliar.push(processo);
            return ("Atendendo agora: " + processo);
        } else {
            return "Não há nenhum atendimento pendente!";
        }
    }

    public String desfazerUltimoAtendimento() {
        if (!pilhaAuxiliar.estaVazia()) {
            Processo processo = pilhaAuxiliar.pop();
            pilhaPrincipal.push(processo);
            return "Processo desfeito e novamente pendente!";
        } else {
            return "Erro: Não há atendimentos para desfazer!";
        }
        
    }

    public void listarPendentes() {
        System.out.println("Pendentes:");
        pilhaPrincipal.imprimir();
    }

    public void listarHistorico() {
        System.out.println("Histórico:");
        pilhaAuxiliar.imprimir();
    }
}
