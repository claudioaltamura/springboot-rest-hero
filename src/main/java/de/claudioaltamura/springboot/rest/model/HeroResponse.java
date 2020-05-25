package de.claudioaltamura.springboot.rest.model;

import lombok.Value;

@Value(staticConstructor="of")
public class HeroResponse {

  private final long id;

  private final String name;

  private final double power;

  private final String realName;

  private final String city;

}
