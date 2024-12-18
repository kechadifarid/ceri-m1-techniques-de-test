package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonFactoryTest {

    private PokemonFactory pokemonFactory;
    private RocketPokemonFactory rocketPokemonFactory;

    @BeforeEach
    void setUp() {
        pokemonFactory = new PokemonFactory();
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    void testCreatePokemonValid() throws PokedexException {
        // Test avec un index valide (par exemple, Bulbizarre avec index 1)
        Pokemon pokemon = pokemonFactory.createPokemon(1, 1000, 150, 2000, 10);

        // Vérification des valeurs du Pokémon
        assertNotNull(pokemon);  // Le Pokémon ne doit pas être nul
        assertEquals(1, pokemon.getIndex());  // Index de Bulbizarre
        assertEquals("Bulbasaur", pokemon.getName());  // Nom de Bulbizarre
        assertEquals(126, pokemon.getAttack());  // Attaque de Bulbizarre
        assertEquals(126, pokemon.getDefense());  // Défense de Bulbizarre
        assertEquals(90, pokemon.getStamina());  // Endurance de Bulbizarre
        assertEquals(1000, pokemon.getCp());  // CP de 1000
        assertEquals(150, pokemon.getHp());  // HP de 150
        assertEquals(2000, pokemon.getDust());  // Dust de 2000
        assertEquals(10, pokemon.getCandy());  // Candy de 10
        assertTrue(pokemon.getIv() > 0);  // IV doit être positif
    }

    @Test
    void testCreatePokemonInvalidIndex() {
        // Test avec un index invalide (par exemple, un index non défini comme 999)
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokemonFactory.createPokemon(999, 1000, 150, 2000, 10);
        });

        // Vérification du message d'exception
        assertEquals("Index invalide: Aucun Pokémon trouvé avec cet index.", exception.getMessage());
    }

    /**
     * Test pour les index négatifs dans RocketPokemonFactory.
     */
    @Test
    void testNegativeIndex() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(-1, 0, 0, 0, 0);

        assertNotNull(pokemon);
        assertEquals(-1, pokemon.getIndex());
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0.0, pokemon.getIv());
    }



    /**
     * Test d'intégration avec un index valide dans RocketPokemonFactory.
     */
    @Test
    void testCreatePokemonValidIndex() {
        Pokemon pokemon = rocketPokemonFactory.createPokemon(1, 500, 100, 2000, 5);  // Index 1 correspond à Bulbasaur

        assertNotNull(pokemon);
        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals(500, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(2000, pokemon.getDust());
        assertEquals(5, pokemon.getCandy());
    }
}
