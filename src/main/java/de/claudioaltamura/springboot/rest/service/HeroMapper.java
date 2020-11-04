package de.claudioaltamura.springboot.rest.service;

import de.claudioaltamura.springboot.rest.model.Hero;
import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.model.HeroRequestWithId;
import de.claudioaltamura.springboot.rest.model.HeroResponse;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class HeroMapper {

  private HeroMapper() {}

  static HeroResponse map2Response(Hero hero){
    return HeroResponse.of(hero.getId(), hero.getName(), hero.getPower(), hero.getRealName(), hero.getCity());
  }

  static List<HeroResponse> map2ListResponse(Collection<Hero> heroes) {
    return heroes.stream().map(HeroMapper::map2Response).collect(Collectors.toList());
  }

  static Hero map2Hero(long id, HeroRequest heroRequest) {
    return new Hero(id, heroRequest.getName(), heroRequest.getPower(), heroRequest.getRealName(), heroRequest.getCity());
  }

  static Hero map2Hero(HeroRequestWithId heroRequest) {
    return new Hero(heroRequest.getId(), heroRequest.getName(), heroRequest.getPower(), heroRequest.getRealName(), heroRequest.getCity());
  }

}
