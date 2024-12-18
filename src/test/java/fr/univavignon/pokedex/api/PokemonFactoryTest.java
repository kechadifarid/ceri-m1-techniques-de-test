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

}
