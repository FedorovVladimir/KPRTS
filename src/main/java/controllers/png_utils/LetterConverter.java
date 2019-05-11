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

    public void getImageByLetter(char letter, ImageView imageView) {
        switch (letter) {
            case '0': {
                getCrop(0, imageView);
                break;
            }
            case '1': {
                getCrop(1, imageView);
                break;
            }
            case '2': {
                getCrop(2, imageView);
                break;
            }
            case '3': {
                getCrop(3, imageView);
                break;
            }
            default: {
                System.out.println("Не найден эквивалент символа " + letter);
            }
        }
    }

    private void getCrop(int offset, ImageView imageView) {
        imageView.setImage(image);
        imageView.setViewport(new Rectangle2D(OFFSET_X * offset, OFFSET_Y, WIDTH, HEIGHT));
    }
}
