/* ColorPanel by Jacek Strotz
 *
 * Purpose: A subclass of JPanel to draw the FrameKey information.
 * More specifically, draw the color boxes used to create the visual.
 */
package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {
    public static int numColor;
    
    public ColorPanel() {
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
        
        for (int i = 0; i < numColor; i++) {
            g.setColor(Color.BLACK);
            g.drawRect(5+28*i, 4, 20, 20);
            g.drawString(""+(i+1), 12+28*i, 37);
            
            g.setColor(FrameMain.getColor(i));
            g.fillRect(6+28*i, 5, 18, 18);
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
