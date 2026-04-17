public class Processo {
    private static int contador = 1;
    private int protocolo; //único, automático e sequencial
    private String solicitante; //quem abriu o processo
    private String tipoServico; // tipo de atendimento, saúde, financeiro
    private int prioridade; //1 - baixa, 2 - normal, 3 - urgente
    private String dataHora; //formato dd/MM/yyyy HH:mm

    //public Processo(String solicitante, String tipoServico, int prioridade) {
    public Processo(String solicitante) {
        this.protocolo = contador;
        contador++;
        this.solicitante = solicitante;
        //this.tipoServico = tipoServico;
        //this.prioridade = prioridade;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setSolicitante (String solicitante) {
        this.solicitante = solicitante;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setTipoServico (String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setPrioridade (int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setDataHora (String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        return "[#" + protocolo + "] " + solicitante;
        // + " | " + tipoServico + " | " + prioridade + 
        //" | " + dataHora;
    }

    //Método Equals
    public int comparaProtocolo (int protocolo) {
        if (this.protocolo == protocolo) return this.protocolo;
        else return -1;
    }
}