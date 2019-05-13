package com.hunglp.draw.graphics.view;

import java.awt.Menu;
import java.awt.MenuBar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrawTool implements IView {
  private JFrame frame;
  private JPanel panel;
  private Menu menuShape;
  private MenuBar menuBar;

  /**
   * initialize view.
   */
  public void initView() {
    frame = new JFrame();
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    addMenu();

    panel = new JPanel();
    frame.add(panel);
  }

  /**
   * menu bar.
   */
  public void addMenu() {
    menuShape = new Menu("Shape", true);
    menuShape.add("Line");
    menuShape.add("Circle");
    menuShape.add("Arc");


    menuBar = new MenuBar();
    menuBar.add(menuShape);
    frame.setMenuBar(menuBar);
  }



}
