
package com.hunglp.draw.graphics.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import com.hunglp.draw.graphics.model.Arc;
import com.hunglp.draw.graphics.model.Circle;
import com.hunglp.draw.graphics.model.Line;
import lombok.Getter;
import lombok.Setter;

/**
 * @author HungLP
 *
 */
@Getter
@Setter
public class DrawTool implements IView {

  public static Line line;
  public static Circle circle;
  public static Arc arc;
  private JFrame frame;
  private JPanel panel;
  JButton btnLine;
  JButton btnCircle;
  JButton btnArc;
  JPanel panelLine;
  JPanel panelCircle;
  JPanel panelArc;
  JPanel topPanel;


  /**
   * initialize view.
   */
  public void initView() {
    frame = new JFrame();
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    panel = new JPanel();
    frame.add(panel);
    addButton();
  }

  /**
   * add button to panel.
   */
  public void addButton() {
    btnLine = new JButton("Line");
    btnCircle = new JButton("Circle");
    btnArc = new JButton("Arc");

    btnLine.setBounds(20, 10, 60, 30);
    btnCircle.setBounds(80, 10, 60, 30);
    btnArc.setBounds(140, 10, 60, 30);

    panel.add(btnLine);
    panel.add(btnCircle);
    panel.add(btnArc);
  }

  /**
   * add Panel.
   */
  public void addPanel() {

    topPanel = new JPanel();
    panelLine = new JPanel();
    panelCircle = new JPanel();
    panelArc = new JPanel();

    topPanel.setLayout(new BorderLayout());
    frame.getContentPane().add(topPanel); // Create a
    JSplitPane splitPaneV = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    topPanel.add(splitPaneV, BorderLayout.CENTER);

    JSplitPane splitPaneH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    splitPaneH.setLeftComponent(panelLine);
    splitPaneH.setRightComponent(panelCircle);
    splitPaneH.setBackground(Color.gray);


    splitPaneV.setLeftComponent(splitPaneH);
    splitPaneV.setRightComponent(panelArc);
    splitPaneV.setBackground(Color.magenta);

    frame.add(topPanel);
    line = new Line();
    circle = new Circle();

    arc = new Arc();
    panelLine.add(line);
    panelCircle.add(circle);
    panelArc.add(arc);

  }



}
