package src.Main.shipUtils;

import src.Main.gameUtils.Buyable;
import src.Main.gameUtils.Damagable;
import src.Main.gameUtils.TypeEnums;
import src.Main.gameUtils.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Enclosed implements Damagable, Buyable {
    private Polygon poly;
    private TypeEnums type;
    private Color color;
    private double health;
    int[] xPoints;
    int[] yPoints;
    private double price;
    public Enclosed(TypeEnums type, Node... nodes){
        if(nodes.length<3){
            System.out.println("Cannot form a polygon with less than 3 nodes!");
            return;
        }
        this.health = type.getHealth();
        this.type = type;
        xPoints = new int[nodes.length];
        yPoints = new int[nodes.length];
        for(int i =0; i < nodes.length; i++){
            xPoints[i] = nodes[i].x;
            yPoints[i] = nodes[i].y;
        }
        poly = new Polygon(xPoints, yPoints, nodes.length);
        color = type.getColor();
    }

    public TypeEnums getType() {
        return type;
    }

    public Polygon getPoly() {
        return poly;
    }

    public Color getColor() {
        return color;
    }

    private double calculateArea(){
        double area = 0.0;
        //shoelace
        int n = xPoints.length;
        for (int i = 0; i < n-1; i++){
            area += xPoints[i] * yPoints[i+1] - yPoints[i] * xPoints[i+1];
        }
        //polygon loop
        area += xPoints[n-1] *yPoints[0] - yPoints[n-1] * xPoints[0];
        area = Math.abs(area) / 2.0;
        return area;
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
        double area = calculateArea();
        price = area*type.getPrice();
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            poly.translate(0, -10);
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            poly.translate(0, 10);
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            poly.translate(-10, 0);
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            poly.translate(10, 0);
        }
    }
}
