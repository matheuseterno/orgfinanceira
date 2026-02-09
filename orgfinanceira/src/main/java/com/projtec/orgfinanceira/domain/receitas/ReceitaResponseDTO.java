package com.projtec.orgfinanceira.domain.receitas;

import java.time.LocalDateTime;

public record ReceitaResponseDTO(Integer Id, String titulo, String descricao, Double valor, LocalDateTime dataReceita, String metodoPagamento, Boolean pago) {
}
