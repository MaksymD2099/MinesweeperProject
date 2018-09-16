
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindowMinesweeper extends MinesweeperGUI{
    
    private JButton startButton;
    private JLabel winnerLabel;
    private static MainWindowMinesweeper instance;
    
    public  JLabel winCounterLabel;
    public JLabel lossCounterLabel;
    
    public JLabel winNum;
    public JLabel lossNum;
    
    
    
    public MainWindowMinesweeper()
    {
        instance = this;
        setSize(480, 480);
        winnerLabel = new JLabel("Messages");
        
        winCounterLabel = new JLabel("Number of Wins");
        lossCounterLabel = new JLabel("Number of Losses");
        
        winNum = new JLabel("");
        winNum.setText("" + intWins);
        
        lossNum = new JLabel("");
        lossNum.setText("" + intLosses);        
        
        startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                MinesweeperGUI game = new MinesweeperGUI();   
                game.play();
            }
        });        
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        
        pane.add(startButton, BorderLayout.CENTER);
        pane.add(winCounterLabel, BorderLayout.EAST);
        pane.add(lossCounterLabel, BorderLayout.WEST);
        pane.add(winNum, BorderLayout.BEFORE_LINE_BEGINS);
        pane.add(lossNum, BorderLayout.LINE_START);
                
    }
    
    public static void main(String[] args) {
        
        MainWindowMinesweeper window = new MainWindowMinesweeper();
        window.setVisible(true);
    }
}
