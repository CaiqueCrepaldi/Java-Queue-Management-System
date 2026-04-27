package fila;

import java.util.Scanner;


public class Menu {

    private static final String LINHA = "=".repeat(65);

    private final Scanner scanner;
    private final GerenciadorFila gerenciador;

    public Menu(GerenciadorFila gerenciador) {
        this.gerenciador = gerenciador;
        this.scanner     = new Scanner(System.in);
    }

    // -------------------------------------------------------------- loop principal

    public void iniciar() {
        exibirBoasVindas();

        boolean continuar = true;

        while (continuar) {
            exibirOpcoes();
            int opcao = lerInteiro("  Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarPessoa();
                case 2 -> chamarProximo();
                case 3 -> gerenciador.exibirPainel();
                case 0 -> continuar = encerrar();
                default -> System.out.println("\n  ⚠  Opção inválida. Tente novamente.\n");
            }
        }

        scanner.close();
    }

    // -------------------------------------------------------------- telas

    private void exibirBoasVindas() {
        System.out.println("\n" + LINHA);
        System.out.println("      SISTEMA DE GERENCIAMENTO DE FILAS — v1.0");
        System.out.println("      Saúde / Atendimento ao Público");
        System.out.println(LINHA);
        System.out.println("  Pessoas com 60 anos ou mais têm atendimento prioritário.");
        System.out.println(LINHA + "\n");
    }

    private void exibirOpcoes() {
        System.out.println("  MENU PRINCIPAL");
        System.out.println("  " + "-".repeat(30));
        System.out.println("  [1]  Cadastrar pessoa na fila");
        System.out.println("  [2]  Chamar próxima pessoa");
        System.out.println("  [3]  Visualizar painel de filas");
        System.out.println("  [0]  Encerrar sistema");
        System.out.println("  " + "-".repeat(30));
    }

    private void cadastrarPessoa() {
        System.out.println("\n  — CADASTRO DE PESSOA —");

        System.out.print("  Nome: ");
        scanner.nextLine(); // limpa buffer
        String nome = scanner.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("  ⚠  Nome não pode ser vazio.\n");
            return;
        }

        int idade = lerInteiro("  Idade: ");
        if (idade < 0 || idade > 130) {
            System.out.println("  ⚠  Idade inválida.\n");
            return;
        }

        Pessoa p = gerenciador.cadastrar(nome, idade);

        System.out.println("\n  ✔  Pessoa cadastrada com sucesso!");
        System.out.printf("     → Senha: %d  |  Fila: %s%n%n",
                p.getSenha(), p.getTipo().getDescricao());

        gerenciador.exibirPainel();
    }

    private void chamarProximo() {
        System.out.println("\n  — CHAMADA DE ATENDIMENTO —");

        Pessoa p = gerenciador.chamarProximo();

        if (p == null) {
            System.out.println("  ℹ  Não há ninguém aguardando no momento.\n");
        } else {
            System.out.println("\n  🔔  CHAMANDO PARA ATENDIMENTO:");
            System.out.println("  " + "─".repeat(50));
            System.out.printf("  Senha: %-4d | %s%n", p.getSenha(), p.getNome());
            System.out.printf("  Idade: %d anos | Fila: %s%n",
                    p.getIdade(), p.getTipo().getDescricao());
            System.out.println("  " + "─".repeat(50) + "\n");

            gerenciador.exibirPainel();
        }
    }

    private boolean encerrar() {
        System.out.println("\n  Sistema encerrado. Até logo! 👋\n");
        return false;
    }

    // -------------------------------------------------------------- utilitários

    private int lerInteiro(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("  ⚠  Entrada inválida. Digite um número inteiro.");
            }
        }
    }
}
