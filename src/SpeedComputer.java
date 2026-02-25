public class SpeedComputer {
    Speed game;
    int count = 0;

    public SpeedComputer(Speed newGame) {
        game = newGame;
    }
    public void draw() {
        System.out.println("WE ARE GOING YAYAYAYAYAYAY");
        count++;
        if (count % 60 == 0) {
            for (int i = 0; i < game.playerTwoHand.getSize() - 1; i++) {
                if (game.playCard(game.playerTwoHand.getCard(i), game.playerTwoHand, game.discard1)) {
                    return;
                }
                if (game.playCard(game.playerTwoHand.getCard(i), game.playerTwoHand, game.discard2)) {
                    return;
                }
            }
            if (game.playerTwoHand.getSize() < 5) {
                game.drawCard(game.playerTwoHand, game.playerTwoDeck);
                return;
            }
        }
        
    }

}
