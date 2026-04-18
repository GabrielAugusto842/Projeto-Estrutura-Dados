import java.util.Scanner;

public class TesteAtendimento {
    public static void main(String[] args) {
        CentralAtendimento central = new CentralAtendimento();
        //VetorDinamico vetor = new VetorDinamico();
        Scanner scanner = new Scanner(System.in);
        String solicitante, entrada, mensagem;
        int opcao = -1;
        System.out.println("CENTRAL DE ATENDIMENTO");
        do {
            System.out.print("\n1 - Abrir novo processo\n" +
                "2 - Atender o próximo\n" +
                "3 - Desfazer o último atendimento\n" +
                "4 - Listar atendimentos pendentes\n" +
                "5 - Listar histórico de atendimentos\n" +
                "0 - sair\n" +
                "Escolha uma opção: "
            );
            try {
                entrada = scanner.nextLine();
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números entre 0 e 5!");
                continue;
            }
            
            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome do solicitante: ");
                    solicitante = scanner.nextLine();
                    if (!solicitante.trim().isEmpty()) {
                        Processo processo = new Processo(solicitante);
                        central.abrirProcesso(processo);
                        System.out.println("Processo adicionado à fila.");
                    } else {
                        System.out.println("Campo obrigatório!");
                    }
                    break;
                case 2:
                    mensagem = central.atenderProximo();
                    System.out.println(mensagem);
                    break;
                case 3:
                    mensagem = central.desfazerUltimoAtendimento();
                    System.out.println(mensagem);
                    break;
                case 4:
                    central.listarPendentes();
                    break;
                case 5:
                    central.listarHistorico();
                    break;
                case 0:
                    System.out.println("Finalizando sistema");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }
}

