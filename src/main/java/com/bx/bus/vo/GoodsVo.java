package com.bx.bus.vo;

import com.bx.bus.domain.Goods;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsVo extends Goods {

	/*
	 *  
	 */
	private static final long serialVersionUID = 1L;

	private Integer page = 1;
	private Integer limit = 10;

}
