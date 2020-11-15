package com.gildedrose;

class GildedRose {
    static Item[] items;
	

 public GildedRose(Item[] items) {
        this.items = items;
    }


	/* Méthode pour obtenir une instance d'un Item du type dont il fait partie pour facilité leur mise à jour */

	private GeneralItem getItemtype(Item item) {
        switch (item.name)
	 		{
				case "Aged Brie":
					return new AgedBrieItem();
		
				case "Backstage passes to a TAFKAL80ETC concert":
					return new BackstageItem();
			
				case "Sulfuras, Hand of Ragnaros":
					return new LegendaryItem();
	        
			default:
			   if(item.name.startsWith("Conjured"))
					return new ConjuredItem();
				return new GeneralItem();
			}
	}
	
	/* Méthode pour executé la misa à jour propre aux item en fonction de leur type */
	public void updateQuality()
	{
		for (Item item: items)
		{
			GeneralItem generalItem = getItemtype(item);
			generalItem.updateQuality(item);
		}
	}

}
