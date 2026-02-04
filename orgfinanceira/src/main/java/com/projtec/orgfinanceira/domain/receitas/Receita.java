package com.projtec.orgfinanceira.domain.receitas;

import com.projtec.orgfinanceira.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "receitas")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Receita {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String titulo;
    private String descricao;
    private Double valor;
    private Date dataReceita;
    private String metodoRecebimento;
    private boolean recorrente;
    private boolean recebido;
    private Date dataCriado;
    private Date dataModificado;
}

