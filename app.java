package pokedex;

import java.sql.*;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Listener;

public class app {
	
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	static PreparedStatement updateField = null;

	public static void main(String[] args) {
		
		//ArrayList to hold data
		ArrayList<Pokemon> pokemonList = new ArrayList<>();
		ArrayList<String> typeList = new ArrayList();
		ArrayList<String> abilityList = new ArrayList();
		ArrayList<String> hiddenList = new ArrayList();
		ArrayList<String> eggList = new ArrayList();
		
		//Connect to DB and fill ArrayList with data
    	try {
			String msAccDB = "Pokemon.mdb";
			String dbURL = "jdbc:ucanaccess://" + msAccDB;
			
			// Create connection using DriverManager
			connection = DriverManager.getConnection(dbURL,"","");
			
			// Create JDBC statement
			statement = connection.createStatement();
			
			// Load Pokemon data into ResultSet via SQL
			resultSet = statement.executeQuery("SELECT Nat, Pokemon, Height_m, Mass_kg"
					+ ", TypeID_I, TypeID_II, AbilityID_I, AbilityID_II, HiddenAbilityID"
					+ ", EggGroupID_I, EggGroupID_II, Gender, Hatch, Hp, Atk, Def, SpA, SpD"
					+ ", Spe, Catch, Color FROM gen1");
			
			//Process/Load data into pokeList
			while(resultSet.next()) {
				Pokemon pokemon = new Pokemon(resultSet.getInt("Nat"), resultSet.getString("Pokemon"), resultSet.getDouble("Height_m"),
						resultSet.getDouble("Mass_kg"), resultSet.getInt("TypeID_I"), resultSet.getInt("TypeID_II"), 
						resultSet.getInt("AbilityID_I"), resultSet.getInt("AbilityID_II"), resultSet.getInt("HiddenAbilityID"),
						resultSet.getInt("EggGroupID_I"), resultSet.getInt("EggGroupID_II"), resultSet.getString("Gender"), resultSet.getString("Hatch"),
						resultSet.getInt("Hp"),	resultSet.getInt("Atk"), resultSet.getInt("Def"), resultSet.getInt("SpA"), resultSet.getInt("SpD"),
						resultSet.getInt("Spe"), resultSet.getInt("Catch"), resultSet.getString("Color"));
				
				pokemonList.add(pokemon);
			}
			
			//Load Type data into ResultSet via SQL
			resultSet = statement.executeQuery("SELECT TypeName FROM Types1");
			
			//Process/Load data into typeList
			while(resultSet.next()) {
				typeList.add(resultSet.getString("TypeName"));
			}
			
			//Load Ability data into ResultSet via SQL
			resultSet = statement.executeQuery("SELECT AbilityName FROM Abilities1");
			
			//Process/Load data into abilityList
			while(resultSet.next()) {
				abilityList.add(resultSet.getString("AbilityName"));
			}
			
			//Load Hidden Ability data into ResultSet via SQL
			resultSet = statement.executeQuery("SELECT AbilityName FROM HiddenAbilities ORDER BY HiddenID ASC");
			
			//Process/Load data into hiddenList
			while(resultSet.next()) {
				hiddenList.add(resultSet.getString("AbilityName"));
			}
			
			//Load Egg Group data into ResultSet via SQL
			resultSet = statement.executeQuery("SELECT EggGroup FROM EggGroups1");
			
			//Process/Load data into eggList
			while(resultSet.next()) {
				eggList.add(resultSet.getString("EggGroup"));
			}
			
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			//Close database connection
			try {
				if(connection != null) {
					resultSet.close();
					statement.close();
					connection.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
			
		//Generate window
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(300, 300);
		shell.setText("PokéCalc");
		
		//Pokedex Button
		final Button btnPokedex = new Button(shell, SWT.NONE);
		btnPokedex.setBounds(10, 10, 264, 75);
		btnPokedex.setText("Pokédex");
		
		//btnPokedex actionlistener
	    Listener pokedexListener = new Listener() {
	        public void handleEvent(Event event) {
	        	Dex dex = new Dex(pokemonList, typeList, abilityList, hiddenList, eggList);
	        	dex.open();
	        }
	      };
	    btnPokedex.addListener(SWT.Selection, pokedexListener);
	    
		//Stat Calculator Button
		final Button btnStatCalculator = new Button(shell, SWT.NONE);
		btnStatCalculator.setText("Stat Calculator");
		btnStatCalculator.setBounds(10, 91, 264, 75);
		
		//btnStatCalculator actionlistener
	    Listener statCalculatorListener = new Listener() {
	        public void handleEvent(Event event) {
	        	StatCalc calc = new StatCalc(pokemonList);
	        	calc.open();
	        }
	      };	
	    btnStatCalculator.addListener(SWT.Selection, statCalculatorListener);
	    
	    final Button btnQuit = new Button(shell, SWT.NONE);
	    btnQuit.setText("Quit");
	    btnQuit.setBounds(10, 172, 264, 75);
	    
	    //btnQuit actionlistener
	    Listener quitListener = new Listener() {
	    	public void handleEvent(Event event) {
	    		System.exit(0);
	    	}
	    };
	    btnQuit.addListener(SWT.Selection, quitListener);
	    
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}
}
