package com.oddle.app.weather.repository;

import com.oddle.app.weather.entity.Wind;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindRepository extends CrudRepository<Wind,Integer> {
}
