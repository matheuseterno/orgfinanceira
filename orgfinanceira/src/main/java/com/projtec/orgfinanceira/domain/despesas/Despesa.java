package com.projtec.orgfinanceira.domain.despesas;

import com.projtec.orgfinanceira.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "despesas")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Despesa {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String titulo;
    private String descricao;
    private Double valor;
    private LocalDateTime dataDespesa;
    private String metodoPagamento;
    private boolean recorrente;
    private boolean pago;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriado;
    private LocalDateTime dataModificado;

    @PrePersist
    protected void onCreate() {
        this.dataCriado = LocalDateTime.now();
        this.dataModificado = LocalDateTime.now();
        if (this.dataDespesa == null) {
            this.dataDespesa = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataModificado = LocalDateTime.now();
    }
}
