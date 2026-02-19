import java.util.ArrayList;
import java.util.Collections;

public class Speed extends CardGame {
    ArrayList<Card> playerOneDeck;
    ArrayList<Card> playerTwoDeck;
    ArrayList<Card> discard1;
    ArrayList<Card> discard2;
    ArrayList<Card> deck1;
    ArrayList<Card> deck2;
    ClickableRectangle pile1;
    ClickableRectangle pile2;

    int discard1x = 210;
    int discard2x = 310;
    int discardHeight = 120;
    int discardWidth = 80;
    int discardy = 240;

    public Speed() {
        super();
        speedInitializeGame();
        dealCards(5);

        pile1 = new ClickableRectangle();
        pile2 = new ClickableRectangle();
        pile1.x = discard1x;
        pile1.y = discardy;
        pile1.height = discardHeight;
        pile1.width = discardWidth;
        pile2.x = discard2x;
        pile2.y = discardy;
        pile2.height = discardHeight;
        pile2.width = discardWidth;
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
            card.setTurned(false);
            return true;
        } else {
            return false;
        }
    }

    public Card getLastPlayedCard(int pile) {
        if (pile == 1) {
            return discard1.getLast();
        } else {
            return discard2.getLast();
        }
    }

    @Override
    public void handleCardClick(int mouseX, int mouseY) {
        super.handleCardClick(mouseX, mouseY);
        if (selectedCard != null) {
            if (pile1.isClicked(mouseX, mouseY)) {
                playCard(selectedCard, playerOneHand, discard1);
                selectedCard = null;
            }
            if (pile2.isClicked(mouseX, mouseY)){
                playCard(selectedCard, playerOneHand, discard2);
                selectedCard = null;
            }
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

        discard1.get(0).setTurned(false);
        discard2.get(0).setTurned(false);

        System.out.println("help please cards dealt");
        playerOneHand.positionCards(50, 450, 80, 120, 20);
        playerTwoHand.positionCards(50, 50, 80, 120, 20);
    }
}