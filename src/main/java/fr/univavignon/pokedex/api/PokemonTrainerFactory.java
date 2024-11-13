package fr.univavignon.pokedex.api;

/**
 * Implémentation de l'interface IPokemonTrainerFactory.
 * Cette classe crée une instance de PokemonTrainer avec les informations fournies.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Créer un Pokedex via la fabrique

        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());

        // Créer un entraîneur avec le nom, l'équipe et le pokédex
        return new PokemonTrainer(name, team, pokedex);

    }
}
