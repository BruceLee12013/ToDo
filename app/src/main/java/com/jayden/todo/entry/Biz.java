package com.jayden.todo.entry;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/15.
 */

public class Biz implements Serializable{
    private String Data;
    private String Flag;
    private String ActionName;
    private String TimeTamp;

    public Biz(String data, String flag, String actionName, String timeTamp) {
        Data = data;
        Flag = flag;
        ActionName = actionName;
        TimeTamp = timeTamp;
    }

    @Override
    public String toString() {
        return "Biz{" +
                "Data='" + Data + '\'' +
                ", Flag='" + Flag + '\'' +
                ", ActionName='" + ActionName + '\'' +
                ", TimeTamp='" + TimeTamp + '\'' +
                '}';
    }
}
