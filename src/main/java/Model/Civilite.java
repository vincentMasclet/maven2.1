package Model;

public enum Civilite {
	M("monsieur"),Mme("madame"),Mlle("mademoizelle");
	
	private String texte;

	private Civilite(String texte) {
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

}
