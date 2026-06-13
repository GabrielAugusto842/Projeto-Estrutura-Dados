package p2;

public class GestorEmprestimos {
    // A chave é a String (ISBN) e o valor é a Fila de Usuários
    /*private NossoHash<String, Fila<Usuario>> controleEspera;
    // Vamos precisar de uma forma de achar o livro para saber se ele está disponível
    private ListaDupla listaLivros; 

    public GestorEmprestimos(ListaDupla listaLivros) {
        this.controleEspera = new NossoHash<>();
        this.listaLivros = listaLivros;
    }

    public void solicitarEmprestimo(String isbn, Usuario u) {
        Livro livro = listaLivros.buscarPorIsbn(isbn);
        
        if (livro == null) {
            System.out.println("Livro com ISBN " + isbn + " nao existe no acervo.");
            return;
        }

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("Emprestimo registrado: '" + livro.getTitulo() + "' para " + u.getNome());
        } else {
            System.out.println("Livro indisponivel. " + u.getNome() + " enviado para a fila de espera.");
            
            // Busca se já existe uma fila para esse ISBN no nosso Hash
            Fila<Usuario> fila = controleEspera.get(isbn);
            if (fila == null) {
                fila = new Fila<>(); // Cria a fila se for o primeiro a esperar
                controleEspera.put(isbn, fila);
            }
            fila.enfileirar(u);
        }
    }

    public void devolverLivro(String isbn) {
        Livro livro = listaLivros.buscarPorIsbn(isbn);
        
        if (livro == null) {
            System.out.println("Livro invalido.");
            return;
        }

        System.out.println("\n--- Devolucao do livro: " + livro.getTitulo() + " ---");
        Fila<Usuario> fila = controleEspera.get(isbn);

        // Se a fila não existir ou estiver vazia
        if (fila == null || fila.estaVazia()) {
            livro.setDisponivel(true);
            System.out.println("Livro devolvido com sucesso. Ninguem na fila. Status: Disponivel.");
        } else {
            // Se tem gente esperando, o livro continua indisponível, mas passa para o próximo
            Usuario proximo = fila.desenfileirar();
            System.out.println("Livro devolvido! Emprestimo transferido automaticamente para o proximo da fila: " + proximo.getNome());
        }
    }

    public void listarFilaDeEspera(String isbn) {
        System.out.println("\n--- Fila de espera para o ISBN " + isbn + " ---");
        Fila<Usuario> fila = controleEspera.get(isbn);
        if (fila == null || fila.estaVazia()) {
            System.out.println("Nao ha ninguem aguardando este livro.");
        } else {
            fila.exibir(); // Método da sua fila que printa os usuários
        }
    }*/
}
