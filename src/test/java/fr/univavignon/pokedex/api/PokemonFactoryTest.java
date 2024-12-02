package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonFactoryTest {

    @Test
    void testCreatePokemonValid() throws PokedexException {
        // Création de l'instance de PokemonFactory
        PokemonFactory factory = new PokemonFactory();

        // Test avec un index valide (par exemple, Bulbizarre avec index 1)
        Pokemon pokemon = factory.createPokemon(1, 1000, 150, 2000, 10);

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
        // Création de l'instance de PokemonFactory
        PokemonFactory factory = new PokemonFactory();

        // Test avec un index invalide (par exemple, un index non défini comme 999)
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            factory.createPokemon(999, 1000, 150, 2000, 10);
        });

        // Vérification du message d'exception
        assertEquals("Index invalide: Aucun Pokémon trouvé avec cet index.", exception.getMessage());
    }

    @Test
    void testCreatePokemonWithIvCalculation() throws PokedexException {
        // Création de l'instance de PokemonFactory
        PokemonFactory factory = new PokemonFactory();

        // Test avec un index valide (par exemple, Ivysaur avec index 2)
        Pokemon pokemon = factory.createPokemon(2, 1200, 180, 2500, 12);

        // Vérification du calcul de l'IV
        double expectedIv = ((156 + 158 + 120) / 45.0) * 100;  // Calcul IV basé sur les statistiques d'Ivysaur
        assertEquals(expectedIv, pokemon.getIv(), 0.1);  // La différence autorisée est de 0.1
    }
}
