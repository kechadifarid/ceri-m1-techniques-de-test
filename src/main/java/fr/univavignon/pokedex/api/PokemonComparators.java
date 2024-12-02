package fr.univavignon.pokedex.api;

import java.util.Comparator;


public enum PokemonComparators implements Comparator<Pokemon> {


	NAME(Comparator.comparing(Pokemon::getName)),


	INDEX(Comparator.comparing(Pokemon::getIndex)),
	

	CP(Comparator.comparing(Pokemon::getCp))
	
	;
	

	private final Comparator<Pokemon> delegate;


	private PokemonComparators(final Comparator<Pokemon> delegate) {
		this.delegate = delegate;
	}


	@Override
	public int compare(final Pokemon first, final Pokemon second) {
		
		return delegate.compare(first, second);
	}

}
