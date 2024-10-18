package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex; // Ajout du mock IPokedex
    private PokemonTrainer trainer;


    @BeforeEach
    public void setUp() {
        // Mock de IPokemonTrainerFactory, IPokedexFactory, et IPokedex
        pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);// Mock de IPokedex

        // Création d'un PokemonTrainer fictif avec un nom, une équipe, et un pokédex
        trainer = new PokemonTrainer("Ash", Team.VALOR, pokedex);

        // Définir le comportement du mock pour createTrainer
        when(pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory)).thenReturn(trainer);

    }

    @Test
    public void testCreateTrainer() {
        // Utilisation du mock pour créer un nouveau PokemonTrainer
        PokemonTrainer createdTrainer = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        // Vérifier que le trainer a bien été créé avec les bonnes propriétés
        assertNotNull(createdTrainer);
        assertEquals("Ash", createdTrainer.getName());
        assertEquals(Team.VALOR, createdTrainer.getTeam());
        assertEquals(pokedex, createdTrainer.getPokedex()); // Vérifier que c'est bien le bon IPokedex qui est utilisé
    }
}
