package io.financialhouse.services;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import io.financialhouse.feign.MerchantLoginFeignClient;
import io.financialhouse.model.request.MerchantLoginRequest;
import io.financialhouse.model.response.MerchantLoginResponse;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class MerchantLoginServiceTest {

	private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6MSwicm9sZSI6ImFkbWluIiwibWVyY2hhbnRJZCI6MSwic3ViTWVyYhhbnRJZHMiOltdLCJ0aW1lc3RhbXAiOjE0NDQzODk4ODB9.zPxVu4fky1uG2fO3X2RbxiI4otK_HG7M4MMTB298";

	@InjectMocks
	private MerchantLoginService merchantLoginService;

	@Mock
	private MerchantLoginFeignClient merchantLoginFeignClient;

	@Test
	public void authenticateTestOk() {
		MerchantLoginRequest request = new MerchantLoginRequest();
		request.setEmail("demo@financialhouse.io");
		request.setPassword("cjaiU8CV");
		request.getEmail();
		request.getPassword();
		request.toString();

		MerchantLoginResponse response = new MerchantLoginResponse();
		response.setStatus("APPROVED");
		response.setToken(token);
		response.toString();
		response.setTokenExpiered(null);
		response.getTokenExpiered();
		response.toString();

		when(merchantLoginFeignClient.authenticate(Mockito.any(MerchantLoginRequest.class))).thenReturn(response);

		MerchantLoginResponse expectedResponse = merchantLoginService.authenticate();
		expectedResponse.setTokenExpiered(LocalDate.now());

		Assert.assertEquals(expectedResponse.getToken(), this.token);
	}

}
