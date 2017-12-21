package model;

import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by Lenovo on 11/1/2017.
 */

public class ModelSecondInteractor implements Interactor {

    private String[] name ={ "Rocket in the universe",
            "A scene in London",
            "Moon over mountains",
            "A simple moon",
            "Sun and volcano",
            "A collection of mountains",
            "River between mountains",
            "Some pine trees",
            "On Small Town",
            "Volcanos reflection"};

    private String[] message = {"Rocket in the universe",
            "A scene in London",
            "Moon over mountains",
            "A simple moon",
            "Sun and volcano",
            "A collection of mountains",
            "River between mountains",
            "Some pine trees",
            "On Small Town",
            "Volcanos reflection"};




    @Override
    public void LoadItems(final LoaderListener loaderListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                   loaderListener.onFinished(getlistCollection());

            }
        },2 * 1000);


    }

    private ArrayList<Object> getlistCollection(){

        ArrayList<Object> list = new ArrayList<>();

        for (int i =0 ; i <10 ; i ++){

            list.add(new ModelSecond(name[i],message[i]));

        }
            return list;

    }



}
