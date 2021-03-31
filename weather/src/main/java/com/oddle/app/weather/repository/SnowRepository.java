package com.oddle.app.weather.repository;

import com.oddle.app.weather.entity.Snow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnowRepository extends CrudRepository<Snow,Integer> {
}
