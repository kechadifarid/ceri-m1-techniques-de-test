package fr.univavignon.pokedex.api;

/**
 * Classe représentant les métadonnées d'un Pokémon.
 * Elle contient les informations de base sur un Pokémon comme son index, son nom,
 * et ses statistiques de combat (attaque, défense, endurance).
 */
public class PokemonMetadata {

	/** L'index du Pokémon, unique pour chaque Pokémon dans le Pokedex. */
	private final int index;

	/** Le nom du Pokémon. */
	private final String name;

	/** La valeur de l'attaque du Pokémon, utilisée pour calculer les dégâts infligés. */
	private final int attack;

	/** La valeur de la défense du Pokémon, utilisée pour réduire les dégâts subis. */
	private final int defense;

	/** La valeur de l'endurance (stamina) du Pokémon, utilisée pour calculer ses PV (points de vie). */
	private final int stamina;

	/**
	 * Constructeur pour initialiser les métadonnées d'un Pokémon avec les valeurs spécifiées.
	 *
	 * @param index L'index unique du Pokémon dans le Pokedex.
	 * @param name Le nom du Pokémon.
	 * @param attack La valeur de l'attaque du Pokémon.
	 * @param defense La valeur de la défense du Pokémon.
	 * @param stamina La valeur de l'endurance du Pokémon.
	 */
	public PokemonMetadata(final int index, final String name, final int attack, final int defense, final int stamina) {
		this.index = index;
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.stamina = stamina;
	}

	/**
	 * Retourne l'index unique du Pokémon.
	 *
	 * @return L'index du Pokémon.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Retourne le nom du Pokémon.
	 *
	 * @return Le nom du Pokémon.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retourne la valeur de l'attaque du Pokémon.
	 *
	 * @return La valeur d'attaque du Pokémon.
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Retourne la valeur de la défense du Pokémon.
	 *
	 * @return La valeur de défense du Pokémon.
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Retourne la valeur de l'endurance (stamina) du Pokémon.
	 *
	 * @return La valeur d'endurance du Pokémon.
	 */
	public int getStamina() {
		return stamina;
	}

}
