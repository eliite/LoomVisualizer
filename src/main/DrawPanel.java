/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author strotz
 */
public class DrawPanel extends JPanel {
    public DrawPanel() {
        setLayout(null);
        setUp();
    } 
    
    public int clamp(int val, int min, int max) {
        while (val < min)
            val += max;
        while (val >= max)
            val -= max;
        
        return val;
    } 
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        boolean[] pattern = new boolean[FrameMain.getRepeatNumber()];
        for (int i = 0; i < pattern.length; i++)
            pattern[i] = (FrameMain.getPattern().charAt(i) == 'N');
        
        g.setColor(new Color(238,238,238));
        g.fillRect(0, 0, 600, 600);
        
        int n = 20, gap = 20;
        int squareSize = 22;
        int squareGap = 6+squareSize;
        
        int counter = FrameMain.getPegNumber();

        for (int y = n-1; y >= 0; y--) {
            for (int x = n-1; x >= 0; x--) {
                counter = clamp(counter, 0, FrameMain.getRepeatNumber());
                if (y < 6 || y > 13) {
                    g.setColor(y <= 7 ? FrameMain.getNewColor() :
                            FrameMain.getOldColor());
                    g.fillRect(gap+x*squareGap, y*squareGap, squareSize, squareSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(gap+x*squareGap, y*squareGap, squareSize, squareSize);
                } else {
                    g.setColor(pattern[counter] ? FrameMain.getNewColor() :
                            FrameMain.getOldColor());
                    
                    g.fillRect(gap+x*squareGap, y*squareGap, squareSize, squareSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(gap+x*squareGap, y*squareGap, squareSize, squareSize);
                    
                    if (x == 0)
                        counter -= (FrameMain.getPegNumber()-n+1);
                    else counter--;
                }
            }
        }
    }
    public void setUp() {
        for (Component c: getComponents())
            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(false);    
    }
    
}
