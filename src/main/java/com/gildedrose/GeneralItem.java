package com.gildedrose;


public class GeneralItem {

	/* On fixe la qualité max qu'un item peut avoir et qui sera commun à tout les items */
	protected static final int maxQuality= 50;


	/* Création des méthodes de test sur la qualité et le sellIn qui seront utilisé dans la méthode mise a jour des Item */
  public boolean isUnderMaxQuality(Item item) {
		return item.quality < maxQuality;
	}

	public boolean isSellInNegative(Item item) {
		return item.sellIn < 0;
	}

	public boolean isQualityPositive(Item item) {
		return item.quality > 0;
	}

	/* Création des méthodes d'incrémentation et décrementation de la qualité et le sellIn qui seront utilisé dans la méthode mise a jour des Item */

	public void decrementSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	public void incrementQuality(Item item) {
		item.quality = item.quality + 1;
	}

	public void decrementQuality(Item item) {
		item.quality = item.quality - 1;
    }
		
		/* Méthode de mise à jour commune a tout les items communs */

  public void updateQuality(Item item) {
        if (isQualityPositive(item)) 
			{
				decrementQuality(item);
			}

		decrementSellIn(item);

	  	if (isSellInNegative(item)) 
	  		{
				if (isQualityPositive(item)) 
				{
					decrementQuality(item);
	      		}
			}
  }
}