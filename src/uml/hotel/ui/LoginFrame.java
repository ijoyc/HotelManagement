package uml.hotel.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ImageIcon;

import uml.hotel.dao.AdminDAO;
import uml.hotel.model.Admin;
import uml.hotel.utils.Utils;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAdmin;
	private JPasswordField passwordField;
	private JLabel lblV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setBounds(115, 71, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801;");
		label_1.setBounds(115, 108, 54, 15);
		contentPane.add(label_1);
		
		txtAdmin = new JTextField();
		txtAdmin.setText("admin");
		txtAdmin.setBounds(179, 68, 134, 21);
		contentPane.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 105, 134, 21);
		contentPane.add(passwordField);
		
		JLabel label_2 = new JLabel("\u5BBE\u9986\u7BA1\u7406\u7CFB\u7EDF");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(139, 10, 173, 21);
		contentPane.add(label_2);
		
		lblV = new JLabel("V1.0");
		lblV.setBounds(370, 33, 54, 15);
		contentPane.add(lblV);
		
		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtAdmin.getText();
				String passwd = new String(passwordField.getPassword());
				
				AdminDAO adminDao = new AdminDAO();
				Admin a = (Admin)adminDao.findByUsername(user).get(0);
				List list = adminDao.findByPassword(passwd);
				if (list.contains(a)) {
					setVisible(false);
					new MainFrame().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
				
			}
		});
		button.setBounds(65, 437, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1.setBounds(267, 437, 93, 23);
		contentPane.add(button_1);
		
		JLabel lbladmin = new JLabel("\u8D85\u7EA7\u7528\u6237\u540D\u7684\u8D26\u53F7\u662Fadmin\uFF0C\u5BC6\u7801\u4E3Aadmin\u3002");
		lbladmin.setHorizontalAlignment(SwingConstants.CENTER);
		lbladmin.setFont(new Font("宋体", Font.PLAIN, 11));
		lbladmin.setForeground(Color.red);
		lbladmin.setBounds(115, 133, 220, 15);
		contentPane.add(lbladmin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(getWidth() / 2 - 155, 183, 305, 216);
		
		ImageIcon icon = Utils.getProperIcon(lblNewLabel, "4de9fccb9e49911aba001020.jpg", new Point());
		lblNewLabel.setIcon(icon);
		
		
		contentPane.add(lblNewLabel, JLabel.CENTER);
		
	}
}
