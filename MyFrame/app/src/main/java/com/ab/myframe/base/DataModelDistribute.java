package com.ab.myframe.base;

/**
 * Created by shenbinghong on 2018/3/9.
 */

public class DataModelDistribute {

    public static BaseModel request(String token){
        // 声明一个空的BaseModel
        BaseModel model = null;

        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel)Class.forName(token).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
