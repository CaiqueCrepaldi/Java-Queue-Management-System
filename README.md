# Sistema de Gerenciamento de Filas 🏥

Sistema em Java com POO para gerenciar filas de atendimento com prioridade para idosos (≥ 60 anos).

---

## 📁 Estrutura do Projeto

```
FilaAtendimento/
└── src/
    ├── Main.java                  ← Ponto de entrada
    └── fila/
        ├── TipoPrioridade.java    ← Enum: PRIORITARIO | COMUM
        ├── Pessoa.java            ← Modelo da pessoa (nome, idade, senha)
        ├── GerenciadorFila.java   ← Lógica de negócio (ArrayList + regras)
        └── Menu.java              ← Interface com o usuário (I/O no terminal)
```

---

## ▶️ Como Compilar e Executar

### Pré-requisito
- Java JDK 17 ou superior instalado

### Compilar
```bash
cd FilaAtendimento/src
javac -d ../out fila/TipoPrioridade.java fila/Pessoa.java fila/GerenciadorFila.java fila/Menu.java Main.java
```

### Executar
```bash
cd FilaAtendimento/out
java Main
```

---

## 🎮 Como Usar

O menu principal oferece 4 opções:

| Opção | Ação |
|-------|------|
| `1` | Cadastrar uma nova pessoa na fila |
| `2` | Chamar o próximo para atendimento |
| `3` | Visualizar o painel de filas |
| `0` | Encerrar o sistema |

### Fluxo de cadastro
1. Informe o **nome** da pessoa
2. Informe a **idade**
3. O sistema automaticamente direciona:
   - **Idade ≥ 60** → Fila Prioritária 🔴
   - **Idade < 60**  → Fila Comum 🟢
4. Uma **senha numérica** é gerada automaticamente

### Chamada de atendimento
- A fila prioritária **sempre** é chamada antes da fila comum
- A pessoa chamada é **removida** da fila
- O painel é atualizado automaticamente

---

## 🧱 Conceitos de POO Utilizados

| Conceito | Onde é aplicado |
|----------|----------------|
| **Encapsulamento** | Atributos `private` com getters em `Pessoa` |
| **Responsabilidade Única** | Cada classe tem uma única responsabilidade |
| **Enum** | `TipoPrioridade` tipifica as categorias de fila |
| **Composição** | `Menu` usa `GerenciadorFila`; `GerenciadorFila` usa `Pessoa` |
| **ArrayList** | Estrutura dinâmica para as duas filas |
| **Cópia Defensiva** | `getFilaPrioritaria()` retorna uma cópia para não expor o estado interno |

---

## 💡 Exemplo de Execução

```
=================================================================
      SISTEMA DE GERENCIAMENTO DE FILAS — v1.0
      Saúde / Atendimento ao Público
=================================================================

  MENU PRINCIPAL
  [1]  Cadastrar pessoa na fila
  [2]  Chamar próxima pessoa
  [3]  Visualizar painel de filas
  [0]  Encerrar sistema

  Escolha uma opção: 1

  — CADASTRO DE PESSOA —
  Nome: Maria Aparecida
  Idade: 72

  ✔  Pessoa cadastrada com sucesso!
     → Senha: 1  |  Fila: Prioritária

=================================================================
           PAINEL DE ATENDIMENTO — FILA ATUAL
=================================================================

  🔴  FILA PRIORITÁRIA  (idosos ≥ 60 anos)
  ─────────────────────────────────────────────────────────────
   1°  Senha 1    | [PRIORITÁRIO] | Maria Aparecida               | 72 anos

  🟢  FILA COMUM
  ─────────────────────────────────────────────────────────────
  (nenhuma pessoa na fila comum)

  Total aguardando: 1 pessoa(s)
=================================================================
```
