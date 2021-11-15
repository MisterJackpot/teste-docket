package com.misterjackpot.cartorio.infra.repository;

import com.misterjackpot.cartorio.infra.entity.CartorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartorioRepository extends JpaRepository<CartorioEntity, Long> {
}
