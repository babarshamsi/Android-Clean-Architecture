package model;

import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by Lenovo on 10/30/2017.
 */

public class ModelInteractor implements Interactor {

    private String[] names = {  "Rocket in the universe",
            "A scene in London",
            "Moon over mountains",
            "A simple moon",
            "Sun and volcano",
            "A collection of mountains",
            "River between mountains",
            "Some pine trees",
            "On Small Town",
            "Volcanos reflection"};

//    private int[] images= {  R.drawable.cohete_flat,
//            R.drawable.london_flat,
//            R.drawable.material_flat,
//            R.drawable.moon_flat,
//            R.drawable.mountain_flat,
//            R.drawable.mountain_mo_flat,
//            R.drawable.moutain_go_flat,
//            R.drawable.pine_flat,
//            R.drawable.towers_flat,
//            R.drawable.vulcan_flat};


    @Override
    public void LoadItems(final LoaderListener loaderListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loaderListener.onFinished(listCollection());

            }
        },2 *1000);


    }

    private ArrayList<Object> listCollection(){

        ArrayList<Object> list = new ArrayList<Object>();

        for (int i =0; i<10 ; i++){

           // list.add(new Model(names[i],images[i]));
            list.add(new Model(names[i]));


        }

        return list;
    }

}
