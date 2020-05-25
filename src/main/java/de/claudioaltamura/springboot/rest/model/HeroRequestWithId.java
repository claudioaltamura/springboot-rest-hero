package de.claudioaltamura.springboot.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HeroRequestWithId {

  private final long id;

  private final String name;

  private final double power;

  private final String realName;

  private final String city;

  @JsonCreator
  public HeroRequestWithId(
      @JsonProperty("id") long id,
      @JsonProperty("name") String name,
      @JsonProperty("power") double power,
      @JsonProperty("realName") String realName,
      @JsonProperty("city") String city) {
    this.id = id;
    this.name = name;
    this.power = power;
    this.realName = realName;
    this.city = city;
  }

}