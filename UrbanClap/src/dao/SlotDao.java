package dao;

import model.Slot;

public class SlotDao extends Dao<Slot, String> {
    private static SlotDao slotDao;
    private SlotDao() {
        super("id");
    }

    public static SlotDao getInstance() {
        if (slotDao == null) {
            slotDao = new SlotDao();
        }
        return slotDao;
    }
}
