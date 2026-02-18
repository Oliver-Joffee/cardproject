import java.util.ArrayList;
import java.util.Collections;

public class Speed extends CardGame {
    ArrayList<Card> playerOneDeck;
    ArrayList<Card> playerTwoDeck;
    ArrayList<Card> discard1;
    ArrayList<Card> discard2;
    ArrayList<Card> deck1;
    ArrayList<Card> deck2;
    Hand playerOneHand;
    Hand playerTwoHand;

    public Speed() {
        playerOneDeck = new ArrayList<>();
        playerTwoDeck = new ArrayList<>();
        discard1 = new ArrayList<>();
        discard2 = new ArrayList<>();
        deck1 = new ArrayList<>();
        deck2  = new ArrayList<>();
        playerOneHand = new Hand();
        playerTwoHand = new Hand(); 
        initializeGame();
        dealCards(5);
        System.out.println("this is player speaking" + playerOneHand.getSize());
    }
    
    @Override
    public void dealCards(int numCards) {
        Collections.shuffle(deck);
        System.out.println("AHHHHHHH");
        for (int i = 0; i < 21; i ++) {
            Card card = deck.remove(0);
            card.setTurned(true);
            playerOneDeck.add(card);
            Card card2 = deck.remove(0);
            card2.setTurned(true);
            playerTwoDeck.add(card2);

        }

        for (int i = 0; i < 5; i++) {
            Card card = deck.remove(0);
            card.setTurned(true);
            deck1.add(card);
            Card card2 = deck.remove(0);
            card2.setTurned(true);
            deck2.add(card2);
        }

        for (int i = 0; i < numCards; i ++) {
            Card card1 = playerOneDeck.remove(0);
            card1.setTurned(false);
            playerOneHand.addCard(card1);
            Card card2 = playerTwoDeck.remove(0);
            playerTwoHand.addCard(card2);
        }
        System.out.println("help please cards dealt");
    }
}