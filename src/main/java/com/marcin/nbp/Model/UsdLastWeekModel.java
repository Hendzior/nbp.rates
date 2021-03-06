package com.marcin.nbp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsdLastWeekModel {

    @JsonProperty("currency")
    private String currencyName;

    @JsonProperty("code")
    private String currencyShortCode;

    @JsonProperty("rates")
    private List<UsdBidModel> rates;

    @Data
    public static class UsdBidModel {

        @JsonProperty("effectiveDate")
        private LocalDate localDate;

        @JsonProperty("bid")
        private double bid;

        @JsonProperty("mid")
        private double mid;

    }

}
