package src.Main.gameUtils;

import java.awt.*;

public class Line extends Rectangle implements Damagable, Buyable{
    Node node1;
    Node node2;
    private double health;
    private double price;
    private TypeEnums type;
    private Rectangle visiblePart;

    public Line(Node node1, Node node2, TypeEnums type){
        health = type.getHealth();
        visiblePart = new Rectangle(); //this should be changed to line
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
    public double getHealth() {
        return 0;
    }

    @Override
    public void calcPrice() {
        double distance = node1.distance(node2);
        price = type.getPrice() * distance;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
