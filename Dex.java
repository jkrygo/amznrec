package pokedex;

import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.ProgressBar;

public class Dex {

	protected Shell shlDex;
	private String[] comboOptions = new String[151];
	private ArrayList<Pokemon> pokeList = new ArrayList<>();
	private ArrayList<String> typeList = new ArrayList<>();
	private ArrayList<String> abilityList = new ArrayList<>();
	private ArrayList<String> hiddenList = new ArrayList<>();
	private ArrayList<String> eggList = new ArrayList<>();
	
	public Dex() {
		
	}
	
	public Dex(ArrayList<Pokemon> pokemonList, ArrayList<String> typeList, ArrayList<String> abilityList,
			   ArrayList<String> hiddenList, ArrayList<String> eggList) {
		this.pokeList = pokemonList;
		this.typeList = typeList;
		this.abilityList = abilityList;
		this.hiddenList = hiddenList;
		this.eggList = eggList;
		
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
			Dex window = new Dex();
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
		shlDex.open();
		shlDex.layout();
		while (!shlDex.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDex = new Shell();
		shlDex.setSize(500,400);
		shlDex.setText("Pokédex");
		
		Combo comboPokemon = new Combo(shlDex, SWT.NONE);
		comboPokemon.setVisibleItemCount(15);
		comboPokemon.setBounds(11, 31, 464, 23);
		comboPokemon.setItems(comboOptions);
		
		Label lblPokemon = new Label(shlDex, SWT.NONE);
		lblPokemon.setBounds(10, 10, 66, 15);
		lblPokemon.setText("POKEMON");
		
		Label lblSprite = new Label(shlDex, SWT.NONE);
		lblSprite.setBounds(184, 58, 136, 136);
		
		Label lblTypes = new Label(shlDex, SWT.NONE);
		lblTypes.setBounds(215, 200, 88, 15);
		lblTypes.setText("Type(s):");
		
		Label lblAbilities = new Label(shlDex, SWT.NONE);
		lblAbilities.setText("Ability(s):");
		lblAbilities.setBounds(215, 221, 88, 15);
		
		Label lblHiddenAbility = new Label(shlDex, SWT.NONE);
		lblHiddenAbility.setText("Hidden Ability:");
		lblHiddenAbility.setBounds(215, 242, 88, 15);
		
		Label lblEggGroup = new Label(shlDex, SWT.NONE);
		lblEggGroup.setText("Egg Group(s):");
		lblEggGroup.setBounds(215, 263, 88, 15);
		
		Label lblTypesVal = new Label(shlDex, SWT.NONE);
		lblTypesVal.setText("---");
		lblTypesVal.setAlignment(SWT.RIGHT);
		lblTypesVal.setBounds(309, 200, 166, 15);
		
		Label lblAbilitiesVal = new Label(shlDex, SWT.NONE);
		lblAbilitiesVal.setText("---");
		lblAbilitiesVal.setAlignment(SWT.RIGHT);
		lblAbilitiesVal.setBounds(309, 221, 166, 15);
		
		Label lblHiddenAbilityVal = new Label(shlDex, SWT.NONE);
		lblHiddenAbilityVal.setText("---");
		lblHiddenAbilityVal.setAlignment(SWT.RIGHT);
		lblHiddenAbilityVal.setBounds(309, 242, 166, 15);
		
		Label lblEggGroupsVal = new Label(shlDex, SWT.NONE);
		lblEggGroupsVal.setText("---");
		lblEggGroupsVal.setAlignment(SWT.RIGHT);
		lblEggGroupsVal.setBounds(309, 263, 166, 15);
		
		Label lblHeight = new Label(shlDex, SWT.NONE);
		lblHeight.setBounds(215, 297, 42, 15);
		lblHeight.setText("Height:");
		
		Label lblWeight = new Label(shlDex, SWT.NONE);
		lblWeight.setText("Weight:");
		lblWeight.setBounds(215, 318, 42, 15);
		
		Label lblColor = new Label(shlDex, SWT.NONE);
		lblColor.setText("Color:");
		lblColor.setBounds(215, 339, 42, 15);
		
		Label lblCatchRate = new Label(shlDex, SWT.NONE);
		lblCatchRate.setBounds(349, 297, 66, 15);
		lblCatchRate.setText("Catch Rate:");
		
		Label lblGenderRate = new Label(shlDex, SWT.NONE);
		lblGenderRate.setText("Gender Rate:");
		lblGenderRate.setBounds(342, 318, 73, 15);
		
		Label lblHatchSteps = new Label(shlDex, SWT.NONE);
		lblHatchSteps.setText("Hatch Steps:");
		lblHatchSteps.setBounds(342, 339, 73, 15);
		
		Label lblHeightVal = new Label(shlDex, SWT.NONE);
		lblHeightVal.setAlignment(SWT.RIGHT);
		lblHeightVal.setBounds(270, 297, 45, 15);
		lblHeightVal.setText("---");
		
		Label lblWeightVal = new Label(shlDex, SWT.NONE);
		lblWeightVal.setAlignment(SWT.RIGHT);
		lblWeightVal.setText("---");
		lblWeightVal.setBounds(270, 318, 45, 15);
		
		Label lblColorVal = new Label(shlDex, SWT.NONE);
		lblColorVal.setText("---");
		lblColorVal.setAlignment(SWT.RIGHT);
		lblColorVal.setBounds(270, 339, 45, 15);
		
		Label lblCatchRateVal = new Label(shlDex, SWT.NONE);
		lblCatchRateVal.setText("---");
		lblCatchRateVal.setAlignment(SWT.RIGHT);
		lblCatchRateVal.setBounds(421, 297, 54, 15);
		
		Label lblGenderRateVal = new Label(shlDex, SWT.NONE);
		lblGenderRateVal.setText("---");
		lblGenderRateVal.setAlignment(SWT.RIGHT);
		lblGenderRateVal.setBounds(421, 318, 54, 15);
		
		Label lblHatchStepsVal = new Label(shlDex, SWT.NONE);
		lblHatchStepsVal.setText("---");
		lblHatchStepsVal.setAlignment(SWT.RIGHT);
		lblHatchStepsVal.setBounds(421, 339, 54, 15);
		
		Label lblStats = new Label(shlDex, SWT.NONE);
		lblStats.setBounds(11, 176, 38, 15);
		lblStats.setText("STATS");
		
		Label lblHp = new Label(shlDex, SWT.NONE);
		lblHp.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblHp.setBounds(11, 200, 20, 15);
		lblHp.setText("HP");
		
		Label lblAtk = new Label(shlDex, SWT.NONE);
		lblAtk.setForeground(SWTResourceManager.getColor(0, 102, 255));
		lblAtk.setBounds(11, 227, 21, 15);
		lblAtk.setText("ATK");
		
		Label lblDef = new Label(shlDex, SWT.NONE);
		lblDef.setForeground(SWTResourceManager.getColor(0, 153, 51));
		lblDef.setBounds(11, 255, 21, 15);
		lblDef.setText("DEF");
		
		Label lblSpa = new Label(shlDex, SWT.NONE);
		lblSpa.setForeground(SWTResourceManager.getColor(0, 0, 204));
		lblSpa.setBounds(11, 283, 21, 15);
		lblSpa.setText("SpA");
		
		Label lblSpd = new Label(shlDex, SWT.NONE);
		lblSpd.setForeground(SWTResourceManager.getColor(0, 102, 0));
		lblSpd.setBounds(11, 311, 21, 15);
		lblSpd.setText("SpD");
		
		Label lblSpe = new Label(shlDex, SWT.NONE);
		lblSpe.setForeground(SWTResourceManager.getColor(255, 0, 153));
		lblSpe.setBounds(11, 339, 21, 15);
		lblSpe.setText("Spe");
		
		Label lblHpStat = new Label(shlDex, SWT.NONE);
		lblHpStat.setAlignment(SWT.RIGHT);
		lblHpStat.setBounds(51, 200, 20, 15);
		lblHpStat.setText("---");
		
		Label lblAtkStat = new Label(shlDex, SWT.NONE);
		lblAtkStat.setAlignment(SWT.RIGHT);
		lblAtkStat.setBounds(51, 227, 21, 15);
		lblAtkStat.setText("---");
		
		Label lblDefStat = new Label(shlDex, SWT.NONE);
		lblDefStat.setAlignment(SWT.RIGHT);
		lblDefStat.setText("---");
		lblDefStat.setBounds(51, 255, 21, 15);
		
		Label lblSpaStat = new Label(shlDex, SWT.NONE);
		lblSpaStat.setAlignment(SWT.RIGHT);
		lblSpaStat.setText("---");
		lblSpaStat.setBounds(51, 283, 21, 15);
		
		Label lblSpdStat = new Label(shlDex, SWT.NONE);
		lblSpdStat.setAlignment(SWT.RIGHT);
		lblSpdStat.setText("---");
		lblSpdStat.setBounds(51, 311, 21, 15);

		Label lblSpeStat = new Label(shlDex, SWT.NONE);
		lblSpeStat.setAlignment(SWT.RIGHT);
		lblSpeStat.setText("---");
		lblSpeStat.setBounds(51, 339, 21, 15);
		
		ProgressBar progressHp = new ProgressBar(shlDex, SWT.NONE);
		progressHp.setMaximum(250);
		progressHp.setBounds(75, 200, 116, 17);
		
		ProgressBar progressAtk = new ProgressBar(shlDex, SWT.NONE);
		progressAtk.setMaximum(250);
		progressAtk.setBounds(75, 227, 116, 17);
		
		ProgressBar progressDef = new ProgressBar(shlDex, SWT.NONE);
		progressDef.setMaximum(250);
		progressDef.setBounds(75, 255, 116, 17);
		
		ProgressBar progressSpa = new ProgressBar(shlDex, SWT.NONE);
		progressSpa.setMaximum(250);
		progressSpa.setBounds(75, 283, 116, 17);
		
		ProgressBar progressSpd = new ProgressBar(shlDex, SWT.NONE);
		progressSpd.setMaximum(250);
		progressSpd.setBounds(75, 311, 116, 17);
		
		ProgressBar progressSpe = new ProgressBar(shlDex, SWT.NONE);
		progressSpe.setMaximum(250);
		progressSpe.setBounds(75, 339, 116, 17);
		
		Listener comboPokemonListener = new Listener() {
			public void handleEvent(Event event) {
				if(comboPokemon.getSelectionIndex() > -1)
				{
					//Update sprite
					lblSprite.setImage(SWTResourceManager.getImage("C:\\Users\\jkryg\\eclipse-workspace\\pokedex\\sprites\\" + (comboPokemon.getSelectionIndex() + 1) + ".png"));
					//Update base stats
					lblHpStat.setText(Integer.toString(pokeList.get(comboPokemon.getSelectionIndex()).getHpStat()));
					lblAtkStat.setText(Integer.toString(pokeList.get(comboPokemon.getSelectionIndex()).getAtkStat()));
					lblDefStat.setText(Integer.toString(pokeList.get(comboPokemon.getSelectionIndex()).getDefStat()));
					lblSpaStat.setText(Integer.toString(pokeList.get(comboPokemon.getSelectionIndex()).getSpaStat()));
					lblSpdStat.setText(Integer.toString(pokeList.get(comboPokemon.getSelectionIndex()).getSpdStat()));
					lblSpeStat.setText(Integer.toString(pokeList.get(comboPokemon.getSelectionIndex()).getSpeStat()));
					
					//Update progress bar
					progressHp.setSelection(pokeList.get(comboPokemon.getSelectionIndex()).getHpStat());
					progressAtk.setSelection(pokeList.get(comboPokemon.getSelectionIndex()).getAtkStat());
					progressDef.setSelection(pokeList.get(comboPokemon.getSelectionIndex()).getDefStat());
					progressSpa.setSelection(pokeList.get(comboPokemon.getSelectionIndex()).getSpaStat());
					progressSpd.setSelection(pokeList.get(comboPokemon.getSelectionIndex()).getSpdStat());
					progressSpe.setSelection(pokeList.get(comboPokemon.getSelectionIndex()).getSpeStat());
					
					//Update general info
					lblTypesVal.setText(typeGet(pokeList.get(comboPokemon.getSelectionIndex()).getTypeId1(), pokeList.get(comboPokemon.getSelectionIndex()).getTypeId2(), typeList));
					lblAbilitiesVal.setText(abilityGet(pokeList.get(comboPokemon.getSelectionIndex()).getAbilityId1(), pokeList.get(comboPokemon.getSelectionIndex()).getAbilityId2(), abilityList));
					lblHiddenAbilityVal.setText(hiddenGet(pokeList.get(comboPokemon.getSelectionIndex()).getHiddenAbilityId(), hiddenList));
					lblEggGroupsVal.setText(eggGet(pokeList.get(comboPokemon.getSelectionIndex()).getEggGroupId1(), pokeList.get(comboPokemon.getSelectionIndex()).getEggGroupId2(), eggList));

					lblHeightVal.setText(Double.toString(pokeList.get(comboPokemon.getSelectionIndex()).getHeight()) + "m");
					lblWeightVal.setText(Double.toString(pokeList.get(comboPokemon.getSelectionIndex()).getMass()) + "kg");
					lblCatchRateVal.setText(Integer.toString(pokeList.get(comboPokemon.getSelectionIndex()).getCatchRate()));
					lblGenderRateVal.setText(pokeList.get(comboPokemon.getSelectionIndex()).getGender());
					lblColorVal.setText(pokeList.get(comboPokemon.getSelectionIndex()).getColor());
					
					//If hatch steps null, update to default text value
					if (pokeList.get(comboPokemon.getSelectionIndex()).getHatch() != null)
					{
						lblHatchStepsVal.setText(pokeList.get(comboPokemon.getSelectionIndex()).getHatch());
					}
					else
					{
						lblHatchStepsVal.setText("---");
					}
				}
				}
			};
		comboPokemon.addListener(SWT.Selection, comboPokemonListener);
	}
	
	public String typeGet(int typeId1, int typeId2, ArrayList<String> typeList) {
		String type1 = typeList.get(typeId1 - 1);
		String type2 = null;
		if((typeId2 - 1) >= 0)
			type2 = typeList.get(typeId2 - 1);
		
		if(type2 == null)
			return type1;
		else
			return type1 + "/" + type2;
	}
	
	public String abilityGet(int abilityId1, int abilityId2, ArrayList<String> abilityList) {
		String ability1 = abilityList.get(abilityId1 - 1);
		String ability2 = null;
		if((abilityId2 - 1) >= 0)
			ability2 = abilityList.get(abilityId2 - 1);
		
		if(ability2 == null)
			return ability1;
		else
			return ability1 + "/" + ability2;
	}
	
	public String hiddenGet(int hiddenId, ArrayList<String> hiddenList) {
		String hidden = null;
		if((hiddenId - 1) >= 0)
			hidden = hiddenList.get(hiddenId - 1);
				
		if(hidden != null)
			return hidden;
		else
			return "---";
	}
	
	public String eggGet(int eggId1, int eggId2, ArrayList<String> eggList) {
		String egg1 = eggList.get(eggId1 - 1);
		String egg2 = null;
		if((eggId2 - 1) >= 0)
			egg2 = eggList.get(eggId2 - 1);
		
		if(egg2 == null)
			return egg1;
		else
			return egg1 + "/" + egg2;
	}
}

