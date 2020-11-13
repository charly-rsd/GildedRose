package com.gildedrose;

class GildedRose {
    Item[] items;
	int maxQuality;

    public GildedRose(Item[] items) {
        this.items = items;
		this.maxQuality = 50;
    }


	public void is_under_max_Quality(Item item){
		return item.quality < maxQuality;
	}

	public void is_sellIn_negative(Item item){
		return item.sellIn < 0;
	}

	public void is_quality_positive(Item item){
		return item.quality > 0;
	}

	public void decrement_sellIn(Item item){
		item.sellIn = item.sellIn - 1;
	}

	public void increment_quality(Item item){
		item.quality = item.quality + 1;
	}

	public void decrement_quality(Item item){
		item.quality = item.quality - 1;
	}

    /**
  	* La méthode update_Aged_Brie met à jour l'objet Aged brie
  	* qualité +1 si sellIn supérieur à 0
  	* qualité +2 sinon
	* @param i le numéro de l'item à traiter dans la liste
	*/
	public void update_Aged_Brie(Item item) 
	{
			

		    if ( is_under_max_Quality(item) ) 
		    {
		    	increment_quality(item);
			}

			decrement_sellIn(item)

		    if ( is_sellIn_negative(item) ) 
		    {
				if ( is_under_max_Quality(item) ) 
				{
	                increment_quality(item);
	           	}
			}			

	}

	

	/**
  	* La méthode update_Common_Item met à jour les objets communs
  	* qualité -1 si sellIn supérieur à 0
  	* qualité -2 sinon
	* @param i le numéro de l'item à traiter dans la liste
	*/
	public void update_Common_Item(Item item)
	{		
			
			

			if ( is_quality_positive(item) ) 
			{
				decrement_quality(item);
			}

			decrement_sellIn(item)

	  		if ( is_sellIn_negative(item) ) 
	  		{
				if ( is_quality_positive(item) ) 
				{
					decrement_quality(item);
	      		}
			}
	}


	/**
  	* La méthode update_Backstage met à jour l'objet Aged brie
  	* qualité +1 si sellIn supérieur à 10
  	* qualité +2 si sellIn entre 5 et 10
  	* qualité +3 si sellIn entre 0 et 5
  	* qualité = 0 si sellIn à 0
	* @param i le numéro de l'item à traiter dans la liste
	*/

	public void update_Backstage (Item item)
	{
			if ( is_under_max_Quality(item))
			{
	            increment_quality(item);
	        }

	        if ( item.sellIn < 11 ) 
			{
	      		if ( is_under_max_Quality(item) )
	      		{
	        	    increment_quality(item);
	            }
	        }


	        if ( item.sellIn < 6 )
			{
	        	if ( is_under_max_Quality(item)) 
	        	{
	            	increment_quality(item);
	            }
	        }


			decrement_sellIn(item)


			if ( is_sellIn_negative(item) )
			{
				item.quality = item.quality - item.quality;
			}
	}

	/**
  	* La méthode updateQuality appelle la fonction de mise à jour correspondant à l'item traité
	*/
	public void updateQuality()
	{
		for ( Item item: items)
		{
	 		switch (items.name)
	 		{

				case "Aged Brie":
					update_Aged_Brie(item);
					break;
		
				case "Backstage passes to a TAFKAL80ETC concert":
					update_Backstage(item);
					break;
			
				case "Sulfuras, Hand of Ragnaros":
					break;
	        
	        default:
	        	update_Common_Item(item);
			}
		}
	}

}
