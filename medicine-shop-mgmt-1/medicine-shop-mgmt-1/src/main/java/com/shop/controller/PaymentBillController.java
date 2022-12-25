package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.shop.entity.PaymentBill;
import com.shop.model.PaymentBillDTO;
import com.shop.service.PaymentBillService;
import com.shop.util.PaymentBillConverter;

public class PaymentBillController  {
	@Autowired
	private PaymentBillConverter billConverter;
	
	@Autowired
	private PaymentBillService billService;
	 @PostMapping("/createPaymentBill")
		public String createPaymentBill(@RequestBody PaymentBillDTO paymentBillDTO) {

			final PaymentBill bill = billConverter.convertToEntity(paymentBillDTO);
			
			return billService.createPaymentBill(bill);
			}
	 @GetMapping("/getPaymentBillById/{billid}")
		public PaymentBillDTO getPaymentBillById(@PathVariable("billid") int billid) {

			return billService.getPaymentBillById(billid);
		}
		
	@GetMapping("/getAllCustomer")
		public List<PaymentBillDTO> getAllPaymentBill() {
			return billService.getAllPaymentBill();
		}
		
	@DeleteMapping("/deletePaymentBillById/{billid}")
		public String deletePaymentBillById(@PathVariable("billid") int billid) {
			return billService.deletePaymentBillById(billid);
		}
}
