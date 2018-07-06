package com.drinkthis.drinkthis.models.data;

import com.drinkthis.drinkthis.models.Cocktail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CocktailDao extends CrudRepository<Cocktail, Integer> {
}
