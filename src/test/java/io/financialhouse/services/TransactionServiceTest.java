package io.financialhouse.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.financialhouse.feign.TransactionFeignClient;
import io.financialhouse.model.request.TransactionReportRequest;
import io.financialhouse.model.request.TransactionRequest;
import io.financialhouse.model.response.MerchantLoginResponse;
import io.financialhouse.model.response.TransactionConsumerInfoResponse;
import io.financialhouse.model.response.TransactionReportDetailsResponse;
import io.financialhouse.model.response.TransactionReportResponse;
import io.financialhouse.model.response.TransactionResponse;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class TransactionServiceTest {

	@InjectMocks
	private TransactionService transactionService;

	@Mock
	private TransactionFeignClient transactionFeignClient;

	@Autowired
	private MerchantLoginService authenticationService;

	private MerchantLoginResponse merchantLoginResponse;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		merchantLoginResponse = authenticationService.authenticate();
	}

	@Test
	public void postTransactionReportTestOK() {
		TransactionRequest request = getRequest();
		TransactionResponse response = getResponse();
		
		when(transactionFeignClient.findTransaction(Mockito.anyString(), Mockito.any(TransactionRequest.class)))
				.thenReturn(response);

		TransactionResponse expectedResponse = transactionService.findTransaction(merchantLoginResponse.getToken(),
				request);
		Assert.assertNotNull(expectedResponse);
	}

	private TransactionResponse getResponse() {
		TransactionResponse response = new TransactionResponse();
		response.setCustomerInfo(null);
		response.setFx(null);
		response.setMerchant(null);
		response.setTransaction(null);
		response.getCustomerInfo();
		response.getFx();
		response.getMerchant();
		response.getTransaction();
		response.toString();
		return response;
	}

	private TransactionRequest getRequest() {
		TransactionRequest request = new TransactionRequest();
		request.setTransactionId(null);
		request.getTransactionId();
		request.toString();
		return request;
	}

}
