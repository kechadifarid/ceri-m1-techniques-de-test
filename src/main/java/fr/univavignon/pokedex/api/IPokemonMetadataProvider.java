package fr.univavignon.pokedex.api;


public interface IPokemonMetadataProvider {


	PokemonMetadata getPokemonMetadata(int index) throws PokedexException;
	
}
