package login1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class f1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f1 frame = new f1();
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
	public f1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 493);
		setTitle("Menu Page");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 143, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please choose an operation:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 26));
		lblNewLabel.setBounds(10, 81, 411, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BUY ITEMS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f3 r = new f3();
				r.show();

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(61, 172, 197, 64);
		contentPane.add(btnNewButton);
		
		JButton btnAboutUs = new JButton("ABOUT US");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				au a = new au();
				a.show();
				
			}
		});
		btnAboutUs.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnAboutUs.setBounds(61, 308, 197, 64);
		contentPane.add(btnAboutUs);
		
		JButton btnNewButton_1_1 = new JButton("STORE-ROOM");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				f2 i = new f2();
				i.show();

				
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1_1.setBounds(367, 172, 191, 64);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("EXIT");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1_2.setBounds(367, 308, 191, 64);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblDearCostumer = new JLabel("Dear Customer,");
		lblDearCostumer.setFont(new Font("Times New Roman", Font.ITALIC, 26));
		lblDearCostumer.setBounds(10, 49, 411, 36);
		contentPane.add(lblDearCostumer);
	}

}
