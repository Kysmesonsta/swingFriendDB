package swinggogo;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import swing.model.Friend;
import swing.model.FriendDBA;
import swing.model.FriendDBAImpl;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class FriendModel extends JFrame {
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label_1;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JButton btnView;
	private JButton btnInsert;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JTextArea taVIEW;
	private JPanel panel_1;
	private JComboBox comSel;
	private JTextField tfSearch;
	private JButton btnSearch;
	FriendDBAImpl dba = new FriendDBAImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendModel frame = new FriendModel();
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
	public FriendModel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 288);
		getContentPane().add(getSplitPane(), BorderLayout.CENTER);
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(200);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "\uAC1C\uC778\uC815\uBCF4\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setLayout(null);
			panel.add(getLabel());
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getLabel_1());
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
			panel.add(getBtnView());
			panel.add(getBtnInsert());
		}
		return panel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("이름");
			label.setBounds(12, 34, 57, 15);
		}
		return label;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("생일");
			lblNewLabel.setBounds(12, 69, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("전화번호");
			lblNewLabel_1.setBounds(12, 114, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("주소");
			label_1.setBounds(12, 160, 57, 15);
		}
		return label_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(71, 31, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(71, 66, 116, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(71, 111, 116, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setBounds(71, 157, 116, 21);
			tfAddr.setColumns(10);
		}
		return tfAddr;
	}
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("전체보기");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Friend f = new Friend();
					taVIEW.setText("");
					ArrayList<Friend> arr = dba.friendView();
					for(Friend f:arr) {
						taVIEW.append("번호 : " + f.getNum()+"\n");
						taVIEW.append("이름 : " + f.getName()+"\n");
						taVIEW.append("전화번호 : " + f.getPhone()+"\n");
					}
					
				}
			});
			btnView.setBounds(12, 198, 83, 21);
		}
		return btnView;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("추가");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setAddr(tfAddr.getText());
					f.setPhone(tfPhone.getText());
					dba.friendInsert(f);
				}
			});
			btnInsert.setBounds(102, 198, 85, 21);
		}
		return btnInsert;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setDividerLocation(200);
		}
		return splitPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 3), "\uC804\uCCB4\uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			scrollPane.setViewportView(getTaVIEW());
		}
		return scrollPane;
	}
	private JTextArea getTaVIEW() {
		if (taVIEW == null) {
			taVIEW = new JTextArea();
		}
		return taVIEW;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getComSel());
			panel_1.add(getTfSearch());
			panel_1.add(getBtnSearch());
		}
		return panel_1;
	}
	private JComboBox getComSel() {
		if (comSel == null) {
			comSel = new JComboBox();
			comSel.setModel(new DefaultComboBoxModel(new String[] {"이름", "전화번호"}));
			comSel.setBounds(12, 10, 72, 21);
		}
		return comSel;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(96, 10, 124, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str=" ";
					if(comSel.getSelectedIndex()==0) {
						str="name";
					}else if(comSel.getSelectedIndex()==1) {
						str="addr";
					}else {
						tfSearch.setText("선택오류");
						return;
					}
					ArrayList<Friend> arr = dba.friendsSearch(str, tfSearch.getText());
					for(Friend f:arr) {
						taVIEW.append("번호 : " + f.getNum()+"\n");
						taVIEW.append("이름 : " + f.getName()+"\n");
						taVIEW.append("생일 : " + f.getBirth());
						taVIEW.append("주소 : " + f.getAddr()+"\n");
						taVIEW.append("전화번호 : " + f.getPhone()+"\n");
					}
				}
			});
			btnSearch.setBounds(232, 9, 97, 23);
		}
		return btnSearch;
	}
}
