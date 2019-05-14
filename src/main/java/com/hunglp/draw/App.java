package com.hunglp.draw;

import com.hunglp.draw.graphics.controller.DrawController;
import com.hunglp.draw.graphics.view.DrawTool;

public class App {
  /**
   * main app.
   * 
   * @param args String
   */
  public static void main(String[] args) {
    DrawTool mainView = new DrawTool();
    mainView.initView();
    DrawController drawController = new DrawController(mainView);
    drawController.initController();
    Thread thread = new Thread(drawController);
    thread.start();
  }
}
