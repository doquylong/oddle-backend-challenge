package com.oddle.app.weather.repository;

import com.oddle.app.weather.entity.Rain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RainRepository extends CrudRepository<Rain,Integer> {
}
