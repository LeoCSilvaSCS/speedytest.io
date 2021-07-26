package io.financialhouse.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
public class TransactionReportResponse {

	private String status;
	private List<TransactionReportDetailsResponse> response;
	
}
