package main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.Map;
import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import main.SbGetLevenshteinDistance;
import main.SbCreateTestPool;
//import com.google.gson.*;
public class SbMainWindow {

	protected Shell shell;
	private Text textWord_1;
	private Text textWord_2;
	private Text textWord_3;
	private Text textWord_4;
	private Text textWord_5;
	private static Map<String,String[]> wordsMap;
	public Random generator = new Random();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
						
		try {
			SbCreateTestPool.createPool();
			setWordsMap(SbCreateTestPool.getWordsFromJson());
			SbMainWindow window = new SbMainWindow();
//			System.out.print(wordsMap);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(796, 595);
		shell.setText("TEST S£ÓWEK");
		shell.setLayout(new GridLayout(1, false));
		
		Label lblWitaj = new Label(shell, SWT.NONE);
		lblWitaj.setFont(SWTResourceManager.getFont("Segoe Script", 15, SWT.BOLD));
		lblWitaj.setAlignment(SWT.CENTER);
		lblWitaj.setText("Witaj!!");
		
		Label lblDescription = new Label(shell, SWT.NONE);
		lblDescription.setFont(SWTResourceManager.getFont("Segoe Script", 10, SWT.NORMAL));
		lblDescription.setText("Przed tob\u0105 jest 5 s\u0142\u00F3wek po polsku, posz\u0119 podaj ich odpowiedniki w j\u0119zyku angielskim.\r\nPo zako\u0144czeniu t\u0142umacze\u0144 wci\u015Bnij przycisk \"ZAKO\u0143CZ\", tw\u00F3j wynik zostanie Ci wy\u015Bwietlony. \r\nPrzebieg ca\u0142ego testu zostanie zapisany w pliku JSON.");
		
		Group groupWords = new Group(shell, SWT.NONE);
		GridData gd_groupWords = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_groupWords.heightHint = 133;
		gd_groupWords.widthHint = 765;
		groupWords.setLayoutData(gd_groupWords);
		
		Label lblWord_1 = new Label(groupWords, SWT.NONE);
		lblWord_1.setBounds(10, 10, 63, 19);
//		wordsMap.
		lblWord_1.setText("Word1");
		
		textWord_1 = new Text(groupWords, SWT.BORDER);
		textWord_1.setBounds(79, 10, 135, 22);
		
		Label lblWord_2 = new Label(groupWords, SWT.NONE);
		lblWord_2.setBounds(10, 57, 63, 19);
		lblWord_2.setText("Word_2");
		
		Label lblWord_3 = new Label(groupWords, SWT.NONE);
		lblWord_3.setBounds(10, 103, 63, 19);
		lblWord_3.setText("Word_3");
		
		Label lblWord_4 = new Label(groupWords, SWT.NONE);
		lblWord_4.setBounds(401, 10, 63, 19);
		lblWord_4.setText("Word_4");
		
		Label lblWord_5 = new Label(groupWords, SWT.NONE);
		lblWord_5.setBounds(401, 57, 63, 19);
		lblWord_5.setText("Word_5");
		
		textWord_2 = new Text(groupWords, SWT.BORDER);
		textWord_2.setBounds(79, 57, 135, 22);
		
		textWord_3 = new Text(groupWords, SWT.BORDER);
		textWord_3.setBounds(79, 103, 135, 22);
		
		textWord_4 = new Text(groupWords, SWT.BORDER);
		textWord_4.setBounds(470, 10, 135, 22);
		
		textWord_5 = new Text(groupWords, SWT.BORDER);
		textWord_5.setBounds(470, 54, 135, 22);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button btnfinish = new Button(shell, SWT.NONE);
		btnfinish.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			lblWord_1.setText(Integer.toString(SbGetLevenshteinDistance.getLevDist("first", "second")) );
			}
		});
		GridData gd_btnfinish = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnfinish.widthHint = 767;
		btnfinish.setLayoutData(gd_btnfinish);
		btnfinish.setFont(SWTResourceManager.getFont("Segoe Script", 15, SWT.BOLD));
		btnfinish.setText("ZAKO\u0143CZ");

	}

	public static void setWordsMap(Map<String,String[]> wordsMap) {
		SbMainWindow.wordsMap = wordsMap;
	}
}
