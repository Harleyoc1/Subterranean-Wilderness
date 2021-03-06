package melonslise.subwild.common.world.gen.feature.cavetype;

import java.util.Random;

import melonslise.subwild.common.capability.INoise;
import melonslise.subwild.common.init.SubWildBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

public class IcyCaveType extends BasicCaveType
{
	public IcyCaveType(String domain, String path)
	{
		super(domain, path);
		this.defSpel = SubWildBlocks.FROZEN_STONE_SPELEOTHEM;
		this.ceilCh = 6f;
	}

	@Override
	public void genFloor(ISeedReader world, INoise noise, BlockPos pos, float depth, int pass, Random rand)
	{
		if(pass == 0)
		{
			double d = this.getNoise(noise, pos, 0.125d);
			if(d > 0.8d)
				this.replaceBlock(world, pos, Blocks.BLUE_ICE.getDefaultState());
			else if(d > 0.6d)
				this.replaceBlock(world, pos, Blocks.PACKED_ICE.getDefaultState());
			else if(d > 0d)
				this.replaceBlock(world, pos, Blocks.ICE.getDefaultState());
			else
				this.replaceBlock(world, pos, Blocks.SNOW_BLOCK.getDefaultState());
		}
		super.genFloor(world, noise, pos, depth, pass, rand);
	}

	@Override
	public void genFloorExtra(ISeedReader world, INoise noise, BlockPos pos, float depth, int pass, Random rand)
	{
		if(pass == 1)
		{
			double d = this.getNoise(noise, pos, 0.1d);
			if(d > -0.1d)
				this.genLayer(world, pos, SubWildBlocks.SNOW_PATCH.get().getDefaultState(), d, -0.1d, 1d, 7);
			else if(d > -0.7d)
				this.genLayer(world, pos, SubWildBlocks.ICE_PATCH.get().getDefaultState(), d, -0.7d, -0.1d, 5);
		}
		super.genFloorExtra(world, noise, pos, depth, pass, rand);
	}

	@Override
	public void genCeil(ISeedReader world, INoise noise, BlockPos pos, float depth, int pass, Random rand)
	{
		if(pass == 0)
		{
			double d = this.getNoise(noise, pos, 0.125d);
			if(d > 0.8d)
				this.replaceBlock(world, pos, Blocks.BLUE_ICE.getDefaultState());
			else if(d > 0.6d)
				this.replaceBlock(world, pos, Blocks.PACKED_ICE.getDefaultState());
			else if(d > 0d)
				this.replaceBlock(world, pos, Blocks.ICE.getDefaultState());
			else
				this.replaceBlock(world, pos, Blocks.SNOW_BLOCK.getDefaultState());
		}
		super.genCeil(world, noise, pos, depth, pass, rand);
	}

	@Override
	public void genWall(ISeedReader world, INoise noise, BlockPos pos, float depth, int pass, Random rand)
	{
		if(pass == 0)
		{
			double d = this.getNoise(noise, pos, 0.125d);
			if(d > 0.8d)
				this.replaceBlock(world, pos, Blocks.BLUE_ICE.getDefaultState());
			else if(d > 0.6d)
				this.replaceBlock(world, pos, Blocks.PACKED_ICE.getDefaultState());
			else if(d > 0d)
				this.replaceBlock(world, pos, Blocks.ICE.getDefaultState());
			else
				this.replaceBlock(world, pos, Blocks.SNOW_BLOCK.getDefaultState());
		}
		super.genWall(world, noise, pos, depth, pass, rand);
	}

	@Override
	public void genWallExtra(ISeedReader world, INoise noise, BlockPos pos, Direction wallDir, float depth, int pass, Random rand) {}

	@Override
	public void genFill(ISeedReader world, INoise noise, BlockPos pos, float depth, int pass, Random rand)
	{
		if(pass == 1)
		{
			BlockPos down = pos.down();
			if(world.getBlockState(down).getBlock() == Blocks.WATER)
				this.genBlock(world, down, Blocks.ICE.getDefaultState());
		}
	}
}