package fila;

import java.util.ArrayList;

public class GerenciadorFila {

    private final ArrayList<Pessoa> filaPrioritaria = new ArrayList<>();
    private final ArrayList<Pessoa> filaComum       = new ArrayList<>();

    // ----------------------------------------------------------------- add

    public Pessoa cadastrar(String nome, int idade) {
        Pessoa p = new Pessoa(nome, idade);

        if (p.getTipo() == TipoPrioridade.PRIORITARIO) {
            filaPrioritaria.add(p);
        } else {
            filaComum.add(p);
        }

        return p;
    }

    // -------------------------------------------------------------- chamada

    public Pessoa chamarProximo() {
        if (!filaPrioritaria.isEmpty()) {
            return filaPrioritaria.remove(0);
        }
        if (!filaComum.isEmpty()) {
            return filaComum.remove(0);
        }
        return null; // filas vazias
    }


    public boolean estaVazia() {
        return filaPrioritaria.isEmpty() && filaComum.isEmpty();
    }

    public int totalNaFila() {
        return filaPrioritaria.size() + filaComum.size();
    }

    public ArrayList<Pessoa> getFilaPrioritaria() {
        return new ArrayList<>(filaPrioritaria); // cópia defensiva
    }

    public ArrayList<Pessoa> getFilaComum() {
        return new ArrayList<>(filaComum);
    }


    public void exibirPainel() {
        String linha = "=".repeat(65);
        String separador = "-".repeat(65);

        System.out.println("\n" + linha);
        System.out.println("           PAINEL DE ATENDIMENTO — FILA ATUAL");
        System.out.println(linha);

        // ---- fila prioritária
        System.out.println("\n  🔴  FILA PRIORITÁRIA  (idosos ≥ 60 anos)");
        System.out.println("  " + separador);
        if (filaPrioritaria.isEmpty()) {
            System.out.println("  (nenhuma pessoa na fila prioritária)");
        } else {
            for (int i = 0; i < filaPrioritaria.size(); i++) {
                System.out.printf("  %2d°  %s%n", i + 1, filaPrioritaria.get(i));
            }
        }

        // ---- fila comum
        System.out.println("\n  🟢  FILA COMUM");
        System.out.println("  " + separador);
        if (filaComum.isEmpty()) {
            System.out.println("  (nenhuma pessoa na fila comum)");
        } else {
            for (int i = 0; i < filaComum.size(); i++) {
                System.out.printf("  %2d°  %s%n", i + 1, filaComum.get(i));
            }
        }

        System.out.println("\n  Total aguardando: " + totalNaFila() + " pessoa(s)");
        System.out.println(linha + "\n");
    }
}
