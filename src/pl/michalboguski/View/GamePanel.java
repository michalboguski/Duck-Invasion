package pl.michalboguski.View;


import pl.michalboguski.Model.GameConstants;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    StatsPanel topPanel;
    PlayPanel playPanel;
    JPanel bottomPanel;


    public GamePanel() {
        setLayout(new BorderLayout());
        setPreferredSize(GameConstants.gameSize);


        this.topPanel = new StatsPanel();
        JLayeredPane centerPanel = new JLayeredPane();

        this.playPanel = new PlayPanel();
        this.playPanel.setBounds(0, 0, GameConstants.screenWidth, GameConstants.screenHeight - 100);
        centerPanel.add(playPanel, JLayeredPane.PALETTE_LAYER);
        this.bottomPanel = new JPanel();

        centerPanel.setBackground(Color.gray);
        bottomPanel.setBackground(Color.red);

        topPanel.setPreferredSize(new Dimension(GameConstants.screenWidth, 50));
        centerPanel.setPreferredSize(new Dimension(GameConstants.screenWidth, GameConstants.screenHeight - 100));
        bottomPanel.setPreferredSize(new Dimension(GameConstants.screenWidth, 50));

        add(centerPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.PAGE_START);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    public StatsPanel getTopPanel() {
        return topPanel;
    }

    public PlayPanel getPlayPanel() {
        return playPanel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }
}
