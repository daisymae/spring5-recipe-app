package guru.springframework.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest // will bring up embedded DB and configure Spring Data JPA for us
public class UnitOfMeasureRepositoryIntegTest {

  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;
  
  @Before
  public void setUp() throws Exception {
  }

  @Test
  @DirtiesContext // this will cause Spring Context to start up a second time for next test
  public void testFindByDescription() {
    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    assertEquals("Teaspoon", uomOptional.get().getDescription());
  }


  @Test
  public void testFindByDescriptionCup() {
    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
    assertEquals("Cup", uomOptional.get().getDescription());
  }
}
