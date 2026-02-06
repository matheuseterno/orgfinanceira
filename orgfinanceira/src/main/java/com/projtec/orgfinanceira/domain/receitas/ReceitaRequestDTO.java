package com.projtec.orgfinanceira.domain.receitas;

public record ReceitaRequestDTO(Integer usuarioId, String titulo, String descricao, Double valor, Long dataReceita, String metodoRecebimeto, Boolean recorrente, Boolean recebido) {
}
