package com.hunglp.draw.graphics.model;

import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Circle extends JPanel {
  private Point clickPoint;
  private Shape shape;
  private List<Shape> lstShape = new ArrayList<>();
}
