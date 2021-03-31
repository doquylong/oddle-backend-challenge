package com.oddle.app.weather.repository;

import com.oddle.app.weather.entity.System;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends CrudRepository<System,Integer> {
}
