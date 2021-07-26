package io.financialhouse.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FeignConfigTest {

	@InjectMocks
	private FeignConfig feignConfig;

	@Test
	public void allConfigsTest() throws KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		Assert.assertNotNull(feignConfig.feignClient());
		Assert.assertNotNull(feignConfig.feignClientLoggerLevel());
	}

}
