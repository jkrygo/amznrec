package pokedex;

import java.util.ArrayList;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class StatCalc {

	protected Shell shlStatCalculator;
	private int level;
	private String[] natures = new String[] {"Hardy", "Lonely", "Brave", "Adamant", "Naughty", "Bold", "Docile",
			"Relaxed", "Impish", "Lax", "Timid", "Hasty", "Serious", "Jolly", "Naive", "Modest", "Mild", "Quiet", "Bashful", 
			"Rash", "Calm", "Gentle", "Sassy", "Careful", "Quirky"};
	private int[] ivs = {0, 0, 0, 0, 0, 0};
	private int[] evs = {0, 0, 0, 0, 0, 0};
	private int[] baseStats = {0, 0, 0, 0, 0, 0};
	private double[] natureMultiplier = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
	private String[] comboOptions = new String[151];
	private  ArrayList<Pokemon> pokeList = new ArrayList<>();
	
	public StatCalc() {
		
	}
	
	public StatCalc(ArrayList<Pokemon> pokemonList) {
		this.pokeList = pokemonList;
		for (int i = 0; i < 151; i++)
		{
			comboOptions[i] = pokemonList.get(i).getNat() + ". " + pokemonList.get(i).getPokemon();
		}
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StatCalc window = new StatCalc();
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
		shlStatCalculator.open();
		shlStatCalculator.layout();
		while (!shlStatCalculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlStatCalculator = new Shell();
		shlStatCalculator.setSize(500,446);
		shlStatCalculator.setText("Stat Calculator");
		
		//Buttons generated
		Button btnCalculate = new Button(shlStatCalculator, SWT.NONE);		
		btnCalculate.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnCalculate.setBounds(11, 297, 464, 50);
		btnCalculate.setText("SELECT POKEMON TO START");
		btnCalculate.setEnabled(false);
		
		Button btnReset = new Button(shlStatCalculator, SWT.NONE);
		btnReset.setText("RESET CALCULATOR");
		btnReset.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnReset.setBounds(11, 353, 464, 50);
		
		//Comboboxes generated
		Combo comboPokemon = new Combo(shlStatCalculator, SWT.NONE);
		comboPokemon.setVisibleItemCount(15);
		comboPokemon.setBounds(11, 31, 464, 23);
		comboPokemon.setItems(comboOptions);
		//Listener to check if user has selected a pokemon
		//If not, Calculate button will be grayed out and user can't press it
		Listener comboPokemonListener = new Listener() {
			public void handleEvent(Event event) {
				if(comboPokemon.getSelectionIndex() > -1)
				{
					btnCalculate.setText("CALCULATE");
					btnCalculate.setEnabled(true);
				}
				}
			};
		comboPokemon.addListener(SWT.Selection, comboPokemonListener);
		
		Combo comboNature = new Combo(shlStatCalculator, SWT.NONE);
		comboNature.setVisibleItemCount(15);
		comboNature.setBounds(168, 81, 307, 22);
		comboNature.setItems(natures);
		//Listener to reset natureMultiplier array values to 1.0 if no nature selected
		Listener comboNatureListener = new Listener() {
			public void handleEvent(Event event) {
				if(comboNature.getSelectionIndex() < 0){
					for (int i = 0; i < 6; i++)
					{
						natureMultiplier[i] = 1.0;
					}
				}
				}
			};
		comboNature.addListener(SWT.Selection, comboNatureListener);	
		
		//Spinner to allow user to select Pokemon level
		Spinner spinnerLevel = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerLevel.setBounds(10, 81, 151, 23);
		spinnerLevel.setMinimum(1);
		spinnerLevel.setMaximum(100);
		spinnerLevel.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
            	level = spinnerLevel.getSelection();
            }
        });
		
		//Labels for everything
		Label lblPokemon = new Label(shlStatCalculator, SWT.NONE);
		lblPokemon.setText("POKEMON");
		lblPokemon.setBounds(10, 10, 66, 15);
		
		Label lblLevel = new Label(shlStatCalculator, SWT.NONE);
		lblLevel.setBounds(10, 60, 55, 15);
		lblLevel.setText("LEVEL");
		
		Label lblNature = new Label(shlStatCalculator, SWT.NONE);
		lblNature.setBounds(168, 60, 55, 15);
		lblNature.setText("NATURE");
		
		Label lblIv = new Label(shlStatCalculator, SWT.NONE);
		lblIv.setBounds(10, 109, 20, 15);
		lblIv.setText("IV");
		
		Label lblEv = new Label(shlStatCalculator, SWT.NONE);
		lblEv.setBounds(167, 109, 20, 15);
		lblEv.setText("EV");
		
		Label lblStats = new Label(shlStatCalculator, SWT.NONE);
		lblStats.setBounds(324, 109, 38, 15);
		lblStats.setText("STATS");
		
		Label lblHpIv = new Label(shlStatCalculator, SWT.NONE);
		lblHpIv.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblHpIv.setBounds(10, 133, 20, 15);
		lblHpIv.setText("HP");
		
		Label lbllHpEv = new Label(shlStatCalculator, SWT.NONE);
		lbllHpEv.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbllHpEv.setBounds(167, 133, 20, 15);
		lbllHpEv.setText("HP");
		
		Label lblHpStats = new Label(shlStatCalculator, SWT.NONE);
		lblHpStats.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblHpStats.setBounds(324, 133, 20, 15);
		lblHpStats.setText("HP");
		
		Label lblAtkIv = new Label(shlStatCalculator, SWT.NONE);
		lblAtkIv.setForeground(SWTResourceManager.getColor(0, 102, 255));
		lblAtkIv.setBounds(10, 160, 21, 15);
		lblAtkIv.setText("ATK");
		
		Label lblAtkEv = new Label(shlStatCalculator, SWT.NONE);
		lblAtkEv.setText("ATK");
		lblAtkEv.setForeground(SWTResourceManager.getColor(0, 102, 255));
		lblAtkEv.setBounds(167, 160, 21, 15);
		
		Label lblAtkStats = new Label(shlStatCalculator, SWT.NONE);
		lblAtkStats.setForeground(SWTResourceManager.getColor(0, 102, 255));
		lblAtkStats.setBounds(324, 160, 21, 15);
		lblAtkStats.setText("ATK");
		
		Label lblDefIv = new Label(shlStatCalculator, SWT.NONE);
		lblDefIv.setForeground(SWTResourceManager.getColor(0, 153, 51));
		lblDefIv.setBounds(10, 188, 21, 15);
		lblDefIv.setText("DEF");
		
		Label lblDefEv = new Label(shlStatCalculator, SWT.NONE);
		lblDefEv.setForeground(SWTResourceManager.getColor(0, 153, 51));
		lblDefEv.setBounds(167, 187, 21, 15);
		lblDefEv.setText("DEF");
		
		Label lblDefStats = new Label(shlStatCalculator, SWT.NONE);
		lblDefStats.setForeground(SWTResourceManager.getColor(0, 153, 51));
		lblDefStats.setBounds(324, 188, 21, 15);
		lblDefStats.setText("DEF");
		
		Label lblSpaIv = new Label(shlStatCalculator, SWT.NONE);
		lblSpaIv.setForeground(SWTResourceManager.getColor(0, 0, 204));
		lblSpaIv.setBounds(10, 216, 21, 15);
		lblSpaIv.setText("SpA");
		
		Label lblSpaEv = new Label(shlStatCalculator, SWT.NONE);
		lblSpaEv.setForeground(SWTResourceManager.getColor(0, 0, 204));
		lblSpaEv.setBounds(167, 216, 21, 15);
		lblSpaEv.setText("SpA");
		
		Label lblSpaStats = new Label(shlStatCalculator, SWT.NONE);
		lblSpaStats.setForeground(SWTResourceManager.getColor(0, 0, 204));
		lblSpaStats.setBounds(324, 216, 21, 15);
		lblSpaStats.setText("SpA");
		
		Label lblSpdIv = new Label(shlStatCalculator, SWT.NONE);
		lblSpdIv.setForeground(SWTResourceManager.getColor(0, 102, 0));
		lblSpdIv.setBounds(10, 244, 21, 15);
		lblSpdIv.setText("SpD");
		
		Label lblSpdEv = new Label(shlStatCalculator, SWT.NONE);
		lblSpdEv.setForeground(SWTResourceManager.getColor(0, 102, 0));
		lblSpdEv.setBounds(167, 244, 21, 15);
		lblSpdEv.setText("SpD");
		
		Label lblSpdStats = new Label(shlStatCalculator, SWT.NONE);
		lblSpdStats.setForeground(SWTResourceManager.getColor(0, 102, 0));
		lblSpdStats.setBounds(324, 244, 21, 15);
		lblSpdStats.setText("SpD");
		
		Label lblSpeIv = new Label(shlStatCalculator, SWT.NONE);
		lblSpeIv.setForeground(SWTResourceManager.getColor(255, 0, 153));
		lblSpeIv.setBounds(10, 272, 21, 15);
		lblSpeIv.setText("SPE");
		
		Label lvlSpeEv = new Label(shlStatCalculator, SWT.NONE);
		lvlSpeEv.setForeground(SWTResourceManager.getColor(255, 0, 153));
		lvlSpeEv.setBounds(167, 272, 21, 15);
		lvlSpeEv.setText("SPE");
		
		Label lvlSpeStats = new Label(shlStatCalculator, SWT.NONE);
		lvlSpeStats.setForeground(SWTResourceManager.getColor(255, 0, 153));
		lvlSpeStats.setBounds(324, 272, 21, 15);
		lvlSpeStats.setText("SPE");
		
		//Spinners to let user input IV's and EV's
		Spinner spinnerIvHp = new Spinner(shlStatCalculator, SWT.RIGHT | SWT.BORDER);
		spinnerIvHp.setMaximum(31);
		spinnerIvHp.setBounds(38, 130, 123, 21);
		spinnerIvHp.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ivs[0] = spinnerIvHp.getSelection();
			}
		});
		
		Spinner spinnerIvAtk = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerIvAtk.setMaximum(31);
		spinnerIvAtk.setBounds(38, 157, 123, 22);
		spinnerIvAtk.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ivs[1] = spinnerIvAtk.getSelection();
			}
		});
		
		Spinner spinnerIvDef = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerIvDef.setMaximum(31);
		spinnerIvDef.setBounds(38, 185, 123, 22);
		spinnerIvDef.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ivs[2] = spinnerIvDef.getSelection();
			}
		});
		
		Spinner spinnerIvSpa = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerIvSpa.setMaximum(31);
		spinnerIvSpa.setBounds(38, 213, 123, 22);
		spinnerIvSpa.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ivs[3] = spinnerIvSpa.getSelection();
			}
		});
		
		Spinner spinnerIvSpd = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerIvSpd.setMaximum(31);
		spinnerIvSpd.setBounds(38, 241, 123, 22);
		spinnerIvSpd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ivs[4] = spinnerIvSpd.getSelection();
			}
		});
		
		Spinner spinnerIvSpe = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerIvSpe.setMaximum(31);
		spinnerIvSpe.setBounds(38, 269, 123, 22);
		spinnerIvSpe.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ivs[5] = spinnerIvSpe.getSelection();
			}
		});
		
		Spinner spinnerEvHp = new Spinner(shlStatCalculator, SWT.RIGHT | SWT.BORDER);
		spinnerEvHp.setMaximum(252);
		spinnerEvHp.setBounds(195, 130, 123, 21);
		spinnerEvHp.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				evs[0] = spinnerEvHp.getSelection();
			}
		});
		
		Spinner spinnerEvAtk = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerEvAtk.setMaximum(252);
		spinnerEvAtk.setBounds(195, 157, 123, 22);
		spinnerEvAtk.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				evs[1] = spinnerEvAtk.getSelection();
			}
		});
		
		Spinner spinnerEvDef = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerEvDef.setMaximum(252);
		spinnerEvDef.setBounds(195, 185, 123, 22);
		spinnerEvDef.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				evs[2] = spinnerEvDef.getSelection();
			}
		});
		
		Spinner spinnerEvSpa = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerEvSpa.setMaximum(252);
		spinnerEvSpa.setBounds(195, 213, 123, 22);
		spinnerEvSpa.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				evs[3] = spinnerEvSpa.getSelection();
			}
		});
		
		Spinner spinnerEvSpd = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerEvSpd.setMaximum(252);
		spinnerEvSpd.setBounds(195, 241, 123, 22);
		spinnerEvSpd.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				evs[4] = spinnerEvSpd.getSelection();
			}
		});
		
		Spinner spinnerEvSpe = new Spinner(shlStatCalculator, SWT.BORDER);
		spinnerEvSpe.setMaximum(252);
		spinnerEvSpe.setBounds(195, 269, 123, 22);
		spinnerEvSpe.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				evs[5] = spinnerEvSpe.getSelection();
			}
		});
			
		//Text fields to display final stats
		Text textStatsHp;
		textStatsHp = new Text(shlStatCalculator, SWT.READ_ONLY | SWT.RIGHT | SWT.BORDER);
		textStatsHp.setBounds(352, 130, 123, 21);
		
		Text textStatsAtk;
		textStatsAtk = new Text(shlStatCalculator, SWT.READ_ONLY | SWT.RIGHT | SWT.BORDER);
		textStatsAtk.setBounds(352, 157, 122, 21);
		
		Text textStatsDef;
		textStatsDef = new Text(shlStatCalculator, SWT.READ_ONLY | SWT.RIGHT | SWT.BORDER);
		textStatsDef.setBounds(352, 185, 122, 21);
		
		Text textStatsSpa;
		textStatsSpa = new Text(shlStatCalculator, SWT.READ_ONLY | SWT.RIGHT | SWT.BORDER);
		textStatsSpa.setBounds(352, 213, 122, 21);
		
		Text textStatsSpd;
		textStatsSpd = new Text(shlStatCalculator, SWT.READ_ONLY | SWT.RIGHT | SWT.BORDER);
		textStatsSpd.setBounds(352, 241, 122, 21);
		
		Text textStatsSpe;
		textStatsSpe = new Text(shlStatCalculator, SWT.READ_ONLY | SWT.RIGHT | SWT.BORDER);
		textStatsSpe.setBounds(352, 269, 122, 21);

		//btnCalculate actionlistener to calculate final stats
		Listener calculateListener = new Listener() {
			public void handleEvent(Event event) {
				//Check to see if Pokemon chosen is valid
				//If invalid, disable calculate button return
				if(comboPokemon.getSelectionIndex() < 0)
				{
					btnCalculate.setText("SELECT POKEMON TO START");
					btnCalculate.setEnabled(false);
					return;
				}
				//Set natureMulitpliers using combobox selection index
				switch (comboNature.getSelectionIndex()) {
				case 0: 
					natureMultiplier[0] = 1.0;
					natureMultiplier[1] = 1.0;
					natureMultiplier[2] = 1.0;
					natureMultiplier[3] = 1.0;
					natureMultiplier[4] = 1.0;
					natureMultiplier[5] = 1.0;
					break;
				case 1:
					natureMultiplier[1] = 1.1;
					natureMultiplier[2] = 0.9;
					break;
				case 2:
					natureMultiplier[1] = 1.1;
					natureMultiplier[5] = 0.9;
					break;
				case 3:
					natureMultiplier[1] = 1.1;
					natureMultiplier[3] = 0.9;
					break;
				case 4:
					natureMultiplier[1] = 1.1;
					natureMultiplier[4] = 0.9;
					break;
				case 5:
					natureMultiplier[2] = 1.1;
					natureMultiplier[1] = 0.9;
					break;
				case 6:
					natureMultiplier[0] = 1.0;
					natureMultiplier[1] = 1.0;
					natureMultiplier[2] = 1.0;
					natureMultiplier[3] = 1.0;
					natureMultiplier[4] = 1.0;
					natureMultiplier[5] = 1.0;
					break;
				case 7:
					natureMultiplier[2] = 1.1;
					natureMultiplier[5] = 0.9;
					break;
				case 8:
					natureMultiplier[2] = 1.1;
					natureMultiplier[3] = 0.9;
					break;
				case 9:
					natureMultiplier[2] = 1.1;
					natureMultiplier[4] = 0.9;
					break;
				case 10:
					natureMultiplier[5] = 1.1;
					natureMultiplier[1] = 0.9;
					break;
				case 11:
					natureMultiplier[5] = 1.1;
					natureMultiplier[2] = 0.9;
					break;
				case 12:
					natureMultiplier[0] = 1.0;
					natureMultiplier[1] = 1.0;
					natureMultiplier[2] = 1.0;
					natureMultiplier[3] = 1.0;
					natureMultiplier[4] = 1.0;
					natureMultiplier[5] = 1.0;
					break;
				case 13:
					natureMultiplier[5] = 1.1;
					natureMultiplier[3] = 0.9;
					break;
				case 14:
					natureMultiplier[5] = 1.1;
					natureMultiplier[4] = 0.9;
					break;
				case 15:
					natureMultiplier[3] = 1.1;
					natureMultiplier[1] = 0.9;
					break;
				case 16:
					natureMultiplier[3] = 1.1;
					natureMultiplier[2] = 0.9;
					break;
				case 17:
					natureMultiplier[3] = 1.1;
					natureMultiplier[5] = 0.9;
					break;
				case 18:
					natureMultiplier[0] = 1.0;
					natureMultiplier[1] = 1.0;
					natureMultiplier[2] = 1.0;
					natureMultiplier[3] = 1.0;
					natureMultiplier[4] = 1.0;
					natureMultiplier[5] = 1.0;
					break;
				case 19:
					natureMultiplier[3] = 1.1;
					natureMultiplier[4] = 0.9;
					break;
				case 20:
					natureMultiplier[4] = 1.1;
					natureMultiplier[1] = 0.9;
					break;
				case 21:
					natureMultiplier[4] = 1.1;
					natureMultiplier[2] = 0.9;
					break;
				case 22:
					natureMultiplier[4] = 1.1;
					natureMultiplier[5] = 0.9;
					break;
				case 23:
					natureMultiplier[4] = 1.1;
					natureMultiplier[3] = 0.9;
					break;
				case 24:
					natureMultiplier[0] = 1.0;
					natureMultiplier[1] = 1.0;
					natureMultiplier[2] = 1.0;
					natureMultiplier[3] = 1.0;
					natureMultiplier[4] = 1.0;
					natureMultiplier[5] = 1.0;
					break;
				}
				
				//Populate baseStats with stats of chosen Pokemon using combobox selection index
				baseStats[0] = pokeList.get(comboPokemon.getSelectionIndex()).getHpStat();
				baseStats[1] = pokeList.get(comboPokemon.getSelectionIndex()).getAtkStat();
				baseStats[2] = pokeList.get(comboPokemon.getSelectionIndex()).getDefStat();
				baseStats[3] = pokeList.get(comboPokemon.getSelectionIndex()).getSpaStat();
				baseStats[4] = pokeList.get(comboPokemon.getSelectionIndex()).getSpdStat();
				baseStats[5] = pokeList.get(comboPokemon.getSelectionIndex()).getSpeStat();

				//Stats calculated and set to appropriate text field
				textStatsHp.setText(String.valueOf((int)((((2 * baseStats[0] + ivs[0] + (evs[0] / 4)) * level) / 100) + level + 10)));
				textStatsAtk.setText(String.valueOf((int)(((((2 * baseStats[1] + ivs[1] + (evs[1] / 4)) * level) / 100) + 5) * natureMultiplier[1])));
				textStatsDef.setText(String.valueOf((int)(((((2 * baseStats[2] + ivs[2] + (evs[2] / 4)) * level) / 100) + 5) * natureMultiplier[2])));
				textStatsSpa.setText(String.valueOf((int)(((((2 * baseStats[3] + ivs[3] + (evs[3] / 4)) * level) / 100) + 5) * natureMultiplier[3])));
				textStatsSpd.setText(String.valueOf((int)(((((2 * baseStats[4] + ivs[4] + (evs[4] / 4)) * level) / 100) + 5) * natureMultiplier[4])));
				textStatsSpe.setText(String.valueOf((int)(((((2 * baseStats[5] + ivs[5] + (evs[5] / 4)) * level) / 100) + 5) * natureMultiplier[5])));
				
			}
		};
		btnCalculate.addListener(SWT.Selection, calculateListener);		
		
		//btnReset actionlistiner to let user reset everything
		Listener resetListener = new Listener() {
			public void handleEvent(Event event) {
				//Set calculate button to false
				btnCalculate.setText("SELECT POKEMON TO START");
				btnCalculate.setEnabled(false);
				//Reset everything to default values
				comboPokemon.deselectAll();
				comboNature.deselectAll();				
				level = 1;
				spinnerLevel.setSelection(level);
				spinnerIvHp.setSelection(0);
				spinnerIvAtk.setSelection(0);
				spinnerIvDef.setSelection(0);
				spinnerIvSpa.setSelection(0);
				spinnerIvSpd.setSelection(0);
				spinnerIvSpe.setSelection(0);
				spinnerEvHp.setSelection(0);
				spinnerEvAtk.setSelection(0);
				spinnerEvDef.setSelection(0);
				spinnerEvSpa.setSelection(0);
				spinnerEvSpd.setSelection(0);
				spinnerEvSpe.setSelection(0);
				textStatsHp.setText("");
				textStatsAtk.setText("");
				textStatsDef.setText("");
				textStatsSpa.setText("");
				textStatsSpd.setText("");
				textStatsSpe.setText("");
				for(int i = 0; i < 6; i++) 
				{
					ivs[i] = 0;
					evs[i] = 0;
					baseStats[i] = 0;
					natureMultiplier[i] = 1.0;
				}
			}
		};
		btnReset.addListener(SWT.Selection, resetListener);
	}
}
