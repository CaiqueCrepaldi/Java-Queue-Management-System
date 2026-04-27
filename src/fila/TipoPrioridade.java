package fila;

/**
 * Define os tipos de prioridade no atendimento.
 */
public enum TipoPrioridade {
    PRIORITARIO("Prioritária"),
    COMUM("Comum");

    private final String descricao;

    TipoPrioridade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
