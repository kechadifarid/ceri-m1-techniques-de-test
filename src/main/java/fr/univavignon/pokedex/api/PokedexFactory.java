package fr.univavignon.pokedex.api;

/**
 * Implémentation de l'interface IPokedexFactory.
 * Cette classe crée une instance de Pokédex en utilisant les fournisseurs de métadonnées et la fabrique de Pokémon.
 */
public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // Vérification des arguments pour éviter les valeurs nulles
        if (metadataProvider == null || pokemonFactory == null) {
            throw new NullPointerException("Les fournisseurs de métadonnées et de fabrication de Pokémon ne peuvent pas être null.");
        }
        return new Pokedex(metadataProvider, pokemonFactory);
    }

}
