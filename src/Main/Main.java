package src.Main;

import src.Main.gameUtils.TypeEnums;
import src.Main.gameUtils.Node;
import src.Main.visuals.GameFrame;

public class Main {
    public static void main(String[] args) {
        Node node = new Node(1,2, TypeEnums.PLAYER);
        GameFrame frame = new GameFrame();
    }
}
