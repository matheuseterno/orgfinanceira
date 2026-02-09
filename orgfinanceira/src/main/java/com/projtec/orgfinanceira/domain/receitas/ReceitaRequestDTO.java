package com.projtec.orgfinanceira.domain.receitas;

public record ReceitaRequestDTO(Integer usuarioId, String titulo, String descricao, Double valor, Long dataReceita, String metodoRecebimento, Boolean recorrente, Boolean recebido) {
}
