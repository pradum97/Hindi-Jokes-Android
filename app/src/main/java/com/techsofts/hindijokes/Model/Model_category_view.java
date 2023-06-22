package com.techsofts.hindijokes.Model;

public class Model_category_view {
    int ID ;
    String TITLE , CATEGORY;

    public Model_category_view(int ID, String TITLE, String CATEGORY, String message) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.CATEGORY = CATEGORY;
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

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

}
