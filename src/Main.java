import fila.GerenciadorFila;
import fila.Menu;

/**
 * Ponto de entrada do Sistema de Gerenciamento de Filas.
 *
 * <p>Estrutura do projeto:
 * <pre>
 *   Main.java                 ← ponto de entrada
 *   fila/
 *     TipoPrioridade.java     ← enum: PRIORITARIO | COMUM
 *     Pessoa.java             ← modelo: nome, idade, senha, tipo
 *     GerenciadorFila.java    ← regras de negócio (ArrayList + lógica)
 *     Menu.java               ← interface com o usuário (I/O)
 * </pre>
 */
public class Main {

    public static void main(String[] args) {
        GerenciadorFila gerenciador = new GerenciadorFila();
        Menu menu = new Menu(gerenciador);
        menu.iniciar();
    }
}
