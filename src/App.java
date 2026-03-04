import processing.core.PApplet;

public class App extends PApplet {


    ClickableRectangle newGameButton = new ClickableRectangle();
    Speed cardGame = new Speed();
    SpeedComputer computer = new SpeedComputer(cardGame);
    private int timer;
    int gameButtonX = 250;
    int gameButtonY = 400;
    int gameButtonWidth = 100;
    int gameButtonHeight = 35;
    boolean game = true;
    

    public static void main(String[] args) {
        PApplet.main("App");
    }
    @Override
    public void settings() {
        size(600, 600);   
        newGameButton.x = gameButtonX;
        newGameButton.y = gameButtonY;
        newGameButton.width = gameButtonWidth;
        newGameButton.height = gameButtonHeight;
    }

    public void endGame(int player) {
        background(255);
        text("PLAYER " + player + " WINS", 300, 300);
        newGameButton.draw(this);
        text("NEW GAME?", newGameButton.x + newGameButton.width/2, newGameButton.y + newGameButton.height/2);
    }

    @Override
    public void draw() {
        background(255);
        

        //Use computer
        computer.draw();
        
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
        text("Deck Size: " + cardGame.getPlayerOneSize(), width / 2, height - 20);
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
        if (cardGame.playerOneDeck.size() == 0 && cardGame.playerOneHand.getSize() == 0) {
            endGame(1);
            game = false;
        }
        if (cardGame.playerTwoDeck.size() == 0 && cardGame.playerTwoHand.getSize() == 0) {
            endGame(2);
            game = false;
        }
    }

    
    @Override
    public void mousePressed() {
        cardGame.handleDrawButtonClick(mouseX, mouseY);
        cardGame.handleCardClick(mouseX, mouseY);
        if (!game) {
            if (newGameButton.isClicked(dmouseX, dmouseY)) {
                game = true;
                cardGame = new Speed();
            }
        }
    }
}