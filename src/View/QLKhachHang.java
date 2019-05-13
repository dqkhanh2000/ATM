package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class QLKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField tfTimKiem;
	private String ID, Ten, SDT, NgaySinh;
	private JTable table;
	private JTextField tfTenKH;
	private JTextField tfIDKH;
	private JTextField tfNgaySinh;
	private JTextField tfSDT;
	private JTextField tfSoDuTong;
	private JTextField tfSoDuThe;
	private JTextField tfNgayTao;
	private DefaultTableModel model;

	public static void main(String[] args) {
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

	public QLKhachHang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 885, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearch = new JLabel("T\u00ECm ki\u1EBFm theo");
		lblSearch.setBounds(20, 18, 90, 14);
		contentPane.add(lblSearch);
		
		JComboBox cbbTimKiem = new JComboBox();
		cbbTimKiem.setBounds(110, 12, 106, 26);
		cbbTimKiem.setModel(new DefaultComboBoxModel(new String[] {"IDKH", "T\u00EAn", "Ng\u00E0y Sinh", "SDT"}));
		contentPane.add(cbbTimKiem);
		
		tfTimKiem = new JTextField();
		tfTimKiem.setBounds(228, 11, 180, 28);
		contentPane.add(tfTimKiem);
		tfTimKiem.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 44, 575, 422);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		model = new DefaultTableModel();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.setBounds(517, 11, 97, 28);
		contentPane.add(btnShowAll);
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vector vtitle = new Vector();
				vtitle.add("IDKH");
				vtitle.add("Họ tên");
				vtitle.add("Ngày sinh");
				vtitle.add("SDT");
				vtitle.add("Số thẻ đã có");
				vtitle.add("Số dư");
				Vector data = Connect.ShowAll();
				model.setColumnIdentifiers(vtitle);
				model.setDataVector(data, vtitle);
			}
		});
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(425, 11, 81, 28);
		contentPane.add(btnSearch);	
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tt = cbbTimKiem.getSelectedIndex();
				switch (tt) {
				case 0:	
						ID = tfTimKiem.getText();
						Ten = "NULL";
						SDT = "NULL";
						NgaySinh = "NULL";
						break;
				case 1:	
					ID = "NULL";
					Ten = "N'"+tfTimKiem.getText()+"'";
					SDT = "NULL";
					NgaySinh = "NULL";
					break;
				case 2:	
					ID = "NULL";
					Ten = "NULL";
					SDT = "NULL";
					NgaySinh = "'"+tfTimKiem.getText()+"'";
					break;
				case 3:	
					ID = "NULL";
					Ten = "NULL";
					SDT = "'"+tfTimKiem.getText()+"'";
					NgaySinh = "NULL";
					break;
				}
				Vector vtitle = new Vector();
				vtitle.add("IDKH");
				vtitle.add("Họ tên");
				vtitle.add("Ngày sinh");
				vtitle.add("SDT");
				vtitle.add("Số thẻ đã có");
				vtitle.add("Số dư");
				Vector data = Connect.Search(ID, Ten, SDT, NgaySinh);
				model.setDataVector(data, vtitle);
			}
		});
			
		
		JButton btnThem = new JButton("Thêm KH");
		btnThem.setBounds(626, 11, 90, 28);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MoTK frame = new MoTK();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		contentPane.add(btnThem);
		
		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setBounds(593, 100, 57, 16);
		contentPane.add(lblHTn);
		
		tfTenKH = new JTextField();
		tfTenKH.setBounds(683, 94, 160, 28);
		contentPane.add(tfTenKH);
		tfTenKH.setColumns(10);
		
		JLabel lblIdkh = new JLabel("IDKH");
		lblIdkh.setBounds(593, 57, 57, 16);
		contentPane.add(lblIdkh);
		
		tfIDKH = new JTextField();
		tfIDKH.setColumns(10);
		tfIDKH.setBounds(683, 54, 160, 28);
		contentPane.add(tfIDKH);
		tfIDKH.setEditable(false);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setBounds(593, 140, 57, 16);
		contentPane.add(lblNgySinh);
		
		tfNgaySinh = new JTextField();
		tfNgaySinh.setColumns(10);
		tfNgaySinh.setBounds(683, 134, 160, 28);
		contentPane.add(tfNgaySinh);
		
		JLabel lblSt = new JLabel("SĐT");
		lblSt.setBounds(593, 180, 57, 16);
		contentPane.add(lblSt);
		
		tfSDT = new JTextField();
		tfSDT.setColumns(10);
		tfSDT.setBounds(683, 174, 160, 28);
		contentPane.add(tfSDT);
		
		JLabel lblSD = new JLabel("Thẻ");
		lblSD.setBounds(593, 261, 81, 16);
		contentPane.add(lblSD);
		
		JLabel lblSD_1 = new JLabel("Tổng số dư");
		lblSD_1.setBounds(593, 220, 81, 16);
		contentPane.add(lblSD_1);
		
		tfSoDuTong = new JTextField();
		tfSoDuTong.setColumns(10);
		tfSoDuTong.setBounds(683, 214, 160, 28);
		contentPane.add(tfSoDuTong);
		tfSoDuTong.setEditable(false);
		
		JComboBox cbbThe = new JComboBox();
		cbbThe.setBounds(683, 256, 160, 26);
		contentPane.add(cbbThe);
		
		JButton btnBtnsua = new JButton("Sửa");
		btnBtnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfIDKH.getText().equals("")) JOptionPane.showInternalMessageDialog(null, "Chưa có thông tin");
				else {
					if(Connect.Sua(tfIDKH.getText(), tfTenKH.getText(), tfNgaySinh.getText(), tfSDT.getText())) JOptionPane.showInternalMessageDialog(null, "Cập nhật thông tin thành công");
					Refresh();
				}
			}
		});
		btnBtnsua.setBounds(626, 378, 90, 28);
		contentPane.add(btnBtnsua);
		
		JLabel lblSD_2 = new JLabel("Số dư");
		lblSD_2.setBounds(593, 299, 55, 16);
		contentPane.add(lblSD_2);
		
		tfSoDuThe = new JTextField();
		tfSoDuThe.setBounds(683, 294, 160, 28);
		contentPane.add(tfSoDuThe);
		tfSoDuThe.setColumns(10);
		tfSoDuThe.setEditable(false);
		
		JLabel lblNgyTo = new JLabel("Ngày tạo");
		lblNgyTo.setBounds(593, 335, 55, 16);
		contentPane.add(lblNgyTo);
		
		tfNgayTao = new JTextField();
		tfNgayTao.setColumns(10);
		tfNgayTao.setBounds(683, 330, 160, 28);
		contentPane.add(tfNgayTao);
		tfNgayTao.setEditable(false);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfIDKH.getText().equals("")) JOptionPane.showInternalMessageDialog(null, "Không có gì để xóa");
				else if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa")==JOptionPane.YES_OPTION) {
					if (Connect.XoaKH(tfIDKH.getText())) {
						JOptionPane.showInternalMessageDialog(null, "Xóa thành công");
						Refresh();
					}
				}
			}
		});
		btnXoa.setBounds(753, 378, 90, 28);
		contentPane.add(btnXoa);
		
		JButton btnThemthe = new JButton("Thêm thẻ");
		btnThemthe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfIDKH.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng");
				}
				else {
					String Sothe = JOptionPane.showInputDialog(null, "Nhập số thẻ");
					String PIN = JOptionPane.showInputDialog(null, "Nhập PIN");
					String PINxn = JOptionPane.showInputDialog(null, "Nhập lại PIN");
					if(PIN.equals(PINxn)) {
						if(Connect.ThemThe(tfIDKH.getText(), Sothe, PIN)) {
							JOptionPane.showMessageDialog(null, "Tạo thẻ thành công");
							Refresh();
						}
						else JOptionPane.showMessageDialog(null, "Tạo thẻ không thành công");
					}
					else JOptionPane.showMessageDialog(null, "Mã PIN không khớp\nTạo thẻ không thành công");
				}
			}
		});
		btnThemthe.setBounds(683, 418, 90, 28);
		contentPane.add(btnThemthe);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cbbThe.removeAllItems();
				int i = table.getSelectedRow();
				tfIDKH.setText(String.valueOf(table.getValueAt(i, 0)));
				tfTenKH.setText(String.valueOf(table.getValueAt(i, 1)));
				tfNgaySinh.setText(String.valueOf(table.getValueAt(i, 2)));
				tfSDT.setText(String.valueOf(table.getValueAt(i, 3)));
				tfSoDuTong.setText(String.valueOf(table.getValueAt(i, 5)));
				//lấy tt toàn bộ thẻ của kh
				Vector data = Connect.LayTTThe(String.valueOf(table.getValueAt(i, 0)));
				Enumeration vEnum = data.elements();
				String[][] datathe = new String[data.size()][4];
				//duyệt từng thẻ
				int j = 0;
				while(vEnum.hasMoreElements()) {
					Vector tt = null;
					tt = (Vector) vEnum.nextElement();
					Enumeration Enum = tt.elements();
					int j1 = 0;
					//đổ thông tin từng thẻ ra datathe[][]
					while(Enum.hasMoreElements()) {
						datathe[j][j1] = (String) Enum.nextElement();
						j1++;
					}
					j++;
				}
				//thêm số thẻ váo cbbThe
				for (int k = 0; k < j; k++) {
					cbbThe.addItem(datathe[k][1]);
				}
				try {
					tfSoDuThe.setText(datathe[cbbThe.getSelectedIndex()][3]);
					tfNgayTao.setText(datathe[cbbThe.getSelectedIndex()][2]);	
				} catch (Exception e) {
					
				}
				cbbThe.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						try {
							tfSoDuThe.setText(datathe[cbbThe.getSelectedIndex()][3]);
							tfNgayTao.setText(datathe[cbbThe.getSelectedIndex()][2]);	
						} catch (Exception e) {
							
						}			
					}
				});
			}
		});
	}
	
	public void Refresh(){
		Vector vtitle = new Vector();
		vtitle.add("IDKH");
		vtitle.add("Họ tên");
		vtitle.add("Ngày sinh");
		vtitle.add("SDT");
		vtitle.add("Số thẻ đã có");
		vtitle.add("Số dư");
		Vector data = Connect.ShowAll();
		model.setDataVector(data, vtitle);
	}
}
