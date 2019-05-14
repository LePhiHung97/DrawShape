package com.hunglp.draw.graphics.model;

import java.awt.Point;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Line extends JPanel {

  private ColoredLine[] lines = new ColoredLine[100];
  private int lineCount;
  private int startX;
  private int startY;
  private int prevX;
  private int prevY;
  private Point pressPoint;
  private Point releasePoint;

  boolean dragging = false;

  public Line() {

  }



}

