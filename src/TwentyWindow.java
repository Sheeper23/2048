

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwentyWindow extends JFrame {
	private TwentyGrid grid;
	private JPanel gridPanel;
	
	public TwentyWindow() {
		super("2048");
		grid = new TwentyGrid();
		gridPanel = new JPanel();
		
		setSize(800, 800);
        setLocation(450, 50);
        setVisible(true);
        setResizable(false);
        setLayout(new GridLayout(1, 1, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gridPanel.setBackground(new Color(185, 173, 161));
        gridPanel.setLayout(new GridLayout(grid.getDIMENS(), grid.getDIMENS(), 5, 5));
        
        add(gridPanel);
        drawGrid();
        
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
            	int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP || key == 87) {  
                	grid.moveUp();
                	//grid.changeDirUp();
                }
                if (key == KeyEvent.VK_DOWN || key == 83) {
                	grid.moveDown();
                    //grid.changeDirDown();
                }
                if (key == KeyEvent.VK_LEFT || key == 65) {
                	grid.moveLeft();
                    //grid.changeDirLeft();
                }
                if (key == KeyEvent.VK_RIGHT || key == 68) {
                	grid.moveRight();
                    //grid.changeDirRight();
                }    
                drawGrid();
            }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
        });
	}
	
	public void drawGrid() {
		gridPanel.removeAll();
		for (int i = 0; i < grid.getGrid().length; i++) {
			for (int j = 0; j < grid.getGrid()[i].length; j++) {
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout());
				JLabel text = new JLabel(""+grid.getGrid()[i][j]);
				text.setFont(new Font(Font.MONOSPACED, Font.BOLD, 70));
				text.setForeground(Color.WHITE);
				
				
				if (grid.getGrid()[i][j] == grid.getBASIS()) {
					text.setForeground(new Color(117, 110, 102));
					panel.setBackground(new Color(238, 228, 218));
				}
				else if (grid.getGrid()[i][j] == grid.getBASIS()*2) {
					text.setForeground(new Color(117, 110, 102));
					panel.setBackground(new Color(237, 224, 200));
				}
				else if (grid.getGrid()[i][j] == grid.getBASIS()*4) {
					panel.setBackground(new Color(242, 177, 121));
				}
				else if (grid.getGrid()[i][j] == grid.getBASIS()*8) {
					panel.setBackground(new Color(245, 149, 99));
				}
				else if (grid.getGrid()[i][j] == grid.getBASIS()*16) {
					panel.setBackground(new Color(246, 124, 95));
				}
				else if (grid.getGrid()[i][j] == grid.getBASIS()*32) {
					panel.setBackground(new Color(246, 94, 59));
				}
				else if (grid.getGrid()[i][j] == grid.getBASIS()*64) {
					panel.setBackground(new Color(237, 207, 114));
				}
				else if (grid.getGrid()[i][j] == grid.getBASIS()*128) {
					panel.setBackground(new Color(237, 204, 97));
				}
				else if (grid.getGrid()[i][j] == grid.getBASIS()*256) {
					panel.setBackground(new Color(237, 200, 80));
				}
				else if (grid.getGrid()[i][j] == grid.getBASIS()*512) {
					panel.setBackground(new Color(237, 197, 63));
				}
				else if (grid.getGrid()[i][j] >= grid.getBASIS()*1024) {
					panel.setBackground(new Color(237, 194, 46));
				}
				   
				else {
					text = new JLabel("");
					panel.setBackground(new Color(204, 192, 179));
					
				}
				
				panel.add(text);
				
				gridPanel.add(panel);
			}
		}
		gridPanel.revalidate();
		gridPanel.repaint();
	}
}
