package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {

        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(index);
        double iv = ((pokemonMetadata.getAttack() + pokemonMetadata.getDefense() + pokemonMetadata.getStamina()) / 45.0) * 100;

        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp,hp, dust,candy,iv);

    }
}
