package com.shop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.shop.entity.PaymentBill;
import com.shop.model.PaymentBillDTO;

@Component
public class PaymentBillConverter {
	// convert PaymentBillDTO to Entity(PaymentBill)
				public PaymentBill convertToEntity(PaymentBillDTO paymentBillDTO) {

					PaymentBill paymentBill = new PaymentBill();
					if (paymentBillDTO != null) {
						BeanUtils.copyProperties(paymentBillDTO, paymentBill);
					}

					return paymentBill;
				}

				// convert Entity(MedicineDetails) to MedicineDetailsDTO
				public PaymentBillDTO convertToPaymentBillDTO(PaymentBill paymentBill) {

					PaymentBillDTO paymentBillDTO= new PaymentBillDTO();
					if (paymentBill != null) {
						BeanUtils.copyProperties(paymentBill, paymentBillDTO);
					}

					return paymentBillDTO;
				}

}
