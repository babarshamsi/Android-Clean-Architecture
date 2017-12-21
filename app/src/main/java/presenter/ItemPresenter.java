package presenter;

import java.util.ArrayList;

import babarshamsi92.androidcleanarchitecture.MyActivity;
import model.LoaderListener;
import model.ModelInteractor;
import model.ModelSecondInteractor;
import view.ModelMvpView;

/**
 * Created by Lenovo on 10/30/2017.
 */

public class ItemPresenter implements Presenter<ModelMvpView>, LoaderListener {

    ModelInteractor modelInteractor ;
    ModelSecondInteractor modelSecondInteractor;
    ModelMvpView modelMvpView;

    public ItemPresenter(){
        modelInteractor = new ModelInteractor();
        modelSecondInteractor = new ModelSecondInteractor();

    }


    @Override
    public void attachedView(ModelMvpView view) {
        if (view == null)
            throw new IllegalArgumentException("You can't set a null view");

        this.modelMvpView = view;



    }

    @Override
    public void detachView() {

        modelMvpView = null;
    }

    @Override
    public void onResume() {
        modelMvpView.showProgress();
      if (modelMvpView instanceof MyActivity)
        modelInteractor.LoadItems(this);
        else
        modelSecondInteractor.LoadItems(this);

    }

    @Override
    public void onItemSelected(int position) {
        modelMvpView.showMessage(Integer.toString(position));
    }

    @Override
    public void onItemSelected(String item) {
        modelMvpView.showMessage(item);
    }



    @Override
    public void onFinished(ArrayList<Object> list) {
        modelMvpView.setItems(list);
        modelMvpView.hideProgress();
    }


}
