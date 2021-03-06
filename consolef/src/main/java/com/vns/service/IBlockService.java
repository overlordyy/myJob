package com.vns.service;

import java.util.List;

import com.vns.vo.BlockInfo;
import com.vns.vo.DataResult;
import com.vns.vo.TableSplitResult;

public interface IBlockService {

	public TableSplitResult<BlockInfo> findBlockList(BlockInfo bi);
	public DataResult<BlockInfo> findBlock(int blockNumber);
	/**
	 * 启动区块加载服务
	 */
	public void blockSta();
	
	public void blockStop();
	
	public DataResult<BlockInfo> blockDivInfo();
	
	public void seqNewBlock();
	
	public void findTokenInfo();
}
