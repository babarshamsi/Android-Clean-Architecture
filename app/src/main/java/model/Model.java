package model;

/**
 * Created by Lenovo on 10/30/2017.
 */

public class Model {


  private String name;
   private int picture;

//    public Model(String name, int picture){
//
//     this.name = name;
//        this.picture = picture;
//
//
//    }
//

    public Model(String name){

        this.name = name;
       // this.picture = picture;


    }

    public String getName(){return name;}
    public int getPicture(){return picture;}

}
