package pl.michalboguski.View;

import pl.michalboguski.Model.GameConstants;
import pl.michalboguski.Model.TimeLapse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {
    JButton newGame;
    JButton highScore;
    JButton exit;
    public StartPanel() {
      //  super();


        setSize(new Dimension(GameConstants.screenWigth-300, GameConstants.screenHeight));
        setBackground(Color.BLACK);
        setLayout(null);



    JLabel SPLabel = new JLabel("Wybierz Opcje");
    newGame = new JButton("New Game");
    highScore = new JButton("High Scores");
    exit = new JButton("Exit");

    newGame.addActionListener(this);
    highScore.addActionListener(this);
    exit.addActionListener(this);

        int buttonWidth = 200;
        int buttonHeight = 60;
        SPLabel.setBounds((GameConstants.screenWigth-300)/2 - buttonWidth/2,50, buttonWidth, buttonHeight);
        newGame.setBounds((GameConstants.screenWigth-300)/2 - buttonWidth/2,150, buttonWidth, buttonHeight);
        highScore.setBounds((GameConstants.screenWigth-300)/2 - buttonWidth/2,300, buttonWidth, buttonHeight);
        exit.setBounds((GameConstants.screenWigth-300)/2 - buttonWidth/2,450, buttonWidth, buttonHeight);

        SPLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        add(SPLabel);
        add(newGame);
        add(highScore);
        add(exit);

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==  newGame ){
            new GameWindow();
            JFrame w = (JFrame) SwingUtilities.getWindowAncestor(newGame);
            w.dispose();
           // new TimeLapse().start();
        }
        if (e.getSource() ==  highScore ){}
        if (e.getSource() == exit ){
           JFrame w = (JFrame) SwingUtilities.getWindowAncestor(exit);
           w.dispose();
        }
    }
}
