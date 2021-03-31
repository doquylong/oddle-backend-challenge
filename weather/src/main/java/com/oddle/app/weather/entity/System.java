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
public class System {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @JsonProperty("message")
    private float message;

    @Column
    @JsonProperty("country")
    private String country;

    @Column
    @JsonProperty("sunrise")
    private long sunrise;

    @Column
    @JsonProperty("sunset")
    private long sunset;

}
