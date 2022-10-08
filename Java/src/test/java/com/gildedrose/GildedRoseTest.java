//package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    // basic happy path test, make sure added item actually gets added.
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    // this time, make sure two items are added
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("one", 0, 0), new Item("two", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("two", app.items[1].name);
    }

    // The aged brie should increase in quality by one instead of decrease
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Aged Brie", 999, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    // make sure the quality doesn't increase pass 50
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Aged Brie", 999, 10) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 100; i ++){
            app.updateQuality();
        }
        assertEquals(50, app.items[0].quality);
    }

    // Ensure the legendary item doesn't change rarity
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 999, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    // Boundary Test, make sure it doesn't change even after 10,0000 days, well after its sellIn value
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 999, 80) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 10000; i ++){
            app.updateQuality();
        }
        assertEquals(80, app.items[0].quality);
    }

    // Another boundary test, the quality of a regular item should decrease, but should never be negative
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("A Gun", 10000, 9997) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 9999; i ++){
            app.updateQuality();
        }
        assertEquals(0, app.items[0].quality);
    }

    // Negative test, make sure the ticket doesn't only increase in quality by 1 when there's 10 days left
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertNotEquals(11, app.items[0].quality);
    }

    // Same as last test, but the quality should increase by 3, not 2 when there's 5 or fewer days left
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertNotEquals(12, app.items[0].quality);
    }

    // finally, ensure that the quality drops immediately to zero after the sellIn date.
    @Test
    void foo() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 6; i ++) {
            app.updateQuality();
        }
        assertNotEquals(28, app.items[0].quality);
    }

}
