package com.oddle.app.weather.repository;

import com.oddle.app.weather.entity.Main;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends CrudRepository<Main,Integer> {
}
