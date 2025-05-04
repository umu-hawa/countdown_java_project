
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class CountdownToArrival{

    public static void main(String[] args) {
        // Define the default arrival date
        LocalDate targetDate = LocalDate.of(2025, 4, 17);

        // Ask the user for input date (Optional)
        String inputDate = JOptionPane.showInputDialog("Enter target arrival date (YYYY-MM-DD):");
        if (inputDate != null && !inputDate.isEmpty()) {
            try {
                targetDate = LocalDate.parse(inputDate);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Using default date.");
            }
        }

        // Create the frame for the GUI
        JFrame frame = new JFrame("Countdown to Sierra Leone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Create label for displaying the countdown
        JLabel countdownLabel = new JLabel("Calculating days remaining...");
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(countdownLabel);

        // Get current date
        LocalDate currentDate = LocalDate.now();
        long daysRemaining = ChronoUnit.DAYS.between(currentDate, targetDate);

        // Real-time countdown (hours, minutes, seconds)
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calculate remaining time in terms of hours, minutes, seconds
                LocalDate now = LocalDate.now();
                LocalDate targetDate = LocalDate.of(  2025, 4, 17); // Assuming 12:00 AM on the target date
                Duration duration = Duration.between(now, targetDate);

                long days = duration.toDays();
                long hours = duration.toHours() % 24;
                long minutes = duration.toMinutes() % 60;
                long seconds = duration.getSeconds() % 60;

                // Update the label with the remaining time
                countdownLabel.setText(String.format("Days: %d, Time Remaining: %02d:%02d:%02d", days, hours, minutes, seconds));
            }
        });

        // Start the timer to update every second
        timer.start();

        // Set the window visible
        frame.setVisible(true);

        // Display the initial message
        JOptionPane.showMessageDialog(frame, "Countdown to Steven's arrival in Sierra Leone:\n" +
                "Days remaining: " + daysRemaining + " days.");
    }
}
