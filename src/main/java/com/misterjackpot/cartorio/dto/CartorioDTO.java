package com.misterjackpot.cartorio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartorioDTO {
    private Long id;
    private String nome;
    private String endereco;

}
