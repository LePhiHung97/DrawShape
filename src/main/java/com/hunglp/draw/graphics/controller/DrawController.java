package com.hunglp.draw.graphics.controller;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import com.hunglp.draw.graphics.view.DrawTool;



public class DrawController implements IController, Runnable {
  public DrawTool view;
  private Menu menu;

  public DrawController(DrawTool view) {
    super();
    this.view = view;
  }

  /**
   * initialize Controller.
   */
  public void initController() {
    view.getFrame().addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {}

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        super.mouseReleased(e);
      }

      @Override
      public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        super.mouseDragged(e);
      }


    });

    view.getMenuBar().getMenu(0).addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "You click Line");

      }
    });



  }

  public void run() {


  }



}
