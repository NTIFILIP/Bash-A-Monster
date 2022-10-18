import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Humanoid enemy = new Humanoid("Max", 100, 10, false);
        Humanoid ally = new Humanoid("Elias", 100, 10, true);

        Scanner scanner = new Scanner(System.in);

        while (ally.isAlive && enemy.isAlive) {
            JFrame frame = drawWindow(ally, enemy);
            enemy.Attack(ally);
            if (ally.isAlive) {
                ally.Attack(enemy);
            }
            System.out.println();
            scanner.nextLine();
            frame.dispose();
        }
    }

    public static JFrame drawWindow(Humanoid ally, Humanoid enemy) {
        JFrame frame = new JFrame("Healthbar"); //create the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set action on closing window

        Healthbar newHealthBars = new Healthbar(ally, enemy);
        newHealthBars.setPreferredSize(new Dimension(600, 300));

        frame.getContentPane().add(newHealthBars);
        frame.pack();
        frame.setAlwaysOnTop(true);
        frame.setVisible(true); //make everything visible
        return frame;
    }
}