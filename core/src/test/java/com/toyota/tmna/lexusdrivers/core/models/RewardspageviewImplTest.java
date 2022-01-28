package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.RewardspageviewImpl;
import org.junit.jupiter.api.Test;

public class RewardspageviewImplTest {

    RewardspageviewImpl rewardspageview;

    @Test
    void checkContainer() {
        rewardspageview = new RewardspageviewImpl();
        rewardspageview.getTitle();
        rewardspageview.getExportedItems();
        rewardspageview.getExportedItemsOrder();
        try{
            rewardspageview.getExportedType();
        } catch (NullPointerException e){}
    }
}
