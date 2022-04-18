
public class HintQuestion {
	
	public boolean HasJewlery;
	public boolean HasHair;
	public boolean HasGlasses;
	public boolean HasHat;
	
	public String Text;
	
	public int Index = 0;
	
	public boolean IsAnswered;
	
	public HintQuestion(String text, boolean hasJewlery, boolean hasHair, boolean hasGlasses, boolean hasHat, int index) {
		Text = text;
		HasGlasses = hasGlasses;
		HasHair = hasHair;
		HasHat = hasHat;
		HasJewlery = hasJewlery;
		Index = index;
	}
	
}
