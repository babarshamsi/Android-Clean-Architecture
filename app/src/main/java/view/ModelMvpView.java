package view;

import java.util.ArrayList;

import model.Model;

/**
 * Created by Lenovo on 10/30/2017.
 */

public interface ModelMvpView {


    void setItems(ArrayList<Object> list);

    void showProgress();

    void hideProgress();

    void showMessage(String message);

}
