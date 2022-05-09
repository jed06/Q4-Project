
public class HintQuestion {
	
	public boolean HasJewelry;
	public boolean HasHair;
	public boolean HasGlasses;
	public boolean HasHat;
	
	public String Text;
	
	public int Index = 0;
	
	public boolean IsAnswered;
	
	public HintQuestion(String text, boolean hasJewelry, boolean hasHair, boolean hasGlasses, boolean hasHat, int index) {
		Text = text;
		HasGlasses = hasGlasses;
		HasHair = hasHair;
		HasHat = hasHat;
		HasJewelry = hasJewelry;
		Index = index;
	}
	
}
