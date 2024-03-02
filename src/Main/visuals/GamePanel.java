package src.Main.visuals;

import src.Main.gameUtils.Node;
import src.Main.gameUtils.TypeEnums;
import src.Main.shipUtils.Enclosed;
import src.Main.shipUtils.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private Enclosed enclosed;
    private Ship flagShip;
    public GamePanel(){
        Node commonNode = new Node(50, 10, TypeEnums.IMMORTAL);
        Node[] nodes = new Node[]{commonNode, new Node(75, 25, TypeEnums.IMMORTAL)
                , new Node(95, 145, TypeEnums.IMMORTAL)};
        Node[] nodes1 = new Node[]{new Node(20, 32, TypeEnums.IMMORTAL), new Node(69, 96, TypeEnums.IMMORTAL)
                , new Node(127, 137, TypeEnums.IMMORTAL), commonNode};
        enclosed = new Enclosed(TypeEnums.IMMORTAL,nodes );
        ArrayList<Enclosed> enclosedArray = new ArrayList<> ();
        enclosedArray.add(new Enclosed(TypeEnums.PLAYER, nodes1));
        enclosedArray.add(enclosed);
        flagShip = new Ship(null, enclosedArray);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                flagShip.keyPressed(e);
                repaint();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //drawShip(enclosed, g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.draw(flagShip.getGraphPath());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    //TODO replace Enclosed with ship
    private void drawShip(Enclosed en, Graphics g){
        g.setColor(en.getColor());
        g.fillPolygon(en.getPoly());
    }
}
