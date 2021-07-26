package io.financialhouse.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
public class TransactionQueryDataTransactionMerchantResponse {

	private String referenceNo;
	private String status;
	private String operation;
	private String message;
	private String created_at;
	private String transactionId;

}
