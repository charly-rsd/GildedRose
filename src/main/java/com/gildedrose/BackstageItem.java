package com.gildedrose;


public class BackstageItem extends GeneralItem {

	/*
      Surcharge de la méthode de mise à jour de la qualité au bout d'une journée propre à l'Item BackStage
  */
	@Override
    public void updateQuality(Item item) {

    if (isUnderMaxQuality(item))
		{
      incrementQuality(item);
	  }

	  if ( item.sellIn < 11 ) 
		{
		  if ( isUnderMaxQuality(item) )
	  	{
	        incrementQuality(item);
	    }
    }


	  if ( item.sellIn < 6 )
		{
        if ( isUnderMaxQuality(item)) 
        {
	         	incrementQuality(item);
	      }
	  }


		decrementSellIn(item);


			if ( isSellInNegative(item) )
			{
				item.quality = item.quality - item.quality;
			}	
    }	
}
