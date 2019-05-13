package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.Connect;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Rectangle;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class Main extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tfMathe;
	private JPasswordField pwdPin;
	private JLabel lblNhapPin;
	private JButton button1, button2, button3, button4 ,button5, button6, button7, button8, btnDuaTheVao ;
	private JButton btnN0, btnN1, btnN2,btnN3,btnN4,btnN5,btnN6,btnN7,btnN8,btnN9,btnEnter,btnCancle,btnClear,btnAdmin;
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lblManhinh, lblTieude, lblSo;
	private String TTHienTai = "Đăng nhập", PIN = "abc", TK = "";
	private JScrollPane scrollPane;
	private JTable table;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setTitle("M\u00F4 ph\u1ECFng ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button1 = new JButton();
		button1.setBounds(10, 87, 72, 60);
		contentPane.add(button1);
		
		button1.addActionListener(this);
		
		button2 = new JButton();
		button2.setBounds(10, 159, 72, 60);
		contentPane.add(button2);
		button2.addActionListener(this);
		
		button3 = new JButton();
		button3.setBounds(10, 231, 72, 60);
		contentPane.add(button3);
		button3.addActionListener(this);
		
		button4 = new JButton();
		button4.setBounds(10, 303, 72, 60);
		contentPane.add(button4);
		button4.addActionListener(this);
		
		button5 = new JButton();
		button5.setBounds(599, 77, 72, 60);
		contentPane.add(button5);
		button5.addActionListener(this);
		
		button6 = new JButton();
		button6.setBounds(599, 159, 72, 60);
		contentPane.add(button6);
		button6.addActionListener(this);
		
		button7 = new JButton();
		button7.setBounds(599, 231, 72, 60);
		contentPane.add(button7);
		button7.addActionListener(this);		
		
		 button8 = new JButton();
		button8.setBounds(599, 303, 72, 60);
		contentPane.add(button8);
		button8.addActionListener(this);
		
		JLabel lblNgnHngT = new JLabel("Ng\u00E2n h\u00E0ng TDAT-Bank");
		lblNgnHngT.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgnHngT.setFont(new Font("Arial", Font.BOLD, 23));
		lblNgnHngT.setBounds(139, 11, 437, 28);
		contentPane.add(lblNgnHngT);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(94, 369, 392, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnN1 = new JButton();
		btnN1.setBounds(16, 21, 62, 48);
		panel.add(btnN1);
		btnN1.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\1.png"));
		btnN1.addActionListener(this);		
		
		btnN2 = new JButton();
		btnN2.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\2.png"));
		btnN2.setBounds(118, 21, 62, 48);
		panel.add(btnN2);
		btnN2.addActionListener(this);
		
		btnN3 = new JButton();
		btnN3.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\3.png"));
		btnN3.setBounds(211, 21, 62, 48);
		panel.add(btnN3);
		btnN3.addActionListener(this);
		
		btnCancle = new JButton();
		btnCancle.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\Cancle.png"));
		btnCancle.setBounds(303, 21, 72, 48);
		panel.add(btnCancle);
		btnCancle.addActionListener(this);
		
		btnN4 = new JButton();
		btnN4.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\4.png"));
		btnN4.setBounds(16, 95, 62, 48);
		panel.add(btnN4);
		btnN4.addActionListener(this);
		
		btnN5 = new JButton();
		btnN5.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\5.png"));
		btnN5.setBounds(118, 95, 62, 48);
		panel.add(btnN5);
		btnN5.addActionListener(this);
		
		btnN6 = new JButton();
		btnN6.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\6.png"));
		btnN6.setBounds(211, 95, 62, 48);
		panel.add(btnN6);
		btnN6.addActionListener(this);
		
		btnClear = new JButton();
		btnClear.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\Clear.png"));
		btnClear.setBounds(303, 95, 72, 48);
		panel.add(btnClear);
		btnClear.addActionListener(this);
		
		btnN7 = new JButton();
		btnN7.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\7.png"));
		btnN7.setBounds(16, 166, 62, 48);
		panel.add(btnN7);
		btnN7.addActionListener(this);
		
		btnN8 = new JButton();
		btnN8.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\8.png"));
		btnN8.setBounds(118, 166, 62, 48);
		panel.add(btnN8);
		btnN8.addActionListener(this);
		
		btnN9 = new JButton();
		btnN9.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\9.png"));
		btnN9.setBounds(211, 166, 62, 48);
		panel.add(btnN9);
		btnN9.addActionListener(this);
		
		btnEnter = new JButton();
		btnEnter.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\Enter.png"));
		btnEnter.setBounds(303, 166, 72, 48);
		panel.add(btnEnter);
		btnEnter.addActionListener(this);
		
		btnN0 = new JButton();
		btnN0.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\0.png"));
		btnN0.setBounds(118, 236, 62, 48);
		panel.add(btnN0);
		btnN0.addActionListener(this);
		
		tfMathe = new JTextField();
		tfMathe.setToolTipText("V\u00EC m\u00F4 ph\u1ECFng cho n\u00EAn m\u1EDDi nh\u1EADp m\u00E3 th\u1EBB");
		tfMathe.setBounds(498, 375, 173, 28);
		contentPane.add(tfMathe);
		tfMathe.setColumns(10);
		
		btnDuaTheVao = new JButton("\u0110\u01B0a th\u1EBB v\u00E0o");
		btnDuaTheVao.addActionListener(this); 
		btnDuaTheVao.setBounds(521, 415, 132, 28);
		contentPane.add(btnDuaTheVao);
		
		lblTieude = new JLabel("Vui lòng chọn giao dịch");
		lblTieude.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieude.setForeground(new Color(220, 220, 220));
		lblTieude.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTieude.setBackground(new Color(34, 139, 34));
		lblTieude.setBounds(103, 51, 470, 40);
		contentPane.add(lblTieude);
		lblTieude.setVisible(false);
		
		lbl1 = new JLabel("Rút tiền");
		lbl1.setForeground(new Color(220, 220, 220));
		lbl1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl1.setBackground(new Color(34, 139, 34));
		lbl1.setBounds(103, 97, 182, 40);
		contentPane.add(lbl1);
		lbl1.setVisible(false);
		
		lbl2 = new JLabel("Xem số dư");
		lbl2.setForeground(new Color(220, 220, 220));
		lbl2.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl2.setBackground(new Color(34, 139, 34));
		lbl2.setBounds(101, 166, 184, 40);
		contentPane.add(lbl2);
		lbl2.setVisible(false);
		
		lbl3 = new JLabel("Cập nhật SDT");
		lbl3.setForeground(new Color(220, 220, 220));
		lbl3.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl3.setBackground(new Color(34, 139, 34));
		lbl3.setBounds(105, 245, 180, 40);
		contentPane.add(lbl3);
		lbl3.setVisible(false);
		
		lbl4 = new JLabel("Đổi PIN");
		lbl4.setForeground(new Color(220, 220, 220));
		lbl4.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl4.setBackground(new Color(34, 139, 34));
		lbl4.setBounds(103, 317, 172, 40);
		contentPane.add(lbl4);
		lbl4.setVisible(false);
		
		lbl5 = new JLabel("Chuyển khoản");
		lbl5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl5.setForeground(new Color(220, 220, 220));
		lbl5.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl5.setBackground(new Color(34, 139, 34));
		lbl5.setBounds(370, 91, 206, 40);
		contentPane.add(lbl5);
		lbl5.setVisible(false);
		
		lbl6 = new JLabel("In sao kê");
		lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl6.setForeground(new Color(220, 220, 220));
		lbl6.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl6.setBackground(new Color(34, 139, 34));
		lbl6.setBounds(360, 166, 213, 40);
		contentPane.add(lbl6);
		lbl6.setVisible(false);
		
		lbl7 = new JLabel("Nạp tiền");
		lbl7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl7.setForeground(new Color(220, 220, 220));
		lbl7.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl7.setBackground(new Color(34, 139, 34));
		lbl7.setBounds(473, 250, 100, 40);
		contentPane.add(lbl7);
		lbl7.setVisible(false);
		
		lbl8 = new JLabel("Giao dịch khác");
		lbl8.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl8.setForeground(new Color(255, 0, 0));
		lbl8.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbl8.setBackground(new Color(34, 139, 34));
		lbl8.setBounds(261, 317, 315, 40);
		contentPane.add(lbl8);
		lbl8.setVisible(false);
		
		lblNhapPin = new JLabel("M\u1EDDi nh\u1EADp m\u00E3 PIN");
		lblNhapPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapPin.setBounds(139, 218, 392, 61);
		contentPane.add(lblNhapPin);
		lblNhapPin.setForeground(new Color(204, 204, 204));
		lblNhapPin.setFont(new Font("SansSerif", Font.BOLD, 40));
		lblNhapPin.setBackground(new Color(34, 139, 34));
		lblNhapPin.setBorder(null);
		lblNhapPin.setVisible(false);
		
		lblSo = new JLabel("");
		lblSo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSo.setBounds(211, 166, 235, 40);
		lblSo.setForeground(new Color(192, 192, 192));
		lblSo.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblSo.setBackground(new Color(34, 139, 34));
		contentPane.add(lblSo);
		lblSo.setVisible(false);
		
		pwdPin = new JPasswordField();
		pwdPin.setBounds(287, 291, 92, 28);
		contentPane.add(pwdPin);
		pwdPin.setBorder(null);
		pwdPin.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		pwdPin.setForeground(new Color(255, 255, 255));
		pwdPin.setBackground(new Color(0, 0, 0));
		pwdPin.setEditable(false);
		pwdPin.setVisible(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(94, 49, 495, 250);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		table = null;
		
		lblManhinh = new JLabel("");
		lblManhinh.setForeground(new Color(0, 0, 0));
		lblManhinh.setIcon(new ImageIcon("C:\\Users\\reycs\\eclipse-workspace\\ATM_official\\IMG\\ManHinh.png"));
		lblManhinh.setBounds(94, 49, 497, 314);
		contentPane.add(lblManhinh);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 54, 23);
		contentPane.add(menuBar);
		
		JMenu mnHelps = new JMenu("Helps");
		menuBar.add(mnHelps);
		
		btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(this);
		mnHelps.add(btnAdmin);
		setResizable(false);
		
	}
	
	public void DangNhap() {
		lblNhapPin.setText("Mời nhập mã PIN");
		tfMathe.setEditable(true);
		tfMathe.setText("");
		pwdPin.setText("");
		lblManhinh.setVisible(true);
		lblTieude.setVisible(false);
		lbl1.setVisible(false);
		
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		lbl6.setVisible(false);
		lbl7.setVisible(false);
		lbl8.setVisible(false);
		btnDuaTheVao.setVisible(true);
		TTHienTai = "Đăng nhập";
		
	}

	public void MenuChinh() {
		scrollPane.setVisible(false);
		lblManhinh.setVisible(true);
		lblNhapPin.setVisible(false);
		pwdPin.setVisible(false);
		lblTieude.setVisible(true);
		lblSo.setText("");
		lblSo.setVisible(false);
		lblTieude.setText("Vui lòng chọn giao dịch");
		lbl1.setVisible(true);
		lbl1.setText("Rút tiền");
		// button1.setText("Rút tiền");
		lbl2.setVisible(true);
		lbl2.setText("Xem số dư");
		lbl3.setVisible(true);
		lbl3.setText("Cập nhật SDT");
		lbl4.setVisible(true);
		lbl4.setText("Đổi PIN");		
		lbl5.setVisible(true);
		lbl5.setText("Chuyển khoản");
		lbl6.setVisible(true);
		lbl6.setText("In sao kê");
		lbl7.setVisible(true);
		lbl7.setText("Nạp tiền");
		lbl8.setVisible(true);
		lbl8.setText("Giao dịch khác");
		TTHienTai = "menu";
		
	}

	public void RutTien() {
		lblTieude.setText("Vui lòng chọn số tiền");
		//lbl1.setText("10,000,000");
		lbl2.setText("5,000,000");
		lbl3.setText("2,000,000");
		lbl4.setText("1,000,000");
		lbl5.setText("500,000");
		lbl6.setText("200,000");
		lbl7.setText("100,000");
		lbl8.setText("Nhập số khác");
		TTHienTai = "Rút tiền";
	}

	public void DoiPin() {
		lblNhapPin.setVisible(true);
		pwdPin.setVisible(true);
		lblNhapPin.setText("Nhập mã pin cũ");
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		lbl6.setVisible(false);
		lbl7.setVisible(false);
		lbl8.setText("Hủy");
		pwdPin.setText("");
		TTHienTai = "Đổi PIN";
		lblTieude.setVisible(false);
	}
	
	public void ChuyenTien() {
		lblTieude.setText("Nhập số thẻ nhận tiền");
		lblSo.setVisible(true);
		lblSo.setText("");
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		lbl6.setVisible(false);
		lbl7.setVisible(false);
		lbl8.setText("Hủy");
		TTHienTai = "Chuyển tiền";
	}
	
	public void BienDongSD() {
		scrollPane.setVisible(true);
		//lblManhinh.setVisible(false);
		lbl8.setText("Hủy");
		lblTieude.setVisible(false);
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		lbl6.setVisible(false);
		lbl7.setVisible(false);
		
		Vector vtitle = new Vector();
		vtitle.add("Số dư trước");
		vtitle.add("Số dư sau");
		vtitle.add("Thời gian GD");
		Vector data = Connect.BDSoDu(tfMathe.getText());
		table = new JTable(data, vtitle);	
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		TTHienTai = "Biến động số dư";
	}
	
	public void CapNhatSDT() {
		lblSo.setVisible(true);
		lblTieude.setVisible(true);
		lblTieude.setText("Mời nhập SDT");
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		lbl6.setVisible(false);
		lbl7.setVisible(false);
		lbl8.setText("Hủy");
		TTHienTai = "Đổi SDT";
	}
	
	public void CNKhac() {
		lblSo.setVisible(false);
		lblNhapPin.setVisible(false);
		pwdPin.setVisible(false);
		lblTieude.setVisible(true);
		lblTieude.setText("Vui lòng chọn giao dịch");
		lbl1.setVisible(true);
		lbl1.setText("Hủy thẻ hiện tại");
		lbl2.setVisible(true);
		lbl2.setText("Thoát");
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		lbl6.setVisible(false);
		lbl7.setVisible(false);
		lbl8.setVisible(true);
		lbl8.setText("Hủy");
		TTHienTai = "Chức năng khác";
	}
	
	public void Thoat() {
		lblSo.setVisible(false);
		lblNhapPin.setVisible(false);
		pwdPin.setVisible(false);
		lblTieude.setVisible(true);
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		lbl6.setVisible(false);
		lblTieude.setText("Bạn có muốn thực hiện giao dịch khác không?");
		lbl7.setVisible(true);
		lbl8.setVisible(true);
		lbl7.setText("Có");
		lbl8.setText("Không");
		TTHienTai = "Thoát";
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(lblSo.isVisible()) {
			if(arg0.getSource()==btnN0)  lblSo.setText(lblSo.getText()+"0");
			if(arg0.getSource()==btnN1)  lblSo.setText(lblSo.getText()+"1");
			if(arg0.getSource()==btnN2)  lblSo.setText(lblSo.getText()+"2");
			if(arg0.getSource()==btnN3)  lblSo.setText(lblSo.getText()+"3");
			if(arg0.getSource()==btnN4)  lblSo.setText(lblSo.getText()+"4");
			if(arg0.getSource()==btnN5)  lblSo.setText(lblSo.getText()+"5");
			if(arg0.getSource()==btnN6)  lblSo.setText(lblSo.getText()+"6");
			if(arg0.getSource()==btnN7)  lblSo.setText(lblSo.getText()+"7");
			if(arg0.getSource()==btnN8)  lblSo.setText(lblSo.getText()+"8");
			if(arg0.getSource()==btnN9)  lblSo.setText(lblSo.getText()+"9");
			if(arg0.getSource()==btnClear) lblSo.setText(lblSo.getText().substring(0, lblSo.getText().length()-1));
			if(arg0.getSource()==btnCancle) lblSo.setText("");
			
		}
		
		//nhập số pin
		if(pwdPin.isVisible()) {
			if(arg0.getSource()==btnN0) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"0");
			if(arg0.getSource()==btnN1) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"1");
			if(arg0.getSource()==btnN2) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"2");
			if(arg0.getSource()==btnN3) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"3");
			if(arg0.getSource()==btnN4) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"4");
			if(arg0.getSource()==btnN5) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"5");
			if(arg0.getSource()==btnN6) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"6");
			if(arg0.getSource()==btnN7) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"7");
			if(arg0.getSource()==btnN8) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"8");
			if(arg0.getSource()==btnN9) if(pwdPin.getText().length()<6) pwdPin.setText(pwdPin.getText()+"9");
			if(arg0.getSource()==btnClear) pwdPin.setText(pwdPin.getText().substring(0, pwdPin.getText().length()-1));
			if(arg0.getSource()==btnCancle) pwdPin.setText("");
		}
		
		//menu chính
		if(TTHienTai.equals("menu")) {
			if(arg0.getSource()==button1) RutTien();
			
			if(arg0.getSource()==button2) {
				DecimalFormat df = new DecimalFormat("#");
				String sd = new BigDecimal(String.valueOf(Connect.CheckSoDu(tfMathe.getText()))).stripTrailingZeros().toPlainString();
				JOptionPane.showMessageDialog(null, "Chủ thẻ: "+Connect.GetTen(tfMathe.getText())+
					"\nSố dư hiện tại: "+sd, "Thông tin", 1);
			}
			
			if(arg0.getSource()==button3) {
				CapNhatSDT();
				return;
			}
			if(arg0.getSource()==button4) {
				DoiPin();
				return;
			}
			if(arg0.getSource()==button5) {
				ChuyenTien();
				return;
			}
			if(arg0.getSource()==button6) {
				BienDongSD();
			}
			if(arg0.getSource()==button7) {
				lblSo.setVisible(true);
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
				lbl5.setVisible(false);
				lbl6.setVisible(false);
				lbl7.setVisible(false);
				lbl8.setText("Hủy");
				lblTieude.setText("Nhập số tiền muốn nạp");
				TTHienTai = "Nạp tiền";				
				return;
			}
			if(arg0.getSource()==button8) {
				CNKhac();
				return;
			}
		}
		
		//rút tiền
		else if(TTHienTai.equals("Rút tiền")) {
			if(arg0.getSource()==button1) 
				if(Connect.RutTien("10000000", tfMathe.getText())) {
					JOptionPane.showMessageDialog(null, "Bạn đã rút thành công "+lbl1.getText());
					Thoat();
					return;
				}
			if(arg0.getSource()==button2)
				if(Connect.RutTien("5000000", tfMathe.getText())) {
					JOptionPane.showMessageDialog(null, "Bạn đã rút thành công "+lbl2.getText());
					Thoat();
					return;
				}
			if(arg0.getSource()==button3)
				if(Connect.RutTien("2000000", tfMathe.getText())) {
					JOptionPane.showMessageDialog(null, "Bạn đã rút thành công "+lbl3.getText());
					Thoat();
					return;
				}
			if(arg0.getSource()==button4) 
				if(Connect.RutTien("1000000", tfMathe.getText())) {
					JOptionPane.showMessageDialog(null, "Bạn đã rút thành công "+lbl4.getText());
					Thoat();
					return;
				}
			if(arg0.getSource()==button5) 
				if(Connect.RutTien("500000", tfMathe.getText())) {
					JOptionPane.showMessageDialog(null, "Bạn đã rút thành công "+lbl5.getText());
					Thoat();
					return;
				}
			if(arg0.getSource()==button6) 
				if(Connect.RutTien("200000", tfMathe.getText())) {
					JOptionPane.showMessageDialog(null, "Bạn đã rút thành công "+lbl6.getText());
					Thoat();
					return;
				}
			if(arg0.getSource()==button7) 
				if(Connect.RutTien("100000", tfMathe.getText())) {
					JOptionPane.showMessageDialog(null, "Bạn đã rút thành công "+lbl7.getText());
					Thoat();
					return;
				}
			if(arg0.getSource()==button8) {
				lblSo.setVisible(true);
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
				lbl5.setVisible(false);
				lbl6.setVisible(false);
				lbl7.setVisible(false);
				lbl8.setText("Hủy");
				TTHienTai = "Rút số khác";				
				return;
			}
		}
		
		//rút số khác
		if( TTHienTai.equals("Rút số khác")) {
			if(arg0.getSource()==btnEnter) {
				if(Connect.RutTien(lblSo.getText(), tfMathe.getText())) {
					JOptionPane.showMessageDialog(null, "Bạn đã rút thành công "+lblSo.getText());
					Thoat();
					lblSo.setVisible(false);
				return;
				}
			}
			if(arg0.getSource()==button8) MenuChinh();
		}
		//chức năng đăng nhập
		if(TTHienTai.equals("Đăng nhập")) {
			if(arg0.getSource()==btnEnter) 
				if (Connect.CheckSoThe(tfMathe.getText())) {
					if(Connect.CheckPIN(pwdPin.getText(), tfMathe.getText())) MenuChinh();
				}
			if(arg0.getSource()==btnDuaTheVao)
				if(Connect.CheckSoThe(tfMathe.getText())) {
					lbl8.setVisible(true);
					lbl8.setText("Hủy");
					pwdPin.setVisible(true);
					lblNhapPin.setVisible(true);
					btnDuaTheVao.setVisible(false);
					tfMathe.setEditable(false);
				}
				else JOptionPane.showMessageDialog(null, "Không tồn tại số thẻ "+tfMathe.getText());
			if(arg0.getSource()==button8) {
				Thoat();
			}
		}
		
		//Chức năng đổi PIN
		if(TTHienTai.equals("Đổi PIN")) {
			if(arg0.getSource()==btnEnter) {
				if(Connect.CheckPIN(pwdPin.getText(), tfMathe.getText())) {
					lblNhapPin.setText("Nhập mã pin mới");
					pwdPin.setText("");
					lbl7.setVisible(false);
					TTHienTai = "Nhâp PIN mới";
					return;
				}
				else JOptionPane.showMessageDialog(null, "Sai mã PIN");
			}
			
			if(arg0.getSource()==button8) MenuChinh();
		}
		if(TTHienTai.equals("Nhâp PIN mới")) {
			if (arg0.getSource()==btnEnter) {
				PIN = pwdPin.getText();
				lblNhapPin.setText("Nhập lại mã pin");
				pwdPin.setText("");
				TTHienTai = "Nhập lại PIN";
				return;
			}
			if(arg0.getSource()==button8) MenuChinh();
		}
		if(TTHienTai.equals("Nhập lại PIN")) {
			if (arg0.getSource()==btnEnter) {
				if(pwdPin.getText().equals(PIN)) {
					if(Connect.DoiPIN(pwdPin.getText(), tfMathe.getText())) {
						JOptionPane.showMessageDialog(null, "Đổi PIN thành công");
						Thoat();
						return;
					}
				}else JOptionPane.showMessageDialog(null, "Không khớp mã PIN");
			}
			if(arg0.getSource()==button8) MenuChinh();
		}
		
		//CHức năng chuyển tiền
		if(TTHienTai.equals("Chuyển tiền")) {
			if (arg0.getSource()==btnEnter) {
				if(Connect.CheckSoThe(lblSo.getText())) {
					TK = lblSo.getText();
					lblTieude.setText("Nhập số tiền cần chuyển");
					lblSo.setText("");
					TTHienTai = "Nhập số tiền cần chuyển";
					return;
				}else JOptionPane.showInternalMessageDialog(null, "Không tồn tại số thẻ: "+lblSo.getText());
			}
			if(arg0.getSource()==button8) MenuChinh();
		}
		
		//Chuyển tiền
		if(TTHienTai == "Nhập số tiền cần chuyển") {
			if (arg0.getSource()==btnEnter) {
				if(Connect.ChuyenTien(lblSo.getText(), tfMathe.getText(), TK)) {
					JOptionPane.showInternalMessageDialog(null, "Thành công!\nBạn đã chuyển thành công: "+lblSo.getText()+"\nTới số thẻ: "+TK);
					Thoat();
				}
			}
			if(arg0.getSource()==button8) MenuChinh();
		}
		
		//Nạp tiền
		if(TTHienTai.equals("Nạp tiền")) {
			if(arg0.getSource()==btnEnter) {
				if(Connect.NapTien(lblSo.getText(), tfMathe.getText())) JOptionPane.showMessageDialog(null, "Bạn đã nạp thành công: "+lblSo.getText(), "Thông báo", 1);
				else JOptionPane.showMessageDialog(null, "Nạp tiền không thành công: ", "Thông báo", 0);
				Thoat();
				return;
			}
			if(arg0.getSource()==button8) MenuChinh();
		}
		if(TTHienTai.equals("Biến động số dư"))  {
			if(arg0.getSource()==button8) MenuChinh();
		}
		if(TTHienTai.equals("Thoát")) {
			if(arg0.getSource()==button7) MenuChinh();
			if(arg0.getSource()==button8) DangNhap();
		}
		
		//đổi sdt
		if(TTHienTai.equals("Đổi SDT")) {
			if(arg0.getSource()==btnEnter)
				if (Connect.DoiSDT(tfMathe.getText(), lblSo.getText())) {
					JOptionPane.showMessageDialog(null, "Cập nhật SDT thành công");
					Thoat();
				}
				else JOptionPane.showMessageDialog(null, "Cập nhật SDT không thành công");
			if(arg0.getSource()==button8) MenuChinh();
		}
		//chức năng khác
		if(TTHienTai.equals("Chức năng khác")) {
			if(arg0.getSource()==button1) {
				lblTieude.setText("Bạn có chắc muốn hủy thẻ?");
				lbl1.setVisible(false);
				lbl7.setVisible(true);
				lbl8.setVisible(true);
				lbl7.setText("Có");
				lbl8.setText("Không");
			}
			if(arg0.getSource()==button8) MenuChinh(); 
			if(arg0.getSource()==button2) {
				Thoat();
			}
		}
		
		//gọi admin
		if(arg0.getActionCommand().equals("Admin")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login window = new Login();
					}
					 catch (Exception e) {
					}
				}
			});
		}
	}
}


