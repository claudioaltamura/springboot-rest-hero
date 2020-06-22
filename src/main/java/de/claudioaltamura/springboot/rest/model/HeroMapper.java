package de.claudioaltamura.springboot.rest.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class HeroMapper {

  private HeroMapper() {}

  public static HeroResponse map2Response(Hero hero){
    return HeroResponse.of(hero.getId(), hero.getName(), hero.getPower(), hero.getRealName(), hero.getCity());
  }

  public static List<HeroResponse> map2ListResponse(Collection<Hero> heroes) {
    return heroes.stream().map(HeroMapper::map2Response).collect(Collectors.toList());
  }

  public static Hero map2Hero(long id, HeroRequest heroRequest) {
    return new Hero(id, heroRequest.getName(), heroRequest.getPower(), heroRequest.getRealName(), heroRequest.getCity());
  }

  public static Hero map2Hero(long id, HeroRequestWithId heroRequest) {
    return new Hero(id, heroRequest.getName(), heroRequest.getPower(), heroRequest.getRealName(), heroRequest.getCity());
  }

}
