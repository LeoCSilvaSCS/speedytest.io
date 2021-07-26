package io.financialhouse.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
public class TransactionResponse {

	private TransactionFXInformationResponse fx;	
	private TransactionConsumerInfoResponse customerInfo;
	private MerchantResponse merchant;
	private TransactionMerchantResponse transaction;
	

}
