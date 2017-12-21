package presenter;



/**
 * Created by Lenovo on 10/30/2017.
 */

public interface Presenter<V> {

    void attachedView(V view);

    void detachView();

    void onResume();

    void onItemSelected(int position);

    void onItemSelected(String item);


}



