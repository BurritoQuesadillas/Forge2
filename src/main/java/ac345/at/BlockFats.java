package ac345.at;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFats extends Block {
    protected BlockFats(Material material) {
        super(material);
        this.setResistance(2000.0F);
        this.setHardness(0.2F);
        this.setStepSound(this.soundTypeSand);
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }
}
