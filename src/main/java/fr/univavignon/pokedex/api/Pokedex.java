package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private final List<Pokemon> pokemons = new ArrayList<>();



    /**
     * Constructeur de la classe Pokedex.
     *
     * @param metadataProvider Un fournisseur de métadonnées Pokémon qui permet de récupérer des informations détaillées sur les Pokémon.
     * @param pokemonFactory  Une usine qui crée des instances de Pokémon à partir des métadonnées.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {

    }

    @Override
    public int size() {
        return pokemons.size();  // Renvoie le nombre de Pokémon dans le Pokédex
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        // Ajoute un Pokémon à la liste et renvoie son index relatif
        pokemons.add(pokemon);
        return pokemons.size() - 1;  // L'index est l'indice du Pokémon ajouté dans la liste
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Index invalide : aucun Pokémon trouvé avec cet id.");
        }
        return pokemons.get(id);  // Renvoie le Pokémon correspondant à l'id
    }

    @Override
    public List<Pokemon> getPokemons() {
        return List.copyOf(pokemons);  // Renvoie une copie non modifiable de la liste des Pokémon
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);  // Crée une copie de la liste
        sortedList.sort(order);  // Trie la copie selon le comparateur fourni
        return List.copyOf(sortedList);  // Renvoie une version non modifiable de la liste triée
    }

    // Implémentation des méthodes de IPokemonMetadataProvider
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Utilisation de PokemonMetadataProvider pour récupérer les métadonnées
        PokemonMetadataProvider provider = new PokemonMetadataProvider();
        return provider.getPokemonMetadata(index);
    }

    // Implémentation des méthodes de IPokemonFactory
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        // Utilisation de PokemonFactory pour créer un Pokémon
        PokemonFactory factory = new PokemonFactory();
        return factory.createPokemon(index, cp, hp, dust, candy);
    }
}
