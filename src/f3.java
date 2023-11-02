package login1;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Container;
import java.awt.Color;


public class f3 extends JFrame {
	private JFrame frame;
	private JTextField ti;
	private JTextField tn;
	private JTextField sp;
	private JTextField ta;
	private JTextField tt;
	Container c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					f3 frame = new f3();
					frame.setVisible(true);
					frame.setSize(1000,1000);
					frame.setResizable(false);
					frame.setTitle("Bill");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	ResultSet rs;
	PreparedStatement pst;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public f3() {
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(188, 143, 143));
		JLabel lblNewLabel = new JLabel("Item ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel.setBounds(27, 69, 81, 25);
		c.add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblItemName.setBounds(167, 69, 103, 25);
		c.add(lblItemName);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblQty.setBounds(313, 69, 49, 25);
		c.add(lblQty);
		
		final JSpinner sq = new JSpinner();
		sq.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int qty = Integer.parseInt(sq.getValue().toString());
				int price = Integer.parseInt(sp.getText());
				
				int tot = qty*price;
				
				ta.setText(String.valueOf(tot));
			}
		});
		sq.setBounds(293, 105, 73, 20);
		getContentPane().add(sq);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblPrice.setBounds(393, 69, 81, 25);
		c.add(lblPrice);
		
		final JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblAmount.setBounds(507, 69, 81, 25);
		c.add(lblAmount);
		
		
		
		ti = new JTextField();
		ti.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					String id = ti.getText();
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mansi","root","mansi");
						PreparedStatement pst = con.prepareStatement("select * from items where ItemID=?");
						
						pst.setString(1, id);
						rs = pst.executeQuery();
						
						if(rs.next() == false) {
							JOptionPane.showMessageDialog(lblAmount, "Item ID not found");
						}
						else {
							String iname = rs.getString("ItemName");
							String price = rs.getString("Price");
							
							tn.setText(iname.trim());
							sp.setText(price.trim());
							
						}
				}
					 catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
		}});
		ti.setBounds(30, 105, 96, 20);
		c.add(ti);
		ti.setColumns(10);
		
		tn = new JTextField();
		tn.setColumns(10);
		tn.setBounds(167, 105, 96, 20);
		c.add(tn);
		
		sp = new JTextField();
		sp.setColumns(10);
		sp.setBounds(393, 105, 96, 20);
		c.add(sp);
		
		ta = new JTextField();
		ta.setColumns(10);
		ta.setBounds(507, 105, 96, 20);
		c.add(ta);
		
		tt = new JTextField();
		tt.setColumns(10);
		tt.setBounds(598, 393, 143, 20);
		c.add(tt);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Bill Generation");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(293, 21, 303, 25);
		c.add(lblNewLabel_1);
		
		final JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = ti.getText();
				String name = tn.getText();
				String q = sq.getValue().toString();
				String pr = sp.getText();
				String a = ta.getText();

				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mansi","root","mansi");
					PreparedStatement ps = con.prepareStatement("insert into buy(ID,ItemName,Qty,Price,Amount)values(?,?,?,?,?)");
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, q);
					ps.setString(4, pr);
					ps.setString(5, a);

					ps.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton, "Inserted Successfully");
				
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		}});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnNewButton.setBounds(598, 148, 143, 56);
		c.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 169, 561, 244);
		c.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("DISPLAY");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mansi","root","mansi");
					Statement st = con.createStatement();
					String query = "select * from buy";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					
					int cols= rsmd.getColumnCount();
					String[] colName= new String[cols];
					for(int i = 0;i<cols;i++) {
						colName[i]= rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
					}
					String id,name,q,p,a;
					while(rs.next()) {
						id = rs.getString(1);
						name = rs.getString(2);
						q = rs.getString(3);
						p = rs.getString(4);
						a = rs.getString(5);
						String[] row = {id,name,q,p,a};
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
		btnNewButton_1.setBounds(598, 241, 143, 25);
		c.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("CLEAR");
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton_1_1.setBounds(598, 277, 143, 25);
		c.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("TOTAL");
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum =0;
				for(int i=0;i<table.getRowCount();i++) {
					sum = sum + Integer.parseInt(table.getValueAt(i, 4).toString());
				}
				tt.setText(Integer.toString(sum));
			}
		});
		btnNewButton_1_1_1.setBounds(598, 327, 143, 46);
		c.add(btnNewButton_1_1_1);
		
		JLabel lblBillalsoSaved = new JLabel("Bill (also saved in the database):");
		lblBillalsoSaved.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblBillalsoSaved.setBounds(27, 136, 284, 30);
		c.add(lblBillalsoSaved);
	}
}
