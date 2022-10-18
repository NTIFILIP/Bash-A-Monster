import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class Healthbar extends JPanel {
    int barWidth = 300;
    int barHeight = 50;
    int verticalPadding = 10;
    int horizontalPadding = 10;
    int fontSize = 26;
    int numHealthBars = 0;

    Humanoid ally;
    Humanoid enemy;

    public Healthbar(Humanoid ally, Humanoid enemy) {
        this.ally = ally;
        this.enemy = enemy;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        addHealthBars(g);
    }

    protected void addHealthBars(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, this.fontSize));
        createHealthBar(g, ally);
        createHealthBar(g, enemy);
    }

    protected void createHealthBar(Graphics g, Humanoid humanoid) {
        int newWidth;

        if (humanoid.isAlive) {
            if (humanoid.isAlly) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.RED);
            }

            float healthPercentage = (float) humanoid.health / humanoid.maxHealth;
            newWidth = (int) (healthPercentage * barWidth);

        } else {
            g.setColor(Color.BLACK);
            newWidth = 0;
        }

        int y = 10 + (barHeight + verticalPadding) * numHealthBars;

        numHealthBars += 1;

        g.fillRect(horizontalPadding, y, newWidth, barHeight);

        int labelX = horizontalPadding * 2 + newWidth;
        int labelY = y + ((barHeight + this.fontSize) / 2);

        g.drawString(humanoid.name, labelX, labelY);
    }
}
