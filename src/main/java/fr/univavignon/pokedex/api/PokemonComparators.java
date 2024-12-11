package fr.univavignon.pokedex.api;

import java.util.Comparator;

/**
 * Enumération des différents comparateurs pour trier les objets {@link Pokemon}.
 * Cette classe fournit plusieurs façons de trier les Pokémon en fonction de leurs
 * propriétés : par nom, par index ou par CP (Combat Power).
 *
 * Chaque comparateur est implémenté en utilisant un {@link Comparator} spécifique
 * à la propriété souhaitée du Pokémon.
 */
public enum PokemonComparators implements Comparator<Pokemon> {

	/**
	 * Comparateur qui trie les Pokémon par leur nom.
	 */
	NAME(Comparator.comparing(Pokemon::getName)),

	/**
	 * Comparateur qui trie les Pokémon par leur index.
	 */
	INDEX(Comparator.comparing(Pokemon::getIndex)),

	/**
	 * Comparateur qui trie les Pokémon par leur CP (Combat Power).
	 */
	CP(Comparator.comparing(Pokemon::getCp));

	/** Le comparateur spécifique à cette enum, utilisé pour effectuer les comparaisons. */
	private final Comparator<Pokemon> delegate;

	/**
	 * Constructeur pour initialiser le comparateur avec un {@link Comparator} spécifique.
	 *
	 * @param delegate Le {@link Comparator} utilisé pour effectuer la comparaison entre Pokémon.
	 */
	private PokemonComparators(final Comparator<Pokemon> delegate) {
		this.delegate = delegate;
	}

	/**
	 * Effectue la comparaison entre deux Pokémon en fonction du comparateur sélectionné.
	 * Cette méthode délègue la comparaison au comparateur correspondant à l'instance de l'enum.
	 *
	 * @param first Le premier Pokémon à comparer.
	 * @param second Le second Pokémon à comparer.
	 * @return Un entier négatif, zéro ou positif selon que le premier Pokémon soit plus petit,
	 *         égal ou plus grand que le second, selon le comparateur sélectionné.
	 */
	@Override
	public int compare(final Pokemon first, final Pokemon second) {
		return delegate.compare(first, second);
	}
}
