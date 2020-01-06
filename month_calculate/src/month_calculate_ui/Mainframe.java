/**
* @author ������	
* @version ����ʱ�䣺2019.09.28 12:56
* v1.0
*/

package month_calculate_ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mainframe extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Mainframe(){
		//ʵ������ť
		JPanel jp01,jp02,jp1, jp2, jp3,jp4;
		JLabel jlb01,jlb02,jlb1, jlb2,jlb3;
		JButton Btn_clear, Btn_calculate;
		JTextField date1,date2;
		JFrame f = new JFrame();
		jp01 = new JPanel();
		jp02 = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jlb01 = new JLabel("����������1������2����֤����2��������1");
        jlb02 = new JLabel("ʱ�������ʽΪ��2018-12-5");
        jlb1 = new JLabel("����1��");
        jlb2 = new JLabel("����2��");
        jlb3 = new JLabel("������ڴ���ʾ");
        date1 = new JTextField(10);
        date2 = new JTextField(10);// ���ò��ֹ���
        Btn_clear = new JButton("���");
        
        Btn_clear.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			jlb3.setText("������ڴ���ʾ");
        			date1.setText("");
        			date2.setText("");
        		}
        });
        Btn_calculate = new JButton("����");
        
        //���㰴ť�¼�����
        Btn_calculate.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			String input1 = date1.getText();
        			String input2 = date2.getText();
        			String regex = "[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2}";
        			Pattern pattern = Pattern.compile(regex);
        			Matcher matcher1 = pattern.matcher(input1);
        			Matcher matcher2 = pattern.matcher(input2);
        			boolean flag1 = matcher1.matches();
        			boolean flag2 = matcher2.matches();
        			if(input1 == null||input1.equals("")) {
        				jlb3.setText("����1����Ϊ��");
        			}else if(input2 == null||input2.equals("")) {
        				jlb3.setText("����2����Ϊ��");
        			}else if(flag1 != true){//input1���������ڸ�ʽ
        				jlb3.setText("����1��ʽ���벻��ȷ");
        			}else if(flag2 != true) {
        				jlb3.setText("����2��ʽ���벻��ȷ");
        			}else{
        				String result = calculate(input1, input2);
            			jlb3.setText(result);
        			}
        		}
        		
        });
        
        //�û����뽹���ж�(Enter����)
        date1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==date1){		//���date1�ı���״̬�ı�(��"Enter"),�򴥷�����������
					date2.requestFocus();     //date2��ý��㣬�������input1ת�Ƶ�input2
				}
			}
		});
        
        //�����¼�����
        date2.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String input1 = date1.getText();
        			String input2 = date2.getText();
        			String regex = "[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2}";
        			Pattern pattern = Pattern.compile(regex);
        			Matcher matcher1 = pattern.matcher(input1);
        			Matcher matcher2 = pattern.matcher(input2);
        			boolean flag1 = matcher1.matches();
        			boolean flag2 = matcher2.matches();
        			if(input1 == null||input1.equals("")) {
        				jlb3.setText("����1����Ϊ��");
        			}else if(input2 == null||input2.equals("")) {
        				jlb3.setText("����2����Ϊ��");
        			}else if(flag1 != true){//input1���������ڸ�ʽ
        				jlb3.setText("����1��ʽ���벻��ȷ");
        			}else if(flag2 != true) {
        				jlb3.setText("����2��ʽ���벻��ȷ");
        			}else{
        				String result = calculate(input1, input2);
            			jlb3.setText(result);
        			}
    			}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        
        //���񲼾�
        f.setLayout(new GridLayout(6, 1));
        // ����������
        jp01.add(jlb01);
        jp02.add(jlb02);
        jp1.add(jlb1);
        jp1.add(date1);
        jp2.add(jlb2);
        jp2.add(date2);
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
        f.setResizable(false);
	}
	
	
	//���㷽��
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
	
	public static void main(String[] args) {
		new Mainframe();
	}

		
		
}