package src.Main.gameUtils;

import java.awt.*;

public class Node extends Point implements Damagable, Buyable{
    private double health;
    private double price;
    private TypeEnums type;

    public Node (int x, int y, TypeEnums type){
        this.x = x;
        this.y = y;
        this.type = type;
        this.health = type.getHealth();
        calcPrice();
    }

    @Override
    public boolean damage(double damage) {
        return false;
    }

    @Override
    public boolean heal(double healAmount) {
        return false;
    }
    @Override
    public double getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public void calcPrice() {
        price = type.getPrice()-25;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
