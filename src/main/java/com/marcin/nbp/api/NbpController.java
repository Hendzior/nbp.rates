package com.marcin.nbp.api;

import com.marcin.nbp.Model.CurrencyModel;
import com.marcin.nbp.Model.GoldModel;
import com.marcin.nbp.Model.UsdLastWeekModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class NbpController {

    private RestTemplate restTemplate;

    public NbpController(RestTemplateBuilder rest) {
        this.restTemplate = rest.build();
    }

    /*
    currrencyCode example: usd
    table example: a
     */
    @GetMapping("/exchangerates/{currencyCode}/{table}")
    public CurrencyModel getRate(@PathVariable String currencyCode, @PathVariable String table) {

        String url = "http://api.nbp.pl/api/exchangerates/rates/"
            + table + "/" + currencyCode + "/?format=json";
        CurrencyModel currencyModel = restTemplate.getForObject(url, CurrencyModel.class);
        return currencyModel;
    }

    @GetMapping("/usdlastweek")
    public UsdLastWeekModel getRates() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/last/7/?format=json";
        return restTemplate.getForObject(url, UsdLastWeekModel.class);
    }

    @GetMapping("/history/exchangerates/{currencyCode}/{noOfDays}/")
    public UsdLastWeekModel getHistoryRates(@PathVariable String currencyCode, @PathVariable int noOfDays) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/" + currencyCode + "/last/" + noOfDays + "/?format=json";
        return restTemplate.getForObject(url, UsdLastWeekModel.class);
    }

    @GetMapping("/gold")
    public GoldModel gold() {
        String url = "http://api.nbp.pl/api/cenyzlota?format=json";
        ResponseEntity<List<GoldModel>> response = restTemplate.exchange(url, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<GoldModel>>() {
            });
        Optional<GoldModel> opt = Optional.of(Objects.requireNonNull(response.getBody()).get(0));
             return opt.get();
     }
}
