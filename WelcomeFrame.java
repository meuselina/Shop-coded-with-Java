import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/** Welcome screen and entry point of the app. */
public class WelcomeFrame extends JFrame {
  private JButton startButton = new JButton();
  private Image backgroundImage;
  private JLabel shopNameLabel = new JLabel();
  private JLabel welcomeLabel = new JLabel();

  public WelcomeFrame() {
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1000;
    int frameHeight = 700;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Welcome");
    setResizable(false);

    // Background image
    try {
      backgroundImage = ImageIO.read(new File("images/background-welcome.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // JPanel with a custom paintComponent that draws the background image
    JPanel backgroundPanel = new JPanel() {
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
          g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
      }
    };
    backgroundPanel.setLayout(null); // absolute positioning
    setContentPane(backgroundPanel);

    startButton.setBounds(144, 312, 110, 96);
    startButton.setText("start");
    startButton.setMargin(new Insets(2, 2, 2, 2));
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        startButtonActionPerformed(evt);
      }
    });
    startButton.setBackground(new Color(0x000040));
    startButton.setForeground(Color.WHITE);
    startButton.setFont(new Font("Cambria", Font.BOLD, 36));
    backgroundPanel.add(startButton);

    shopNameLabel.setBounds(72, 208, 256, 96);
    shopNameLabel.setText("Shamishop");
    shopNameLabel.setForeground(Color.WHITE);
    shopNameLabel.setFont(new Font("Edwardian Script ITC", Font.BOLD, 68));
    backgroundPanel.add(shopNameLabel);

    welcomeLabel.setBounds(24, 136, 376, 80);
    welcomeLabel.setText("Welcome to");
    welcomeLabel.setFont(new Font("Edwardian Script ITC", Font.BOLD, 68));
    welcomeLabel.setForeground(Color.WHITE);
    backgroundPanel.add(welcomeLabel);

    showLoadingScreen(this);
    setVisible(true);
  }

  private static void showLoadingScreen(JFrame frame) {
    JProgressBar progressBar = new JProgressBar();
    progressBar.setMinimum(0);
    progressBar.setMaximum(50);
    progressBar.setForeground(new Color(255, 105, 180)); // neon pink

    // JOptionPane that holds the progress bar
    JOptionPane optionPane = new JOptionPane(progressBar, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});

    // A modal JDialog blocks the main window while it is open
    JDialog dialog = new JDialog(frame, null, true);
    dialog.setUndecorated(true); // no title bar
    dialog.setContentPane(optionPane);
    dialog.pack();
    dialog.setLocationRelativeTo(frame);

    // Timer that advances the progress bar
    Timer timer = new Timer(5, new ActionListener() {
      private int progress = 0;

      public void actionPerformed(ActionEvent e) {
        progressBar.setValue(progress);
        progress++;
        if (progress > 100) {
          dialog.dispose(); // close the dialog once loading is done
        }
      }
    });
    timer.start();

    dialog.setVisible(true);
  }

  public static void main(String[] args) {
    new WelcomeFrame();
  }

  public void startButtonActionPerformed(ActionEvent evt) {
    new CategoryFrame(); // open the category selection
    dispose();           // close the welcome screen
  }
}
