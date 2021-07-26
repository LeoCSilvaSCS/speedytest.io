package io.financialhouse.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
public class TransactionReportDetailsResponse {

	/**
	 * Quantity transaction
	 */
	private Integer count;
	/**
	 * Total amount
	 */
	private Integer total;
	/**
	 * Original currency
	 */
	private String currency;

}
