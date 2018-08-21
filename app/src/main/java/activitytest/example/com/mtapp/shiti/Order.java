package activitytest.example.com.mtapp.shiti;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2018/8/16.
 */

public class Order extends BmobObject {
    private String ShopName;
    private String Food;
    private String State;
    private String UserName;
    private int Number;
    private double Sum_Money;


    public void setShopName(String ShopName){
        this.ShopName=ShopName;
    }
    public String getShopName(){
        return ShopName;
    }
    public void setUserName(String UserName){
        this.UserName=UserName;
    }
    public String getUserName(){
        return UserName;
    }
    public void setFood(String Food){
        this.Food=Food;
    }
    public String getFood(){
        return Food;
    }
    public void setState(String State){
        this.State = State;
    }
    public String getState(){
        return State;
    }
    public void setNumber(int Number){
        this.Number = Number;
    }
    public int getNumber(){
        return Number;
    }
    public void setSum_Money(int Sum_Money){
        this.Sum_Money = Sum_Money;
    }
    public double getSum_Money(){
        return Sum_Money;
    }
}
