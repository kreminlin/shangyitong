package com.atguigu.shangyitong.entity;


import com.baomidou.mybatisplus.annotation.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@TableName(value = "hospital_set")
@Data
@ApiModel(description = "医院设置")
public class HospitalSet  {

  @TableId(value = "id",type = IdType.AUTO)
  private long id;
  @NotBlank(message = "名称不能为空")
  @ApiModelProperty(value = "医院名称")
  @TableField("hosname")
  private String hosname;
  @ApiModelProperty(value = "医院编号")
  private String hoscode;
  @ApiModelProperty(value = "访问路径")
  private String apiUrl;
  @ApiModelProperty(value = "关键时间")
  private String signKey;
  @ApiModelProperty(value = "联系人")
  private String contactsName;
  @ApiModelProperty(value = "联系人电话")
  private String contactsPhone;

  @NotNull(message = "状态不能为空")
  @Min(value = 12,message = "状态不嫩为0")
  @ApiModelProperty(value = "状态")
  private long status;
  @ApiModelProperty(value = "创建时间")
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  @ApiModelProperty(value = "更新时间")
  private Date updateTime;
  @ApiModelProperty(value = "是否删除")
  private long isDeleted;
  @ApiModelProperty(value = "版本号")
  @TableField(fill = FieldFill.INSERT)
  private long version;

}
