package com.oddle.app.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("internalId")
    private int id;

    @Column
    @JsonProperty("id")
    private String cityId;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("timezone")
    private String timezone;

    @Column
    @JsonProperty("dt")
    private long datetime;

    @Column
    @JsonProperty("lon")
    private String lon;

    @Column
    @JsonProperty("lat")
    private String lat;

    @Column
    @JsonProperty("clouds")
    private float clouds;

    @JsonProperty("coord")
    public void setCoord(Map<String, String> coord){
        this.lon = coord.get("lon");
        this.lat = coord.get("lat");
    }

    @JsonProperty("clouds")
    public void setClouds(Map<String, Float> clouds){
        this.clouds = clouds.get("all");
    }

    @Column
    @JsonProperty("weather")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "info", cascade = CascadeType.ALL)
    private List<Weather> weather = new ArrayList<>();

    @JsonProperty("main")
    @OneToOne
    @JoinColumn(name = "mainId", unique = true)
    private Main main;

    @JsonProperty("wind")
    @OneToOne
    @JoinColumn(name = "windId",  unique = true)
    private Wind wind;

    @JsonProperty("rain")
    @OneToOne
    @JoinColumn(name = "rainId",  unique = true)
    private Rain rain;

    @JsonProperty("snow")
    @OneToOne
    @JoinColumn(name = "snowId",  unique = true)
    private Snow snow;

    @JsonProperty("sys")
    @OneToOne
    @JoinColumn(name = "sysId",  unique = true)
    private System system;

    @JsonIgnore
    @Column(columnDefinition = "boolean default false")
    private boolean delFlg;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public float getClouds() {
        return clouds;
    }

    public void setClouds(float clouds) {
        this.clouds = clouds;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public boolean isDelFlg() {
        return delFlg;
    }

    public void setDelFlg(boolean delFlg) {
        this.delFlg = delFlg;
    }
}
