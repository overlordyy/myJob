package com.vns.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vns.vo.BlockInfo;

public interface BlockMapper {

	public List<BlockInfo> findBlockList(BlockInfo bi);
	public int findBlockListCount(BlockInfo bi);
	public List<BlockInfo> findBlock();
	public List<BlockInfo> findBlockByBlockNumber(@Param("blockNumber")int blockNumber,@Param("type")int type);
	public void deleteBlock();
	public void insertBlock(BlockInfo bi);
	public List<BlockInfo> findBlockListOrder();
	public BlockInfo blockDivInfo();
	public int rewardSum();
	public BlockInfo findBlockInfoByHash(@Param("blockHash")String blockHash);
}
