package controller;

import javafx.event.ActionEvent;
import model.StageList;

public class BackConfirmFormController extends StageList {
    public void btnOkOnAction(ActionEvent actionEvent) {
        mainStage.show();
        backConfirmStage.close();
        vehicleEntryStage.close();
        vehicleExitStage.close();
        mainMenuPaymentStage.close();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        backConfirmStage.close();
    }
}
