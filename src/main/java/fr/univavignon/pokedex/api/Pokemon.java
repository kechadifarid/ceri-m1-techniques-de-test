package fr.univavignon.pokedex.api;


public final class Pokemon extends PokemonMetadata {


	private final int cp;


	private final int hp;

	private final int dust;


	private final int candy;

	private final double iv;

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


	public int getCp() {
		return cp;
	}
	

	public int getHp() {
		return hp;
	}


	public int getDust() {
		return dust;
	}

	public int getCandy() {
		return candy;
	}
	

	public double getIv() {
		return iv;
	}
	
}
