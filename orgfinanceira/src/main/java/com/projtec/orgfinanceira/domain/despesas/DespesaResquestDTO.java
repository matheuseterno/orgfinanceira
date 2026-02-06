package com.projtec.orgfinanceira.domain.despesas;

public record DespesaResquestDTO(Integer usuarioId, String titulo, String descricao, Double valor, Long dataDespesa, String metodoPagamento, Boolean recorrente, Boolean pago) {
}
