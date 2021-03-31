package com.oddle.app.weather.controller;

import com.oddle.app.weather.entity.Response;
import com.oddle.app.weather.service.InfoService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class WeatherController {
    private final InfoService infoService;

    public WeatherController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("")
    public String doc() {
        return "Please access <a href=\"http://localhost:8080/swagger-ui.html\">this link</a>  to redirect to APIs infomation page";
    }

    @GetMapping("/info")
    public Response getInfo(@RequestParam("q") String cityName) {
        return infoService.getInfo(cityName);
    }

    @GetMapping("/save")
    public Response saveInfo(@RequestParam("q") String cityName) {
        return infoService.saveInfo(cityName);
    }

    @GetMapping("/history")
    public Response history(@RequestParam("q") String cityName) {
        return infoService.getInfoInDB(cityName);
    }

    @DeleteMapping("/info/{id}")
    public Response delete(@PathVariable("id") int id) {
        return infoService.delete(id);
    }

    @DeleteMapping("/info")
    public Response delete(@RequestParam("q") String cityName) {
        return infoService.delete(cityName);
    }
}