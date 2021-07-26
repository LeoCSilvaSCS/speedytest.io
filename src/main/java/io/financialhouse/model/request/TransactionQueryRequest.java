package io.financialhouse.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionQueryRequest {

	private String fromDate;
	private String toDate;
	private Integer merchantId;
	private Integer acquirerId;
	private String status;
	private String operation;
	private String paymentMethod;
	/**
	 * Search by special field
	 */
	private String filterField;
	private String filterValue;
	private Integer page;
	private String errorCode;

}
