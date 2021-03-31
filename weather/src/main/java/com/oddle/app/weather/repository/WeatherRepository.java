package com.oddle.app.weather.repository;

import com.oddle.app.weather.entity.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<Weather,Integer> {
}
