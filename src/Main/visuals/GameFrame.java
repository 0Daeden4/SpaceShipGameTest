package src.Main.visuals;

import src.Main.gameUtils.Node;
import src.Main.gameUtils.TypeEnums;
import src.Main.shipUtils.Enclosed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {


    public GameFrame(){
        GamePanel gamePanel = new GamePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
