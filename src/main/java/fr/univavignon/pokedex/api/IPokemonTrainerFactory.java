package fr.univavignon.pokedex.api;


public interface IPokemonTrainerFactory {


	PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory);
	
}
