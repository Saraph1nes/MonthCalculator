/**
* @author ������	
* @version ����ʱ�䣺2019.09.28 12:56
* v1.0
*/

package month_calculate;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class demo extends JFrame{
	
	public static void main(String[] args) {

		JPanel jp01,jp02,jp1, jp2, jp3,jp4;
		JLabel jlb01,jlb02,jlb1, jlb2,jlb3;
		JButton Btn_clear, Btn_calculate;
		JTextField jtf1,jtf2;
		
		JFrame f = new JFrame();
		
		jp01 = new JPanel();
		jp02 = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jlb01 = new JLabel("����������1������2����֤����2��������1");
        jlb02 = new JLabel("ʱ�������ʽΪ��1999-01-01");
        jlb1 = new JLabel("����1��");
        jlb2 = new JLabel("����2��");
        jlb3 = new JLabel("(������ڴ���ʾ)");
        
        jtf1 = new JTextField(10);

        jtf2 = new JTextField(10);// ���ò��ֹ���

        Btn_clear = new JButton("���");
        Btn_clear.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			jlb3.setText("(������ڴ���ʾ)");
        			jtf1.setText("");
        			jtf2.setText("");
        		}
        });
        
        Btn_calculate = new JButton("����");
        Btn_calculate.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			String input1 = jtf1.getText();
        			String input2 = jtf2.getText();
        			String result = calculate(input1, input2);
        			jlb3.setText(result);
        		}
        });

        
        f.setLayout(new GridLayout(6, 1));

        // ����������
        jp01.add(jlb01);
        
        jp02.add(jlb02);
        
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);

        jp3.add(Btn_clear);
        jp3.add(Btn_calculate);
        
        jp4.add(jlb3);

        // ���뵽JFrame
        f.add(jp01);
        f.add(jp02);
        f.add(jp1);
        f.add(jp2);
        f.add(jp4);
        f.add(jp3);

        f.setLocation(500,300);
        f.setSize(500, 300);
        f.setTitle("�·ݼ�����");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	
	
	
	public static String calculate(String str1,String str2) {
//	System.out.println("���������������ڣ���ʽΪ��(��-��-��)");
		
//		Scanner reader = new Scanner(System.in);
//		System.out.println("��������ְ����: ");
//		String str1 = reader.next();
//		
		
		String[] date1 = str1.split("-");
		int date1Year = Integer.parseInt(date1[0]);
		int date1Month = Integer.parseInt(date1[1]);
		int date1Day = Integer.parseInt(date1[2]);
		
		
	/*  System.out.println("Day of date 1: "+ date1Day);
		System.out.println("Month of date 1: "+ date1Month);
		System.out.println("Year of date 1: "+ date1Year);*/	
		
//		System.out.println("����������2����ʽΪ��(��-��-��): ");
//		String str2 = reader.next();
//		System.out.println("You entered: " + str1 + " and " + str2);
		
		String[] date2 = str2.split("-");
		int date2Year = Integer.parseInt(date2[0]);
		int date2Month = Integer.parseInt(date2[1]);
		int date2Day = Integer.parseInt(date2[2]);
				
	/*	System.out.println("Day of date 2: "+ date2Day);
		System.out.println("Month of date 2: "+ date2Month);
		System.out.println("Year of date 2: "+ date2Year);*/
		
		if(date1Month>12|date2Month>12|date1Day>31|date2Day>31) {
			String s = "�·ݻ������������";
			return s;
		}else {
			int dayDiff, monthDiff, yearDiff;
			
			yearDiff = date2Year - date1Year;
			monthDiff = date2Month - date1Month;
			if(monthDiff < 0){
				monthDiff = monthDiff + 12;
				yearDiff--;
			}
			dayDiff = date2Day - date1Day;
			if(dayDiff < 0){
				if(date1Month == 1 || date1Month == 3 || date1Month == 5 || date1Month == 7 || date1Month == 8 || date1Month == 10 || date1Month == 12){
					dayDiff = dayDiff + 31;
				}
				else if(date1Month == 2){
					if(date1Year % 4 == 0)
						dayDiff = dayDiff + 29;
					else
						dayDiff = dayDiff + 28;
				}
				else{
					dayDiff = dayDiff + 30;
				}
				monthDiff--;
			}
		/*	System.out.println("Day difference: "+ dayDiff);
			System.out.println("Month difference: "+ monthDiff);
			System.out.println("Year difference: "+ yearDiff);*/
			
			int allmonth = yearDiff * 12 + monthDiff ;
//			System.out.println("��� "+ yearDiff + "��" + monthDiff + " �� " + dayDiff +" �� \t" );
//			System.out.println("���" + allmonth + "��" + dayDiff +"��");
			String res = "���" + allmonth + "��" + dayDiff +"��";
			return res;
		}
		}
		
		
}