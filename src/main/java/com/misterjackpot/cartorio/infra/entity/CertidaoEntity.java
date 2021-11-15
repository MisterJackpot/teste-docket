package com.misterjackpot.cartorio.infra.entity;

import lombok.*;

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
    @ToString.Exclude
    private CartorioEntity cartorio;

    private Long tipo;
}
