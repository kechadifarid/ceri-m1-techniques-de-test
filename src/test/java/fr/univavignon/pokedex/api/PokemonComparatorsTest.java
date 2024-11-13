package fr.univavignon.pokedex.api;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class PokemonComparatorsTest {

    @Test
    public void testNameComparator() {
        // Création des données
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        List<Pokemon> pokemons = Arrays.asList(bulbizarre, aquali);

        // Tri avec le comparateur NAME
        pokemons.sort(PokemonComparators.NAME);

        // Vérification de l'ordre par nom
        assertEquals("Aquali", pokemons.get(0).getName());
        assertEquals("Bulbizarre", pokemons.get(1).getName());
    }

    @Test
    public void testIndexComparator() {
        // Création des données
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        List<Pokemon> pokemons = Arrays.asList(bulbizarre, aquali);

        // Tri avec le comparateur INDEX
        pokemons.sort(PokemonComparators.INDEX);

        // Vérification de l'ordre par index
        assertEquals(0, pokemons.get(0).getIndex());
        assertEquals(133, pokemons.get(1).getIndex());
    }

    @Test
    public void testCpComparator() {
        // Création des données
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        List<Pokemon> pokemons = Arrays.asList(bulbizarre, aquali);

        // Tri avec le comparateur CP
        pokemons.sort(PokemonComparators.CP);

        // Vérification de l'ordre par CP
        assertEquals(2729, pokemons.get(0).getCp()); // Aquali a les CP les plus élevés
        assertEquals(613, pokemons.get(1).getCp()); // Bulbizarre a les CP les plus bas
    }


    @Test
    public void testIvComparator() {
        // Création des données avec IV calculés manuellement : 56% pour Bulbizarre et 100% pour Aquali
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        List<Pokemon> pokemons = Arrays.asList(bulbizarre, aquali);

        // Tri avec un comparateur pour IV
        pokemons.sort((p1, p2) -> Double.compare(p2.getIv(), p1.getIv())); // Tri décroissant par IV

        // Vérification de l'ordre par IV
        assertEquals(100, pokemons.get(0).getIv());
        assertEquals(56, pokemons.get(1).getIv());
    }

    @Test
    public void testMultipleComparators() {
        // Création des données avec des noms identiques mais des CP différents
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        List<Pokemon> pokemons = Arrays.asList(bulbizarre, aquali);

        // Tri d'abord par nom, puis par CP (si les noms sont égaux)
        pokemons.sort(PokemonComparators.NAME.thenComparing(PokemonComparators.CP));

        // Vérification de l'ordre (nom d'abord, puis CP comme critère secondaire)
        assertEquals("Aquali", pokemons.get(0).getName());
        assertEquals("Bulbizarre", pokemons.get(1).getName());
    }
}

