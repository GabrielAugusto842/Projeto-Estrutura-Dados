package p2;

public class TesteLista {
    public static void main(String[] args) {
        ListaDupla listaLivros = new ListaDupla();
        System.out.println(listaLivros.listarDoInicio());
        listaLivros.insereInicio(new Livro("A1B2", "Livro", "Autor", 2010));
        System.out.println(listaLivros.listarDoInicio());
        listaLivros.insereInicio(new Livro("C3D4", "Livro2", "Autor2", 2012));
        System.out.println(listaLivros.listarDoInicio());
        listaLivros.insereFim(new Livro("E5F6", "Livro3", "Autor3", 2014));
        System.out.println(listaLivros.listarDoInicio());
        System.out.println(listaLivros.listarDoFim());
        System.out.println("Quantidade de livros: " + listaLivros.tamanho());
        System.out.println(listaLivros.buscarPorIsbn("A1B2") != null ? "Livro encontrado: " + listaLivros.buscarPorIsbn("A1B2") : "Livro nao encontrado.");
        System.out.println(listaLivros.buscarPorIsbn("AAAA") != null ? listaLivros.buscarPorIsbn("AAAA") : "Livro nao encontrado.");
        System.out.println(listaLivros.removePrimeiro() + " saiu do inicio");
        System.out.println(listaLivros.listarDoInicio());
        System.out.println(listaLivros.removeUltimo() + " saiu do inicio");
        System.out.println(listaLivros.listarDoInicio());
        listaLivros.insereFim(new Livro("E5F6", "Livro3", "Autor3", 2014));
    }
}
