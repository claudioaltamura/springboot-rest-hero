package de.claudioaltamura.springboot.rest.service;

import de.claudioaltamura.springboot.rest.model.HeroConverter;
import de.claudioaltamura.springboot.rest.model.Hero;
import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.model.HeroRequestWithId;
import de.claudioaltamura.springboot.rest.model.HeroResponse;
import java.util.Collection;
import java.util.List;
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
    Hero hero = HeroConverter.convert2Hero(id, heroRequest);
    heroes.put(id, hero);
    return HeroConverter.convert2Response(hero);
  }

  @Override
  public Collection<HeroResponse> findAll() {
    return HeroConverter.convert2ListResponse(heroes.values());
  }

}
