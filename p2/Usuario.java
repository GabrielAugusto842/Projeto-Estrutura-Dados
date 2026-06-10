package p2;

public class Usuario {
    private int matricula;
    private String nome;
    private String email;
    
    public Usuario(int matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[" + matricula + "] " + nome + " - " + email;
    }

    //Método Equals
    public int comparaMatricula (int matricula) {
        if (matricula == this.matricula) return this.matricula;
        else return -1;
    }
    
}
