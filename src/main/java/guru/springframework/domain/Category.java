package guru.springframework.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
/* this code does not run if do not include the 
 * @EqualsAndHashCode to exclude recipes. Without
 * this, there is an infinite loop that causes a StackOverflowError
 * due to the circular dependencies.
 * Also update Ingredient and Notes.
 * It could be helpful to look at the code generated by Lombok to make
 * sure it is doing what you expect and will work for your code.
 * 
 */
@Entity
@EqualsAndHashCode(exclude = {"recipes"})
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
