package de.claudioaltamura.springboot.rest.model;

import lombok.Data;

@Data
public class Hero {

  private final long id;

  private final String name;

  private final double power;

  private final String realName;

  private final String city;

}
