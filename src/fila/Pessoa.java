package fila;


public class Pessoa {

    private static int contadorSenha = 1;

    private final int senha;
    private final String nome;
    private final int idade;
    private final TipoPrioridade tipo;

    public Pessoa(String nome, int idade) {
        this.senha  = contadorSenha++;
        this.nome   = nome;
        this.idade  = idade;
        this.tipo   = (idade >= 60) ? TipoPrioridade.PRIORITARIO : TipoPrioridade.COMUM;
    }

    // ---------------------------------------------------------------- getters

    public int getSenha()              { return senha; }
    public String getNome()            { return nome;  }
    public int getIdade()              { return idade; }
    public TipoPrioridade getTipo()    { return tipo;  }

    // ---------------------------------------------------------------- display

    @Override
    public String toString() {
        String tag = (tipo == TipoPrioridade.PRIORITARIO) ? "[PRIORITÁRIO]" : "[COMUM]      ";
        return String.format("Senha %-4d | %s | %-30s | %d anos", senha, tag, nome, idade);
    }

    /** Reseta o contador de senhas (útil para testes). */
    public static void resetContador() {
        contadorSenha = 1;
    }
}
