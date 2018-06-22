package guru.springframework.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.anySet;

public class IndexControllerTest {

  IndexController indexController;
  @Mock
  RecipeService recipeService;
  @Mock
  Model model;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    indexController = new IndexController(recipeService);
  }

  @Test
  public void testGetIndexPage() throws Exception {
    // given
    Set<Recipe> recipes = new HashSet<>();
    recipes.add(new Recipe());
    Recipe recipe = new Recipe();
    recipe.setId(1L);
    recipes.add(recipe);
    
    when(recipeService.getRecipes()).thenReturn(recipes);
    ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
    
    // when
    String viewName = indexController.getIndexPage(model);

    // then    
    assertEquals("index", viewName);
    verify(recipeService, times(1)).getRecipes();
    // first pass
//    verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    // BDD
    verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
    Set<Recipe> setInController = argumentCaptor.getValue();
    assertEquals(2, setInController.size());
  }

}
