package fr.univavignon.pokedex.api;

/**
 * Implémentation de l'interface IPokedexFactory.
 * Cette classe crée une instance de Pokédex en utilisant les fournisseurs de métadonnées et la fabrique de Pokémon.
 */
public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // Création d'un objet Pokedex avec les services de métadonnées et de fabrique de Pokémon
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
