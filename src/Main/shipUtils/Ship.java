package src.Main.shipUtils;

import src.Main.gameUtils.Line;
import src.Main.gameUtils.Node;

import java.awt.event.KeyEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class Ship {
    private GeneralPath graphPath = new GeneralPath();
    private ArrayList<Ship> enemies = new ArrayList<>();
    private ArrayList<Enclosed> hull;
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Line> lines = new ArrayList<>();
    private Node startNode;
    //TODO drawship using thread
    public Ship (Ship enemy, ArrayList<Enclosed> hull){
        enemies.add(enemy);
        this.hull = hull;
        for(Enclosed enclosed: hull){
            nodes.addAll(calcNodes(enclosed));
        }
        startNode = nodes.getFirst();
        createAvailableLines();
        graphPath.moveTo(startNode.x, startNode.y);
        drawShip(lines.getFirst());
    }
    public Ship (Ship enemy, Enclosed hull){
        enemies.add(enemy);
        this.hull = new ArrayList<>();
        this.hull.add(hull);
        nodes =calcNodes(hull);
        startNode = nodes.getFirst();
        createAvailableLines();

        graphPath.moveTo(startNode.x, startNode.y);
        drawShip(lines.getFirst());
    }

    public GeneralPath getGraphPath() {
        return graphPath;
    }

    private ArrayList<Node> calcNodes(Enclosed compartment){
        ArrayList<Node> nodes = new ArrayList<>();
        Node prevNode = null;

        for(int i =0; i < compartment.getPoly().npoints; i ++){
            Node node = new Node(compartment.xPoints[i], compartment.yPoints[i], compartment.getType());
            nodes.add(node);
            if(i==0){
                prevNode = node;
            }else{
                prevNode.createLine(node);
                prevNode = node;
            }
        }
        return nodes;
    }

    private void createAvailableLines (){
        for(Node n: nodes){
            if(n.getStartOfLines().isEmpty()) {
                n.createLine(startNode);
                //startNode.connectLine(n);
            }
            for(Line l: n.getStartOfLines()){
                if(!lines.contains(l)){
                    lines.add(l);
                }
            }
        }
    }
    private void drawShip(Line line){

        Node startOfLine = line.getStartNode();
        Node endOfLine = line.getEndNode();
        line.setVisited(true);
        graphPath.lineTo(endOfLine.x, endOfLine.y);
        ArrayList<Line> lines = startOfLine.getStartOfLines();
        for(Line l : lines){
            if(!l.getEndNode().getStartOfLines().isEmpty()){
                for(Line nextLine : l.getEndNode().getStartOfLines() ){
                    if(!nextLine.isVisited()) {
                        nextLine.setVisited(true);
                        drawShip(nextLine);
                    }
                }
            }
        }

    }
    public void moveShip(int horizontalMovement, int verticalMovement){
        Node moveNode;
        for(Line l : lines){
            moveNode = l.getEndNode();
            moveNode.x += horizontalMovement/Math.max(moveNode.getEndOfLines().size(),1);
            moveNode.y += verticalMovement/Math.max(moveNode.getEndOfLines().size(),1);
            l.setVisited(false);
        }


    }
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            moveShip(0, -10);
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveShip(0, 10);
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveShip(-10, 0);
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveShip(10, 0);
        }
        graphPath = new GeneralPath();
        graphPath.moveTo(startNode.getX(), startNode.getY());
        drawShip(lines.getFirst());
    }

}
