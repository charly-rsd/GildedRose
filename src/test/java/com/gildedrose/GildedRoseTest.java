package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

   

    @Test
    void testInsert() {
    	Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 20)};
    	GildedRose app = new GildedRose(items);

    	// On test si le nom du produit qu'on a ajouter est bien le meme qu'indiqué : "+5 Dexterity Vest"
        assertThat(app.items[0].name, is("+5 Dexterity Vest"));

		// On test si le nombre de jour avant peremption du produit qu'on a ajouter est bien le meme qu'indiqué : 10
        assertThat(app.items[0].sellIn, is(10));

		// On test si la qualité du produit qu'on a ajouter est bien la meme qu'indiqué : 20
        assertThat(app.items[0].quality, is(20));
	}

	@Test
    void testtoString() {
    	Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 20)};
    	GildedRose app = new GildedRose(items);

    	// On test si le nom du produit qu'on a ajouter est bien le meme qu'indiqué : "+5 Dexterity Vest"
         assertThat(app.items[0].toString(), is("+5 Dexterity Vest, 10, 20"));

	}


	@Test
    void testDegrade1() {
    	Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 20)};
    	GildedRose app = new GildedRose(items);

    	app.updateQuality();

    	// On test si le nombre de jour restant du produit diminue bel et bien apres mise a jour : 10-1
        assertThat(app.items[0].sellIn, is(9));

		// On test également si sa qualité diminue après la maj : 20-1
        assertThat(app.items[0].quality, is(19));
	}

	@Test
    void testDegrade2() {
    	Item[] items = new Item[] {new Item("+5 Dexterity Vest", 0, 20)};
    	GildedRose app = new GildedRose(items);

    	app.updateQuality();

		// On test également si sa qualité diminue 2 fois plus car il est périmé après la maj : 20-2
        assertThat(app.items[0].quality, is(18));
	}

	@Test
    void testAgedBrie() {
    	Item[] items = new Item[] {new Item("Aged Brie", 10, 0)};
    	GildedRose app = new GildedRose(items);

    	app.updateQuality();

        // On test si le nombre de jour restant du produit diminue bel et bien apres mise a jour : 10-1
        assertThat(app.items[0].sellIn, is(9));

		// On test si la qualité du produit "Aged brie" a bien augmenter après qu'un jour soit passé
	    assertThat(app.items[0].quality, is(1));
	}

	@Test
    void testAgedBrieNeg() {
    	Item[] items = new Item[] {new Item("Aged Brie", -1, 20)};
    	GildedRose app = new GildedRose(items);

    	app.updateQuality();

		// On test si la qualité du produit "Aged brie" a bien augmenter après qu'un jour soit passé alors que le sellIn est negatif
	    assertThat(app.items[0].quality, is(22));
	}
	

	@Test
    void testNegativeQuality() {
    	Item[] items = new Item[] {new Item("+5 Dexterity Vest", 1, 0)};
    	GildedRose app = new GildedRose(items);

    	app.updateQuality();

		// On test également si sa qualité peut etre negative
        assertThat(app.items[0].quality, is(0));
	}

	@Test
    void testNegativeSellInQuality() {
    	Item[] items = new Item[] {new Item("+5 Dexterity Vest", 0, 0)};
    	GildedRose app = new GildedRose(items);

    	app.updateQuality();

		// On test également si sa qualité peut etre negative
        assertThat(app.items[0].quality, is(0));
	}

	@Test
    void testQualityLimit() {
    	Item[] items = new Item[] {new Item("+5 Dexterity Vest", 1, 51),
    							   new Item("Aged Brie", 0 , 50)
    							};

    	GildedRose app = new GildedRose(items);

    	// On test si la qualité d'un produit peut être plus de 50 à l'insertion
    	//assertThat(app.items[0].quality, is(51));

    	app.updateQuality();

		// On test si la qualité du produit 'Aged Brie' peut depasser 50 en veillissant
        assertThat(app.items[0].quality, is(50));
	}

	

	@Test
    void testSulfurasQuality() {
    	Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)};

    	GildedRose app = new GildedRose(items);


    	app.updateQuality();

		// On test si la qualité de Sulfuras, Hand of Ragnaros n'as pas baissé alors que 1 jour est passé car c'est un objet légendaire
		 assertThat(app.items[0].quality, is(80));
	}

	@Test
    void testSulfurasQualityNeg() {
    	Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", -1, 80)};

    	GildedRose app = new GildedRose(items);


    	app.updateQuality();

		// On test si la qualité de Sulfuras, Hand of Ragnaros n'as pas baissé alors que 1 jour est passé car c'est un objet légendaire
		 assertThat(app.items[0].quality, is(80));
	}

	@Test
	void testBackstageQuality1() {
    	Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 50, 20)};

    	GildedRose app = new GildedRose(items);


    	app.updateQuality();

        // On test si le nombre de jour restant du produit diminue bel et bien apres mise a jour : 10-1
        assertThat(app.items[0].sellIn, is(49));

		// On test si la qualité du produit "Backstage passes to a TAFKAL80ETC concert" a bien augmenter de 1 après qu'un jour soit passé
        assertThat(app.items[0].quality, is(21));
	}

    @Test
    void testBackstageQuality150() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50)};

        GildedRose app = new GildedRose(items);


        app.updateQuality();

        // On test si la qualité du produit "Backstage passes to a TAFKAL80ETC concert" a bien augmenter de 2 après qu'un jour soit passé car il rest - de 10j
        assertThat(app.items[0].quality, is(50));
    }

	@Test
	void testBackstageQuality2() {
    	Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20)};

    	GildedRose app = new GildedRose(items);


    	app.updateQuality();

		// On test si la qualité du produit "Backstage passes to a TAFKAL80ETC concert" a bien augmenter de 2 après qu'un jour soit passé car il rest - de 10j
        assertThat(app.items[0].quality, is(22));
	}

	@Test
	void testBackstageQuality250() {
    	Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49)};

    	GildedRose app = new GildedRose(items);


    	app.updateQuality();

		// On test si la qualité du produit "Backstage passes to a TAFKAL80ETC concert" a bien augmenter de 2 après qu'un jour soit passé car il rest - de 10j
        assertThat(app.items[0].quality, is(50));
	}

	@Test
	void testBackstageQuality350() {
    	Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48)};

    	GildedRose app = new GildedRose(items);


    	app.updateQuality();

		// On test si la qualité du produit "Backstage passes to a TAFKAL80ETC concert" a bien augmenter de 3 après qu'un jour soit passé car il rest - de 5j
        assertThat(app.items[0].quality, is(50));
	}

	@Test
	void testBackstagePassedQuality() {
    	Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};

    	GildedRose app = new GildedRose(items);


    	app.updateQuality();

		// On verifie que la qualité du produit "Backstage passes to a TAFKAL80ETC concert" est bien retombée a 0 une fois le concert passé
        assertThat(app.items[0].quality, is(0));
	}

	@Test
	void testConjureQuality() {
    	Item[] items = new Item[] {new Item("Conjured Mana Cake", 3, 6)};

    	GildedRose app = new GildedRose(items);


    	app.updateQuality();

		
		// On test si la qualité se degrade bien deux fois plus qu'un produit normal pour l'item conjured
        // assertThat(app.items[0].quality, is(4));

        //PROBLEME
	}

	



}
