package com.shop.service;

import java.util.List;

import com.shop.entity.MedicineDetails;
import com.shop.entity.PaymentBill;
import com.shop.model.PaymentBillDTO;

public interface PaymentBillService {
	String createPaymentBill(PaymentBill paymentBill);
	
	PaymentBillDTO getPaymentBillById(int billid);
	
	List<PaymentBillDTO> getAllPaymentBill();
	
	String deletePaymentBillById(int billid);
	
	
	
	
}
