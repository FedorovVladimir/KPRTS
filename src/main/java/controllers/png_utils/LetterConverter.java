package controllers.png_utils;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LetterConverter {
    private final Image image = new Image(LetterConverter.class.getResourceAsStream("/png/Buttons/chars.png"));
    private final double HEIGHT = 20;
    private final double WIDTH = 14;
    private final double OFFSET_X = 1;
    private final double OFFSET_Y = 0;
    private final String alphabet = "0123456789АБВГДЕЖЗИЙКЛМНОПРСТУФ   ШILSM   3.,";

    public void getImageByLetter(char letter, ImageView imageView) {
        imageView.setImage(image);
        int offset = alphabet.indexOf(letter);
        if (offset < 0) {
            offset = alphabet.indexOf(' ');
        }
        imageView.setViewport(new Rectangle2D(OFFSET_X * offset * WIDTH, OFFSET_Y, WIDTH, HEIGHT));

    }

    public void setTextInPanel(ImageView[] panel, String sourceText) {
        char[] text = sourceText.toCharArray();
        int textOffset = 1;
        for (int i = panel.length - 1; i >= 0; i--) {
            if (textOffset <= text.length) {
                getImageByLetter(text[text.length - textOffset], panel[i]);
                textOffset++;
            } else {
                getImageByLetter(' ', panel[i]);
            }
        }
    }
}
