package com.vns.service;

import java.util.List;

import com.vns.vo.BlockInfo;
import com.vns.vo.DataResult;
import com.vns.vo.HomeBlock;
import com.vns.vo.PriceMarket;
import com.vns.vo.TableSplitResult;

public interface IBlockService {

	public TableSplitResult<BlockInfo> findBlockList(BlockInfo bi);
	public DataResult<BlockInfo> findBlock(int blockNumber,int type);
	
	public void blockStop();
	
	public DataResult<BlockInfo> blockDivInfo();
	
	public DataResult<PriceMarket> findVnsNewInfo();
	
	/**
	 * 查询区块信息
	 * @return
	 */
	public DataResult<HomeBlock> findBlockInfo();
	
	/**
	 * 操作数据
	 */
	public void operationBlockInfo();
	
	public DataResult<BlockInfo> findBlockInfoByHash(String blockHash);
}
