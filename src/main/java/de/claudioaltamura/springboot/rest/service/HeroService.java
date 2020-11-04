package de.claudioaltamura.springboot.rest.service;

import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.model.HeroRequestWithId;
import de.claudioaltamura.springboot.rest.model.HeroResponse;
import java.util.Collection;

public interface HeroService {

  HeroResponse add(HeroRequest heroRequest);

  void update(HeroRequestWithId heroRequestWithId);

  HeroResponse findById(long heroId);

  Collection<HeroResponse> findAll();

  void destroy(long heroId);

  void destroyAll();

}
