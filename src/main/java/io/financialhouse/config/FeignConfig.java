package io.financialhouse.config;

import java.io.Serializable;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLSocketFactory;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import feign.Client;
import feign.Logger;

@Configuration
public class FeignConfig implements Serializable {

	private static final long serialVersionUID = -931446298459764803L;

	@Bean
	Logger.Level feignClientLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	@Profile({ "dev" })
	public Client feignClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		return new Client.Default(disableSSl(), new NoopHostnameVerifier());
	}

	private SSLSocketFactory disableSSl() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
			@Override
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				return true;
			}
		};
		return org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build()
				.getSocketFactory();
	}

}
