package com.marcin.nbp.controller;

import com.marcin.nbp.service.UsdLastWeekService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


@Controller
public class MainController {

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("currencies",
            Arrays.asList("eur", "usd", "chf"));
        return "index";
    }
    @GetMapping("/rate")
    public String rate(ModelMap modelMap) {
        modelMap.addAttribute("currencies",
            Arrays.asList("eur", "usd", "chf"));
        return "form";
    }
    @PostMapping("/rates")
    public String rates(@RequestParam String cur, ModelMap modelMap){
        modelMap.addAttribute("currency", cur);
        return "rate";
    }

    @GetMapping("/usd7")
    public String getUsdRates(ModelMap modelMap) {

        UsdLastWeekService usdLastWeekService = new UsdLastWeekService();
        modelMap.addAttribute("usdLastWeekService", usdLastWeekService);

        return "usd7days";
    }
    @GetMapping("/goldrate")
    public String getGoldRate(){

    return "gold";
}
}