package seedu.duke.commands;

import seedu.duke.data.Item;
import seedu.duke.data.ItemList;
import seedu.duke.exceptions.InvMgrException;
import seedu.duke.ui.Ui;
import seedu.duke.common.Messages;

import static seedu.duke.parser.CliSyntax.PREFIX_ITEM_INDEX;
import static seedu.duke.parser.CliSyntax.PREFIX_QUANTITY;

public class LostCommand extends Command {
    private int itemIndex;
    private int itemQuantity;
    public static final String COMMAND_WORD = "lost";
    public static final String COMMAND_NAME = "Report Lost Item";
    public static final String USAGE_MESSAGE = "Marks item as lost";
    public static final String COMMAND_FORMAT = COMMAND_WORD + " " + PREFIX_ITEM_INDEX + "[item number] "
            + PREFIX_QUANTITY + "[item quantity]";
    public static final String HELP_MESSAGE = COMMAND_NAME + ":\n"
            + "[Function] "
            + USAGE_MESSAGE
            + ":\n"
            + "[Command Format] "
            + COMMAND_FORMAT
            + "\n";

    /**
     * Prepares the lost command for execution by extracting the task number of the task to be marked.
     *
     * @param itemIndex Index of item to be marked as lost
     */
    public LostCommand(int itemIndex, int itemQuantity) {
        this.itemIndex = itemIndex;
        this.itemQuantity = itemQuantity;
    }

    protected static boolean checkItemListSize() {
        if (ItemList.getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Marks an item in ItemList.itemArrayList as list
     * Updates the lost status in the user's item list file in the user's hard disk
     *
     * @param itemList Manages the user's task list
     * @param ui Displays messages to the user
     */
    @Override
    public void execute(ItemList itemList, Ui ui) throws InvMgrException {
        boolean isEmptyItemList = checkItemListSize();
        if (isEmptyItemList) {
            throw new InvMgrException(Messages.EMPTY_ITEM_LIST_MESSAGE);
        }
        Item lostItem = null;
        try {
            lostItem = itemList.getItem(itemIndex);
        } catch (IndexOutOfBoundsException e) {
            ui.showMessages(Messages.ITEM_NUMBER_OUT_OF_RANGE_MESSAGE);
            ui.showDivider();
            return;
        }
        int updatedItemQuantity = lostItem.getQuantity() - itemQuantity;
        if (updatedItemQuantity > 0) {
            lostItem.setQuantity(updatedItemQuantity);
            ui.showMessages(Messages.REPORTED_LOST_MESSAGE);
            System.out.println(lostItem);
        } else if (updatedItemQuantity == 0) {
            System.out.println("delete command item index is " + itemIndex);
            DeleteCommand deleteCommand = new DeleteCommand(itemIndex);
            deleteCommand.execute(itemList, ui);
            ui.showMessages(Messages.REPORTED_LOST_AND_DELETED_MESSAGE);
        } else {
            throw new InvMgrException(Messages.LOST_ERROR_MESSAGE);
        }
        ui.showDivider();
    }

}
