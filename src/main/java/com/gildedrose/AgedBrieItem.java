package com.gildedrose;


public class AgedBrieItem extends GeneralItem {



    /*
        Surcharge de la Méthode de mise à jour de la qualité au bout d'une journée propre à l'Item Aged Brie
    */
    @Override
    public void updateQuality(Item item) {

        if (isUnderMaxQuality(item))
        {
            incrementQuality(item);
        }

        decrementSellIn(item);

        if (isSellInNegative(item))
        {
            if (isUnderMaxQuality(item))
            {
                incrementQuality(item);
            }
        }
    }
}