package io.financialhouse.services;

import org.springframework.stereotype.Service;

import io.financialhouse.feign.TransactionReportFeignClient;
import io.financialhouse.model.request.TransactionReportRequest;
import io.financialhouse.model.response.TransactionReportResponse;

@Service
public class TransactionReportService {

	private TransactionReportFeignClient transactionReportFeignClient;

	public TransactionReportService(TransactionReportFeignClient transactionReportFeignClient) {
		this.transactionReportFeignClient = transactionReportFeignClient;
	}

	public TransactionReportResponse getTransactionReportBy(String token,
			TransactionReportRequest transactionReportRequest) {
		return transactionReportFeignClient.sendTransactionReport(token, transactionReportRequest);
	}
}
