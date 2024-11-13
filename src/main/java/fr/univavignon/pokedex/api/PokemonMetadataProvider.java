package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static final Map<Integer, PokemonMetadata> POKEMON_METADATA_DB = new HashMap<>();

    // Initialisation des données des Pokémon directement dans le code
    static {
        POKEMON_METADATA_DB.put(1, new PokemonMetadata(1, "Bulbasaur", 126, 126, 90));
        POKEMON_METADATA_DB.put(2, new PokemonMetadata(2, "Ivysaur", 156, 158, 120));
        POKEMON_METADATA_DB.put(3, new PokemonMetadata(3, "Venusaur", 198, 200, 160));
        // Ajoutez ici les autres Pokémon nécessaires en suivant le même modèle
    }


    /**
     * Récupère et retourne les métadonnées du Pokémon identifié par l'index.
     * @param index Index du Pokémon pour récupérer ses métadonnées.
     * @return Les métadonnées du Pokémon.
     * @throws PokedexException Si l'index donné n'est pas valide.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!POKEMON_METADATA_DB.containsKey(index)) {
            throw new PokedexException("Index invalide: Aucun Pokémon trouvé avec cet index.");
        }
        return POKEMON_METADATA_DB.get(index);
    }



}
