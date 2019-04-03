package srushti.example.com.quiza;

/**
 * model class..the representation for multiple questions
 * Created by Srushti on 25-01-2018.
 */
//to create connection btw model and controller

public class Question {
    private int TextResID;
    private boolean AnsTrue;
//alt+insert for constructor,getter and setter method i.e to generate some other
    //File-settings-codestyle-code geenration --to remove m

    public Question(int textResID, boolean ansTrue) {
        TextResID = textResID;
        AnsTrue = ansTrue;
    }

    public int getTextResID() {
        return TextResID;
    }

    public void setTextResID(int textResID) {
        TextResID = textResID;
    }

    public boolean isAnsTrue() {
        return AnsTrue;
    }

    public void setAnsTrue(boolean ansTrue) {
        AnsTrue = ansTrue;
    }
}
