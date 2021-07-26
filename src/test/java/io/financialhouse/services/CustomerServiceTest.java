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

import io.financialhouse.feign.CustomerFeignClient;
import io.financialhouse.model.request.TransactionRequest;
import io.financialhouse.model.response.MerchantLoginResponse;
import io.financialhouse.model.response.TransactionConsumerInfoResponse;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService customerService;

	@Mock
	private CustomerFeignClient customerFeignClient;

	@Autowired
	private MerchantLoginService authenticationService;

	private MerchantLoginResponse merchantLoginResponse;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		merchantLoginResponse = authenticationService.authenticate();
	}

	@Test
	public void postcustomerTestOK() {
		TransactionConsumerInfoResponse response = createResponse();

		TransactionRequest request = new TransactionRequest();
		request.setTransactionId(null);
		request.getTransactionId();

		when(customerFeignClient.findCustomer(Mockito.anyString(), Mockito.any(TransactionRequest.class)))
				.thenReturn(response);

		TransactionConsumerInfoResponse expectedResponse = customerService
				.findCustomer(merchantLoginResponse.getToken(), request);
		Assert.assertNotNull(expectedResponse);
	}

	private TransactionConsumerInfoResponse createResponse() {
		TransactionConsumerInfoResponse response = new TransactionConsumerInfoResponse();
		
		response.setId(null);
		response.setCreated_at(null);
		response.setUpdated_at(null);
		response.setDeleted_at(null);
		response.setNumber(null);
		response.setExpiryMonth(null);
		response.setStartMonth(null);
		response.setStartYear(null);
		response.setEmail(null);
		response.setBillingAddress1(null);
		response.setBillingAddress2(null);
		response.setBillingCity(null);
		response.setBillingCompany(null);
		response.setBillingCountry(null);
		response.setBillingFax(null);
		response.setBillingFirstName(null);
		response.setBillingLastName(null);
		response.setBillingPhone(null);
		response.setBillingPostcode(null);
		response.setBillingState(null);
		response.setBillingTitle(null);
		response.setBirthday(null);
		response.setCreated_at(null);
		response.setDeleted_at(null);
		response.setEmail(null);
		response.setExpiryMonth(null);
		response.setExpiryTear(null);
		response.setGender(null);
		response.setBillingTitle(null);
		response.setBillingCompany(null);
		response.setBillingAddress1(null);
		response.setBillingAddress2(null);
		response.setBillingCity(null);
		response.setBillingPostcode(null);
		response.setBillingState(null);
		response.setBillingPhone(null);
		response.setBillingFax(null);
		response.setShippingTitle(null);
		response.setShippingFirstName(null);
		response.setShippingLastName(null);
		response.setShippingCompany(null);
		response.setShippingAddress1(null);
		response.setShippingAddress2(null);
		response.setShippingCity(null);
		response.setShippingPostcode(null);
		response.setShippingState(null);
		response.setShippingCountry(null);
		response.setShippingPhone(null);
		response.setShippingFax(null);

		response.getId();
		response.getCreated_at();
		response.getUpdated_at();
		response.getDeleted_at();
		response.getNumber();
		response.getExpiryMonth();
		response.getStartMonth();
		response.getStartYear();
		response.getEmail();
		response.getBillingAddress1();
		response.getBillingAddress2();
		response.getBillingCity();
		response.getBillingCompany();
		response.getBillingCountry();
		response.getBillingFax();
		response.getBillingFirstName();
		response.getBillingLastName();
		response.getBillingPhone();
		response.getBillingPostcode();
		response.getBillingState();
		response.getBillingTitle();
		response.getBirthday();
		response.getCreated_at();
		response.getDeleted_at();
		response.getEmail();
		response.getExpiryMonth();
		response.getExpiryTear();
		response.getGender();
		response.getBillingTitle();
		response.getBillingCompany();
		response.getBillingAddress1();
		response.getBillingAddress2();
		response.getBillingCity();
		response.getBillingPostcode();
		response.getBillingState();
		response.getBillingPhone();
		response.getBillingFax();
		response.getShippingTitle();
		response.getShippingFirstName();
		response.getShippingLastName();
		response.getShippingCompany();
		response.getShippingAddress1();
		response.getShippingAddress2();
		response.getShippingCity();
		response.getShippingPostcode();
		response.getShippingState();
		response.getShippingCountry();
		response.getShippingPhone();
		response.getShippingFax();
		response.toString();
		return response;
	}

}
