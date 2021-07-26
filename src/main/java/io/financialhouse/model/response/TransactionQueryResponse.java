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
public class TransactionQueryResponse {

	private Integer per_page;
	private Integer current_page;
	private String next_page_url;
	private String prev_page_url;
	private Integer from;
	private Integer to;
	private List<TransactionQueryDataResponse> data;

}
