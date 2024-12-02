package fr.univavignon.pokedex.api;


public interface IPokedexFactory {


	IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory);
	
}
