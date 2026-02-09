package com.projtec.orgfinanceira.domain.despesas;

import java.time.LocalDateTime;

public record DespesaResponseDTO(Integer id, String titulo, String descricao, Double valor, LocalDateTime dataDespesa, String metodoPagamento, Boolean pago) {
}
