package pl.michalboguski.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static pl.michalboguski.Model.GameConstants.*;

public class StartPanel extends JPanel implements ActionListener {
    JButton newGame;
    JButton highScore;
    JButton exit;

    public StartPanel() {
        super();
        setSize(startSize);
        setBackground(Color.BLACK);
        setLayout(null);

        JLabel SPLabel = new JLabel("Wybierz Opcje");
        newGame = new JButton("New Game");
        highScore = new JButton("High Scores");
        exit = new JButton("Exit");

        newGame.addActionListener(this);
        highScore.addActionListener(this);
        exit.addActionListener(this);

        SPLabel.setBounds((screenWidth - 300) / 2 - buttonWidth / 2, 50, buttonWidth, buttonHeight);
        newGame.setBounds((screenWidth - 300) / 2 - buttonWidth / 2, 150, buttonWidth, buttonHeight);
        highScore.setBounds((screenWidth - 300) / 2 - buttonWidth / 2, 300, buttonWidth, buttonHeight);
        exit.setBounds((screenWidth - 300) / 2 - buttonWidth / 2, 450, buttonWidth, buttonHeight);

        SPLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        add(SPLabel);
        add(newGame);
        add(highScore);
        add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            removeAll();
            add(new LevelPanel());
            repaint();
            revalidate();
        }
        if (e.getSource() == highScore) {
            //todo
        }
        if (e.getSource() == exit) {
            JFrame w = (JFrame) SwingUtilities.getWindowAncestor(exit);
            w.dispose();
        }
    }
}
