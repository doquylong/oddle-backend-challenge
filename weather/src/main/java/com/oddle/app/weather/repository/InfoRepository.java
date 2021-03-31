package com.oddle.app.weather.repository;

import com.oddle.app.weather.entity.Info;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends CrudRepository<Info, Integer> {
    List<Info> getInfoByNameAndDelFlg(String name, boolean delFlg);
    Info getByIdAndDelFlg(int id, boolean delFlg);
}
