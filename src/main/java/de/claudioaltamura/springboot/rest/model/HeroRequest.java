package de.claudioaltamura.springboot.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HeroRequest {

  private final String name;

  private final double power;

  private final String realName;

  private final String city;

  @JsonCreator
  public HeroRequest(
      @JsonProperty("name") String name,
      @JsonProperty("power") double power,
      @JsonProperty("realName") String realName,
      @JsonProperty("city") String city) {
    this.name = name;
    this.power = power;
    this.realName = realName;
    this.city = city;
  }

}
