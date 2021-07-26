package io.financialhouse.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import io.financialhouse.config.FeignConfig;
import io.financialhouse.model.request.TransactionRequest;
import io.financialhouse.model.response.TransactionResponse;

@FeignClient(configuration = FeignConfig.class, name = "transactionFeingClient", url = "${reporting.api.url}")
public interface TransactionFeignClient {

	@PostMapping(path = "/api/v3/transaction")
	TransactionResponse findTransaction(@RequestHeader("Authorization") String bearerToken,
			@RequestBody TransactionRequest request);
}
