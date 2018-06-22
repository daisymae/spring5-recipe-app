package guru.springframework.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import guru.springframework.services.RecipeService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
    String viewName = indexController.getIndexPage(model);
    assertEquals("index", viewName);
    verify(recipeService, times(1)).getRecipes();
    verify(model, times(1)).addAttribute(eq("recipes"), anySet());
  }

}
