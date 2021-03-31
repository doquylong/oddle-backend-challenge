package com.oddle.app.weather.service.impl;

import com.oddle.app.weather.entity.*;
import com.oddle.app.weather.repository.*;
import com.oddle.app.weather.service.InfoService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class InfoserviceImpl implements InfoService {

    private final Logger logger = LoggerFactory.logger(InfoserviceImpl.class);

    private final RestTemplate restTemplate;
    private final InfoRepository infoDao;
    private final MainRepository mainDao;
    private final RainRepository rainDao;
    private final SnowRepository snowDao;
    private final SystemRepository sysDao;
    private final WindRepository windDao;

    final String uri = "https://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={apiKey}";

    @Value("${weather.apikey}")
    private String apiKey;

    public InfoserviceImpl(RestTemplate restTemplate, InfoRepository infoDao, MainRepository mainDao, RainRepository rainDao, SnowRepository snowDao, SystemRepository sysDao, WindRepository windDao) {
        this.restTemplate = restTemplate;
        this.infoDao = infoDao;
        this.mainDao = mainDao;
        this.rainDao = rainDao;
        this.snowDao = snowDao;
        this.sysDao = sysDao;
        this.windDao = windDao;
    }

    @Override
    public Response getInfo(String cityName) {
        ResponseEntity<Info> info = null;
        Response res = null;
        try {
            info = restTemplate.getForEntity(uri, Info.class, cityName, apiKey);
            res = new Response(info);
        } catch (HttpClientErrorException ex) {
            logger.error(ex.getMessage());
            JSONObject json = new JSONObject(ex.getResponseBodyAsString());
            res = new Response(ex.getRawStatusCode(), json.getString("message"), null);
        }
        return res;
    }

    @Override
    public void saveInfo(Info info) {
        mainDao.save(info.getMain());
        Rain rain = info.getRain();
        if (rain != null) rainDao.save(rain);
        Snow snow = info.getSnow();
        if (snow != null) snowDao.save(snow);
        sysDao.save(info.getSystem());
        for (Weather w : info.getWeather()) {
            w.setId(UUID.randomUUID().toString());
            w.setInfo(info);
        }
        windDao.save(info.getWind());
        infoDao.save(info);
    }

    @Override
    public Response saveInfo(String cityName) {
        Response res = getInfo(cityName);
        if (res.getStatus() == HttpStatus.OK.value()) {
            try {
                Info info = (Info) res.getData();
                saveInfo(info);
                res.setData(info.getName());
            } catch (Exception ex) {
                logger.error(ex.getMessage());
                res.setData(null);
                res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                res.setMessage("An error occurred while saving data");
                return res;
            }

        }
        return res;
    }

    @Override
    public Response getInfoInDB(String cityName) {
        List<Info> infoList;
        try {
            infoList = infoDao.getInfoByNameAndDelFlg(cityName, false);
            return new Response(HttpStatus.OK.value(), "OK", infoList);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred while query data", null);
        }
    }

    @Override
    public Response delete(String cityName) {
        List<Info> infoList;
        try {
            infoList = infoDao.getInfoByNameAndDelFlg(cityName, false);
            if (infoList != null || infoList.size() > 0) {
                for (Info info : infoList) {
                    info.setDelFlg(true);
                    infoDao.save(info);
                }
            }
            return new Response(HttpStatus.OK.value(), "OK", null);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred while update data", null);
        }
    }

    @Override
    public Response delete(int id) {
        try {
            Info info = infoDao.getByIdAndDelFlg(id, false);
            if (info != null) {
                info.setDelFlg(true);
                infoDao.save(info);
            }
            return new Response(HttpStatus.OK.value(), "OK", null);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred while update data", null);
        }
    }


}
