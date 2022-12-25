package com.shop.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.MedicineDetails;
import com.shop.entity.PaymentBill;
import com.shop.model.PaymentBillDTO;
import com.shop.repository.PaymentBillRepository;
import com.shop.service.PaymentBillService;
import com.shop.util.PaymentBillConverter;

@Service
public class PaymentBillimpl implements PaymentBillService{

	@Autowired
	private PaymentBillRepository paymentBillRepository; 
	
	@Autowired
	private PaymentBillConverter billConverter;
	
	@Override
	public String createPaymentBill(PaymentBill paymentBill) {
		String message = null;
		paymentBillRepository.save(paymentBill);
		if (paymentBill != null) {
			message = "Payment Bill are Saved Successfully";
		}
		return message;
	}

	@Override
	public PaymentBillDTO getPaymentBillById(int billid) {
		PaymentBill foundBill= paymentBillRepository.findById(billid).get();
		return billConverter.convertToPaymentBillDTO(foundBill);
	}

	@Override
	public List<PaymentBillDTO> getAllPaymentBill() {
		List<PaymentBill> allPaymentBillList = paymentBillRepository.findAll();

		List<PaymentBillDTO> allPaymentBillDTOs = new ArrayList<>();

		for (PaymentBill paymentBill : allPaymentBillList) {
			allPaymentBillDTOs.add(billConverter.convertToPaymentBillDTO(paymentBill));
		}

		return allPaymentBillDTOs;
	}

	@Override
	public String deletePaymentBillById(int billid) {
		Optional<PaymentBill> paymentBill = paymentBillRepository.findById(billid);

		if (paymentBill.isPresent()) {
			paymentBillRepository.deleteById(billid);
			return "Payment Bill is Deleted Successfully :)";
		}

		return "Payment Bill is Not Found :(";
	}

	


	

}
