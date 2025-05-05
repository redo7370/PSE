package main.ui;

import java.awt.*;
import javax.swing.JFrame;

public class Menu extends JFrame{
    
    public Menu(Color bg){
        setTitle("Menü");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(bg);

        setVisible(true);
    }
}
