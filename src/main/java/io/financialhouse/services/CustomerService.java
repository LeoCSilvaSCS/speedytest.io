package io.financialhouse.services;

import org.springframework.stereotype.Service;

import io.financialhouse.feign.CustomerFeignClient;
import io.financialhouse.model.request.TransactionRequest;
import io.financialhouse.model.response.TransactionConsumerInfoResponse;

@Service
public class CustomerService {

	private CustomerFeignClient customerFeignClient;

	public CustomerService(CustomerFeignClient customerFeignClient) {
		this.customerFeignClient = customerFeignClient;
	}

	public TransactionConsumerInfoResponse findCustomer(String token, TransactionRequest transactionRequest) {
		return customerFeignClient.findCustomer(token, transactionRequest);
	}
}
