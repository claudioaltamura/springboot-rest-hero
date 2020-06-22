package de.claudioaltamura.springboot.rest.service;

import static de.claudioaltamura.springboot.rest.model.HeroMapper.*;

import de.claudioaltamura.springboot.rest.exception.HeroNotFoundException;
import de.claudioaltamura.springboot.rest.model.Hero;
import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.model.HeroRequestWithId;
import de.claudioaltamura.springboot.rest.model.HeroResponse;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class HeroServiceImpl implements HeroService {

  private final Map<Long, Hero> heroes = new ConcurrentHashMap<>();
  private final AtomicLong index = new AtomicLong(1);

  @Override
  public HeroResponse add(HeroRequest heroRequest) {
    long id = index.getAndIncrement();
    Hero hero = map2Hero(id, heroRequest);
    heroes.put(id, hero);

    return map2Response(hero);
  }

  @Override
  public void update(HeroRequestWithId heroRequestWithId) {
    long heroId = heroRequestWithId.getId();
    Hero hero = heroes.get(heroId);

    heroes.put(heroRequestWithId.getId(), map2Hero(heroId, heroRequestWithId));
  }

  @Override
  public HeroResponse find(long heroId) {
    Hero hero = heroes.get(heroId);

    if(hero != null) {
      return map2Response(hero);
    } else {
      throw new HeroNotFoundException();
    }
  }

  @Override
  public Collection<HeroResponse> findAll() {
    return map2ListResponse(heroes.values());
  }

  @Override
  public void destroy(long heroId) {
    Hero hero = heroes.get(heroId);

    if(hero != null) {
      heroes.remove(heroId);
    }
  }

  @Override
  public void destroyAll() {
    heroes.clear();
  }

}
