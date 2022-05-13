package com.atom596.ages.stone.entities;

import net.minecraft.entity.Entity;

import javax.annotation.Nonnull;

interface IBecomeAngry {
    boolean becomeAngryAt(@Nonnull Entity entity);
    boolean isAngry();
}
