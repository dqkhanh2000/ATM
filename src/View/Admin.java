package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import Data.Connect;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;

	
	public Admin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 241, 127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnXoasaipin = new JButton("Mở thẻ bị khóa");
		btnXoasaipin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							XoaSaiPin frame = new XoaSaiPin();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnXoasaipin.setBounds(10, 11, 190, 28);
		contentPane.add(btnXoasaipin);
		
		JButton btnMTiKhon = new JButton("Quản lý khách hàng");
		btnMTiKhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							QLKhachHang frame = new QLKhachHang();
							frame.setVisible(true);
						} catch (Exception e) {
						}
					}
				});
			}
		});
		btnMTiKhon.setBounds(10, 51, 190, 28);
		contentPane.add(btnMTiKhon);
	}
}
class XoaSaiPin extends JFrame {

	private JPanel contentPane;
	private JTextField txtTfsotk;
	
	
	public XoaSaiPin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 137);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Nh\u1EADp S\u1ED1 t\u00E0i kho\u1EA3n");
		lbl.setBounds(6, 25, 107, 16);
		contentPane.add(lbl);
		
		txtTfsotk = new JTextField();
		txtTfsotk.setBounds(125, 19, 196, 28);
		contentPane.add(txtTfsotk);
		txtTfsotk.setColumns(10);
		
		JButton btnMKha = new JButton("M\u1EDF Kh\u00F3a");
		btnMKha.setBounds(112, 64, 90, 28);
		btnMKha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ATM;integratedSecurity=true");
					Statement st = conn.createStatement();
					int t = st.executeUpdate("UPDATE TaiKhoan SET SaiPIN = 0 WHERE SoTK = "+txtTfsotk.getText());
					if(t!=0) JOptionPane.showMessageDialog(null, "Mở khóa tài khoản thành công");
					else JOptionPane.showMessageDialog(null, "Không tồn tại số thẻ: "+txtTfsotk.getText());
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Lỗi Tạo tài khoản: "+e.toString());
				}
			}
		});
		contentPane.add(btnMKha);
	}
}
class Login extends JFrame{
	
	private JTextField tfUsername;
	private JPasswordField passwordField;
	
	public Login() {
		setTitle("Admin login");
		setBounds(100, 100, 283, 179);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 27, 68, 25);
		getContentPane().add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(88, 29, 167, 20);
		getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 63, 68, 14);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 60, 167, 20);
		getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ATM;integratedSecurity=true");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Login where Username = N'"+tfUsername.getText()+"' and Password = N'"+passwordField.getText()+"'");
					if (rs.next()) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Admin frame = new Admin();
									frame.setVisible(true);
								} catch (Exception e) {
								}
							}
						});
						dispose();
					}
					else JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Lỗi login Admin: " + ex.toString());
				}
			}
		});
		btnLogin.setBounds(88, 91, 89, 23);
		getContentPane().add(btnLogin);
		setVisible(true);
	}
}
