package fr.univavignon.pokedex.api;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import java.util.List;

public class PokedexTest {

    @Test
    public void testAddPokemon() throws PokedexException {
        // Création de l'instance de Pokedex avec des mocks pour les providers
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Création d'un Pokémon à ajouter
        Pokemon pokemon = pokemonFactory.createPokemon(1, 1000, 150, 2000, 10);

        // Ajout du Pokémon au Pokédex et vérification de l'index
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);  // Le premier Pokémon ajouté a l'index 0

        // Vérification de la taille du Pokédex après l'ajout
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemonValid() throws PokedexException {
        // Création de l'instance de Pokedex
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Création et ajout d'un Pokémon
        Pokemon pokemon = pokemonFactory.createPokemon(1, 1000, 150, 2000, 10);
        pokedex.addPokemon(pokemon);

        // Récupération du Pokémon par son index (id)
        Pokemon retrievedPokemon = pokedex.getPokemon(0);

        // Vérification de la récupération correcte
        assertNotNull(retrievedPokemon);
        assertEquals("Bulbasaur", retrievedPokemon.getName());  // Vérification du nom du Pokémon
        assertEquals(1000, retrievedPokemon.getCp());  // Vérification du CP
    }

    @Test
    public void testGetPokemonInvalidIndex() {
        // Création de l'instance de Pokedex
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Tentative de récupération d'un Pokémon avec un index invalide
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(0);  // Pas de Pokémon ajouté, donc l'index 0 est invalide
        });

        // Vérification du message d'erreur
        assertEquals("Index invalide : aucun Pokémon trouvé avec cet id.", exception.getMessage());
    }

    @Test
    public void testGetPokemonsSorted() throws PokedexException {
        // Création de l'instance de Pokedex
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Création de deux Pokémon et ajout au Pokédex
        Pokemon pokemon1 = pokemonFactory.createPokemon(1, 1000, 150, 2000, 10);  // Bulbasaur
        Pokemon pokemon2 = pokemonFactory.createPokemon(2, 1500, 180, 3000, 15);  // Ivysaur
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        // Comparateur pour trier les Pokémon par CP (en ordre croissant)
        Comparator<Pokemon> cpComparator = Comparator.comparingInt(Pokemon::getCp);

        // Récupération des Pokémon triés
        List<Pokemon> sortedPokemons = pokedex.getPokemons(cpComparator);

        // Vérification de l'ordre des Pokémon après le tri par CP
        assertEquals("Bulbasaur", sortedPokemons.get(0).getName());
        assertEquals("Ivysaur", sortedPokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonsUnsorted() throws PokedexException {
        // Création de l'instance de Pokedex
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Création de deux Pokémon et ajout au Pokédex
        Pokemon pokemon1 = pokemonFactory.createPokemon(1, 1000, 150, 2000, 10);  // Bulbasaur
        Pokemon pokemon2 = pokemonFactory.createPokemon(2, 1500, 180, 3000, 15);  // Ivysaur
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        // Vérification des Pokémon dans l'ordre d'ajout (non trié)
        List<Pokemon> unsortedPokemons = pokedex.getPokemons();
        assertEquals("Bulbasaur", unsortedPokemons.get(0).getName());
        assertEquals("Ivysaur", unsortedPokemons.get(1).getName());
    }
}
