package src.Main.gameUtils;

import java.awt.*;
import java.util.ArrayList;

public class Node extends Point implements Damagable, Buyable{
    private double health;
    private double price;
    private TypeEnums type;
    private ArrayList<Line> startOfLines;
    private ArrayList<Line> endOfLines;

    public Node (double x, double y, TypeEnums type){
        this.x = (int)x;
        this.y = (int)y;
        this.type = type;
        this.health = type.getHealth();
        startOfLines = new ArrayList<>();
        endOfLines = new ArrayList<>();
        calcPrice();
    }

    public ArrayList<Line> getStartOfLines() {
        return startOfLines;
    }

    public TypeEnums getType() {
        return type;
    }

    public ArrayList<Line> getEndOfLines() {
        return endOfLines;
    }

    public void createLine(Node endNode){
        if(endNode == null) {
            System.out.println("End node can not be null!");
        }
        if(this == endNode){
            System.out.println("Start node can not be the end node at the same time!");
            return;
        }
        startOfLines.add(new Line(this, endNode, this.type));
        endNode.connectLine(this);
    }
    public void connectLine(Node startNode){
        if(startNode == null) {
            System.out.println("Start node can not be null!");
        }
        if(this == startNode){
            System.out.println("End node can not be the start node at the same time!");
            return;
        }
        endOfLines.add(startNode.startOfLines.getLast());
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
