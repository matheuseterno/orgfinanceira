package com.projtec.orgfinanceira.domain.despesas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "despesas")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Despesas {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany
    @JoinColumn(name = "usuario_id")
    private Integer usuario;
    private String titulo;
    private String descricao;
    private Double valor;
    private Date dataDespesa;
    private String metodoPagamento;
    private boolean recorrente;
    private boolean pago;
    private Date dataCriado;
    private Date dataModificado;
}
