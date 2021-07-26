package io.financialhouse.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.financialhouse.feign.MerchantLoginFeignClient;
import io.financialhouse.model.request.MerchantLoginRequest;
import io.financialhouse.model.response.MerchantLoginResponse;


@Service
public class MerchantLoginService {
	
    @Value("${merchant.login.email}")
    private String email;

    @Value("${merchant.login.password}")
    private String password;

    private MerchantLoginFeignClient merchantClient;

	public MerchantLoginService(MerchantLoginFeignClient merchantClient) {
		this.merchantClient = merchantClient;
	}
    
    public MerchantLoginResponse authenticate() {

        var merchantLoginRequest = new MerchantLoginRequest();
        merchantLoginRequest.setEmail(email);
        merchantLoginRequest.setPassword(password);
        //Implement cache
        var merchantLoginResponse = merchantClient.authenticate(merchantLoginRequest);

        return merchantLoginResponse;
    }

}
