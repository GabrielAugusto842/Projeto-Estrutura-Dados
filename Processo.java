import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Processo {
    private static int contador = 1; //para criar o número do protocolo
    private int protocolo; //único, automático e sequencial
    private String solicitante; //quem abriu o processo
    private String tipoServico; // tipo de atendimento, saúde, financeiro
    private int prioridade; //1 - baixa, 2 - normal, 3 - urgente
    private String dataHora; //formato dd/MM/yyyy HH:mm

    public Processo(String solicitante, String tipoServico, int prioridade) {
        this.protocolo = contador;
        contador++;
        this.solicitante = solicitante;
        this.tipoServico = tipoServico;
        this.prioridade = prioridade;
        //Pegar data e hora atual
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.dataHora = data.format(formato);
    }

    //getters e setters
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

    public String getDataHora() {
        return dataHora;
    }

    //Usado em pilha prioridade, transforma número em texto
    public String definePrioridade(int prioridade) {
        String urgencia;
        if (prioridade == 1) {
            urgencia = "Baixa";
        } else if (prioridade == 2) {
            urgencia = "Normal";
        } else {
            urgencia = "Urgente";
        }
        return urgencia;
    }

    @Override
    public String toString() {
        return "[#" + protocolo + "] " + solicitante + " | " +
        tipoServico + " | " + definePrioridade(prioridade) + " | " + 
        dataHora  + "\n";
    }

    //Método Equals
    public int comparaProtocolo (int protocolo) {
        if (this.protocolo == protocolo) return this.protocolo;
        else return -1;
    }
}