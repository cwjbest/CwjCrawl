package com.jwc.ssm.handlers;

//import com.jwc.ssm.service.FiveLeaguesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cwj on 17-5-23.
 *
 */
@Controller
public class FiveLeaguesHandler {

    @Autowired
//    private FiveLeaguesServiceImpl fiveLeaguesService;

    @RequestMapping("/football")
    public String list(Map<String,Object> map){
//        map.put("fiveLeagues",fiveLeaguesService.findAll());
        return "football";
    }

    @RequestMapping("/select")
    public String select(String season, String continent, String country, Map<String, Object> map){
        String[] seasons = (season == null ? null : season.split(","));
        String[] continents = (continent == null ? null : continent.split(","));
        String[] countries = (country == null ? null : country.split(","));
        Map<String, String[]> params = new HashMap<String, String[]>(3);
        params.put("seasons",seasons);
        params.put("continents",continents);
        params.put("countries",countries);

//        for (Map.Entry<String, String[]> entry : params.entrySet()){
//            for (String str:entry.getValue()) {
//                System.out.println(entry.getKey() + ":" + str);
//            }
//        }

        String isSeasonsEmpty = params.get("seasons") == null ? "true" : "false";
        String isContinentsEmpty = params.get("continents") == null ? "true" : "false";
        String isCountriesEmpty = params.get("countries") == null ? "true" : "false";

        System.out.println(isSeasonsEmpty + isContinentsEmpty + isCountriesEmpty);
//        map.put("fiveLeagues",fiveLeaguesService.findBySCC(params, isSeasonsEmpty, isContinentsEmpty, isCountriesEmpty));
        return "football";
    }
}
