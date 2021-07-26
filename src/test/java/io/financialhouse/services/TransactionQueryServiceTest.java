package io.financialhouse.services;

import static org.mockito.Mockito.when;

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

import io.financialhouse.feign.TransactionQueryFeignClient;
import io.financialhouse.model.request.TransactionQueryRequest;
import io.financialhouse.model.response.MerchantLoginResponse;
import io.financialhouse.model.response.TransactionQueryDataResponse;
import io.financialhouse.model.response.TransactionQueryResponse;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class TransactionQueryServiceTest {

	@InjectMocks
	private TransactionQueryService transactionQueryService;

	@Mock
	private TransactionQueryFeignClient transactionQueryFeignClient;

	@Autowired
	private MerchantLoginService authenticationService;

	private MerchantLoginResponse merchantLoginResponse;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		merchantLoginResponse = authenticationService.authenticate();
	}

	@Test
	public void postTransactionQueryTestOK() {

		TransactionQueryRequest request = getRequest();
		TransactionQueryResponse response = getResponse();
		
		when(transactionQueryFeignClient.findTransactionList(Mockito.anyString(),
				Mockito.any(TransactionQueryRequest.class))).thenReturn(response);

		TransactionQueryResponse expectedResponse = transactionQueryService
				.findTransactionList(merchantLoginResponse.getToken(), request);
		Assert.assertNotNull(expectedResponse);
	}

	
	
	private TransactionQueryResponse getResponse() {
		TransactionQueryResponse response = new TransactionQueryResponse();
		response.setCurrent_page(null);
		response.setData(null);
		response.setFrom(null);
		response.setNext_page_url(null);
		response.setPer_page(null);
		response.setPrev_page_url(null);
		response.setTo(null);
		
		response.getCurrent_page();
		response.getData();
		response.getFrom();
		response.getNext_page_url();
		response.getPer_page();
		response.getPrev_page_url();
		response.getTo();
		response.toString();
		return response;
	}

	private TransactionQueryRequest getRequest() {
		TransactionQueryRequest request = new TransactionQueryRequest();
		request.setFromDate(null);
		request.setToDate(null);
		request.setMerchantId(null);
		request.setAcquirerId(null);
		request.setStatus(null);
		request.setOperation(null);
		request.setPaymentMethod(null);
		request.setFilterField(null);
		request.setFilterValue(null);
		request.setPage(null);
		request.setErrorCode(null);
		request.getFromDate();
		request.getToDate();
		request.getMerchantId();
		request.getAcquirerId();
		request.getStatus();
		request.getOperation();
		request.getPaymentMethod();
		request.getFilterField();
		request.getFilterValue();
		request.getPage();
		request.getErrorCode();
		request.toString();
		return request;
	}

}
