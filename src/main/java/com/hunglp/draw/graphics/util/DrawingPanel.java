
package com.hunglp.draw.graphics.util;

import java.awt.Graphics;
import javax.swing.JPanel;
import com.hunglp.draw.graphics.model.MyShape;

public class DrawingPanel extends JPanel {
  private MyShape shape = null;

  public void paint(Graphics g) {
    shape.draw(g);
  }

  public void drawShape(MyShape shape) {
    this.shape = shape;
  }
}
