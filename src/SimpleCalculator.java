import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class SimpleCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField txtDisplay;
	private JButton btnOpenBracket;
	private JButton btnCloseBracket;
	private JButton btnBackspace;
	private JButton btnCancel;
	private JButton btnAdd;
	private JButton btnSubtract;
	private JButton btnMultiply;
	private JButton btnDivide;
	private JButton btn7;
	private JButton btn4;
	private JButton btn1;
	private JButton btnExponent;
	private JButton btn8;
	private JButton btn5;
	private JButton btn2;
	private JButton btn0;
	private JButton btn9;
	private JButton btn6;
	private JButton btn3;
	private JButton btnEquals;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator frame = new SimpleCalculator();
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
	public SimpleCalculator() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 105, 180), new Color(255, 105, 180)));
		contentPane.setFont(new Font("Helvetica", Font.PLAIN, 13));
		contentPane.setBackground(new Color(255, 240, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluateDisplay();
			}
		});
		txtDisplay.addKeyListener(new KeyAdapter() {
			String validCharacters = "1234567890+-*/^()";
			@Override
			public void keyTyped(KeyEvent e) {
				if (!validCharacters.contains(""+e.getKeyChar())) {
					// "consume" any character that is not a number
					e.consume();
				}
			}
		});
		txtDisplay.setBounds(25, 6, 250, 40);
		contentPane.add(txtDisplay);
		txtDisplay.setColumns(10);

		btnOpenBracket = new JButton("(");
		btnOpenBracket.setForeground(new Color(221, 160, 221));
		btnOpenBracket.setHorizontalAlignment(SwingConstants.LEFT);
		btnOpenBracket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "(");
			}
		});
		btnOpenBracket.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btnOpenBracket.setBounds(25, 50, 50, 50);
		contentPane.add(btnOpenBracket);

		btnCloseBracket = new JButton(")");
		btnCloseBracket.setForeground(new Color(221, 160, 221));
		btnCloseBracket.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCloseBracket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + ")");
			}
		});
		btnCloseBracket.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btnCloseBracket.setBounds(90, 50, 50, 50);
		contentPane.add(btnCloseBracket);

		btnBackspace = new JButton("B");
		btnBackspace.setForeground(new Color(199, 21, 133));
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = txtDisplay.getText();
				if (!temp.equals("")) {
					txtDisplay.setText(temp.substring(0, temp.length() - 1));
				}
			}
		});
		btnBackspace.setFont(new Font("Helvetica", Font.BOLD, 16));
		btnBackspace.setBounds(158, 50, 50, 50);
		contentPane.add(btnBackspace);

		btnCancel = new JButton("C");
		btnCancel.setForeground(new Color(199, 21, 133));
		btnCancel.setBackground(new Color(255, 192, 203));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(null);
			}
		});
		btnCancel.setFont(new Font("Helvetica", Font.BOLD, 16));
		btnCancel.setBounds(225, 50, 50, 50);
		contentPane.add(btnCancel);

		btnAdd = new JButton("+");
		btnAdd.setForeground(new Color(221, 160, 221));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "+");
			}
		});
		btnAdd.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btnAdd.setBounds(25, 115, 50, 50);
		contentPane.add(btnAdd);

		btnSubtract = new JButton("-");
		btnSubtract.setForeground(new Color(221, 160, 221));
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "-");
			}
		});
		btnSubtract.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btnSubtract.setBounds(25, 177, 50, 50);
		contentPane.add(btnSubtract);

		btnMultiply = new JButton("*");
		btnMultiply.setForeground(new Color(221, 160, 221));
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "*");
			}
		});
		btnMultiply.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMultiply.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btnMultiply.setBounds(25, 239, 50, 50);
		contentPane.add(btnMultiply);

		btnDivide = new JButton("/");
		btnDivide.setForeground(new Color(221, 160, 221));
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "/");
			}
		});
		btnDivide.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btnDivide.setBounds(25, 305, 50, 50);
		contentPane.add(btnDivide);

		btn7 = new JButton("7");
		btn7.setForeground(new Color(255, 105, 180));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "7");
			}
		});
		btn7.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn7.setBounds(90, 115, 50, 50);
		contentPane.add(btn7);

		btn4 = new JButton("4");
		btn4.setForeground(new Color(255, 105, 180));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "4");
			}
		});
		btn4.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn4.setBounds(90, 177, 50, 50);
		contentPane.add(btn4);

		btn1 = new JButton("1");
		btn1.setForeground(new Color(255, 105, 180));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "1");
			}
		});
		btn1.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn1.setBounds(90, 239, 50, 50);
		contentPane.add(btn1);

		btnExponent = new JButton("^");
		btnExponent.setForeground(new Color(221, 160, 221));
		btnExponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "^");
			}
		});
		btnExponent.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btnExponent.setBounds(90, 305, 50, 50);
		contentPane.add(btnExponent);

		btn8 = new JButton("8");
		btn8.setForeground(new Color(255, 105, 180));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "8");
			}
		});
		btn8.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn8.setBounds(158, 115, 50, 50);
		contentPane.add(btn8);

		btn5 = new JButton("5");
		btn5.setForeground(new Color(255, 105, 180));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "5");
			}
		});
		btn5.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn5.setBounds(158, 177, 50, 50);
		contentPane.add(btn5);

		btn2 = new JButton("2");
		btn2.setForeground(new Color(255, 105, 180));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "2");
			}
		});
		btn2.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn2.setBounds(158, 239, 50, 50);
		contentPane.add(btn2);

		btn0 = new JButton("0");
		btn0.setForeground(new Color(255, 105, 180));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "0");
			}
		});
		btn0.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn0.setBounds(158, 305, 50, 50);
		contentPane.add(btn0);

		btn9 = new JButton("9");
		btn9.setForeground(new Color(255, 105, 180));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "9");
			}
		});
		btn9.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn9.setBounds(225, 115, 50, 50);
		contentPane.add(btn9);

		btn6 = new JButton("6");
		btn6.setForeground(new Color(255, 105, 180));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "6");
			}
		});
		btn6.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn6.setBounds(225, 177, 50, 50);
		contentPane.add(btn6);

		btn3 = new JButton("3");
		btn3.setForeground(new Color(255, 105, 180));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(txtDisplay.getText() + "3");
			}
		});
		btn3.setFont(new Font("Helvetica", Font.PLAIN, 16));
		btn3.setBounds(225, 239, 50, 50);
		contentPane.add(btn3);

		btnEquals = new JButton("=");
		btnEquals.setForeground(new Color(147, 112, 219));
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluateDisplay();
			}
		});
		btnEquals.setFont(new Font("Helvetica", Font.BOLD, 16));
		btnEquals.setBounds(225, 305, 50, 50);
		contentPane.add(btnEquals);
	}

	private void evaluateDisplay() {
		try {
			// three lines to get the infix expression, attempt to
			// evaluate expression, and put result onto display
			String infixExpression = txtDisplay.getText();
			InfixEvaluation i = new InfixEvaluation();
			txtDisplay.setText("" + i.evaluate(infixExpression)); 
		} catch (UnsupportedOperationException e) {
			JOptionPane.showMessageDialog(this,"Math error", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			// one line to set display text to “ERROR”
			JOptionPane.showMessageDialog(this,"Syntax error", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	 

}
