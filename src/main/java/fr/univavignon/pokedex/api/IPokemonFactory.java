package fr.univavignon.pokedex.api;

public interface IPokemonFactory {


	Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException;
	
}
