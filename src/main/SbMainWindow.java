package main;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.List;
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
	protected static  Map<String,String[]> wordsMap;
	protected static List<String> choosenWords;
	

	public Random generator = new Random();
	private Text textName;
	private Text textSurname;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		SbCreateTestPool testPool = new SbCreateTestPool();				
		try {
			testPool.createPool();
			setWordsMap(testPool.getWordsFromJson());
			setChoosenWords(testPool.getRandomQuestionList());
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
		if(!choosenWords.isEmpty())
		{
			lblWord_1.setText(choosenWords.get(0));
		}else
		{
			lblWord_1.setText("error");
		}
		
		textWord_1 = new Text(groupWords, SWT.BORDER);
		textWord_1.setBounds(79, 10, 135, 22);
		
		Label lblWord_2 = new Label(groupWords, SWT.NONE);
		lblWord_2.setBounds(10, 57, 63, 19);
		if(!choosenWords.isEmpty())
		{
			lblWord_2.setText(choosenWords.get(1));
		}else
		{
			lblWord_2.setText("error");
		}
		
		Label lblWord_3 = new Label(groupWords, SWT.NONE);
		lblWord_3.setBounds(10, 103, 63, 19);
		if(!choosenWords.isEmpty())
		{
			lblWord_3.setText(choosenWords.get(2));
		}else
		{
			lblWord_3.setText("error");
		}
		
		Label lblWord_4 = new Label(groupWords, SWT.NONE);
		lblWord_4.setBounds(401, 10, 63, 19);
		if(!choosenWords.isEmpty())
		{
			lblWord_4.setText(choosenWords.get(3));
		}else
		{
			lblWord_4.setText("error");
		}
		
		Label lblWord_5 = new Label(groupWords, SWT.NONE);
		lblWord_5.setBounds(401, 57, 63, 19);
		if(!choosenWords.isEmpty())
		{
			lblWord_5.setText(choosenWords.get(4));
		}else
		{
			lblWord_5.setText("error");
		}
		
		textWord_2 = new Text(groupWords, SWT.BORDER);
		textWord_2.setBounds(79, 57, 135, 22);
		
		textWord_3 = new Text(groupWords, SWT.BORDER);
		textWord_3.setBounds(79, 103, 135, 22);
		
		textWord_4 = new Text(groupWords, SWT.BORDER);
		textWord_4.setBounds(470, 10, 135, 22);
		
		textWord_5 = new Text(groupWords, SWT.BORDER);
		textWord_5.setBounds(470, 54, 135, 22);
		
		Group group = new Group(shell, SWT.NONE);
		group.setLayout(new GridLayout(4, false));
		GridData gd_group = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_group.widthHint = 715;
		group.setLayoutData(gd_group);
		
		Label lblImi = new Label(group, SWT.NONE);
		GridData gd_lblImi = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblImi.widthHint = 90;
		lblImi.setLayoutData(gd_lblImi);
		lblImi.setAlignment(SWT.CENTER);
		lblImi.setText("Imi\u0119");
		
		textName = new Text(group, SWT.BORDER);
		GridData gd_textName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_textName.widthHint = 160;
		textName.setLayoutData(gd_textName);
		
		Label lblNazwisko = new Label(group, SWT.NONE);
		lblNazwisko.setAlignment(SWT.CENTER);
		GridData gd_lblNazwisko = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNazwisko.widthHint = 96;
		lblNazwisko.setLayoutData(gd_lblNazwisko);
		lblNazwisko.setText("Nazwisko");
		
		textSurname = new Text(group, SWT.BORDER);
		GridData gd_textSurname = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_textSurname.widthHint = 152;
		textSurname.setLayoutData(gd_textSurname);
		
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
	
	public static void setChoosenWords(List<String> choosenWords) {
		SbMainWindow.choosenWords = choosenWords;
	}
}
