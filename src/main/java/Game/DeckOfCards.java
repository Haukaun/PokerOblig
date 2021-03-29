package Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javafx.scene.image.Image;

public class DeckOfCards {
    private final char[] suit = new char[]{'S', 'H', 'D', 'C'};
    private final Integer[] face = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private ArrayList<Card> deck = new ArrayList();
    private Image backOfCardImage = new Image("./Images/gray_back.png");

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public Image getBackOfCardImage() {
        return this.backOfCardImage;
    }

    public void setBackOfCardImage(Image backOfCardImage) {
        this.backOfCardImage = backOfCardImage;
    }

    public DeckOfCards() {
    }

    public void addCards() {
        for(int i = 0; i < this.suit.length; ++i) {
            String value = String.valueOf(this.suit[i]);

            for(int x = 0; x < this.face.length; ++x) {
                this.deck.add(new Card(this.suit[i], this.face[x]));
            }
        }

    }

    public String deckInfo() {
        String output = "";

        for(int i = 0; i < this.deck.size(); ++i) {
            output = output + ((Card)this.deck.get(i)).asString() + "\n";
        }

        return output;
    }

    public void shuffelCards() {
        this.deck.forEach((card) -> {
            Collections.shuffle(this.deck);
        });
    }

    public Collection<Card> dealHand(int card) throws IllegalArgumentException {
        if (card > this.deck.size()) {
            throw new IllegalArgumentException();
        } else {
            ArrayList<Card> drawnCard = new ArrayList();

            for(int cardsDrawn = 0; cardsDrawn < card; ++cardsDrawn) {
                Card cardDrawn = this.deck.get(cardsDrawn);
                drawnCard.add(cardDrawn);
                this.deck.remove(cardDrawn);
            }

            return drawnCard;
        }
    }
}