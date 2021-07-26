package io.financialhouse.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import io.financialhouse.model.request.TransactionQueryRequest;
import io.financialhouse.model.response.TransactionQueryResponse;

@FeignClient(name = "transactionQuery", url = "${reporting.api.url}")
public interface TransactionQueryFeignClient {

	@PostMapping("/api/v3/transaction/list")
	TransactionQueryResponse findTransactionList(@RequestHeader("Authorization") String bearerToken,
			@RequestBody TransactionQueryRequest request);

}
