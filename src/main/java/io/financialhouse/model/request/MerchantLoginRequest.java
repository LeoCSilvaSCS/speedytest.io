package io.financialhouse.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MerchantLoginRequest {

	private String email;
	private String password;	 
}
