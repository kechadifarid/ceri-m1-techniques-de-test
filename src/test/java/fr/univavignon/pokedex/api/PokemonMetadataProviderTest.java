package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the PokemonMetadataProvider class.
 */
class PokemonMetadataProviderTest {

    private final PokemonMetadataProvider provider = new PokemonMetadataProvider();

    @Test
    void testGetPokemonMetadataValid() throws PokedexException {
        // Teste si la méthode retourne les bonnes métadonnées pour un index valide
        PokemonMetadata metadata = provider.getPokemonMetadata(1);

        assertNotNull(metadata); // Vérifie que l'objet n'est pas null
        assertEquals("Bulbasaur", metadata.getName()); // Vérifie que le nom est correct
        assertEquals(126, metadata.getAttack()); // Vérifie que l'attaque est correcte
        assertEquals(126, metadata.getDefense()); // Vérifie que la défense est correcte
        assertEquals(90, metadata.getStamina()); // Vérifie que l'endurance est correcte
    }

    @Test
    void testGetPokemonMetadataInvalid() {
        // Teste si la méthode lance une exception pour un index invalide
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            provider.getPokemonMetadata(999); // Index invalide qui n'existe pas
        });

        assertEquals("Index invalide: Aucun Pokémon trouvé avec cet index.", exception.getMessage());
    }

    @Test
    void testGetPokemonMetadataNonExistentIndex() {
        // Teste avec un index non existant dans la base de données
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            provider.getPokemonMetadata(4); // L'index 4 n'existe pas dans les données statiques
        });

        assertEquals("Index invalide: Aucun Pokémon trouvé avec cet index.", exception.getMessage());
    }

    @Test
    void testGetPokemonMetadataMultipleValidIndexes() throws PokedexException {
        // Teste plusieurs index valides pour vérifier si les données sont récupérées correctement
        PokemonMetadata bulbasaur = provider.getPokemonMetadata(1);
        PokemonMetadata ivysaur = provider.getPokemonMetadata(2);
        PokemonMetadata venusaur = provider.getPokemonMetadata(3);

        // Vérifications pour chaque Pokémon
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals("Ivysaur", ivysaur.getName());
        assertEquals("Venusaur", venusaur.getName());
    }
}
