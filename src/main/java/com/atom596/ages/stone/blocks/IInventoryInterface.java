package com.atom596.ages.stone.blocks;

import net.minecraft.inventory.IInventory;

import javax.annotation.Nonnull;

interface IInventoryInterface {
    @Nonnull
    IInventory getInventory();
}
