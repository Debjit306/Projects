package com.medshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medshop.entity.Cart;

;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
