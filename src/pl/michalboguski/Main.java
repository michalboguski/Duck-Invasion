package pl.michalboguski;

import pl.michalboguski.Model.TimeLapse;
import pl.michalboguski.View.StartWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        TimeLapse tl = new TimeLapse();
        tl.start();
        SwingUtilities.invokeLater(() -> new StartWindow());






    }
}
