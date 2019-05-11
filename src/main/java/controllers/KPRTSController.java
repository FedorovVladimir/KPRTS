package controllers;

import controllers.png_utils.LetterConverter;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


public class KPRTSController {
    // показания основной и резервной/зпу навигации
    private double navigationMain;
    private double navigationReserve;

    // показания основной и резервной связи
    private double contactMain;
    private double contactReserve;

    @FXML
    private ImageView mainNavigation;

    @FXML
    public void initialize() {
        new LetterConverter().getImageByLetter('1', mainNavigation);
    }

    public double getNavigationMain() {
        return navigationMain;
    }

    public void setNavigationMain(double navigationMain) {
        this.navigationMain = navigationMain;
    }

    public double getNavigationReserve() {
        return navigationReserve;
    }

    public void setNavigationReserve(double navigationReserve) {
        this.navigationReserve = navigationReserve;
    }

    public double getContactMain() {
        return contactMain;
    }

    public void setContactMain(double contactMain) {
        this.contactMain = contactMain;
    }

    public double getContactReserve() {
        return contactReserve;
    }

    public void setContactReserve(double contactReserve) {
        this.contactReserve = contactReserve;
    }
}
