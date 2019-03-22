package com.marcin.nbp.service;

import com.marcin.nbp.Model.UsdLastWeekModel;
import org.springframework.web.client.RestTemplate;

public class UsdLastWeekService {

    public UsdLastWeekModel getUsdLastWeek() {

        String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/last/7/?format=json";
        RestTemplate restTemplate = new RestTemplate();
        UsdLastWeekModel usdLastWeekModel = (UsdLastWeekModel) restTemplate.getForObject(url, UsdLastWeekModel.class);

        return usdLastWeekModel;

    }

}
