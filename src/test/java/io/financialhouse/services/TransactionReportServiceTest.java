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

import io.financialhouse.feign.TransactionReportFeignClient;
import io.financialhouse.model.request.TransactionReportRequest;
import io.financialhouse.model.response.MerchantLoginResponse;
import io.financialhouse.model.response.TransactionReportDetailsResponse;
import io.financialhouse.model.response.TransactionReportResponse;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class TransactionReportServiceTest {

	@InjectMocks
	private TransactionReportService transactionReportService;

	@Mock
	private TransactionReportFeignClient transactionReportFeignClient;

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
		TransactionReportRequest request = getTransactionReportRequest();
		TransactionReportResponse response = getTransactionResponse();
		when(transactionReportFeignClient.sendTransactionReport(Mockito.anyString(),
				Mockito.any(TransactionReportRequest.class))).thenReturn(response);

		TransactionReportResponse expectedResponse = transactionReportService
				.getTransactionReportBy(merchantLoginResponse.getToken(), request);
		Assert.assertEquals(response.getStatus(), expectedResponse.getStatus());
	}

	private TransactionReportResponse getTransactionResponse() {
		TransactionReportResponse response = new TransactionReportResponse();
		response.setStatus("APPROVED");
		response.setResponse(getTransactionReportDetailList());
		response.getResponse();
		response.getStatus();
		response.toString();
		return response;
	}

	private List<TransactionReportDetailsResponse> getTransactionReportDetailList() {
		List<TransactionReportDetailsResponse> responseList = new ArrayList<>();
		TransactionReportDetailsResponse responseDetail = new TransactionReportDetailsResponse();
		responseDetail.setCount(283);
		responseDetail.setTotal(28300);
		responseDetail.setCurrency("USD");
		responseList.add(responseDetail);
		responseDetail = new TransactionReportDetailsResponse();
		responseDetail.setCount(280);
		responseDetail.setTotal(1636515);
		responseDetail.setCurrency("EUR");
		responseDetail.getCount();
		responseDetail.getTotal();
		responseDetail.getCurrency();
		responseDetail.toString();
		responseList.add(responseDetail);
		return responseList;
	}

	private TransactionReportRequest getTransactionReportRequest() {
		TransactionReportRequest request = new TransactionReportRequest();
		request.setAcquirer(1);
		request.setFromDate("2015-07-01");
		request.setMerchant(1);
		request.setToDate("2015-10-01");
		request.getAcquirer();
		request.getFromDate();
		request.getMerchant();
		request.getToDate();
		request.toString();
		return request;
	}

}
