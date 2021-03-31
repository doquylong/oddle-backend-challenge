package com.oddle.app.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @JsonProperty("temp")
    private float temp;

    @Column
    @JsonProperty("feels_like")
    private float feelsLike;

    @Column
    @JsonProperty("pressure")
    private float pressure;

    @Column
    @JsonProperty("humidity")
    private float humidity;

    @Column
    @JsonProperty("temp_min")
    private float tempMin;

    @Column
    @JsonProperty("temp_max")
    private float tempMax;

    @Column
    @JsonProperty("sea_level")
    private float seaLevel;

    @Column
    @JsonProperty("grnd_level")
    private float grndLevel;

}
