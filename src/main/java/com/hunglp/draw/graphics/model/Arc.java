
package com.hunglp.draw.graphics.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;

/**
 * Arc shape.
 * 
 * @author HungLP
 *
 */
@Setter
@Getter
public class Arc extends JPanel {
  private boolean dragging = false;
  private Point anchor;
  private Point target;
  private Shape fakePath;
  private List<Shape> shapes = new ArrayList<>();

  /**
   * @param p1
   * @param p2
   * @param p3
   * @return
   */
  public Path2D makePath(Point p1, Point p2, Point p3) {
    Path2D point = new GeneralPath();
    point.moveTo(p1.getX(), p1.getY());
    point.curveTo(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    return point;
  }


  @Override
  public Dimension getPreferredSize() {
    return new Dimension(1000, 800);
  }



  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
        RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
        RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
        RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    g2d.setColor(Color.BLACK);
    for (Shape shape : shapes) {
      g2d.draw(shape);
    }
    if (anchor != null && target != null) {
      g2d.setColor(Color.GREEN);
      g2d.draw(new Line2D.Double(anchor, target));
    }
    if (fakePath != null) {
      g2d.setColor(Color.BLUE);
      g2d.draw(fakePath);
    }
    g2d.dispose();
  }


}
