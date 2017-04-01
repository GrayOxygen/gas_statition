package com.lehuoji.crawler.gas_statition.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author 王辉阳
 * @Description 加油站对象
 */
@AllArgsConstructor
@NoArgsConstructor
public class GasStation {
	@Getter
	@Setter
	private String adcode;
	@Getter
	@Setter
	private String address;
	@Getter
	@Setter
	private String adname;
	@Getter
	@Setter
	private String biz_type;
	@Getter
	@Setter
	private String citycode;
	@Getter
	@Setter
	private String cityname;
	@Getter
	@Setter
	private String discount_num;
	@Getter
	@Setter
	private String gridcode;
	@Getter
	@Setter
	private String groupbuy_num;
	@Getter
	@Setter
	private String id;
	@Getter
	@Setter
	private String indoor_map;
	@Getter
	@Setter
	private String location;
	@Getter
	@Setter
	private String match;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String navi_poiid;
	@Getter
	@Setter
	private String pcode;
	@Getter
	@Setter
	private String pname;
	@Getter
	@Setter
	private String tel;
	@Getter
	@Setter
	private String type;
	@Getter
	@Setter
	private String typecode;

}
