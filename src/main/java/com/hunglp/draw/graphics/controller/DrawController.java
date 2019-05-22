package com.hunglp.draw.graphics.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JOptionPane;
import com.hunglp.draw.graphics.model.Arc;
import com.hunglp.draw.graphics.model.Circle;
import com.hunglp.draw.graphics.model.ColoredLine;
import com.hunglp.draw.graphics.model.CommandButton;
import com.hunglp.draw.graphics.model.Line;
import com.hunglp.draw.graphics.view.DrawTool;

/**
 * Action Draw.
 * 
 * @author HungLP
 *
 */
public class DrawController implements IController, Runnable {
  public DrawTool view;
  private Menu menu;
  private int commandBtn;

  public Line line;
  public Circle circle;
  public Arc arc;
  private Graphics graphics;

  /**
   * Contructor DrawController.
   * 
   */
  public DrawController(DrawTool view) {
    super();
    this.view = view;
    graphics = view.getFrame().getGraphics();
  }

  /**
   * initialize Controller.
   */
  public void initController() {
    // Button Action

    view.getBtnLine().addActionListener(e -> drawLine());
    view.getBtnCircle().addActionListener(e -> drawCircle());
    view.getBtnArc().addActionListener(e -> drawArc());

    // Mouse Listener
    view.getFrame().addMouseListener(new MouseAdapter() {


      @Override
      public void mouseClicked(MouseEvent e) {
        if (commandBtn == 3) {
          if (arc.getAnchor() != null && arc.getTarget() != null) {
            arc.setFakePath(null);
            arc.getShapes().add(arc.makePath(arc.getAnchor(), e.getPoint(), arc.getTarget()));
            arc.setAnchor(null);
            arc.setTarget(null);
            view.getFrame().repaint();
          }
        }
      }


      @Override
      public void mousePressed(MouseEvent e) {
        if (commandBtn == 1) {


          line.setStartX(e.getX());
          line.setStartY(e.getY());

          line.setPrevX(line.getStartX());
          line.setPrevY(line.getStartY());
          line.setDragging(true);
          graphics = (Graphics2D) view.getFrame().getGraphics(); // Get a graphics

          graphics.setColor(Color.black);
          graphics.setXORMode(view.getFrame().getBackground());
          graphics.drawLine(line.getStartX(), line.getStartY(), line.getPrevX(), line.getPrevY());

          // Luu toa do press
          // line.setPressPoint(new Point(e.getX(), e.getY()));
        } else if (commandBtn == 2) {
          circle.setClickPoint(new Point(e.getPoint()));
          System.out.println("Press point : " + e.getX() + " # " + e.getY());


        } else if (commandBtn == 3) {
          if (arc.getAnchor() == null) {
            arc.setTarget(null);
          }
          arc.setAnchor(new Point(e.getPoint()));
        }


      }

      @Override
      public void mouseReleased(MouseEvent e) {
        if (commandBtn == 1) {
          if (!line.isDragging()) {
            return;
          }
          graphics.drawLine(line.getStartX(), line.getStartY(), line.getPrevX(), line.getPrevY());
          // previous line
          int endX = e.getX();
          int endY = e.getY();
          graphics.setPaintMode();
          graphics.drawLine(line.getStartX(), line.getStartY(), endX, endY); // Draw new line
          graphics.dispose(); // draw operation is over
          graphics.dispose();

          if (line.getLineCount() < line.getLines().length) { // Add the line to the arr
            line.getLines()[line.getLineCount()] = new ColoredLine();
            line.getLines()[line.getLineCount()].setX1(line.getStartX());
            line.getLines()[line.getLineCount()].setY1(line.getStartY());
            line.getLines()[line.getLineCount()].setX2(endX);
            line.getLines()[line.getLineCount()].setY2(endY);
            line.setLineCount(line.getLineCount() + 1);
          }

          // Luu toa do release
          // line.setReleasePoint(new Point(e.getX(), e.getY()));


        } else if (commandBtn == 3) {
          arc.setDragging(false);
        } else if (commandBtn == 2) {

        }
      }

      @Override
      public void mouseDragged(MouseEvent e) {
        if (commandBtn == 1) {

          System.out.println("Dragging Line...");
          if (!line.isDragging()) {
            return;
          }
          graphics.drawLine(line.getStartX(), line.getStartY(), line.getPrevX(), line.getPrevY());
          line.setPrevX(e.getX());
          line.setPrevY(e.getY());
          graphics.drawLine(line.getStartX(), line.getStartY(), line.getPrevX(), line.getPrevY());
        } else if (commandBtn == 3) {
          JOptionPane.showMessageDialog(null, "Arc");
        } else if (commandBtn == 2) {
          System.out.println("Dragging circle ....");
          int minX = Math.min(e.getX(), circle.getClickPoint().x);
          int minY = Math.min(e.getY(), circle.getClickPoint().y);
          int maxX = Math.max(e.getX(), circle.getClickPoint().x);
          int maxY = Math.max(e.getY(), circle.getClickPoint().y);
          System.out.println("Realse : " + e.getX() + " # " + e.getY());

          int size = Math.min(maxX - minX, maxY - minY);
          if (minX < circle.getClickPoint().x) {
            minX = circle.getClickPoint().x - size;
          }
          if (minY < circle.getClickPoint().y) {
            minY = circle.getClickPoint().y - size;
          }
          circle.setShape(new Ellipse2D.Double(minX, minY, size, size));

          circle.repaint();

          Graphics2D g2d = (Graphics2D) graphics.create();
          g2d.setColor(new Color(0, 0, 255, 64));
          g2d.draw(circle.getShape());
          g2d.dispose();

        }
      }

    });

  }

  /**
   * draw Arc.
   */
  private void drawArc() {
    // view.getPanel().add(new Line());
    arc = new Arc();
    this.commandBtn = CommandButton.COMMAND_BTNARC;
  }

  /**
   * draw Circle.
   */
  private void drawCircle() {
    // view.getPanel().add(new Circle());
    circle = new Circle();
    this.commandBtn = CommandButton.COMMAND_BTNCIRCLE;
  }

  /**
   * draw Line.
   */
  private void drawLine() {
    line = new Line();
    this.commandBtn = CommandButton.COMMAND_BTNLINE;
  }

  public void run() {


  }



}
