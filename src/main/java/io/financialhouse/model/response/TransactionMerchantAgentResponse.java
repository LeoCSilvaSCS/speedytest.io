package io.financialhouse.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
public class TransactionMerchantAgentResponse {

	private Integer id;
	private String customerIp;
	private String customerUserAgent;
	private String merchantIp;
	
}
