package pl.michalboguski.View;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public final static int screenWidth = 1280;
    public final static int screenHeight = 720;

    public GamePanel()  {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(screenWidth, screenHeight));


        UpPanel topPanel = new UpPanel();
        JLayeredPane centerPanel = new JLayeredPane();

        PlayPanel playPanel = new PlayPanel();
        playPanel.setBounds(0,0,screenWidth, screenHeight-100);
        centerPanel.add(playPanel, JLayeredPane.PALETTE_LAYER);

        JPanel glassPanel = new JPanel();
        glassPanel.setBounds(0,0,screenWidth, screenHeight-100);
        glassPanel.setBackground(new Color(0,0,0,0));
        glassPanel.setOpaque(false);

        centerPanel.add(glassPanel, JLayeredPane.DRAG_LAYER);
        JPanel bottomPanel = new JPanel();

        centerPanel.setBackground(Color.gray);
        bottomPanel.setBackground(Color.red);

        topPanel.setPreferredSize(new Dimension(screenWidth,50));
        centerPanel.setPreferredSize(new Dimension(screenWidth,screenHeight-100));
        bottomPanel.setPreferredSize(new Dimension(screenWidth,50));

        add(centerPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.PAGE_START);
        add(bottomPanel, BorderLayout.PAGE_END);
        topPanel.setPreferredSize(new Dimension(screenWidth,50));

    }

}
