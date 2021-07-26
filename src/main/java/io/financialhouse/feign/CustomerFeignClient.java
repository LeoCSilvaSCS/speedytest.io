package io.financialhouse.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import io.financialhouse.config.FeignConfig;
import io.financialhouse.model.request.TransactionRequest;
import io.financialhouse.model.response.TransactionConsumerInfoResponse;

@FeignClient(configuration = FeignConfig.class, name = "customerFeingClient", url = "${reporting.api.url}")
public interface CustomerFeignClient {

	@PostMapping(path = "/api/v3/client")
	TransactionConsumerInfoResponse findCustomer(@RequestHeader("Authorization") String bearerToken,
			@RequestBody TransactionRequest request);
}
