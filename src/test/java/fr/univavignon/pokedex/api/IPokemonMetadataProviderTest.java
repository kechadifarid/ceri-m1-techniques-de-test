package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonMetadataProviderTest {
    @Test
    public void bulbisaurTest() throws PokedexException {
        IPokemonMetadataProvider factory = Mockito.mock(IPokemonMetadataProvider.class);

        when(factory.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        PokemonMetadata pokemonMetadata = factory.getPokemonMetadata(0);

        assertEquals(0,pokemonMetadata.getIndex());
        assertEquals("Bulbizarre",pokemonMetadata.getName());
        assertEquals(126,pokemonMetadata.getAttack());
        assertEquals(126,pokemonMetadata.getDefense());
        assertEquals(90,pokemonMetadata.getStamina());

    }

}