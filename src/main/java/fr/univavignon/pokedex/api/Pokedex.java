package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    /**
     * Liste interne qui stocke les Pokémon ajoutés dans le Pokédex.
     * Elle est déclarée comme final pour garantir que l'objet de la liste ne peut pas être remplacé.
     * Les ajouts et modifications des Pokémon sont gérés exclusivement via les méthodes de la classe.
     */
    private final List<Pokemon> pokemons = new ArrayList<>();


    /**
     * Constructeur de la classe Pokedex.
     *
     * @param metadataProvider Un fournisseur de métadonnées Pokémon qui permet de récupérer des informations détaillées sur les Pokémon.
     * @param pokemonFactory  Une usine qui crée des instances de Pokémon à partir des métadonnées.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // Initialisation éventuelle des fournisseurs et usines si nécessaire.
    }

    /**
     * Renvoie la taille actuelle du Pokédex, c'est-à-dire le nombre total de Pokémon enregistrés.
     *
     * @return Nombre de Pokémon enregistrés dans le Pokédex.
     */
    @Override
    public int size() {
        return pokemons.size();  // Renvoie le nombre de Pokémon dans le Pokédex
    }

    /**
     * Ajoute un nouveau Pokémon au Pokédex et renvoie l'indice auquel il a été ajouté.
     *
     * @param pokemon Le Pokémon à ajouter.
     * @return L'indice relatif du Pokémon ajouté dans la liste.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon); // Ajoute le Pokémon à la liste
        return pokemons.size() - 1;  // L'index est l'indice du Pokémon ajouté dans la liste
    }

    /**
     * Récupère un Pokémon du Pokédex à partir de son identifiant unique.
     *
     * @param id L'identifiant du Pokémon à récupérer.
     * @return Le Pokémon correspondant à l'identifiant donné.
     * @throws PokedexException Si l'identifiant est invalide (inférieur à 0 ou supérieur à la taille de la liste).
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Index invalide : aucun Pokémon trouvé avec cet id.");
        }
        return pokemons.get(id);  // Renvoie le Pokémon correspondant à l'id
    }

    /**
     * Renvoie une liste immuable contenant tous les Pokémon du Pokédex.
     *
     * @return Une copie non modifiable de la liste des Pokémon.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return List.copyOf(pokemons);  // Renvoie une copie non modifiable de la liste des Pokémon
    }

    /**
     * Renvoie une liste triée des Pokémon du Pokédex selon un comparateur donné.
     *
     * @param order Le comparateur définissant l'ordre de tri.
     * @return Une copie non modifiable de la liste triée des Pokémon.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);  // Crée une copie de la liste
        sortedList.sort(order);  // Trie la copie selon le comparateur fourni
        return List.copyOf(sortedList);  // Renvoie une version non modifiable de la liste triée
    }

    /**
     * Récupère les métadonnées d'un Pokémon (nom, type, etc.) à partir de son index.
     *
     * @param index L'index du Pokémon dont on souhaite obtenir les métadonnées.
     * @return Les métadonnées du Pokémon.
     * @throws PokedexException Si l'index est invalide ou si une erreur survient lors de la récupération.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Utilisation de PokemonMetadataProvider pour récupérer les métadonnées
        PokemonMetadataProvider provider = new PokemonMetadataProvider();
        return provider.getPokemonMetadata(index);
    }

    /**
     * Crée une instance de Pokémon avec des paramètres spécifiques (CP, HP, poussière, bonbons, etc.).
     *
     * @param index L'index du Pokémon à créer.
     * @param cp Les points de combat (Combat Power) du Pokémon.
     * @param hp Les points de vie (Hit Points) du Pokémon.
     * @param dust La quantité de poussière nécessaire pour alimenter le Pokémon.
     * @param candy La quantité de bonbons disponible pour évoluer le Pokémon.
     * @return Une instance de Pokémon correspondant aux paramètres fournis.
     * @throws PokedexException Si une erreur survient lors de la création du Pokémon.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        // Utilisation de PokemonFactory pour créer un Pokémon
        PokemonFactory factory = new PokemonFactory();
        return factory.createPokemon(index, cp, hp, dust, candy);
    }
}
