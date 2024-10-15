package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IPokedexFactoryTest {

    @Test
    void testCreatePokedex() {
        // Création de mocks pour IPokemonMetadataProvider et IPokemonFactory
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Création d'une instance de mock pour IPokedexFactory
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Définir le comportement du mock pour createPokedex
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        // Appel de la méthode
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérification que le Pokedex créé est le même que celui retourné par le mock
        assertNotNull(createdPokedex);
        assertEquals(pokedex, createdPokedex);


    }

    @Test
    void testCreatePokedex_WithNullParameters() {
        // Création d'une instance de mock pour IPokedexFactory
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Définir le comportement du mock pour createPokedex avec des paramètres nuls
        when(pokedexFactory.createPokedex(null, null)).thenThrow(new IllegalArgumentException("Parameters cannot be null"));

        // Vérification que l'exception est levée lorsque les paramètres sont nuls
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            pokedexFactory.createPokedex(null, null);
        });

        assertEquals("Parameters cannot be null", exception.getMessage());
    }
}
