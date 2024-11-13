package fr.univavignon.pokedex.api;

/**
 * Implémentation de l'interface IPokemonTrainerFactory.
 * Cette classe crée une instance de PokemonTrainer avec les informations fournies.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        if (name == null) {
            throw new NullPointerException("Le nom de l'entraîneur ne peut pas être null.");
        }
        if (team == null) {
            throw new NullPointerException("L'équipe de l'entraîneur ne peut pas être null.");
        }
        if (pokedexFactory == null) {
            throw new NullPointerException("La fabrique de Pokédex ne peut pas être null.");
        }

        // Créer un Pokedex via la fabrique
        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());

        // Créer un entraîneur avec le nom, l'équipe et le pokédex
        return new PokemonTrainer(name, team, pokedex);
    }
}


