package src.Main.gameUtils;

import java.awt.*;
import java.awt.geom.Path2D;

public class Line implements Damagable, Buyable{
    private Node startNode;
    private Node endNode;
    private double health;
    private double price;
    private TypeEnums type;
    private boolean visited = false;
    public Line(Node node1, Node node2, TypeEnums type){
        health = type.getHealth();
        startNode = node1;
        endNode = node2;
        this.type = type;
         //this should be changed to line
        calcPrice();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public TypeEnums getType() {
        return type;
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
        double distance = startNode.distance(endNode);
        price = type.getPrice() * distance;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
