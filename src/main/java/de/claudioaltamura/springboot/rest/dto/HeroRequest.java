package de.claudioaltamura.springboot.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@ToString
public class HeroRequest {

  @NotBlank
  private final String name;

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "100.0")
  private final double power;

  @NotBlank
  private final String realName;

  @NotBlank
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
