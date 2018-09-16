import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MinesweeperGUI extends JFrame implements KeyListener{
    
    private JButton[][] boardButtons = new JButton[8][8];
    private int[][] board = new int[8][8];
    JButton[][] buttons;
    //final private int NUM_BUTTONS = 64;
    private boolean ctrlKeyPressed = false;
    private int dimension = 8;
    private int bound = dimension-2;
    
    public int intWins = 0;
    public int intLosses = 0;
    
    private boolean isGameFinished = false;
    
    
    public MinesweeperGUI()
    {
       //super();        
    }
    
    //------BEGIN randomBomb()------------

    public void randomBomb()
    {
        Random rand = new Random();
        for (int i = 1; i <= 10; i++) 
        {            
            int rowBomb = rand.nextInt(8);
            int columnBomb = rand.nextInt(8);
            
            if(board[rowBomb][columnBomb] == -1)
            {
                rowBomb = rand.nextInt(8);
                columnBomb = rand.nextInt(8);
            }
            
            boardButtons[rowBomb][columnBomb].setText("Bomb");                      
            board[rowBomb][columnBomb] = -1;
            boardButtons[rowBomb][columnBomb].setVisible(true);    // DEBUGGING
        }
    }
    
    //------END randomBomb()-----------
    
    //------BEGIN putProxim()----------
    
    public void putProxim() 
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                 if(board[i][j] != -1){
                     
                     if(j>=1 && board[i][j-1] == -1)                     
                        ++board[i][j];                     
                     
                     if(j<= bound && board[i][j+1] == -1)                     
                        ++board[i][j];
                     
                     if(i>=1 && board[i-1][j] == -1)                     
                        ++board[i][j];
                     
                     if(i<= bound && board[i+1][j] == -1)                    
                        ++board[i][j];                         
                     
                     if(i>=1 && j>= 1 && board[i-1][j-1] == -1)                 
                        ++board[i][j];
                         
                     if(i<= bound && j<= bound && board[i+1][j+1] == -1)                      
                        ++board[i][j];
                         
                     
                     if(i>=1 && j<= bound && board[i-1][j+1] == -1) 
                         ++board[i][j];
                         
                     if(i<= bound && j>= 1 && board[i+1][j-1] == -1) 
                         ++board[i][j];                        
                    
                     
                     if (true && board[i][j] != 0)
                     {
                        boardButtons[i][j].setText(String.format("%d", board[i][j]));
                     }
                 }
            }
        }        
    } 

//-----------END OF putProxim()----------
    
    
//-----------BEGIN areaScanner()---------
            
    public void areaScanner(int coordX, int coordY)
    {
        //we need to make the numbers on the boarder visisble
        
        if(coordX == 0)
        {
            if(coordY == 0)
            {
                for (int i = coordX; i <= coordX + 1; i++) 
                {
                    if(board[i][coordY] == 0){
                        boardButtons[i][coordY].doClick(0);
                    }
                }
                    for (int j = coordY; j <= coordY + 1; j++)
                    {
                        if(board[coordX][j] == 0){
                            boardButtons[coordX][j].doClick(0);
                        }                        
                    }
            }
            if(coordY == 7)
            {
                for (int i = coordX; i <= coordX + 1; i++) 
                {
                    if(board[i][coordY] == 0){
                        boardButtons[i][coordY].doClick(0);
                    }
                }
                    for (int j = coordY; j <= coordY + 1; j++)
                    {
                        if(board[coordX][j] == 0){
                            boardButtons[coordX][j].doClick(0);
                        }                        
                    }
            }
            else
                {
                for (int i = coordX; i <= coordX + 1; i++) 
                {
                    if(board[i][coordY] == 0){
                        boardButtons[i][coordY].doClick(0);
                    }
                }
                    for (int j = coordY; j <= coordY + 1; j++)
                    {
                        if(board[coordX][j] == 0){
                            boardButtons[coordX][j].doClick(0);
                        }                        
                    }
            }
        }
            else if(coordX == 7){
                    if(coordY == 0){
                for (int i = coordX; i <= coordX + 1; i++) 
                {
                    if(board[i][coordY] == 0){
                        boardButtons[i][coordY].doClick(0);
                    }
                }
                    for (int j = coordY; j <= coordY + 1; j++)
                    {
                        if(board[coordX][j] == 0){
                            boardButtons[coordX][j].doClick(0);
                        }                        
                    }
            }
        }
            else if(coordY == 7)
                    {
                for (int i = coordX; i <= coordX + 1; i++) 
                {
                    if(board[i][coordY] == 0){
                        boardButtons[i][coordY].doClick(0);
                    }
                }
                    for (int j = coordY; j <= coordY + 1; j++)
                    {
                        if(board[coordX][j] == 0){
                            boardButtons[coordX][j].doClick(0);
                        }                        
                    }
            }
        
        }
     

        
       /*
         for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 0){
                    
                    if(j>=1 && board[i][j-1] == 0) {
                        boardButtons[i][j-1].setEnabled(false);                        
                    }
                    if(j<= bound && board[i][j+1] == 0) {
                        boardButtons[i][j+1].setEnabled(false);
                    
                    }
                    if(i>=1 && board[i-1][j] == 0) {
                        boardButtons[i-1][j].setEnabled(false);
                        
                    }
                    if(i<= bound && board[i+1][j] == 0) {
                        boardButtons[i+1][j].setEnabled(false);
                    
                    }
                    if(i>=1 && j>= 1 && board[i-1][j-1] == 0) {
                        boardButtons[i-1][j-1].setEnabled(false);
                       
                    }
                    if(i<= bound && j<= bound && board[i+1][j+1] == 0) {
                        boardButtons[i+1][j+1].setEnabled(false);
                        
                    }
                    if(i>=1 && j<= bound && board[i-1][j+1] == 0) {
                        boardButtons[i-1][j+1].setEnabled(false);
                       
                    }
                    if(i<= bound && j>= 1 && board[i+1][j-1] == 0) {
                        boardButtons[i+1][j-1].setEnabled(false);
                    
                    }
                }
            }
        }
        
        /*while(maxSize == false){
        if(board[coordY][coordX] == 0){
                    
            if(board[coordY][coordX + areaSize] == 0){ boardButtons[coordY][coordX + areaSize].setEnabled(false);}
            else if(board[coordY][coordX + areaSize] >= 1) {boardButtons[coordY][coordX + areaSize].setEnabled(false); }
            if(board[coordY][coordX + (areaSize +1)] >= 1) {/*Do nothing} 
                             
        }
       */
      
                
    public void verifyArea(int board[][])
    {
        
    }
    
    public void gameWon()
    {
        isGameFinished = true;
        ++intWins;        
    }
    
    
    public void gameLost()
    {
        isGameFinished = true;
        ++intLosses;
    }

    
    public void play()
    {
        JFrame frame = new JFrame("Mine Sweeper");
        
        frame.setSize(900, 900);
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(8, 8));
       
        for (int i=0; i < 8; ++i)
        {
            for (int j = 0; j < 8; j++) {
                // Only constant variables can be accesssed in the 
            int row = i;
            int column = j;
          
            
            boardButtons[row][column] = new JButton();            
            boardButtons[row][column].setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            boardButtons[row][column].addKeyListener(this);
            boardButtons[row][column].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (ctrlKeyPressed && boardButtons[row][column].getText().equals("Mine!"))
                    {
                        boardButtons[row][column].setText("" + board[row][column]);
                    }
                    else if (ctrlKeyPressed)
                    {
                        boardButtons[row][column].setText("Mine!");
                    }
                    else if (board[row][column] == -1)
                    {
                        boardButtons[row][column].setText("BOOMBitch!");
                        //endGame();                                                                  //we need to make this!
                    }
                    
                    else if(board[row][column] == 0){
                        
                        boardButtons[row][column].setEnabled(false);
                        areaScanner(row,column);
                        
                    }/*
                    else if(board[row][column] != -1)
                    {
                        boardButtons[row][column].setEnabled(false);
                        //makes everything that doesnt have a number clock by itself (.doClick() mthod)
                        for(int i = 0; i < 8; i++)
                        {
                            for(int j = 0; j < 8; j++)
                        {
                            boardButtons[i][j].doClick(0);
                           // boardButtons[i][j].setText(String.format("%d", board[i][j]));
                        }
                       }
                    }*/
                }
            });

            frame.add(boardButtons[row][column]);          
            }
        }
        
        randomBomb();
        putProxim();
        
        
        frame.setVisible(true);
    }//--------------END OF play()------------
    
   
    
    

    @Override
    public void keyTyped(KeyEvent ke){
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        ctrlKeyPressed = ke.isControlDown();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        ctrlKeyPressed = ke.isControlDown();
    }
}
/*

package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board {
    private Cell[][] cells;
    private int cellID = 0;
    private int side = 8;
    private int limit = side-2;

    public void setBoard(){
        JFrame frame = new JFrame();
        frame.add(addCells());

        plantMines();
        setCellValues();

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(side,side));
        cells = new Cell[side][side];
        for(int i = 0; i< side; i++){
            for(int j = 0; j<side; j++){
                cells[i][j] = new Cell(this);
                cells[i][j].setId(getID());
                panel.add(cells[i][j].getButton());
            }
        }
        return panel;
    }

    public void plantMines(){
        ArrayList<Integer> loc = generateMinesLocation(10);
        for(int i : loc){
            getCell(i).setValue(-1);
        }
    }
    /*Choose rendom places for mines
    public ArrayList<Integer> generateMinesLocation(int q){
        ArrayList<Integer> loc = new ArrayList<Integer>();
        int random;
        for(int i = 0; i<q;){
            random = (int)(Math.random()* (side*side));
            if(!loc.contains(random)){
                loc.add(random);
                i++;
            }
        }
        return loc;
    }
    // MOST IMPORTANT PART/////////////////////////////////////////////////////
    /*This method count number of mines around particular cell and set its value
    public void setCellValues(){
        for(int i = 0; i<side; i++){
            for(int j = 0; j<side; j++){
                 if(cells[i][j].getValue() != -1){
                     if(j>=1 && cells[i][j-1].getValue() == -1) cells[i][j].incrementValue();
                     if(j<= limit && cells[i][j+1].getValue() == -1) cells[i][j].incrementValue();
                     if(i>=1 && cells[i-1][j].getValue() == -1) cells[i][j].incrementValue();
                     if(i<= limit && cells[i+1][j].getValue() == -1) cells[i][j].incrementValue();
                     if(i>=1 && j>= 1 && cells[i-1][j-1].getValue() == -1) cells[i][j].incrementValue();
                     if(i<= limit && j<= limit && cells[i+1][j+1].getValue() == -1) cells[i][j].incrementValue();
                     if(i>=1 && j<= limit && cells[i-1][j+1].getValue() == -1) cells[i][j].incrementValue();
                     if(i<= limit && j>= 1 && cells[i+1][j-1].getValue() == -1) cells[i][j].incrementValue();
                 }
            }
        }
    }
    /*This method starts chain reaction. When user click on particular cell, if cell is empty (value = 0) this
    method look for other empty cells next to activated one. If finds one, it call checkCell and in effect,
    start next scan on its closest area.
     
    public void scanForEmptyCells(){
        for(int i = 0; i<side; i++){
            for(int j = 0; j<side; j++){
                if(!cells[i][j].isNotChecked()){
                    if(j>=1 && cells[i][j-1].isEmpty()) cells[i][j-1].checkCell();
                    if(j<= limit && cells[i][j+1].isEmpty()) cells[i][j+1].checkCell();
                    if(i>=1 && cells[i-1][j].isEmpty()) cells[i-1][j].checkCell();
                    if(i<= limit && cells[i+1][j].isEmpty()) cells[i+1][j].checkCell();
                    if(i>=1 && j>= 1 && cells[i-1][j-1].isEmpty()) cells[i-1][j-1].checkCell();
                    if(i<= limit && j<= limit && cells[i+1][j+1].isEmpty()) cells[i+1][j+1].checkCell();
                    if(i>=1 && j<= limit && cells[i-1][j+1].isEmpty()) cells[i-1][j+1].checkCell();
                    if(i<= limit && j>= 1 && cells[i+1][j-1].isEmpty()) cells[i+1][j-1].checkCell();
                }
            }
        }
    }
    //////////////////////////////////////////////////////////////////////////////////
    public int getID(){
        int id = cellID;
        cellID++;
        return id;
    }

    public Cell getCell(int id){
        for(Cell[] a : cells){
            for(Cell b : a){
                if(b.getId() == id) return b;

            }
        }
        return null;
    }

    public void fail(){
        for(Cell[] a : cells){
            for(Cell b : a){
                b.reveal();
            }
        }
    }
}

*/
