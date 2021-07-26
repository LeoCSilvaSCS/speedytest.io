package io.financialhouse.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
public class TransactionQueryDataAcquirer {

	private Integer id;
	private String name;
	private String code;
	private String type;
	
}
