package de.claudioaltamura.springboot.rest.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class HeroConverter {

  private HeroConverter() {}

  public static HeroResponse convert2Response(Hero hero){
    return HeroResponse.of(hero.getId(), hero.getName(), hero.getPower(), hero.getRealName(), hero.getCity());
  }

  public static List<HeroResponse> convert2ListResponse(Collection<Hero> heroes) {
    return heroes.stream().map(HeroConverter::convert2Response).collect(Collectors.toList());
  }

  public static Hero convert2Hero(long id, HeroRequest heroRequest) {
    return new Hero(id, heroRequest.getName(), heroRequest.getPower(), heroRequest.getRealName(), heroRequest.getCity());
  }
}
