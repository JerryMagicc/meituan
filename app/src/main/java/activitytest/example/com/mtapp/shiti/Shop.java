package activitytest.example.com.mtapp.shiti;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2018/8/7.
 */

public class Shop extends BmobObject {
    private String ShopName;
    private Integer Money;
    private String Food;

    public String getshopName() {
        return ShopName;
    }
    public void setshopName(String ShopName) {
        this.ShopName = ShopName;
    }
    public int getMoney() {
        return Money;
    }
    public void setMoney(int Money) {
        this.Money = Money;
    }
    public String getFood() {
        return Food;
    }
    public void setFood(String Food) {
        this.Food = Food;
    }

}


