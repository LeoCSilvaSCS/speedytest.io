package io.financialhouse.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.financialhouse.model.request.MerchantLoginRequest;
import io.financialhouse.model.response.MerchantLoginResponse;

@FeignClient(name = "merchantLogin", url = "${reporting.api.url}")
public interface MerchantLoginFeignClient {

	@PostMapping("/api/v3/merchant/user/login")
	MerchantLoginResponse authenticate(@RequestBody MerchantLoginRequest merchantLoginRequest);

}
