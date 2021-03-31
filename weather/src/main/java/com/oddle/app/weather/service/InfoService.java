package com.oddle.app.weather.service;

import com.oddle.app.weather.entity.Info;
import com.oddle.app.weather.entity.Response;

public interface InfoService {
    Response getInfo (String cityName);
    void saveInfo (Info info);
    Response saveInfo (String cityName);
    Response getInfoInDB(String cityName);
    Response delete(String cityName);
    Response delete(int id);
}
