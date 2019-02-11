package com.marcin.nbp.controller;

import com.marcin.nbp.service.UsdLastWeekService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;


@Controller
public class MainController {

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("currencies",
            Arrays.asList("eur", "usd", "chf"));
        return "index";
    }

    @GetMapping("/usd7days")
    public String getUsdRates(ModelMap modelMap) {

        UsdLastWeekService usdLastWeekService = new UsdLastWeekService();
        usdLastWeekService.getUsdLastWeek().getRates();
        modelMap.addAttribute("usdLastWeekService", usdLastWeekService);

        return "usd7days";
    }
    @GetMapping("/goldrate")
    public String getGoldRate(){


    return "gold";
}
}