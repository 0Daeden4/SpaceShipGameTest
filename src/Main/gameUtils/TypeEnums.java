package src.Main.gameUtils;

import java.awt.*;

public enum TypeEnums {
    IMMORTAL(-1, 0, Color.BLACK),
    PLAYER(100, 0, Color.green),
    HEAVY_ARMOR(600, 500, Color.darkGray),
    ARMOR(400, 350, Color.gray),
    STEEL(300, 300, Color.LIGHT_GRAY),
    METAL(175, 100, Color.WHITE),
    GLASS(75, 50, Color.CYAN);
    private double health;
    private double price;
    private Color color;
    private TypeEnums(double health, double price, Color color){
        this.health = health;
        this.price = price;
        this.color = color;
    }

    public double getHealth() {
        return health;
    }

    public double getPrice() {
        return price;
    }
    public Color getColor(){
        return color;
    }
}
