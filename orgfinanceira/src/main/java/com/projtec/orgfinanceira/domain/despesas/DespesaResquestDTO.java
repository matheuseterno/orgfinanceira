package com.projtec.orgfinanceira.domain.despesas;

public record DespesaResquestDTO(Integer usuarioId, String titulo, String descricao, Double valor, Long dataDespesa, String MetodoPagamento, Boolean recorrente, Boolean pago) {
}
