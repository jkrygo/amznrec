package pokedex;

public class Pokemon {
	
	public Pokemon(int nat, String pokemon, double height, double mass, int typeId1, int typeId2, int abilityId1,
			int abilityId2, int hiddenAbilityId, int eggGroupId1, int eggGroupId2, String gender, String hatch,
			int hpStat,	int atkStat, int defStat, int spaStat, int spdStat, int speStat, int catchRate, String color) {

		this.nat = nat;
		this.pokemon = pokemon;
		this.height = height;
		this.mass = mass;
		this.typeId1 = typeId1;
		this.typeId2 = typeId2;
		this.abilityId1 = abilityId1;
		this.abilityId2 = abilityId2;
		this.hiddenAbilityId = hiddenAbilityId;
		this.eggGroupId1 = eggGroupId1;
		this.eggGroupId2 = eggGroupId2;
		this.gender = gender;
		this.hatch = hatch;
		this.hpStat = hpStat;
		this.atkStat = atkStat;
		this.defStat = defStat;
		this.spaStat = spaStat;
		this.spdStat = spdStat;
		this.speStat = speStat;
		this.catchRate = catchRate;
		this.color = color;
	}
	
	int nat;
	String pokemon;
	double height;
	double mass;
	int typeId1;
	int typeId2;
	int abilityId1;
	int abilityId2;
	int hiddenAbilityId;
	int eggGroupId1;
	int eggGroupId2;
	String gender;
	String hatch;
	int hpStat;
	int atkStat;
	int defStat;
	int spaStat;
	int spdStat;
	int speStat;
	int catchRate;
	String color;
	
	public int getNat() {
		return nat;
	}
	public void setNat(int nat) {
		this.nat = nat;
	}
	public String getPokemon() {
		return pokemon;
	}
	public void setPokemon(String pokemon) {
		this.pokemon = pokemon;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public int getTypeId1() {
		return typeId1;
	}
	public void setTypeId1(int typeId1) {
		this.typeId1 = typeId1;
	}
	public int getTypeId2() {
		return typeId2;
	}
	public void setTypeId2(int typeId2) {
		this.typeId2 = typeId2;
	}
	public int getAbilityId1() {
		return abilityId1;
	}
	public void setAbilityId1(int abilityId1) {
		this.abilityId1 = abilityId1;
	}
	public int getAbilityId2() {
		return abilityId2;
	}
	public void setAbilityId2(int abilityId2) {
		this.abilityId2 = abilityId2;
	}
	public int getHiddenAbilityId() {
		return hiddenAbilityId;
	}
	public void setHiddenAbilityId(int hiddenAbilityId) {
		this.hiddenAbilityId = hiddenAbilityId;
	}
	public int getEggGroupId1() {
		return eggGroupId1;
	}
	public void setEggGroupId1(int eggGroupId1) {
		this.eggGroupId1 = eggGroupId1;
	}
	public int getEggGroupId2() {
		return eggGroupId2;
	}
	public void setEggGroupId2(int eggGroupId2) {
		this.eggGroupId2 = eggGroupId2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHatch() {
		return hatch;
	}
	public void setHatch(String hatch) {
		this.gender = hatch;
	}
	public int getHpStat() {
		return hpStat;
	}
	public void setHpStat(int hpStat) {
		this.hpStat = hpStat;
	}
	public int getAtkStat() {
		return atkStat;
	}
	public void setAtkStat(int atkStat) {
		this.atkStat = atkStat;
	}
	public int getDefStat() {
		return defStat;
	}
	public void setDefStat(int defStat) {
		this.defStat = defStat;
	}
	public int getSpaStat() {
		return spaStat;
	}
	public void setSpaStat(int spaStat) {
		this.spaStat = spaStat;
	}
	public int getSpdStat() {
		return spdStat;
	}
	public void setSpdStat(int spdStat) {
		this.spdStat = spdStat;
	}
	public int getSpeStat() {
		return speStat;
	}
	public void setSpeStat(int speStat) {
		this.speStat = speStat;
	}
	public int getCatchRate() {
		return catchRate;
	}
	public void setCatchRate(int catchRate) {
		this.catchRate = catchRate;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return nat + ". " +  pokemon;
	}
}
