/*
Name: Nick Lai
ID#: 2282417
Email: lai137@mail.chapman.edu
Class: CPSC 231-01
Assignment#: In-class 2

Simulates multiple threads withdrawing and depositing into an account. Shown using a GUI.
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccountGUI extends JFrame
{
	//sets the frame size for the gui
	public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public static final int FILL_WIDTH = 600;
    public static final int FILL_HEIGHT = 200;
	public static final int PAUSE = 100; //milliseconds
	
	private JPanel box;
	
	//generates a random number
	Random randomnum = new Random();
	
	StartListener startListener;
	
	//sets the gui visible
	public static void main(String[]args)
	{
		BankAccountGUI gui = new BankAccountGUI();
		gui.setVisible(true);
	}
	
	//sets frame size values and a title
	public BankAccountGUI()
	{
		setSize(WIDTH, HEIGHT);
		setTitle("Bank Account Simulation");
		//gracefully closes the program
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		    	startListener.stopThreads();
		    }
		});
		
		setLayout(new BorderLayout());
		
		box = new JPanel( );
        add(box, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel( );
        buttonPanel.setLayout(new FlowLayout( ));

        JButton startButton = new JButton("Start");
        startListener = new StartListener();
        startButton.addActionListener(startListener);
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);
	}
	
	//instantiates and starts multiple threads when called. stops threads when called
	private class StartListener implements ActionListener
	{
		List<Thread> accountThreads;
		
		StartListener() {
			accountThreads = new ArrayList<Thread>();
		}
		
		public void actionPerformed(ActionEvent e)
		{
			startThread();
		}
		
		public void startThread()
		{
			Thread oneAccountThread = new Thread(new AccountSimulator());
			accountThreads.add(oneAccountThread);
			oneAccountThread.start();
		}
		
		public void stopThreads() 
		{
			for (int i = 0; i < accountThreads.size();++i) {
				System.out.println("interrupting thread:" + i);

				accountThreads.get(i).interrupt();
				try 
				{
					System.out.println("joining thread:" + i);
					accountThreads.get(i).join();
				} 
				
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			System.exit(0);
		}
	}
	
	private class AccountSimulator extends BankAccount implements Runnable
	{
		BankAccount acct = new BankAccount();
	
		public void run()
		{
			Graphics g = box.getGraphics();
			acct.LoadSave();
			JLabel acctTotal = new JLabel(acct.toString());
			box.add(acctTotal);
			System.out.println("Program is running");
			
			//continues to randomly select withdraw or deposit until the program is closed.
			while (true) 
			{
				int choose = randomnum.nextInt(2);
				if(choose ==  0)
				{
					acct.Deposit();
					acctTotal.setText(acct.toString());
				}
				
				else
				{
					acct.Withdraw();
					acctTotal.setText(acct.toString());
				}
				// sleep and check if user shutdown application
				if (shouldExit(PAUSE)) {
					break;
				}
			}
			System.out.println("AccountSimulator exiting...");
		}
		
		//saves the current state of the account on shutdown
		public boolean shouldExit(int milliseconds)
		{
			try
			{
				Thread.sleep(milliseconds);
			}
			catch(InterruptedException e)
			{
				System.out.println("Stopping simulation, saving account...");
				acct.SaveState();
				return true;
			}
			return false;
		}
		
	}
}
