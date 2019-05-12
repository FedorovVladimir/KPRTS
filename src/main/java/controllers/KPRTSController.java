package controllers;

import controllers.png_utils.LetterConverter;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.KPRTS;
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

    // прочие квадратные кнопки
    @FXML
    private ImageView APK, VOR, DME, ILS, MLS, RSBN, MB1, MB2, MB3, DKMV1, DKMV2, CHNGNav, CHNGCont;

    // прочие круглые кнопки
    @FXML
    private  ImageView VSS, MRP, OPZ, PSD, MFK, Eight33, AM, RD, PA, PS;

    // главный тумблер
    @FXML
    private ImageView mainSwitcher;

    private ArrayList<ImageView[]> panels;

    private KPRTS kprts;

    // !!!! временная заглушка для состояния аппарата
    private int state = 0;

    /**
     * Не получилось обработать одновременное нажатие средней кнопки с правой и левой.
     * Логика будет немного другой. Нажатие на среднюю тумблер оттягивает.
     * Повторное нажатие кнопку вжимает обратно
     */

    private boolean dangerMode = false;

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

        MB1.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MB1.png")));
        MB1.setViewport(new Rectangle2D(3, 4, 42, 25));

        MB2.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MB2.png")));
        MB2.setViewport(new Rectangle2D(3, 4, 42, 25));

        MB3.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MB3.png")));
        MB3.setViewport(new Rectangle2D(3, 4, 42, 25));

        DKMV1.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/DKMB1.png")));
        DKMV1.setViewport(new Rectangle2D(3, 4, 42, 25));

        DKMV2.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/DKMB2.png")));
        DKMV2.setViewport(new Rectangle2D(3, 4, 42, 25));

        VSS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnBCC.png")));
        VSS.setViewport(new Rectangle2D(0, 0, 32, 32));

        MRP.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnMRP.png")));
        MRP.setViewport(new Rectangle2D(0, 0, 32, 32));

        Eight33.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/8.33.png")));
        Eight33.setViewport(new Rectangle2D(0, 0, 32, 32));

        AM.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/AM.png")));
        AM.setViewport(new Rectangle2D(0, 0, 32, 32));

        RD.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/RD.png")));
        RD.setViewport(new Rectangle2D(0, 0, 32, 32));

        PA.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/PA.png")));
        PA.setViewport(new Rectangle2D(0, 0, 32, 32));

        PS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/PS.png")));
        PS.setViewport(new Rectangle2D(0, 0, 32, 32));

        OPZ.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnOPZ.png")));
        OPZ.setViewport(new Rectangle2D(0, 0, 32, 32));

        PSD.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnPSD.png")));
        PSD.setViewport(new Rectangle2D(0, 0, 32, 32));

        MFK.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MFK.png")));
        MFK.setViewport(new Rectangle2D(0, 0, 32, 32));

        CHNGNav.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/arrow.png")));
        CHNGNav.setViewport(new Rectangle2D(3, 4, 42, 25));

        CHNGCont.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/arrow.png")));
        CHNGCont.setViewport(new Rectangle2D(3, 4, 42, 25));

        mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
        mainSwitcher.setViewport(new Rectangle2D(10, 6, 88, 88));

        mainSwitcher.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.MIDDLE)) {
                    if (mouseEvent.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                        if (state == 0) {
                            mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                            mainSwitcher.setViewport(new Rectangle2D(10, 106, 88, 88));
                        } else
                        if (state == 1) {
                            mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                            mainSwitcher.setViewport(new Rectangle2D(210, 106, 88, 88));
                        } else {
                            mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                            mainSwitcher.setViewport(new Rectangle2D(110, 106, 88, 88));
                        }
                    }
                }
            }
        });

        mainSwitcher.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.MIDDLE)) {
                    if (mouseEvent.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
                        if (state == 0) {
                            mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                            mainSwitcher.setViewport(new Rectangle2D(10, 6, 88, 88));
                        } else
                        if (state == 1) {
                            mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                            mainSwitcher.setViewport(new Rectangle2D(210, 6, 88, 88));
                        } else {
                            mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                            mainSwitcher.setViewport(new Rectangle2D(110, 6, 88, 88));
                        }
                    }
                }
            }
        });

        mainSwitcher.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 1) {
                        if (state == 0) {
                            setToMode2();
                        } else
                        if (state == 2) {
                            if (!dangerMode) {
                                mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                                mainSwitcher.setViewport(new Rectangle2D(210, 6, 88, 88));
                            } else {
                                mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                                mainSwitcher.setViewport(new Rectangle2D(210, 106, 88, 88));
                            }
                            state = 1;
                        }
                    }
                } else
                if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                    if (state == 1) {
                        setToMode2();
                    } else if (state == 2) {
                        if (dangerMode) {
                            mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                            mainSwitcher.setViewport(new Rectangle2D(10, 106, 88, 88));
                            state = 0;
                        }
                    }
                } else
                if (mouseEvent.getButton().equals(MouseButton.MIDDLE)) {
                    if (mouseEvent.getClickCount() == 1) {
                        if (state == 0) {
                            if (!dangerMode) {
                                dangerMode = true;
                                mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                                mainSwitcher.setViewport(new Rectangle2D(10, 106, 88, 88));
                            } else {
                                dangerMode = false;
                                mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                                mainSwitcher.setViewport(new Rectangle2D(10, 6, 88, 88));
                            }
                        } else if (state == 1) {
                            if (!dangerMode) {
                                dangerMode = true;
                                mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                                mainSwitcher.setViewport(new Rectangle2D(210, 106, 88, 88));
                            } else {
                                dangerMode = false;
                                mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                                mainSwitcher.setViewport(new Rectangle2D(210, 6, 88, 88));
                            }
                        } else if (state == 2) {
                            if (!dangerMode) {
                                dangerMode = true;
                                mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                                mainSwitcher.setViewport(new Rectangle2D(110, 106, 88, 88));
                            } else {
                                dangerMode = false;
                                mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                                mainSwitcher.setViewport(new Rectangle2D(110, 6, 88, 88));
                            }
                        }
                    }
                }
            }

            private void setToMode2() {
                if (!dangerMode) {
                    mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                    mainSwitcher.setViewport(new Rectangle2D(110, 6, 88, 88));
                } else {
                    mainSwitcher.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/Kompl.png")));
                    mainSwitcher.setViewport(new Rectangle2D(110, 106, 88, 88));
                }
                state = 2;
            }
        });
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

    @FXML
    public void MB1Pressed() {
        MB1.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MB1.png")));
        MB1.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void MB1Released() {
        MB1.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MB1.png")));
        MB1.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void MB2Pressed() {
        MB2.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MB2.png")));
        MB2.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void MB2Released() {
        MB2.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MB2.png")));
        MB2.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void MB3Pressed() {
        MB3.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MB3.png")));
        MB3.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void MB3Released() {
        MB3.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MB3.png")));
        MB3.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void DKMV1Pressed() {
        DKMV1.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/DKMB1.png")));
        DKMV1.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void DKMV1Released() {
        DKMV1.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/DKMB1.png")));
        DKMV1.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void DKMV2Pressed() {
        DKMV2.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/DKMB2.png")));
        DKMV2.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void DKMV2Released() {
        DKMV2.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/DKMB2.png")));
        DKMV2.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void VSSPressed() {
        VSS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnBCC.png")));
        VSS.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void VSSReleased() {
        VSS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnBCC.png")));
        VSS.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void MRPPressed() {
        MRP.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnMRP.png")));
        MRP.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void MRPReleased() {
        MRP.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnMRP.png")));
        MRP.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void Eight33Pressed() {
        Eight33.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/8.33.png")));
        Eight33.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void Eight33Released() {
        Eight33.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/8.33.png")));
        Eight33.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void AMPressed() {
        AM.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/AM.png")));
        AM.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void AMReleased() {
        AM.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/AM.png")));
        AM.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void RDPressed() {
        RD.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/RD.png")));
        RD.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void RDReleased() {
        RD.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/RD.png")));
        RD.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void PAPressed() {
        PA.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/PA.png")));
        PA.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void PAReleased() {
        PA.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/PA.png")));
        PA.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void PSPressed() {
        PS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/PS.png")));
        PS.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void PSReleased() {
        PS.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/PS.png")));
        PS.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void OPZPressed() {
        OPZ.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnOPZ.png")));
        OPZ.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void OPZReleased() {
        OPZ.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnOPZ.png")));
        OPZ.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void PSDPressed() {
        PSD.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnPSD.png")));
        PSD.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void PSDReleased() {
        PSD.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/KnPSD.png")));
        PSD.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void MFKPressed() {
        MFK.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MFK.png")));
        MFK.setViewport(new Rectangle2D(34, 0, 32, 32));
    }

    @FXML
    public void MFKReleased() {
        MFK.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/MFK.png")));
        MFK.setViewport(new Rectangle2D(0, 0, 32, 32));
    }

    @FXML
    public void CHNGNavPressed() {
        CHNGNav.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/arrow.png")));
        CHNGNav.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void CHNGNavReleased() {
        CHNGNav.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/arrow.png")));
        CHNGNav.setViewport(new Rectangle2D(3, 4, 43, 26));
    }

    @FXML
    public void CHNGContPressed() {
        CHNGCont.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/arrow.png")));
        CHNGCont.setViewport(new Rectangle2D(52, 4, 42, 24));
    }

    @FXML
    public void CHNGContReleased() {
        CHNGCont.setImage(new Image(getClass().getResourceAsStream("/png/Buttons/arrow.png")));
        CHNGCont.setViewport(new Rectangle2D(3, 4, 43, 26));
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
