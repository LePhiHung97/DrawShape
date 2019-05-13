package com.hunglp.draw.graphics.model;

import java.awt.Graphics;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Line extends MyShape {
  private int lineCount;
  int startX;
  int startY;
  int prevX;
  int prevY;
  boolean dragging = false;

  public void draw(Graphics g) {
    // TODO Auto-generated method stub

  }
}
