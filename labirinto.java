import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerLabirintoGUI {
    private static long startTime;
    private static Timer timer;
    private static JLabel label;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Contador do Labirinto");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        label = new JLabel("Tempo: 0s");
        label.setBounds(100, 20, 150, 30);
        frame.add(label);

        JButton startButton = new JButton("Iniciar Jogo");
        startButton.setBounds(80, 50, 120, 30);
        frame.add(startButton);

        JButton stopButton = new JButton("Terminar Jogo");
        stopButton.setBounds(80, 90, 120, 30);
        frame.add(stopButton);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                label.setText("Tempo: " + elapsedTime + "s");
            }
        });

        startButton.addActionListener(e -> {
            startTime = System.currentTimeMillis();
            timer.start();
        });

        stopButton.addActionListener(e -> {
            timer.stop();
            long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
            JOptionPane.showMessageDialog(frame, "Terminaste em " + elapsedTime + " segundos!");
        });

        frame.setVisible(true);
    }
}
