package login1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTextField;
import java.awt.Color;

public class f2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable tblModel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f2 frame = new f2();
					frame.setVisible(true);
					frame.setTitle("Stores");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	/**
	 * Create the frame.
	 */
	public f2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Store-Room");
		setBounds(100, 100, 734, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 143, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Items Available");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(17, 31, 515, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(38, 144, 127, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Item Name:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(38, 201, 127, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_1_2.setBounds(38, 255, 127, 21);
		contentPane.add(lblNewLabel_1_2);
		
		final JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String name = textField_1.getText();
				String price = textField_2.getText();
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mansi","root","mansi");
					PreparedStatement ps = con.prepareStatement("insert into items(ItemID,ItemName,Price)values(?,?,?)");
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, price);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton, "Inserted Successfully");
				
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBounds(17, 298, 103, 35);
		contentPane.add(btnNewButton);
		
		final JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String name = textField_1.getText();
				String price = textField_2.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mansi","root","mansi");
					PreparedStatement ps = con.prepareStatement("delete from items where ItemID=?");
					ps.setString(1, id);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(btnDelete, "Deleted Successfully");
				
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnDelete.setBounds(17, 351, 103, 35);
		contentPane.add(btnDelete);
		
		final JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String name = textField_1.getText();
				String price = textField_2.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mansi","root","mansi");
					PreparedStatement ps = con.prepareStatement("UPDATE items set ItemName=?,Price=? where ItemID=?");
					ps.setString(3, id);
					ps.setString(1, name);
					ps.setString(2, price);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(btnEdit, "Updated Successfully");
				
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnEdit.setBounds(17, 401, 103, 35);
		contentPane.add(btnEdit);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setFillsViewportHeight(true);
		table.setBounds(397, 416, 277, -271);
		contentPane.add(table);
		
		JButton btnDisplay = new JButton("display");
		btnDisplay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mansi","root","mansi");
					Statement st = con.createStatement();
					String query = "select * from items";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tblModel.getModel();
					
					
					int cols= rsmd.getColumnCount();
					String[] colName= new String[cols];
					for(int i = 0;i<cols;i++) {
						colName[i]= rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
					}
					String id,name,price;
					while(rs.next()) {
						id = rs.getString(1);
						name = rs.getString(2);
						price = rs.getString(3);
						String[] row = {id,name,price};
						model.addRow(row);
						
					}
					st.close();
					con.close();
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDisplay.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnDisplay.setBounds(195, 323, 89, 35);
		contentPane.add(btnDisplay);
		
		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblModel.setModel(new DefaultTableModel());
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnClear.setBounds(195, 369, 96, 35);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(340, 122, 370, 323);
		contentPane.add(scrollPane);
		
		tblModel = new JTable();
		scrollPane.setViewportView(tblModel);
		
		textField = new JTextField();
		textField.setBounds(164, 146, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 203, 127, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 257, 127, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("Database Table:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setBounds(340, 97, 213, 14);
		contentPane.add(lblNewLabel_2);
	}

}
