package de.claudioaltamura.springboot.rest.model;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Hero {

  @EqualsAndHashCode.Include
  @ToString.Include
  private final long id;

  private String name;

  private double power;

  private String realName;

  private String city;

}
