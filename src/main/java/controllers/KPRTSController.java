package controllers;

import controllers.png_utils.LetterConverter;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.KPRTS;

import java.awt.event.MouseEvent;
import java.beans.EventHandler;
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

    // блок ячеек режима связи
    @FXML
    private ImageView contactMode_1, contactMode_2, contactMode_3, contactMode_4,
            contactMode_5, contactMode_6, contactMode_7, contactMode_8;

    // прочие кнопки
    @FXML
    private ImageView APK, VOR, DME, ILS, MLS, RSBN, MB1, MB2, MB3;

    private ArrayList<ImageView[]> panels;

    private KPRTS kprts;

    @FXML
    public void initialize() {
        kprts = new KPRTS();
        // включение - вызвать turnOn в статусе 2
        kprts.turnOn(2);
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

        for (int i = 1; i <= 6; i++) {
            setTextOnPanel(i, kprts.getTextFromPanel(i));
            System.out.println(kprts.getTextFromPanel(i));
        }

        APK.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/ARK.png")));
        APK.setViewport(new Rectangle2D(3, 4, 42, 25));

        VOR.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/VOR.png")));
        VOR.setViewport(new Rectangle2D(3, 4, 42, 25));

        DME.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/DME.png")));
        DME.setViewport(new Rectangle2D(3, 4, 42, 25));

        ILS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/ILS.png")));
        ILS.setViewport(new Rectangle2D(3, 4, 42, 25));

        MLS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MLS.png")));
        MLS.setViewport(new Rectangle2D(3, 4, 42, 25));

        RSBN.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/RSBN.png")));
        RSBN.setViewport(new Rectangle2D(3, 4, 42, 25));
    }

    public void setTextOnPanel(int numberOfPanel, String message) {
        int concreteNum = numberOfPanel - 1;
        new LetterConverter().setTextInPanel(panels.get(concreteNum), message);
    }

    @FXML
    public void ARKPressed() {
        APK.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/ARK.png")));
        APK.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void ARKReleased() {
        APK.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/ARK.png")));
        APK.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void VORPressed() {
        VOR.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/VOR.png")));
        VOR.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void VORReleased() {
        VOR.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/VOR.png")));
        VOR.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void DMEPressed() {
        DME.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/DME.png")));
        DME.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void DMEReleased() {
        DME.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/DME.png")));
        DME.setViewport(new Rectangle2D(3, 4, 43, 26));
    }
    @FXML
    public void ILSPressed() {
        ILS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/ILS.png")));
        ILS.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void ILSReleased() {
        ILS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/ILS.png")));
        ILS.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void MLSPressed() {
        MLS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MLS.png")));
        MLS.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void MLSReleased() {
        MLS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MLS.png")));
        MLS.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void RSBNPressed() {
        RSBN.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/RSBN.png")));
        RSBN.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void RSBNReleased() {
        RSBN.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/RSBN.png")));
        RSBN.setViewport(new Rectangle2D(3, 4, 43, 26));
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
