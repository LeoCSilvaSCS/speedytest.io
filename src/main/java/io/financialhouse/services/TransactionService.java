package io.financialhouse.services;

import org.springframework.stereotype.Service;

import io.financialhouse.feign.TransactionFeignClient;
import io.financialhouse.model.request.TransactionRequest;
import io.financialhouse.model.response.TransactionResponse;

@Service
public class TransactionService {

	private TransactionFeignClient transactionFeignClient;

	public TransactionService(TransactionFeignClient transactionFeignClient) {
		this.transactionFeignClient = transactionFeignClient;
	}

	public TransactionResponse findTransaction(String token,
			TransactionRequest transactionRequest) {
		return transactionFeignClient.findTransaction(token, transactionRequest);
	}
}
