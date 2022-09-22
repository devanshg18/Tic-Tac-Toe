import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class tic implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1 ;
    tic() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600 , 600);
        frame.getContentPane().setBackground(Color.RED);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text.setBackground(Color.blue);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("Ink Free" , Font.BOLD , 75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic-Tac-Toe");
        text.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0 , 0 , 600 , 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(25,25,25));

        for (int i = 0; i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Bola" , Font.ITALIC , 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text);
        frame.add(title_panel , BorderLayout.NORTH);
        frame.add(button_panel);
        FirstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0;i<9;i++){
            if (e.getSource()==buttons[i]){
                if (player1){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.YELLOW);
                        buttons[i].setText("X");
                        player1 = false;
                        text.setText("O's Turn");
                        Check();
                    }
                }
                else {
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.MAGENTA);
                        buttons[i].setText("O");
                        player1 = true;
                        text.setText("X's Turn");
                        Check();
                    }
                }
            }
        }

    }
    public void FirstTurn()  {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            player1 = true;
            text.setText("xTurn");
        }
        else{
            player1 = false;
            text.setText("oTurn");
        }
    }
    public void Check(){
        //0-Wins
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[1].getText().equals("X")) &&
                        (buttons[2].getText().equals("X"))
        ) {
            xWins(0,1,2);
        }
        if(
                (buttons[3].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[5].getText().equals("X"))
        ) {
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText().equals("X")) &&
                        (buttons[7].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(6,7,8);
        }
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[3].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(0,3,6);
        }
        if(
                (buttons[1].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[7].getText().equals("X"))
        ) {
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText().equals("X")) &&
                        (buttons[5].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(2,5,8);
        }
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[8].getText().
                                equals("X"))
        ) {
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(2,4,6);
        }
        //check O win conditions
        if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[1].getText().equals("O")) &&
                        (buttons[2].getText().equals("O"))
        ) {
            oWins(0,1,2);
        }
        if(
                (buttons[3].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[5].getText().equals("O"))
        ) {
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText().equals("O")) &&
                        (buttons[7].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(6,7,8);
        }
        if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[3].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(0,3,6);
        }
        if(
                (buttons[1].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[7].getText().equals("O"))
        ) {
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText().equals("O")) &&
                        (buttons[5].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(2,5,8);
        }
        if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(0,4,8);
        }
        if(
                (buttons[2].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(2,4,6);
        }
    }

    public void xWins(int a , int b , int    c){
        buttons[a].setBackground(Color.DARK_GRAY);
        buttons[b].setBackground(Color.DARK_GRAY);
        buttons[c].setBackground(Color.DARK_GRAY);

        for (int i =0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");
    }
    public void oWins(int a , int b , int    c){
        buttons[a].setBackground(Color.DARK_GRAY);
        buttons[b].setBackground(Color.DARK_GRAY);
        buttons[c].setBackground(Color.DARK_GRAY);

        for (int i =0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");
    }
}
