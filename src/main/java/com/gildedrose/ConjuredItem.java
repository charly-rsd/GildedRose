package com.gildedrose;



public class ConjuredItem extends GeneralItem {

/*
      Surcharge de la méthode de mise à jour de la qualité au bout d'une journée propre à l'Item Conjured
*/
@Override
public void updateQuality(Item item) {
    if ( isQualityPositive(item) ) 
        {
            decrementQuality(item);
            decrementQuality(item);
        }

    decrementSellIn(item);

      if ( isSellInNegative(item) ) 
          {
            if ( isQualityPositive(item) ) 
            {
                decrementQuality(item);
                decrementQuality(item);
              }
        }
}

}