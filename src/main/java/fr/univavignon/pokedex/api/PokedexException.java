package fr.univavignon.pokedex.api;


 public final class PokedexException extends Exception {

   /** Serialization index. **/
   private static final long serialVersionUID = 1L;

   public PokedexException(final String message) {
     super(message);
   }

 }
