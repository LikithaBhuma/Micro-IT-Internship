import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private final JTextField txt;
    private double a = 0, b = 0, res = 0;
    private char op;

    public Calculator() {
        setTitle("Calculator");
        setSize(350, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));
        getContentPane().setBackground(Color.black);

        // Display field
        txt = new JTextField();
        txt.setEditable(false);
        txt.setFont(new Font("Consolas", Font.BOLD, 36));
        txt.setHorizontalAlignment(SwingConstants.RIGHT);
        txt.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(txt, BorderLayout.NORTH);

        // Buttons panel
        JPanel pnl = new JPanel(new GridLayout(4, 4, 4, 4));
        pnl.setBackground(Color.WHITE);
        String[] keys = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String k : keys) {
            JButton btn = new JButton(k);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setFocusPainted(false);
            btn.setForeground(Color.WHITE);

            if (k.matches("\\d")) {
                btn.setBackground(Color.cyan);
            } else if (k.equals("C")) {
                btn.setBackground(Color.green);
            } else if (k.equals("=")) {
                btn.setBackground(Color.BLUE);
            } else {
                btn.setBackground(Color.MAGENTA);
            }

            btn.addActionListener(this);
            pnl.add(btn);
        }

        add(pnl, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("\\d")) {
            txt.setText(txt.getText() + cmd);
        } else if (cmd.equals("C")) {
            txt.setText("");
            a = b = res = 0;
        } else if (cmd.equals("=")) {
            try {
                b = Double.parseDouble(txt.getText());
                switch (op) {
                    case '+': 
                    	res = a + b; 
                    	break;
                    case '-': 
                    	res = a - b; 
                    	break;
                    case '*': 
                    	res = a * b; 
                    	break;
                    case '/':
                        if (b == 0) {
                            txt.setText("Error: Divide by 0");
                            return;
                        }
                        res = a / b;
                        break;
                }
                txt.setText(String.valueOf(res));
            } catch (NumberFormatException ex) {
                txt.setText("Invalid Input");
            }
        } else {
            try {
                a = Double.parseDouble(txt.getText());
                op = cmd.charAt(0);
                txt.setText("");
            } catch (NumberFormatException ex) {
                txt.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
