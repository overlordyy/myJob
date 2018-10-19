package com.vns.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vns.vo.BlockInfo;

public interface BlockMapper {

	public List<BlockInfo> findBlockList(BlockInfo bi);
	public int findBlockListCount(BlockInfo bi);
	public List<BlockInfo> findBlock();
	public List<BlockInfo> findBlockByBlockNumber(@Param("blockNumber")int blockNumber);
	public void deleteBlock();
	public void insertBlock(BlockInfo bi);
	public List<BlockInfo> findBlockListOrder();
	public BlockInfo blockDivInfo();
	public int findBlockByHash(@Param("blockHash")String blockHash);
	public int findBlockByNumber(@Param("blockNumber")int blockNumber);
	public List<String> findTokenInfo();
}
