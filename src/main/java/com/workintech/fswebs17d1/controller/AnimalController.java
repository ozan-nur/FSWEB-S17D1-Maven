package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    // GET ALL
    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    // POST
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    // PUT
    @PutMapping("/{id}")
    public Animal updateAnimal(
            @PathVariable Integer id,
            @RequestBody Animal animal
    ) {
        animals.put(id, animal);
        return animal;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable Integer id) {
        return animals.remove(id);
    }
}
