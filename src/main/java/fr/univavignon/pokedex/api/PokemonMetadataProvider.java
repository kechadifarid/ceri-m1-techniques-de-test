package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Fournisseur des métadonnées des Pokémon. Cette classe fournit un accès aux informations de base
 * sur les Pokémon (comme l'index, le nom, les statistiques) via la méthode {@link #getPokemonMetadata(int)}.
 * Les métadonnées des Pokémon sont stockées dans une base de données interne simulée.
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /** Base de données simulée des métadonnées des Pokémon, indexée par l'index du Pokémon. */
    private static final Map<Integer, PokemonMetadata> POKEMON_METADATA_DB = new HashMap<>();

    // Initialisation des données des Pokémon directement dans le code
    static {
        // Ajout de quelques Pokémon à la base de données interne
        POKEMON_METADATA_DB.put(1, new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));
        POKEMON_METADATA_DB.put(2, new PokemonMetadata(1, "Ivysaur", 156, 158, 120));
        POKEMON_METADATA_DB.put(3, new PokemonMetadata(2, "Venusaur", 198, 200, 160));
        // Ajoutez ici les autres Pokémon nécessaires en suivant le même modèle
    }

    /**
     * Retourne les métadonnées d'un Pokémon spécifié par son index.
     * Si l'index du Pokémon n'existe pas dans la base de données, une exception {@link PokedexException} est levée.
     *
     * @param index L'index du Pokémon dont les métadonnées doivent être récupérées.
     * @return Les métadonnées du Pokémon correspondant à l'index spécifié.
     * @throws PokedexException Si aucun Pokémon n'est trouvé avec l'index donné.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!POKEMON_METADATA_DB.containsKey(index)) {
            // Lève une exception si le Pokémon avec l'index spécifié n'existe pas
            throw new PokedexException("Index invalide: Aucun Pokémon trouvé avec cet index.");
        }
        // Retourne les métadonnées du Pokémon correspondant à l'index
        return POKEMON_METADATA_DB.get(index);
    }
}
