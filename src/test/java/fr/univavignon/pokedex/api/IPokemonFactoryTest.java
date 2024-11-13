package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokemonFactoryTest {
//cc
    @Test
    void testCreatePokemon() throws PokedexException {
        // Création d'un mock de IPokemonFactory
        IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);

        // Définir le comportement du mock pour la méthode createPokemon
        when(factory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(
                new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0)
        );

        // Appel de la méthode et vérification du résultat
        Pokemon pokemon = factory.createPokemon(0, 613, 64, 4000, 4);

        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(90, pokemon.getStamina());
        assertEquals(56.0, pokemon.getIv());

    }
}
