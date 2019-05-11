package controllers;

import controllers.png_utils.LetterConverter;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.ArrayList;


public class KPRTSController {
    // показания основной и резервной/зпу навигации
    private double navigationMain;
    private double navigationReserve;

    // показания основной и резервной связи
    private double contactMain;
    private double contactReserve;

    // блок ячеек основной навигации
    @FXML
    private ImageView mainNavigation_1, mainNavigation_2, mainNavigation_3,
            mainNavigation_4, mainNavigation_5, mainNavigation_6, mainNavigation_7, mainNavigation_8;

    // блок ячеек резервной навигации
    @FXML
    private ImageView reserveNavigation_1, reserveNavigation_2, reserveNavigation_3,
            reserveNavigation_4, reserveNavigation_5, reserveNavigation_6, reserveNavigation_7, reserveNavigation_8;

    // блок ячеек режима навигации
    @FXML
    private ImageView navigationMode_1, navigationMode_2, navigationMode_3, navigationMode_4,
            navigationMode_5, navigationMode_6, navigationMode_7, navigationMode_8;

    // блок ячеек основной связи
    @FXML
    private ImageView contactMain_1, contactMain_2, contactMain_3, contactMain_4,
            contactMain_5, contactMain_6, contactMain_7, contactMain_8;

    // блок ячеек резервной связи
    @FXML
    private ImageView contactReserve_1, contactReserve_2, contactReserve_3, contactReserve_4,
            contactReserve_5, contactReserve_6, contactReserve_7, contactReserve_8;

    @FXML
    private ImageView contactMode_1, contactMode_2, contactMode_3, contactMode_4,
            contactMode_5, contactMode_6, contactMode_7, contactMode_8;

    private ArrayList<ImageView[]> panels;

    @FXML
    public void initialize() {
        panels = new ArrayList<>();
        ImageView[] mainNavigation = new ImageView[] {
                mainNavigation_1, mainNavigation_2, mainNavigation_3, mainNavigation_4,
                mainNavigation_5, mainNavigation_6,mainNavigation_7, mainNavigation_8
        };

        ImageView[] reserveNavigation = new ImageView[] {
                reserveNavigation_1, reserveNavigation_2, reserveNavigation_3,
                reserveNavigation_4, reserveNavigation_5, reserveNavigation_6, reserveNavigation_7, reserveNavigation_8
        };
        ImageView[] modeNavigation = new ImageView[] {
                navigationMode_1, navigationMode_2, navigationMode_3, navigationMode_4,
                navigationMode_5, navigationMode_6, navigationMode_7, navigationMode_8
        };
        ImageView[] mainContact = new ImageView[] {
                contactMain_1, contactMain_2, contactMain_3, contactMain_4,
                contactMain_5, contactMain_6, contactMain_7, contactMain_8
        };
        ImageView[] reserveContact = new ImageView[] {
                contactReserve_1, contactReserve_2, contactReserve_3, contactReserve_4,
                contactReserve_5, contactReserve_6, contactReserve_7, contactReserve_8
        };
        ImageView[] modeContact = new ImageView[] {
                contactMode_1, contactMode_2, contactMode_3, contactMode_4,
                contactMode_5, contactMode_6, contactMode_7, contactMode_8
        };
        panels.add(mainNavigation);
        panels.add(reserveNavigation);
        panels.add(modeNavigation);
        panels.add(mainContact);
        panels.add(reserveContact);
        panels.add(modeContact);
    }

    public void setTextOnPanel(int numberOfPanel, String message) {
        int concreteNum = numberOfPanel - 1;
        new LetterConverter().setTextInPanel(panels.get(concreteNum), message);
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
