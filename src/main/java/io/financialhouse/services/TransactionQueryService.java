package io.financialhouse.services;

import org.springframework.stereotype.Service;

import io.financialhouse.feign.TransactionQueryFeignClient;
import io.financialhouse.model.request.TransactionQueryRequest;
import io.financialhouse.model.response.TransactionQueryResponse;

@Service
public class TransactionQueryService {

	private TransactionQueryFeignClient transactionQueryFeignClient;

	public TransactionQueryService(TransactionQueryFeignClient transactionQueryFeignClient) {
		this.transactionQueryFeignClient = transactionQueryFeignClient;
	}

	public TransactionQueryResponse findTransactionList(String token,
			TransactionQueryRequest transactionQueryRequest) {
		return transactionQueryFeignClient.findTransactionList(token, transactionQueryRequest);
	}
}
