package login1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class wel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wel frame = new wel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public wel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 498);
		setTitle("Welcome Page");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 143, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FOOD ORDERING SYSTEM");
		lblNewLabel.setBackground(new Color(119, 136, 153));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(86, 37, 594, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Press the button to continue...");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 19));
		lblNewLabel_1.setBounds(26, 152, 284, 22);
		contentPane.add(lblNewLabel_1);
		
			
			JButton btnNewButton = new JButton("WELCOME");
			btnNewButton.setBounds(167, 205, 342, 95);
			contentPane.add(btnNewButton);
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 33));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login l = new login();
					l.show();
					dispose();
				}
			});
	}
}
