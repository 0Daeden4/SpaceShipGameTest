package src.Main.visuals;

import src.Main.gameUtils.Node;
import src.Main.gameUtils.TypeEnums;
import src.Main.shipUtils.Enclosed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private Enclosed enclosed;
    public GamePanel(){
        Node[] nodes = new Node[]{new Node(5, 10, TypeEnums.IMMORTAL), new Node(15, 25, TypeEnums.IMMORTAL)
                , new Node(35, -45, TypeEnums.IMMORTAL)};
        enclosed = new Enclosed(TypeEnums.IMMORTAL,nodes );
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                enclosed.keyPressed(e);
                repaint();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawShip(enclosed, g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    //TODO replace Enclosed with ship
    private void drawShip(Enclosed en, Graphics g){
        g.setColor(en.getColor());
        g.fillPolygon(en.getPoly());
    }
}
