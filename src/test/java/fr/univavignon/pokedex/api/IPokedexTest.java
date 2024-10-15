package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokedexTest {
    // Instances de Pokémon à utiliser pour les tests
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
    Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.00);

    IPokedex ipokedex; // Déclaration d'une interface IPokedex pour le mock

    // Méthode exécutée avant chaque test pour initialiser les mocks
    @BeforeEach
    public void setup() {
        // Création d'un mock pour l'interface IPokedex
        ipokedex = Mockito.mock(IPokedex.class);
    }

    // Test pour vérifier l'ajout de Pokémon
    @Test
    public void pokemonAddTest() {
        // Configuration des retours de la méthode 'addPokemon' pour les Pokémon
        when(ipokedex.addPokemon(bulbizarre)).thenReturn(0); // Bulbizarre sera ajouté à l'index 0
        when(ipokedex.addPokemon(aquali)).thenReturn(1); // Aquali sera ajouté à l'index 1
        when(ipokedex.size()).thenReturn(2); // La taille du Pokedex après ajout sera 2

        // Ajout des Pokémon et récupération de leurs index
        int indexBulbizzare = ipokedex.addPokemon(bulbizarre);
        int indexAquali = ipokedex.addPokemon(aquali);

        // Vérifications des index retournés
        assertEquals(0, indexBulbizzare); // Vérifie que l'index de Bulbizarre est 0
        assertEquals(1, indexAquali); // Vérifie que l'index de Aquali est 1
        assertEquals(2, ipokedex.size()); // Vérifie que la taille du Pokedex est 2
    }

    // Test pour vérifier la récupération des Pokémon par leur index
    @Test
    void testGetPokemon() throws PokedexException {
        // Configurer le mock pour retourner les Pokémon respectifs en fonction de l'index
        when(ipokedex.getPokemon(0)).thenReturn(bulbizarre); // Retourne Bulbizarre pour l'index 0
        when(ipokedex.getPokemon(1)).thenReturn(aquali); // Retourne Aquali pour l'index 1

        // Appel de la méthode getPokemon
        Pokemon pokemon1 = ipokedex.getPokemon(0);
        Pokemon pokemon2 = ipokedex.getPokemon(1);

        // Vérification que les Pokémon retournés sont corrects
        assertNotNull(pokemon1); // Vérifie que pokemon1 n'est pas nul
        assertEquals(bulbizarre, pokemon1); // Vérifie que pokemon1 est bien Bulbizarre
        assertEquals(aquali, pokemon2); // Vérifie que pokemon2 est bien Aquali
    }

    // Test pour vérifier la récupération de la liste des Pokémon
    @Test
    void testGetPokemons() {
        // Créer une liste de Pokémon à retourner par le mock
        List<Pokemon> pokemonList = Arrays.asList(bulbizarre, aquali);
        when(ipokedex.getPokemons()).thenReturn(pokemonList); // Configure le mock pour retourner la liste de Pokémon

        // Appel de la méthode getPokemons
        List<Pokemon> pokemons = ipokedex.getPokemons();

        // Vérification que la liste retournée correspond à la liste attendue
        assertEquals(pokemonList, pokemons); // Vérifie que la liste de Pokémon obtenue est la même que celle attendue
    }
}
