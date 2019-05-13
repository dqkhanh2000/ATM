package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Data.Connect;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MoTK extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfSDT;
	private JTextField tfNgaySinh;
	private JTextField tfSoTK;
	private JTextField tfPIN;

	public MoTK() {
		setTitle("M\u1EDF T\u00E0i Kho\u1EA3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("H\u1ECD T\u00EAn");
		lblName.setBounds(20, 11, 86, 14);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(116, 4, 194, 28);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfSDT = new JTextField();
		tfSDT.setBounds(116, 43, 194, 28);
		contentPane.add(tfSDT);
		tfSDT.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setBounds(10, 49, 96, 16);
		contentPane.add(lblSinThoi);
		
		JLabel lblNgaySinh = new JLabel("Ng\u00E0y sinh");
		lblNgaySinh.setBounds(10, 88, 96, 16);
		contentPane.add(lblNgaySinh);
		
		tfNgaySinh = new JTextField();
		tfNgaySinh.setColumns(10);
		tfNgaySinh.setBounds(116, 82, 194, 28);
		contentPane.add(tfNgaySinh);
		
		JLabel lblSTiKhon = new JLabel("Số thẻ");
		lblSTiKhon.setBounds(10, 124, 96, 16);
		contentPane.add(lblSTiKhon);
		
		tfSoTK = new JTextField();
		tfSoTK.setColumns(10);
		tfSoTK.setBounds(116, 118, 194, 28);
		contentPane.add(tfSoTK);
		
		JLabel lblMPin = new JLabel("M\u00E3 PIN");
		lblMPin.setBounds(10, 163, 96, 16);
		contentPane.add(lblMPin);
		
		tfPIN = new JTextField();
		tfPIN.setColumns(10);
		tfPIN.setBounds(116, 157, 194, 28);
		contentPane.add(tfPIN);
		
		JButton btnXcNhn = new JButton("X\u00E1c nh\u1EADn");
		btnXcNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Ten = tfName.getText();
				String NgaySinh = tfNgaySinh.getText();
				String SDT = tfSDT.getText();
				String TK = tfSoTK.getText();
				String Pin = tfPIN.getText();
				Connect.TaoTK(Ten, NgaySinh, SDT, TK, Pin);
			}
		});
		btnXcNhn.setBounds(116, 196, 90, 28);
		contentPane.add(btnXcNhn);
		
	}

}
