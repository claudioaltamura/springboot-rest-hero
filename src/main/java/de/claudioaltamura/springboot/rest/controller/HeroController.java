package de.claudioaltamura.springboot.rest.controller;

import de.claudioaltamura.springboot.rest.model.HeroRequest;
import de.claudioaltamura.springboot.rest.model.HeroResponse;
import de.claudioaltamura.springboot.rest.service.HeroService;
import java.net.URI;
import java.util.Collection;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HeroController {

  private final HeroService heroService;

  @GetMapping("/api/v1/heroes")
  public ResponseEntity<Collection<HeroResponse>> findAll() {
    return ResponseEntity.ok(heroService.findAll());
  }

  @PostMapping("/api/v1/heroes")
  public ResponseEntity<HeroResponse> add(@RequestBody @Valid HeroRequest heroRequest) {
    HeroResponse hero = heroService.add(heroRequest);

    if (hero == null)
      return ResponseEntity.noContent().build();

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
        "/{id}").buildAndExpand(hero.getId()).toUri();

    return ResponseEntity.created(location).body(hero);
  }

}
