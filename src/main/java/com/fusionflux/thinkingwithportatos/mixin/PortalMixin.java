package com.fusionflux.thinkingwithportatos.mixin;

import com.fusionflux.thinkingwithportatos.ThinkingWithPortatos;
import com.qouteall.immersive_portals.portal.Portal;
import com.qouteall.immersive_portals.portal.PortalLike;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Portal.class)
public abstract class PortalMixin extends Entity implements PortalLike {

    public PortalMixin(EntityType<?> type, World world) {
        super(type, world);
        throw new AssertionError(
                ThinkingWithPortatos.MODID + "'s PortalMixin constructor was called, something is very wrong!"
        );
    }

    @Shadow
    public abstract Vec3d transformLocalVec(Vec3d localVec);

    @Inject(method = "transformVelocity", at = @At("TAIL"), cancellable = true,remap = false)
    public void transformVelocity(Entity entity, CallbackInfo ci) {
        //double velocityScalar = ((VelocityTransfer) entity).getVelocityTransfer();
        //entity.setVelocity(entity.getVelocity().normalize().multiply(velocityScalar));
        //entity.horizontalCollision = false;
        //entity.verticalCollision=false;
        //entity.noClip=true;
        //((IEEntity) entity).isRecentlyCollidingWithPortal();
        //((IEEntity) entity).tickCollidingPortal(5);
        entity.setVelocity(entity.getVelocity());
    }


}
