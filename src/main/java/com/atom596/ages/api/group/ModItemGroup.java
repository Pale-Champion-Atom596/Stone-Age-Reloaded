package com.atom596.ages.api.group;

import com.atom596.ages.api.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ModItemGroup extends ItemGroup {
    public static final ItemGroup AGES = new ModItemGroup();

    ModItemGroup() {
        super(Reference.MODID);
    }

    @Override
    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(ModIcon.icon);
    }
}
