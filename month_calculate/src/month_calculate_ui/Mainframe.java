/**
* @author 夏宇轩	
* @version 创建时间：2019.09.28 12:56
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
		//实例化按钮
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
        jlb01 = new JLabel("请输入日期1和日期2，保证日期2大于日期1");
        jlb02 = new JLabel("时间输入格式为：2018-12-5");
        jlb1 = new JLabel("日期1：");
        jlb2 = new JLabel("日期2：");
        jlb3 = new JLabel("结果将在此显示");
        date1 = new JTextField(10);
        date2 = new JTextField(10);// 设置布局管理
        Btn_clear = new JButton("清空");
        
        Btn_clear.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			jlb3.setText("结果将在此显示");
        			date1.setText("");
        			date2.setText("");
        		}
        });
        Btn_calculate = new JButton("计算");
        
        //计算按钮事件监听
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
        				jlb3.setText("日期1不能为空");
        			}else if(input2 == null||input2.equals("")) {
        				jlb3.setText("日期2不能为空");
        			}else if(flag1 != true){//input1不符合日期格式
        				jlb3.setText("日期1格式输入不正确");
        			}else if(flag2 != true) {
        				jlb3.setText("日期2格式输入不正确");
        			}else{
        				String result = calculate(input1, input2);
            			jlb3.setText(result);
        			}
        		}
        		
        });
        
        //用户输入焦点判断(Enter换行)
        date1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==date1){		//如果date1文本框状态改变(按"Enter"),则触发动作监听，
					date2.requestFocus();     //date2获得焦点，即焦点从input1转移到input2
				}
			}
		});
        
        //键盘事件监听
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
        				jlb3.setText("日期1不能为空");
        			}else if(input2 == null||input2.equals("")) {
        				jlb3.setText("日期2不能为空");
        			}else if(flag1 != true){//input1不符合日期格式
        				jlb3.setText("日期1格式输入不正确");
        			}else if(flag2 != true) {
        				jlb3.setText("日期2格式输入不正确");
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
        
        //网格布局
        f.setLayout(new GridLayout(6, 1));
        // 加入各个组件
        jp01.add(jlb01);
        jp02.add(jlb02);
        jp1.add(jlb1);
        jp1.add(date1);
        jp2.add(jlb2);
        jp2.add(date2);
        jp3.add(Btn_clear);
        jp3.add(Btn_calculate);
        jp4.add(jlb3);
        // 加入到JFrame
        f.add(jp01);
        f.add(jp02);
        f.add(jp1);
        f.add(jp2);
        f.add(jp4);
        f.add(jp3);
        f.setLocation(500,300);
        f.setSize(500, 300);
        f.setTitle("月份计算器");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
	}
	
	
	//计算方法
	public static String calculate(String str1,String str2) {
//	System.out.println("依次输入两个日期，格式为：(年-月-日)");
		
//		Scanner reader = new Scanner(System.in);
//		System.out.println("请输入入职日期: ");
//		String str1 = reader.next();
//		
		
		String[] date1 = str1.split("-");
		int date1Year = Integer.parseInt(date1[0]);
		int date1Month = Integer.parseInt(date1[1]);
		int date1Day = Integer.parseInt(date1[2]);
		
		
	/*  System.out.println("Day of date 1: "+ date1Day);
		System.out.println("Month of date 1: "+ date1Month);
		System.out.println("Year of date 1: "+ date1Year);*/	
		
//		System.out.println("请输入日期2，格式为：(年-月-日): ");
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
			String s = "月份或日期输入错误";
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
//			System.out.println("相差 "+ yearDiff + "年" + monthDiff + " 月 " + dayDiff +" 天 \t" );
//			System.out.println("相差" + allmonth + "月" + dayDiff +"天");
			String res = "相差" + allmonth + "月" + dayDiff +"天";
			return res;
		}
		}
	
	public static void main(String[] args) {
		new Mainframe();
	}

		
		
}