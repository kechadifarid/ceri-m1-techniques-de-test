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
        PokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();  // Déclaration de trainerFactory ici

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

        // Test avec le nom null
        assertThrows(NullPointerException.class, () -> {
            trainerFactory.createTrainer(null, Team.RED, new PokedexFactory());
        }, "Une exception NullPointerException devrait être lancée lorsque le nom de l'entraîneur est null.");



        // Test avec l'équipe null
        assertThrows(NullPointerException.class, () -> {
            trainerFactory.createTrainer("Ash Ketchum", null, new PokedexFactory());
        }, "Une exception NullPointerException devrait être lancée lorsque l'équipe est null.");

        // Test avec la fabrique de Pokedex null
        assertThrows(NullPointerException.class, () -> {
            trainerFactory.createTrainer("Ash Ketchum", Team.RED, null);
        }, "Une exception NullPointerException devrait être lancée lorsque la fabrique de Pokédex est null.");
    }

    @Test
     void testCreateTrainerWithInvalidTeam() {
        // Création de la fabrique de Pokedex
        IPokedexFactory pokedexFactory = new PokedexFactory();

        // Création de la fabrique de PokemonTrainer
        PokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();  // Déclaration ici aussi

        // Test avec une équipe invalide (en supposant que vous avez une logique de validation d'équipe)
        // Par exemple, vous pouvez tester une équipe non définie ou non valide
        assertThrows(IllegalArgumentException.class, () -> {
            // Supposons qu'il n'y ait que deux équipes valides : Team.RED et Team.BLUE
            trainerFactory.createTrainer("Ash Ketchum", Team.valueOf("INVALID_TEAM"), pokedexFactory);
        }, "Une exception IllegalArgumentException devrait être lancée lorsque l'équipe est invalide.");
    }
}
