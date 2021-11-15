package com.misterjackpot.cartorio.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CARTORIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartorioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CertidaoEntity> certidoes;
}
