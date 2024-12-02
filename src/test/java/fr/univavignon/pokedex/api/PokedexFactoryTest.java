package fr.univavignon.pokedex.api;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PokedexFactoryTest {

    @Test
   void testCreatePokedex() {
        // Création des mocks ou des objets réels nécessaires
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();

        // Création d'une instance de PokedexFactory
        PokedexFactory pokedexFactory = new PokedexFactory();

        // Création du Pokedex via la fabrique
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérification que l'objet Pokedex n'est pas null
        assertNotNull(pokedex, "Le Pokédex ne doit pas être null.");

        // Vérification que l'objet est bien une instance de Pokedex
        assertTrue(pokedex instanceof Pokedex, "L'instance doit être de type Pokedex.");

        // Vérification des arguments passés au Pokedex
        // Ici, on vérifie si les méthodes de Pokedex utilisent correctement les fournisseurs
        assertDoesNotThrow(() -> pokedex.getPokemonMetadata(1));  // Test que la récupération de métadonnées fonctionne
        assertDoesNotThrow(() -> pokedex.createPokemon(1, 100, 50, 200, 10));  // Test que la création de Pokémon fonctionne
    }

    @Test
   void testCreatePokedexWithNullArguments() {
        // Création de l'instance de la fabrique
        PokedexFactory pokedexFactory = new PokedexFactory();

        // Test avec un argument metadataProvider null
        assertThrows(NullPointerException.class, () -> {
            pokedexFactory.createPokedex(null, new PokemonFactory());
        }, "Une exception NullPointerException devrait être lancée lorsque le metadataProvider est null.");

        // Test avec un argument pokemonFactory null
        assertThrows(NullPointerException.class, () -> {
            pokedexFactory.createPokedex(new PokemonMetadataProvider(), null);
        }, "Une exception NullPointerException devrait être lancée lorsque le pokemonFactory est null.");
    }
}

