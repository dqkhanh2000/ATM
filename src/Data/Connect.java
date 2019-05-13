package Data;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Connect {
	private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=ATM;integratedSecurity=true";
	private static Connection conn;
	private static LocalDateTime now ;



	public static boolean CheckPIN(String PIN, String MaThe) {
		boolean rt = false;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM TaiKhoan WHERE SoTK = "+MaThe);
			rs.next();
			if (rs.getString("PIN").equals(PIN)) {
				if(rs.getInt("SaiPin")>5) JOptionPane.showMessageDialog(null, "Tài khoản bị khóa do nhập sai PIN quá nhiều lần, liên hệ ngân hàng để mở!");
				else {
					rt = true;
					st.executeUpdate("UPDATE TaiKhoan SET SaiPin = 0 WHERE SoTK = "+MaThe);
				}
			}
			else {
				if(rs.getInt("SaiPin")>5) JOptionPane.showMessageDialog(null, "Nhập sai PIN quá 5 lần, tài khoản bị khóa");
				else JOptionPane.showMessageDialog(null, "Nhập sai mã PIN");
				st.executeUpdate("UPDATE TaiKhoan SET SaiPin = SaiPin + 1 WHERE SoTK = "+MaThe);
				rt = false;
			}		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi check pin: "+e.toString());
		}
		return rt;
	}

	public static boolean CheckSoThe(String SoThe) {
		boolean rt = false;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM TaiKhoan WHERE SoTK = "+SoThe);
			if(rs.next()==false) rt = false;
			else rt = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi khi đọc thẻ: "+e.toString());
		}
		return rt;
	}

	public static boolean RutTien(String SoTien, String SoThe) {
		boolean rt = false;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			if (Float.parseFloat(SoTien)-CheckSoDu(SoThe)<=0) {
				GiaoDich(SoTien, SoThe, false);
				int t = st.executeUpdate("UPDATE TaiKhoan SET SoDu = SoDu - "+SoTien+" WHERE SoTK = "+SoThe);
				if (t!=0) rt = true;
			} else JOptionPane.showMessageDialog(null, "Số dư không đủ", "Thông báo", 0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi rút tiền: "+e.toString(), "Thông báo", 0);
			rt = false;
		}
		return rt;
	}

	public static float CheckSoDu(String SoThe){
		float rt = 0;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM TaiKhoan WHERE SoTK = "+SoThe);
			if(rs.next()) rt = rs.getFloat("SoDu");
				
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi check số dư: "+e.toString(), "Thông báo", 0);
		}
		return rt;
	}

	public static String GetTen(String SoThe) {
		String rt = "";
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM TaiKhoan INNER JOIN KhachHang ON TaiKhoan.IDKH = KhachHang.IDKH WHERE SoTK = "+SoThe);
			if (rs.next()) rt = rs.getString("TenKH");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi Getten: "+e.toString(), "Thông báo", 0);
		}
		return rt;
	}
	
	public static boolean DoiPIN(String PIN, String MaThe) {
		boolean rt = false;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			int t =st.executeUpdate("UPDATE TaiKhoan SET PIN = "+PIN+" WHERE SoTK = "+MaThe);
			if (t!=0) rt = true;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi đổi pin: "+e.toString());
		}
		return rt;
	}

	public static boolean ChuyenTien(String SoTien, String SoThechuyen, String SoTheNhan) {
		boolean rt = false;
		if (RutTien(SoTien, SoThechuyen)) 
			if (NapTien(SoTien, SoTheNhan)) rt = true;
		return rt;
	}
	
	public static boolean NapTien(String SoTien, String SoThe) {
		boolean rt = false;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			GiaoDich(SoTien, SoThe, true);
			int t = st.executeUpdate("UPDATE TaiKhoan SET SoDu = SoDu + "+SoTien+" WHERE SoTK = "+SoThe);
			if (t!=0) rt = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi nạp tiền: "+e.toString(), "Thông báo", 0);
			rt = false;
		}
		return rt;
	}

	public static void GiaoDich(String SoTien, String SoThe, boolean KieuBD) {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(d.getTime());
		try {
			float sd = CheckSoDu(SoThe);
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			if (KieuBD)	st.executeUpdate("INSERT INTO GiaoDich VALUES ("+SoThe+", "+sd+", "+(sd+Float.parseFloat(SoTien))+", '"+date+"') ");
			else st.executeUpdate("INSERT INTO GiaoDich VALUES ("+SoThe+", "+sd+", "+(sd-Float.parseFloat(SoTien))+", '"+date+"') ");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật giao dịch: "+e.toString(), "Thông báo", 0);
			e.printStackTrace();
		}	
	}

	public static Vector BDSoDu(String SoThe) {
		Vector Data = new Vector(10,3);
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * From GiaoDich Where SoTK = "+SoThe+" ORDER BY NgayGD DESC");
			while (rs.next()) {
				Vector row = new Vector(3);
				for (int i = 2; i<=4;i++)
					row.add(rs.getString(i));
				Data.add(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi biến động số dư: "+e.toString(), "Thông báo", 0);
		}
		return Data;
	}

	public static boolean DoiSDT(String Sothe, String SDT) {
		boolean rt = false;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			int t = st.executeUpdate("UPDATE dbo.KhachHang SET SDT = '"+SDT+"' WHERE IDKH = (SELECT IDKH FROM dbo.TaiKhoan WHERE SoTK = "+Sothe+")");
			if (t!=0) rt = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi nạp tiền: "+e.toString(), "Thông báo", 0);
			rt = false;
		}
		return rt;
	}
	
	public static Vector Search(String ID, String Ten, String SDT, String NgaySinh) {
		Vector Data = new Vector(10,3);
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("EXEC sp_Search "+ID+", "+Ten+", "+SDT+", "+NgaySinh);
			while (rs.next()) {
				Vector row = new Vector(6);
				for (int i = 1; i<=6;i++)
					row.add(rs.getString(i));
				Data.add(row);
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi tìm kiếm: "+e.toString());
		}
		return Data;
	}

	public static boolean TaoTK(String Ten, String NgaySinh, String SDT, String TK, String PIN) {
		boolean rt = false;
		if(CheckSoThe(TK))JOptionPane.showMessageDialog(null, "Thẻ đã tồn tại");
		else  {
			try {
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ATM;integratedSecurity=true");
				Statement st = conn.createStatement();
				int t = st.executeUpdate("EXEC spTaoTaiKoan N'"+Ten+"', '"+NgaySinh+"', '"+SDT+"', "+TK+", "+PIN);
				if(t!=0) {
					rt =  true;
					JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công");
				}
				else JOptionPane.showMessageDialog(null, "Tạo tài khoản không thành công");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Lỗi Tạo tài khoản: "+e.toString());
			}
		}
		return rt;
	}

	public static Vector ShowAll() {
		Vector Data = new Vector(10,3);
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("EXEC sp_ShowAll");
			while (rs.next()) {
				Vector row = new Vector(6);
				for (int i = 1; i<=6;i++)
					row.add(rs.getString(i));
				Data.add(row);
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi Lấy tt: "+e.toString());
		}
		return Data;
	}
	
	public static Vector LayTTThe(String IDKH) {
		Vector Data = new Vector();
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select IDKH, SoTK, NgayTao, SoDu From TaiKhoan Where IDKH = "+IDKH);
			while (rs.next()) {
				Vector row = new Vector();
				for (int i = 1; i<=4;i++)
					row.add(rs.getString(i));
				Data.add(row);
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi Lấy tt thẻ: "+e.toString());
		}
		return Data;
	}

	public static boolean XoaThe(String SoThe) {
		boolean rt = false;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			int i = st.executeUpdate("DELETE FROM TaiKhoan Where SoTK = "+SoThe);
			if(i != 0) rt = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi hủy thẻ: "+e.toString());
		}
		return rt;
	}
	
	public static boolean XoaKH(String IDKH) {
		boolean rt = false;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			int i = st.executeUpdate("EXEC sp_XoaKH "+IDKH);
			if(i == 0) rt = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi xoa kh: "+e.toString());
		}
		return rt;
	}
	
	public static boolean Sua(String IDKH, String Ten, String NgaySinh, String SDT) {
		boolean rt = false;
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			int i = st.executeUpdate("EXEC dbo.sp_Sua "+IDKH+", N'"+Ten+"', '"+SDT+"', '"+NgaySinh+"'");
			if(i != 0) rt = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa tt: "+e.toString());
		}
		return rt;
	}
	
	public static boolean ThemThe(String IDKH, String SoTK, String PIN ) {
		boolean rt = false;
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(d.getTime());
		try {
			conn = DriverManager.getConnection(URL);
			Statement st = conn.createStatement();
			int i = st.executeUpdate("INSERT INTO TaiKhoan(IDKH, SoTK, NgayTao, PIN) VALUES ('"+IDKH+"', '"+SoTK+"', '"+date+"', '"+PIN+"')");
			if(i != 0) rt = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi tạo thẻ: "+e.toString());
		}
		return rt;
	}
}