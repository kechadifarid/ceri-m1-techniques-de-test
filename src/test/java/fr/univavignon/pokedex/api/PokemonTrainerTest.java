package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTrainerFactoryTest {

    @Test
    void testCreateTrainer() {
        // Création d'une fabrique de Pokedex
        IPokedexFactory pokedexFactory = new PokedexFactory();

        // Création d'un nom de joueur et d'une équipe fictive
        String trainerName = "Ash Ketchum";
        Team trainerTeam = Team.RED;  // Vous pouvez aussi utiliser un autre enum de Team si nécessaire

        // Création de la fabrique de PokemonTrainer
        PokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        // Création de l'entraîneur via la fabrique
        PokemonTrainer trainer = trainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);

        // Vérification que l'entraîneur n'est pas null
        assertNotNull(trainer, "L'entraîneur ne doit pas être null.");

        // Vérification que le nom de l'entraîneur est correctement assigné
        assertEquals(trainerName, trainer.getName(), "Le nom de l'entraîneur doit être correctement assigné.");

        // Vérification que l'équipe de l'entraîneur est correctement assignée
        assertEquals(trainerTeam, trainer.getTeam(), "L'équipe de l'entraîneur doit être correctement assignée.");

        // Vérification que le Pokédex de l'entraîneur a bien été créé
        assertNotNull(trainer.getPokedex(), "Le Pokédex de l'entraîneur ne doit pas être null.");
    }

    @Test
    void testCreateTrainerWithNullArguments() {
        // Création de la fabrique de PokemonTrainer
        PokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();  // Déclaration ici aussi

        // Regroupement des tests d'arguments null dans une seule invocation lambda
        assertThrows(NullPointerException.class, () -> {
            // Cas où l'un des arguments est null (nom, équipe ou fabrique de Pokédex)
            // Tester avec nom null
            trainerFactory.createTrainer(null, Team.RED, new PokedexFactory());
            // Tester avec équipe null
            trainerFactory.createTrainer("Ash Ketchum", null, new PokedexFactory());
            // Tester avec fabrique de Pokedex null
            trainerFactory.createTrainer("Ash Ketchum", Team.RED, null);
        }, "Une exception NullPointerException devrait être lancée lorsque le nom, l'équipe ou la fabrique de Pokédex sont null.");
    }

    @Test
    void testCreateTrainerWithInvalidTeam() {
        // Création de la fabrique de Pokedex
        IPokedexFactory pokedexFactory = new PokedexFactory();

        // Création de la fabrique de PokemonTrainer
        PokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        // Test avec une équipe invalide dans une seule invocation lambda
        assertThrows(IllegalArgumentException.class, () -> {
            // Tester avec une équipe invalide
            trainerFactory.createTrainer("Ash Ketchum", Team.valueOf("INVALID_TEAM"), pokedexFactory);
        }, "Une exception IllegalArgumentException devrait être lancée lorsque l'équipe est invalide.");
    }
}
