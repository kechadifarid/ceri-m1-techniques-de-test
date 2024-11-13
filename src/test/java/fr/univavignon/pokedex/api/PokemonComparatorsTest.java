package fr.univavignon.pokedex.api;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class PokemonComparatorsTest {

    @Test
    public void testNameComparator() {
        // Create test data
        Pokemon pikachu = new Pokemon(1, "Pikachu", 55, 40, 35, 100, 60, 10, 20, 80);
        Pokemon charmander = new Pokemon(2, "Charmander", 52, 43, 39, 80, 45, 20, 10, 75);
        Pokemon bulbasaur = new Pokemon(3, "Bulbasaur", 49, 49, 45, 90, 60, 15, 30, 75);

        List<Pokemon> pokemons = Arrays.asList(pikachu, charmander, bulbasaur);

        // Sort using NAME comparator
        pokemons.sort(PokemonComparators.NAME);

        // Verify the order by name
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Charmander", pokemons.get(1).getName());
        assertEquals("Pikachu", pokemons.get(2).getName());
    }

    @Test
    public void testIndexComparator() {
        // Create test data
        Pokemon pikachu = new Pokemon(1, "Pikachu", 55, 40, 35, 100, 60, 10, 20, 80);
        Pokemon charmander = new Pokemon(2, "Charmander", 52, 43, 39, 80, 45, 20, 10, 75);
        Pokemon bulbasaur = new Pokemon(3, "Bulbasaur", 49, 49, 45, 90, 60, 15, 30, 75);

        List<Pokemon> pokemons = Arrays.asList(pikachu, charmander, bulbasaur);

        // Sort using INDEX comparator
        pokemons.sort(PokemonComparators.INDEX);

        // Verify the order by index
        assertEquals(1, pokemons.get(0).getIndex());
        assertEquals(2, pokemons.get(1).getIndex());
        assertEquals(3, pokemons.get(2).getIndex());
    }

    @Test
    public void testCpComparator() {
        // Create test data
        Pokemon pikachu = new Pokemon(1, "Pikachu", 55, 40, 35, 100, 60, 10, 20, 80);
        Pokemon charmander = new Pokemon(2, "Charmander", 52, 43, 39, 80, 45, 20, 10, 75);
        Pokemon bulbasaur = new Pokemon(3, "Bulbasaur", 49, 49, 45, 90, 60, 15, 30, 75);

        List<Pokemon> pokemons = Arrays.asList(pikachu, charmander, bulbasaur);

        // Sort using CP comparator
        pokemons.sort(PokemonComparators.CP);

        // Verify the order by combat points (cp)
        assertEquals(80, pokemons.get(0).getCp());
        assertEquals(75, pokemons.get(1).getCp());
        assertEquals(60, pokemons.get(2).getCp());
    }

    @Test
    public void testMultipleComparators() {
        // Create test data with same index but different attributes
        Pokemon pikachu = new Pokemon(1, "Pikachu", 55, 40, 35, 100, 60, 10, 20, 80);
        Pokemon charmander = new Pokemon(1, "Charmander", 52, 43, 39, 80, 45, 20, 10, 75);
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", 49, 49, 45, 90, 60, 15, 30, 75);

        List<Pokemon> pokemons = Arrays.asList(pikachu, charmander, bulbasaur);

        // Sort first by NAME and then by CP
        pokemons.sort(PokemonComparators.NAME.thenComparing(PokemonComparators.CP));

        // Verify the order (name first, then cp for tie-breaker)
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Charmander", pokemons.get(1).getName());
        assertEquals("Pikachu", pokemons.get(2).getName());
    }
}

