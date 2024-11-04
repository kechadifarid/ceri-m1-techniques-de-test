package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonMetadataProviderTest {
    @Test
    public void testGetPokemonMetadata_ValidIndex_0() throws PokedexException {
        IPokemonMetadataProvider factory = Mockito.mock(IPokemonMetadataProvider.class);

        when(factory.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        PokemonMetadata pokemonMetadata = factory.getPokemonMetadata(0);

        assertEquals(0,pokemonMetadata.getIndex());
        assertEquals("Bulbizarre",pokemonMetadata.getName());
        assertEquals(126,pokemonMetadata.getAttack());
        assertEquals(126,pokemonMetadata.getDefense());
        assertEquals(90,pokemonMetadata.getStamina());

    }

    @Test
    void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        // Création d'un mock de IPokemonMetadataProvider
        IPokemonMetadataProvider provider = Mockito.mock(IPokemonMetadataProvider.class);

        // Définir le comportement du mock pour une exception sur un index invalide
        when(provider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));

        // Vérification que l'exception est bien levée
        Exception exception = assertThrows(PokedexException.class, () -> {
            provider.getPokemonMetadata(-1);
        });

        assertEquals("Invalid index", exception.getMessage());
    }

}