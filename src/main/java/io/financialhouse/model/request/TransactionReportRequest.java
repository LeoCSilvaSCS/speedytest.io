package io.financialhouse.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionReportRequest {
	
	private String fromDate;
	private String toDate;
	private Integer merchant;
	private Integer acquirer;
}
