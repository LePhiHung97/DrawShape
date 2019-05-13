package com.hunglp.draw;

import com.hunglp.draw.graphics.controller.DrawController;
import com.hunglp.draw.graphics.model.Line;
import com.hunglp.draw.graphics.model.MyShape;
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
    DrawController mainController = new DrawController(mainView);
    mainController.initController();
    Thread thread = new Thread(mainController);
    thread.start();

    MyShape m = new Line();
  }
}
