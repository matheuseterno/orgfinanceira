package com.projtec.orgfinanceira.domain.receitas;

import com.projtec.orgfinanceira.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "receitas")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String titulo;
    private String descricao;
    private Double valor;
    private LocalDateTime dataReceita;
    private String metodoRecebimento;
    private boolean recorrente;
    private boolean recebido;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriado;

    private LocalDateTime dataModificado;

    @PrePersist
    protected void onCreate(){
        this.dataCriado = LocalDateTime.now();
        this.dataModificado = LocalDateTime.now();
        if(this.dataReceita == null){
            dataReceita = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate(){
        this.dataModificado = LocalDateTime.now();
    }
}

