import processing.core.PApplet;

public class App extends PApplet {

    Speed cardGame = new Speed();
    private int timer;

    public static void main(String[] args) {
        PApplet.main("App");
    }
    @Override
    public void settings() {
        size(600, 600);   
    }

    @Override
    public void draw() {
        background(255);
        
        // Draw player hands
        
        for (int i = 0; i < cardGame.playerOneHand.getSize(); i++) {
            
            Card card = cardGame.playerOneHand.getCard(i);
            if (card != null) {
                
                card.draw(this);
            }
        }
        // Draw computer hand
        for (int i = 0; i < cardGame.playerTwoHand.getSize(); i++) {
            Card card = cardGame.playerTwoHand.getCard(i);
            if (card != null) {
                card.draw(this);
            }
        }
        
        // Draw draw button
        fill(200);
        cardGame.drawButton.draw(this);
        fill(0);
        textAlign(CENTER, CENTER);
        text("Draw", cardGame.drawButton.x + cardGame.drawButton.width / 2, cardGame.drawButton.y + cardGame.drawButton.height / 2);

        // Display current player
        fill(0);
        textSize(16);
        //text("Current Player: " + cardGame.getCurrentPlayer(), width / 2, 20);

        // Display deck size
        text("Deck Size: " + cardGame.getDeckSize(), width / 2,
                height - 20);
        // Display last played card
        if (cardGame.getLastPlayedCard(1) != null) {
            cardGame.getLastPlayedCard(1).setPosition(cardGame.discard1x, cardGame.discardy, 80, 120);
            cardGame.getLastPlayedCard(1).draw(this);
        }

        if (cardGame.getLastPlayedCard(2) != null) {
            cardGame.getLastPlayedCard(2).setPosition(cardGame.discard2x, cardGame.discardy, 80, 120);
            cardGame.getLastPlayedCard(2).draw(this);
        }

        if (cardGame.getCurrentPlayer() == "Player Two") {
            fill(0);
            textSize(16);
            text("Computer is thinking...", width / 2, height / 2 + 80);
            timer++;
            if (timer == 100) {
                cardGame.handleComputerTurn();
                timer = 0;
            }
        }

        cardGame.drawChoices(this);
    }

    
    @Override
    public void mousePressed() {
        cardGame.handleDrawButtonClick(mouseX, mouseY);
        cardGame.handleCardClick(mouseX, mouseY);
    }

}
