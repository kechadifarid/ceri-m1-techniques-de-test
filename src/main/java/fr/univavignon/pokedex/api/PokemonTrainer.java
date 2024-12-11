package fr.univavignon.pokedex.api;

/**
 * Représente un dresseur de Pokémon. Un dresseur a un nom, une équipe de Pokémon, et un Pokédex
 * qui contient les Pokémon qu'il a rencontrés ou capturés.
 */
public class PokemonTrainer {

	/** Le nom du dresseur. */
	private final String name;

	/** L'équipe de Pokémon du dresseur. */
	private final Team team;

	/** Le Pokédex du dresseur qui contient les Pokémon rencontrés. */
	private final IPokedex pokedex;

	/**
	 * Crée un nouveau dresseur avec un nom, une équipe de Pokémon et un Pokédex.
	 *
	 * @param name Le nom du dresseur.
	 * @param team L'équipe de Pokémon du dresseur.
	 * @param pokedex Le Pokédex du dresseur.
	 */
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}

	/**
	 * Retourne le nom du dresseur.
	 *
	 * @return Le nom du dresseur.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retourne l'équipe de Pokémon du dresseur.
	 *
	 * @return L'équipe du dresseur.
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Retourne le Pokédex du dresseur, qui contient les Pokémon rencontrés ou capturés.
	 *
	 * @return Le Pokédex du dresseur.
	 */
	public IPokedex getPokedex() {
		return pokedex;
	}
}
