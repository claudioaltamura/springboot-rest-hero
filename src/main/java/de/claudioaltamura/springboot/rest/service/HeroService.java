package de.claudioaltamura.springboot.rest.service;

import de.claudioaltamura.springboot.rest.model.Hero;
import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.model.HeroRequestWithId;
import de.claudioaltamura.springboot.rest.model.HeroResponse;
import java.util.Collection;
import java.util.List;

public interface HeroService {

  HeroResponse add(HeroRequest heroRequest);

  Collection<HeroResponse> findAll();

}
