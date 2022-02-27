/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Component;
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
        
        boolean[][] pattern = new boolean[4][];
        pattern[0] = new boolean[FrameMain.getRepeatNumber(0)];
        pattern[1] = new boolean[FrameMain.getRepeatNumber(1)];
        pattern[2] = new boolean[FrameMain.getRepeatNumber(2)];
        pattern[3] = new boolean[FrameMain.getRepeatNumber(3)];
        
        for (int b = 0; b < 4; b++) {
            for (int i = 0; i < FrameMain.getRepeatNumber(b); i++)
                pattern[b][i] = (FrameMain.getPattern(b).charAt(i) == 'N');
        }
        
        g.setColor(new Color(60, 63, 65));
        g.fillRect(0, 0, 600, 600);
        
        int n = 20, gap = 20;
        int squareSize = 28;
        int squareGap = 0+squareSize;
        
        int counter = FrameMain.getPegNumber();
        
        int solid = n;
        for (int i = 0; i < 4; i++)
            solid -= FrameMain.getRowNumber(i);

        solid /= 2;
        
        int recent_length = n-1;
        
        // bottom solid block
        for (int y = recent_length; y > recent_length-solid; y--) {
            for (int x = n-1; x >= 0; x--) {
                    Color c = FrameMain.getColor(0);
                    g.setColor(FrameMain.getColor(0));
                    
                    g.fillRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);
                    g.setColor((c.getRed() + c.getGreen() + c.getBlue()) > 150 ? Color.BLACK : Color.WHITE);
                    g.drawRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);
            }
        }
        
        // first pattern
        recent_length -= solid;
        for (int y = recent_length; y > recent_length-FrameMain.getRowNumber(0); y--) {
            for (int x = n-1; x >= 0; x--) {
                counter = clamp(counter, 0, FrameMain.getRepeatNumber(0));
                
                Color c = pattern[0][counter] ? FrameMain.getColor(1) :
                            FrameMain.getColor(0);
                g.setColor(c);

                g.fillRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);
                g.setColor((c.getRed() + c.getGreen() + c.getBlue()) > 150 ? Color.BLACK : Color.WHITE);
                g.drawRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);

                if (x == 0)
                    counter -= (FrameMain.getPegNumber()-n+1);
                else counter--;
            }
        }

        // second pattern
        if (FrameMain.getPatternNum() > 1) {
            recent_length -= (FrameMain.getRowNumber(0));
            for (int y = recent_length; y > recent_length-FrameMain.getRowNumber(1); y--) {
                for (int x = n-1; x >= 0; x--) {
                    counter = clamp(counter, 0, FrameMain.getRepeatNumber(1));
                    
                    Color c = pattern[1][counter] ? FrameMain.getColor(2) :
                                FrameMain.getColor(1);
                    g.setColor(c);

                    g.fillRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);
                    g.setColor((c.getRed() + c.getGreen() + c.getBlue()) > 150 ? Color.BLACK : Color.WHITE);
                    g.drawRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);

                    if (x == 0)
                        counter -= (FrameMain.getPegNumber()-n+1);
                    else counter--;
                }
            }
        }

        // third pattern
        if (FrameMain.getPatternNum() > 2) {
            recent_length -= (FrameMain.getRowNumber(1));
            for (int y = recent_length; y > recent_length-FrameMain.getRowNumber(2); y--) {
                for (int x = n-1; x >= 0; x--) {
                    counter = clamp(counter, 0, FrameMain.getRepeatNumber(2));
                    
                    Color c = pattern[2][counter] ? FrameMain.getColor(3) :
                                FrameMain.getColor(2);
                    g.setColor(c);

                    g.fillRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);
                    g.setColor((c.getRed() + c.getGreen() + c.getBlue()) > 150 ? Color.BLACK : Color.WHITE);
                    g.drawRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);

                    if (x == 0)
                        counter -= (FrameMain.getPegNumber()-n+1);
                    else counter--;
                }
            }
        }
        
        // fourth pattern
        if (FrameMain.getPatternNum() > 3) {
            recent_length -= (FrameMain.getRowNumber(2));
            for (int y = recent_length; y > recent_length-FrameMain.getRowNumber(3); y--) {
                for (int x = n-1; x >= 0; x--) {
                    counter = clamp(counter, 0, FrameMain.getRepeatNumber(3));
                    
                    Color c = pattern[3][counter] ? FrameMain.getColor(4) :
                                FrameMain.getColor(3);
                    g.setColor(pattern[3][counter] ? FrameMain.getColor(4) :
                                FrameMain.getColor(3));

                    g.fillRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);
                    g.setColor((c.getRed() + c.getGreen() + c.getBlue()) > 150 ? Color.BLACK : Color.WHITE);
                    g.drawRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);

                    if (x == 0)
                        counter -= (FrameMain.getPegNumber()-n+1);
                    else counter--;
                }
            }
        }
        
        // top solid block
        recent_length -= FrameMain.getRowNumber(FrameMain.getPatternNum()-1);
        for (int y = recent_length; y >= 0; y--) {
            for (int x = n-1; x >= 0; x--) {
                    Color c = FrameMain.getColor(FrameMain.getPatternNum());
                    g.setColor(c);
                    g.fillRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);
                    
                    g.setColor((c.getRed() + c.getGreen() + c.getBlue()) > 150 ? Color.BLACK : Color.WHITE);
                    g.drawRect(gap+x*squareGap, 30+y*squareGap, squareSize, squareSize);
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
