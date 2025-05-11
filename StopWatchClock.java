package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class StopWatchClock extends JFrame implements ActionListener {
    JLabel clockLabel = new JLabel();
    JLabel stopwatchLabel = new JLabel("00:00:00");
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");
    JButton resetButton = new JButton("Reset");
    Timer clockTimer;
    Timer stopwatchTimer;
    int elapsedSeconds = 0;
    boolean running = false;
    public StopWatchClock() {
        setTitle("Stopwatch / Clock");
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(clockLabel);
        stopwatchLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        stopwatchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(stopwatchLabel);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        add(buttonPanel);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);
        clockTimer = new Timer(1000, e -> {
            clockLabel.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        });
        clockTimer.start();
        stopwatchTimer = new Timer(1000, e -> {
            elapsedSeconds++;
            stopwatchLabel.setText(formatTime(elapsedSeconds));
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new StopWatchClock();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!running) {
                stopwatchTimer.start();
                running = true;
            }
        } else if (e.getSource() == stopButton) {
            stopwatchTimer.stop();
            running = false;
        } else if (e.getSource() == resetButton) {
            stopwatchTimer.stop();
            running = false;
            elapsedSeconds = 0;
            stopwatchLabel.setText("00:00:00");
        }
    }
    private String formatTime(int totalSeconds) {
        int hrs = totalSeconds / 3600;
        int mins = (totalSeconds % 3600) / 60;
        int secs = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hrs, mins, secs);
    }
}

