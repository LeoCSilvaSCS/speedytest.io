package io.financialhouse.model.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@NoArgsConstructor
public class MerchantLoginResponse {

	private String token;
	private String status;
	private LocalDate tokenExpiered;
}
