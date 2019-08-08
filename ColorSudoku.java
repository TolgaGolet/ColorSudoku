package colorsudoku;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author MTG
 */
public class ColorSudoku extends JFrame {
    
    public static final int GRID_SIZE=9;  //9x9
    
    public static final int CELL_SIZE=75;
    public static final int TABLE_WIDTH=CELL_SIZE*GRID_SIZE;
    public static final int TABLE_HEIGHT=CELL_SIZE*GRID_SIZE;
    
    public static final Color OPEN_CELL_BG_COLOR=Color.LIGHT_GRAY;            
   
    private JTextField[][] Cells=new JTextField[GRID_SIZE][GRID_SIZE];  
 
    /*
    1.Magenta
    2.Yellow
    3.Orange
    4.Green
    5.Red
    6.Black
    7.White
    8.Cyan
    9.Blue
    */
    private int[][] puzzle =
      {{5, 3, 4, 6, 7, 8, 9, 1, 2},
       {6, 7, 2, 1, 9, 5, 3, 4, 8},
       {1, 9, 8, 3, 4, 2, 5, 6, 7},
       {8, 5, 9, 7, 6, 1, 4, 2, 3},
       {4, 2, 6, 8, 5, 3, 7, 9, 1},
       {7, 1, 3, 9, 2, 4, 8, 5, 6},
       {9, 6, 1, 5, 3, 7, 2, 8, 4},
       {2, 8, 7, 4, 1, 9, 6, 3, 5},
       {3, 4, 5, 2, 8, 6, 1, 7, 9}};
    
    //false means colored
   private boolean[][] masks =
      {{false, false, true, false, true, false, true, false, true},
       {false, false, true, false, false, false, false, true, false},
       {false, true, false, true, false, true, true, false, true},
       {true, false, false, false, true, false, false, false, false},
       {false, true, false, false, false, false, true, false, false},
       {false, true, false, true, false, true, false, true, false},
       {true, false, true, false, true, false, false, true, false},
       {false, false, false, false, false, true, true, false, true},
       {true, false, false, true, false, false, false, false, false}};
   
   //Constuctor.
   public ColorSudoku() {
       Container container=getContentPane();                        
       container.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
       

        Mouse mouse1=new Mouse();                         
        
      for(int row=0; row<GRID_SIZE; ++row) {
          for(int col=0;col<GRID_SIZE;++col) {
              Cells[row][col] = new JTextField(); 
              container.add(Cells[row][col]);           
              
              if(masks[row][col]) {              
                  Cells[row][col].setEditable(false);        
                  Cells[row][col].setBackground(OPEN_CELL_BG_COLOR);            
                  Cells[row][col].addMouseListener(mouse1);      
              }
              else {
                  Cells[row][col].setEditable(false);         
                 
                  switch(puzzle[row][col]) {
                      case 1: Cells[row][col].setBackground(Color.MAGENTA); break;
                      case 2: Cells[row][col].setBackground(Color.YELLOW);  break;
                      case 3: Cells[row][col].setBackground(Color.ORANGE);  break;
                      case 4: Cells[row][col].setBackground(Color.GREEN);   break;
                      case 5: Cells[row][col].setBackground(Color.RED);     break;
                      case 6: Cells[row][col].setBackground(Color.BLACK);   break;
                      case 7: Cells[row][col].setBackground(Color.WHITE);   break;
                      case 8: Cells[row][col].setBackground(Color.CYAN);    break;
                      case 9: Cells[row][col].setBackground(Color.BLUE);    break;
                  }
              }
          }
      }
      container.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT)); 
      
      Border topLeftBorder=BorderFactory.createMatteBorder(5, 5, 0, 0, Color.DARK_GRAY);
      Border leftBorder=BorderFactory.createMatteBorder(0, 5, 0, 0, Color.DARK_GRAY);
      Border leftBottomBorder=BorderFactory.createMatteBorder(0, 5, 5, 0, Color.DARK_GRAY);
      Border bottomBorder=BorderFactory.createMatteBorder(0, 0, 5, 0, Color.DARK_GRAY);
      Border rightBottomBorder=BorderFactory.createMatteBorder(0, 0, 5, 5, Color.DARK_GRAY);
      Border rightBorder=BorderFactory.createMatteBorder(0, 0, 0, 5, Color.DARK_GRAY);
      Border topRightBorder=BorderFactory.createMatteBorder(5, 0, 0, 5, Color.DARK_GRAY);
      Border topBorder=BorderFactory.createMatteBorder(5, 0, 0, 0, Color.DARK_GRAY);
      
      Cells[0][0].setBorder(topLeftBorder);
      Cells[3][0].setBorder(topLeftBorder);
      Cells[6][0].setBorder(topLeftBorder);
      Cells[0][3].setBorder(topLeftBorder);
      Cells[3][3].setBorder(topLeftBorder);
      Cells[6][3].setBorder(topLeftBorder);
      Cells[0][6].setBorder(topLeftBorder);
      Cells[3][6].setBorder(topLeftBorder);
      Cells[6][6].setBorder(topLeftBorder);
      
      Cells[1][0].setBorder(leftBorder);
      Cells[4][0].setBorder(leftBorder);
      Cells[7][0].setBorder(leftBorder);
      Cells[1][3].setBorder(leftBorder);
      Cells[4][3].setBorder(leftBorder);
      Cells[7][3].setBorder(leftBorder);
      Cells[1][6].setBorder(leftBorder);
      Cells[4][6].setBorder(leftBorder);
      Cells[7][6].setBorder(leftBorder);
      
      Cells[2][0].setBorder(leftBottomBorder);
      Cells[5][0].setBorder(leftBottomBorder);
      Cells[8][0].setBorder(leftBottomBorder);
      Cells[2][3].setBorder(leftBottomBorder);
      Cells[5][3].setBorder(leftBottomBorder);
      Cells[8][3].setBorder(leftBottomBorder);
      Cells[2][6].setBorder(leftBottomBorder);
      Cells[5][6].setBorder(leftBottomBorder);
      Cells[8][6].setBorder(leftBottomBorder);
      
      Cells[2][1].setBorder(bottomBorder);
      Cells[5][1].setBorder(bottomBorder);
      Cells[8][1].setBorder(bottomBorder);
      Cells[2][4].setBorder(bottomBorder);
      Cells[5][4].setBorder(bottomBorder);
      Cells[8][4].setBorder(bottomBorder);
      Cells[2][7].setBorder(bottomBorder);
      Cells[5][7].setBorder(bottomBorder);
      Cells[8][7].setBorder(bottomBorder);
      
      Cells[2][2].setBorder(rightBottomBorder);
      Cells[5][2].setBorder(rightBottomBorder);
      Cells[8][2].setBorder(rightBottomBorder);
      Cells[2][5].setBorder(rightBottomBorder);
      Cells[5][5].setBorder(rightBottomBorder);
      Cells[8][5].setBorder(rightBottomBorder);
      Cells[2][8].setBorder(rightBottomBorder);
      Cells[5][8].setBorder(rightBottomBorder);
      Cells[8][8].setBorder(rightBottomBorder);
      
      Cells[1][2].setBorder(rightBorder);
      Cells[4][2].setBorder(rightBorder);
      Cells[7][2].setBorder(rightBorder);
      Cells[1][5].setBorder(rightBorder);
      Cells[4][5].setBorder(rightBorder);
      Cells[7][5].setBorder(rightBorder);
      Cells[1][8].setBorder(rightBorder);
      Cells[4][8].setBorder(rightBorder);
      Cells[7][8].setBorder(rightBorder);
      
      Cells[0][2].setBorder(topRightBorder);
      Cells[3][2].setBorder(topRightBorder);
      Cells[6][2].setBorder(topRightBorder);
      Cells[0][5].setBorder(topRightBorder);
      Cells[3][5].setBorder(topRightBorder);
      Cells[6][5].setBorder(topRightBorder);
      Cells[0][8].setBorder(topRightBorder);
      Cells[3][8].setBorder(topRightBorder);
      Cells[6][8].setBorder(topRightBorder);
      
      Cells[0][1].setBorder(topBorder);
      Cells[3][1].setBorder(topBorder);
      Cells[6][1].setBorder(topBorder);
      Cells[0][4].setBorder(topBorder);
      Cells[3][4].setBorder(topBorder);
      Cells[6][4].setBorder(topBorder);
      Cells[0][7].setBorder(topBorder);
      Cells[3][7].setBorder(topBorder);
      Cells[6][7].setBorder(topBorder);
      
      
      pack();                                                 
 
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Color Sudoku");
      setVisible(true);
      setLocation(600, 200);
   }
    
    public static void main(String[] args) {
        ColorSudoku gui=new ColorSudoku();
    }
   
    private class Mouse implements MouseListener {
        
        @Override
        public void mouseClicked(MouseEvent e) {
         //To understand which cell is selected.
         int rowSelected = -1;
         int colSelected = -1;
 
         JTextField source = (JTextField)e.getSource();
         //Finding the selected cell.
         boolean found = false;
         for (int row = 0; row < GRID_SIZE && !found; ++row) {
            for (int col = 0; col < GRID_SIZE && !found; ++col) {
               if (Cells[row][col] == source) {
                  rowSelected = row;
                  colSelected = col;
                  found = true;  
               }
            }
         }
         
         if(Cells[rowSelected][colSelected].getBackground()==OPEN_CELL_BG_COLOR) Cells[rowSelected][colSelected].setBackground(Color.MAGENTA);
         else if(Cells[rowSelected][colSelected].getBackground()==Color.MAGENTA) Cells[rowSelected][colSelected].setBackground(Color.YELLOW);
         else if(Cells[rowSelected][colSelected].getBackground()==Color.YELLOW) Cells[rowSelected][colSelected].setBackground(Color.ORANGE);
         else if(Cells[rowSelected][colSelected].getBackground()==Color.ORANGE) Cells[rowSelected][colSelected].setBackground(Color.GREEN);
         else if(Cells[rowSelected][colSelected].getBackground()==Color.GREEN) Cells[rowSelected][colSelected].setBackground(Color.RED);
         else if(Cells[rowSelected][colSelected].getBackground()==Color.RED) Cells[rowSelected][colSelected].setBackground(Color.BLACK);
         else if(Cells[rowSelected][colSelected].getBackground()==Color.BLACK) Cells[rowSelected][colSelected].setBackground(Color.WHITE);
         else if(Cells[rowSelected][colSelected].getBackground()==Color.WHITE) Cells[rowSelected][colSelected].setBackground(Color.CYAN);
         else if(Cells[rowSelected][colSelected].getBackground()==Color.CYAN) Cells[rowSelected][colSelected].setBackground(Color.BLUE);
         else if(Cells[rowSelected][colSelected].getBackground()==Color.BLUE) Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
         //To understand which cell is selected.
         int rowSelected = -1;
         int colSelected = -1;

         JTextField source = (JTextField)e.getSource();
         //Finding the selected cell.
         boolean found = false;
         for (int row = 0; row < GRID_SIZE && !found; ++row) {
            for (int col = 0; col < GRID_SIZE && !found; ++col) {
               if (Cells[row][col] == source) {
                  rowSelected = row;
                  colSelected = col;
                  found = true;  
               }
            }
         }
            if(Cells[rowSelected][colSelected].getBackground()!=OPEN_CELL_BG_COLOR) {
                int inputColor;
                if(Cells[rowSelected][colSelected].getBackground()==Color.MAGENTA) {
                    inputColor=1;
                    if(inputColor!=puzzle[rowSelected][colSelected]) {
                        JOptionPane.showMessageDialog(null, "Wrong color!");  
                        Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
                    }
                }
                else if(Cells[rowSelected][colSelected].getBackground()==Color.YELLOW) {
                    inputColor=2;
                    if(inputColor!=puzzle[rowSelected][colSelected]) {
                        JOptionPane.showMessageDialog(null, "Wrong color!");
                        Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
                    }
                }
                else if(Cells[rowSelected][colSelected].getBackground()==Color.ORANGE) {
                    inputColor=3;
                    if(inputColor!=puzzle[rowSelected][colSelected]) {
                        JOptionPane.showMessageDialog(null, "Wrong color!");
                        Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
                    }
                }
                else if(Cells[rowSelected][colSelected].getBackground()==Color.GREEN) {
                    inputColor=4;
                    if(inputColor!=puzzle[rowSelected][colSelected]) {
                        JOptionPane.showMessageDialog(null, "Wrong color!");
                        Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
                    }
                }
                else if(Cells[rowSelected][colSelected].getBackground()==Color.RED) {
                    inputColor=5;
                    if(inputColor!=puzzle[rowSelected][colSelected]) {
                        JOptionPane.showMessageDialog(null, "Wrong color!");
                        Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
                    }
                }
                else if(Cells[rowSelected][colSelected].getBackground()==Color.BLACK) {
                    inputColor=6;
                    if(inputColor!=puzzle[rowSelected][colSelected]) {
                        JOptionPane.showMessageDialog(null, "Wrong color!");
                        Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
                    }
                }
                else if(Cells[rowSelected][colSelected].getBackground()==Color.WHITE) {
                    inputColor=7;
                    if(inputColor!=puzzle[rowSelected][colSelected]) {
                        JOptionPane.showMessageDialog(null, "Wrong color!");
                        Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
                    }
                }
                else if(Cells[rowSelected][colSelected].getBackground()==Color.CYAN) {
                    inputColor=8;
                    if(inputColor!=puzzle[rowSelected][colSelected]) {
                        JOptionPane.showMessageDialog(null, "Wrong color!");
                        Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
                    }
                }
                else if(Cells[rowSelected][colSelected].getBackground()==Color.BLUE) {
                    inputColor=9;
                    if(inputColor!=puzzle[rowSelected][colSelected]) {
                        JOptionPane.showMessageDialog(null, "Wrong color!");
                        Cells[rowSelected][colSelected].setBackground(OPEN_CELL_BG_COLOR);
                    }
                }
            }
            boolean isFinished=true;
            for(int row=0;row<GRID_SIZE;++row) {
                for(int col=0;col<GRID_SIZE;++col) {
                    if(Cells[row][col].getBackground()==OPEN_CELL_BG_COLOR) isFinished=false;
                }
            }
            if(isFinished) JOptionPane.showMessageDialog(null, "Congratulations!");
        }
        
    }
}
