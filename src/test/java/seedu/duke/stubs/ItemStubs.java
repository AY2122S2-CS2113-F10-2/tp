package seedu.duke.stubs;

import seedu.duke.data.Item;

public class ItemStubs {

    public static final String PENCIL_NAME = "Pencil";
    public static final int PENCIL_QUANTITY = 3;
    public static final String PENCIL_DESCRIPTION = "Drawing";
    public static final Item ITEM_PENCIL = generateItem(PENCIL_NAME, PENCIL_QUANTITY, PENCIL_DESCRIPTION);

    public static final String MARKER_NAME = "Markers";
    public static final int MARKER_QUANTITY = 3;
    public static final String MARKER_DESCRIPTION = "Drawing";
    public static final Item ITEM_MARKER = generateItem(MARKER_NAME, MARKER_QUANTITY, MARKER_DESCRIPTION);

    public static final String PAPER_NAME = "Paper";
    public static final int PAPER_QUANTITY_10 = 10;
    public static final int PAPER_QUANTITY_15 = 15;
    public static final String A4_PAPER_DESCRIPTION = "A4 stacks of 30";
    public static final String A5_PAPER_DESCRIPTION = "A5 stacks of 30";
    public static final Item ITEM_PAPER_A4_10 = generateItem(PAPER_NAME, PAPER_QUANTITY_10, A4_PAPER_DESCRIPTION);
    public static final Item ITEM_PAPER_A5_10 = generateItem(PAPER_NAME, PAPER_QUANTITY_10, A5_PAPER_DESCRIPTION);
    public static final Item ITEM_PAPER_A4_15 = generateItem(PAPER_NAME, PAPER_QUANTITY_15, A4_PAPER_DESCRIPTION);
    public static final Item ITEM_PAPER_A5_15 = generateItem(PAPER_NAME, PAPER_QUANTITY_15, A5_PAPER_DESCRIPTION);


    public static final String HDMI_CABLE_NAME = "HDMI Cable";
    public static final int HDMI_CABLE_QUANTITY = 2;
    public static final String HDMI_CABLE_DESCRIPTION = "For connecting displays";
    public static final Item ITEM_HDMI = generateItem(HDMI_CABLE_NAME, HDMI_CABLE_QUANTITY, HDMI_CABLE_DESCRIPTION);

    public static final String WHITEBOARD_NAME = "Whiteboard";
    public static final int WHITEBOARD_QUANTITY = 1;
    public static final String WHITEBOARD_DESCRIPTION = "To draw on";
    public static final Item ITEM_WHITEBOARD = generateItem(WHITEBOARD_NAME, WHITEBOARD_QUANTITY,
            WHITEBOARD_DESCRIPTION);

    /**
     * Generate an {@code Item}.
     * @param name name of Item
     * @param quantity quantity of Item
     * @param description description of Item
     * @return Item matching the given arguments
     */
    private static Item generateItem(String name, int quantity, String description) {
        return new Item(name, quantity, description);
    }
}
