package com.marcin.nbp.api;

import com.marcin.nbp.Model.CurrencyModel;
import com.marcin.nbp.Model.GoldModel;
import com.marcin.nbp.Model.UsdLastWeekModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class NbpController {

    /*
    currrencyCode example: usd
    table example: a
     */

    @GetMapping("/exchangerates/{currencyCode}/{table}")
    public CurrencyModel getRate(@PathVariable String currencyCode, @PathVariable String table) {

        String url = "http://api.nbp.pl/api/exchangerates/rates/"
            + table + "/" + currencyCode + "/?format=json";
        RestTemplate restTemplate = new RestTemplate();
        CurrencyModel currencyModel = (CurrencyModel) restTemplate.getForObject(url, CurrencyModel.class);
        System.out.println(currencyModel.getRates());
        return currencyModel;

    }

    @GetMapping("/usdlastweek")
    public UsdLastWeekModel getRates() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/last/7/?format=json";

        RestTemplate restTemplate = new RestTemplate();
        UsdLastWeekModel usdLastWeekModel = (UsdLastWeekModel) restTemplate.getForObject(url, UsdLastWeekModel.class);

        return usdLastWeekModel;
    }

    @GetMapping("/getgold")
    public List<GoldModel> getGoldCost() {

        //  String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/?format=json";
        String url = "http://api.nbp.pl/api/cenyzlota?format=json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<GoldModel>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<GoldModel>>() {
        });
        List<GoldModel> goldModels = response.getBody();

        return goldModels;
    }

}
