import java.util.ArrayList;
import java.util.Collections;

public class Speed extends CardGame {
    ArrayList<Card> playerOneDeck;
    ArrayList<Card> playerTwoDeck;
    ArrayList<Card> discard1;
    ArrayList<Card> discard2;
    ArrayList<Card> deck1;
    ArrayList<Card> deck2;

    public Speed() {
        super();
        speedInitializeGame();
        dealCards(5);
    }

    protected void speedInitializeGame() {
        playerOneDeck = new ArrayList<>();
        playerTwoDeck = new ArrayList<>();
        discard1 = new ArrayList<>();
        discard2 = new ArrayList<>();
        deck1 = new ArrayList<>();
        deck2  = new ArrayList<>();
        playerOneHand = new Hand();
        playerTwoHand = new Hand(); 
    }

    public boolean playCard(Card card, Hand hand, ArrayList<Card> discard) {
        if (discard.get(discard.size()-1).getValue() == card.getValue() + 1 || discard.get(discard.size()-1).getValue() == card.getValue() - 1) {
            discard.add(card);
            hand.removeCard(card);
            return true;
        } else {
            return false;
        }
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

        discard1.add(deck1.get(0));
        deck1.remove(0);
        discard2.add(deck2.get(0));
        deck2.remove(0);

        System.out.println("help please cards dealt");
        playerOneHand.positionCards(50, 450, 80, 120, 20);
        playerTwoHand.positionCards(50, 50, 80, 120, 20);
    }
}