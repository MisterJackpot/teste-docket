package com.misterjackpot.cartorio.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CERTIDAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertidaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private CartorioEntity cartorio;

    private Long tipo;
}
