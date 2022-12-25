package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.PaymentBill;


public interface PaymentBillRepository extends JpaRepository<PaymentBill,Integer>  {
	
	@Query("from PaymentBill where lower(customerName) like :n%")
	List<PaymentBill> getPaymentBillByName(@Param("n") String customerName);
	
	@Query("from PaymentBill where price=:p ")
	List<PaymentBill> getPaymentBillByprice(@Param("p") double price);
}
