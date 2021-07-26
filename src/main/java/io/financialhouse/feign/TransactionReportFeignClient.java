package io.financialhouse.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import io.financialhouse.config.FeignConfig;
import io.financialhouse.model.request.TransactionReportRequest;
import io.financialhouse.model.response.TransactionReportResponse;


@FeignClient(configuration = FeignConfig.class, name = "transactionReportFeingClient", url = "${reporting.api.url}")
public interface TransactionReportFeignClient {

   @PostMapping(path = "/api/v3/transactions/report")
   TransactionReportResponse sendTransactionReport(
           @RequestHeader("Authorization") String bearerToken,
           @RequestBody TransactionReportRequest request
   );
}
