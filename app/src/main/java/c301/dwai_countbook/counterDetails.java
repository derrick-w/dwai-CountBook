package c301.dwai_countbook;

/**
 * Created by DWai on 10/2/2017.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class CounterDetails{
    private String name;
    private Date updated;
    private int current;
    private int initial;
    private String comment;



    public void setInitial(int initial) {
        this.update();
        this.initial = initial;
    }

    public Date getLast() {
        return last;
    }



    private Date last;

    public CounterDetails(String name, String comment, int initial) {
        this.name = name;
        this.comment = comment;
        this.initial = initial;
        this.updated = new Date();
        this.last = new Date();
        this.current = this.initial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.update();
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.update();
        this.comment = comment;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.update();
        this.current = current;
    }


    public String getDateString() {
        return new SimpleDateFormat("dd/MM/yy, h:mm a").format(this.updated);
    }
    public String getLastString() {
        return new SimpleDateFormat("dd/MM/yy, h:mm:ss a").format(this.last);
    }
    public void update(){
        this.last = new Date();
    }
    public int getInitial() {
        return initial;
    }


    @Override
    public String toString() {
        return new SimpleDateFormat("dd/MM/yy, h:mm a").format(this.updated);
    }
}