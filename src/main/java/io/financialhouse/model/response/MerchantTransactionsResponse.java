package io.financialhouse.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
public class MerchantTransactionsResponse {

	private String referenceNo;
	private Integer merchantId;
	private String status;
	private String channel;
	private String customData;
	private String chainId;
	private Integer agentInfoId;
	private String operation;
	private Integer fxTransactionId;
	private String updated_at;
	private String created_at;
	private Integer acquirerTransactionId;
	private String code;
	private String message;
	private String transactionId;
	private TransactionMerchantAgentResponse agent;
}
