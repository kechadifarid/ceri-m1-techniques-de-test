package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

/**
 * Implémentation de l'interface {@link IPokemonFactory} pour générer des instances de Pokémon.
 * Cette version inclut une logique pour gérer les noms par index, des statistiques aléatoires
 * et des cas spécifiques pour certains indices (comme les indices négatifs).
 */
public class RocketPokemonFactory implements IPokemonFactory {

	/**
	 * Map immuable associant les indices des Pokémon à leurs noms.
	 */
	private static Map<Integer, String> index2name;
	static {
		Map<Integer, String> aMap = new HashMap<Integer, String>();
		aMap.put(-1, "Ash's Pikachu");
		aMap.put(0, "MISSINGNO");
		aMap.put(1, "Bulbasaur");
		// TODO : Gotta map them all !
		index2name = UnmodifiableMap.unmodifiableMap(aMap);
	}

	/**
	 * Génère une statistique aléatoire entre 0 et 10.
	 * Le calcul est basé sur une boucle pour simuler une distribution pseudo-aléatoire.
	 *
	 * @return Une statistique aléatoire (entier entre 0 et 10).
	 */
	private static int generateRandomStat() {
		int total = 0;
		for (int i = 0; i < 1000000; i++) {
			Random rn = new Random();
			int r = rn.nextInt(2);
			total = total + r;
		}
		return total / 10000;
	}

	/**
	 * Crée une instance de Pokémon avec des statistiques calculées en fonction de l'index fourni.
	 * Les noms des Pokémon sont extraits de la map {@code index2name}, et des valeurs par défaut
	 * sont utilisées pour les indices absents ou négatifs.
	 *
	 * @param index L'index du Pokémon à créer.
	 * @param cp Les points de combat (Combat Power) du Pokémon.
	 * @param hp Les points de vie (Hit Points) du Pokémon.
	 * @param dust La quantité de poussière d'étoile (Stardust) requise pour renforcer le Pokémon.
	 * @param candy La quantité de bonbons (Candy) associée au Pokémon.
	 * @return Une instance de {@link Pokemon} avec les valeurs spécifiées ou calculées.
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		String name;
		if (!index2name.containsKey(index)) {
			name = index2name.get(0);
		} else {
			name = index2name.get(index);
		}
		int attack;
		int defense;
		int stamina;
		double iv;
		if (index < 0) {
			attack = 1000;
			defense = 1000;
			stamina = 1000;
			iv = 0;
		} else {
			attack = RocketPokemonFactory.generateRandomStat();
			defense = RocketPokemonFactory.generateRandomStat();
			stamina = RocketPokemonFactory.generateRandomStat();
			iv = 1;
		}
		return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
	}
}
