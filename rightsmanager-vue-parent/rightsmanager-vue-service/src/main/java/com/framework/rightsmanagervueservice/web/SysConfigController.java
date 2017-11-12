package com.framework.rightsmanagervueservice.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.framework.rightsmanagervueservice.dto.SysSystemConfigRequest;
import com.framework.rightsmanagervueservice.util.BeanToMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.framework.rightsmanagervueservice.service.SysSystemConfigService;
import com.framework.rightsmanagervueservice.model.SysSystemConfig;
import com.framework.rightsmanagervueservice.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 系统配置 控制层
 * @author leo.aqing
 */
@RestController
@RequestMapping("/admin")
@Api(value = "SysConfigController", description = "系统配置接口")
public class SysConfigController extends CommonController{
	@Autowired
	private SysSystemConfigService sysSystemConfigService;
	
	@ApiOperation(value = "获取配置", httpMethod="POST")
	@PostMapping(value = "/configs", produces = {"application/json;charset=UTF-8"})
	public String configs(@RequestBody(required=false) SysSystemConfig record,HttpServletRequest request) {
		Map<String, Object> data = new HashMap<String, Object>();
		List<SysSystemConfig> configs = sysSystemConfigService.selectAll();
		for (SysSystemConfig c : configs) {
			data.put(c.getName(), c.getValue());
		}
		return FastJsonUtils.resultSuccess(200, "查询配置成功", data);
	}

	@ResponseBody
	@ApiOperation(value = "更新配置", httpMethod="POST")
	@PostMapping(value = "/systemConfigs", produces = {"application/json;charset=UTF-8"})
	public String systemConfigs(@RequestBody(required=false) SysSystemConfigRequest recordrequest, HttpServletRequest request) {
		Map<String, Object>  inputconfigMap = BeanToMapUtil.convertBean(recordrequest);
		SysSystemConfig record =new SysSystemConfig();
		Map<String, Object> data = new HashMap<String, Object>();
		List<SysSystemConfig> configs = sysSystemConfigService.selectAll();

		for (String v : inputconfigMap.keySet()) {
			List<SysSystemConfig> findConfigs = configs.stream()
					.filter((SysSystemConfig config) -> config.getName().trim().equals(v.trim()))
					.collect(Collectors.toList());
			Object inputValue = inputconfigMap.get(v);
			if(findConfigs.isEmpty()) {
				SysSystemConfig newrecord = new SysSystemConfig();
				newrecord.setName(v);
				newrecord.setValue(inputValue.toString());
				sysSystemConfigService.insert(newrecord);
			}
			else if(findConfigs.get(0).getValue() != inputValue) {
				SysSystemConfig newrecord = new SysSystemConfig();
				newrecord.setName(v);
				newrecord.setValue(inputValue.toString());
				newrecord.setId(findConfigs.get(0).getId());
				sysSystemConfigService.updateByPrimaryKeySelective(newrecord);
			}
		}

		return FastJsonUtils.resultSuccess(200, "更新配置成功", data);
	}
}
