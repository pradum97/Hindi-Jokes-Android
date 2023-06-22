package com.techsofts.hindijokes.Model;

public class Model
{
  int ID;
  String TITLE ;

    public Model(int ID, String TITLE) {
        this.ID = ID;
        this.TITLE = TITLE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }
}
