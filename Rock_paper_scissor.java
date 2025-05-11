package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Rock_paper_scissor {
    public static void main(String[] args) {
        JFrame f = new JFrame("RPS");
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        JButton b1 = new JButton("Rock");
        JButton b2 = new JButton("Paper");
        JButton b3 = new JButton("Scissors");
        JLabel l = new JLabel("Choose one");
        f.add(b1); f.add(b2); f.add(b3); f.add(l);
        String[] a = {"Rock", "Paper", "Scissors"};
        Random r = new Random();
        ActionListener al = e -> {
            String u = ((JButton)e.getSource()).getText();
            String c = a[r.nextInt(3)];
            String res;
            if (u.equals(c)) res = "Draw";
            else if ((u.equals("Rock") && c.equals("Scissors")) ||
                     (u.equals("Paper") && c.equals("Rock")) ||
                     (u.equals("Scissors") && c.equals("Paper"))) res = "Win";
            else res = "Lose";
            l.setText("You: " + u + ", CPU: " + c + " → " + res);
        };
        b1.addActionListener(al);
        b2.addActionListener(al);
        b3.addActionListener(al);
        f.setVisible(true);
    }
}
