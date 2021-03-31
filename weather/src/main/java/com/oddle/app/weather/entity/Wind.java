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
public class Wind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @JsonProperty("speed")
    private float speed;

    @Column
    @JsonProperty("deg")
    private float deg;

    @Column
    @JsonProperty("gust")
    private float gust;

}
