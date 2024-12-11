package fr.univavignon.pokedex.api;

/**
 * Représente un Pokémon capturé dans le jeu.
 * Cette classe étend {@link PokemonMetadata} et ajoute des attributs spécifiques
 * relatifs aux statistiques et ressources d'un Pokémon, tels que le CP, les points de vie (HP),
 * les poussières de Stardust, les bonbons et l'IV (Individual Value).
 */
public final class Pokemon extends PokemonMetadata {

	/** Le CP (Combat Power) du Pokémon, qui détermine sa force au combat. */
	private final int cp;

	/** Les points de vie (HP) du Pokémon. */
	private final int hp;

	/** La quantité de poussière de Stardust nécessaire pour effectuer certaines actions avec ce Pokémon. */
	private final int dust;

	/** Le nombre de bonbons nécessaires pour faire évoluer ou renforcer ce Pokémon. */
	private final int candy;

	/** La valeur d'IV (Individual Value) du Pokémon, qui influence sa puissance globale. */
	private final double iv;

	/**
	 * Constructeur pour créer un Pokémon avec ses statistiques de base.
	 *
	 * @param index L'index du Pokémon dans la base de données.
	 * @param name Le nom du Pokémon.
	 * @param attack La statistique d'attaque du Pokémon.
	 * @param defense La statistique de défense du Pokémon.
	 * @param stamina La statistique d'endurance du Pokémon.
	 * @param cp Le CP du Pokémon, représentant sa force de combat.
	 * @param hp Les points de vie (HP) du Pokémon.
	 * @param dust La quantité de poussière de Stardust associée à ce Pokémon.
	 * @param candy Le nombre de bonbons associés à ce Pokémon.
	 * @param iv La valeur IV, qui détermine la puissance cachée du Pokémon.
	 */
	public Pokemon(
			final int index,
			final String name,
			final int attack,
			final int defense,
			final int stamina,
			final int cp,
			final int hp,
			final int dust,
			final int candy,
			final double iv) {
		super(index, name, attack, defense, stamina);
		this.cp = cp;
		this.hp = hp;
		this.dust = dust;
		this.candy = candy;
		this.iv = iv;
	}

	/**
	 * Retourne le CP (Combat Power) du Pokémon.
	 *
	 * @return Le CP du Pokémon.
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * Retourne les points de vie (HP) du Pokémon.
	 *
	 * @return Les HP du Pokémon.
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Retourne la quantité de poussière de Stardust associée au Pokémon.
	 *
	 * @return La quantité de Stardust du Pokémon.
	 */
	public int getDust() {
		return dust;
	}

	/**
	 * Retourne le nombre de bonbons associés au Pokémon.
	 *
	 * @return Le nombre de bonbons du Pokémon.
	 */
	public int getCandy() {
		return candy;
	}

	/**
	 * Retourne la valeur d'IV (Individual Value) du Pokémon, qui détermine sa puissance cachée.
	 *
	 * @return La valeur IV du Pokémon.
	 */
	public double getIv() {
		return iv;
	}
}
