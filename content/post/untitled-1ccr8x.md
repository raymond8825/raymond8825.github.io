---
title: Untitled
slug: untitled-1ccr8x
url: /post/untitled-1ccr8x.html
date: '2023-09-07 09:59:17'
lastmod: '2023-11-02 13:01:22'
toc: true
isCJKLanguage: true
---

# Untitled

# 垂直化调用

feat_jsf_alias_zptian_0913

1. 别名改与不改
2. 上线顺序
3. 配置文件&别名后缀
4. 单分组至少两台应用

每个分组只上一台,前端上完切流量,然后再上后面的,

交易web的别名只有

# jsf-provider

jsf.provider.ptrip.trade.service.alias              = ENV_PRD

jsf.provider.ptrip.trade.order.service.alias        = ENV_PRD_ORDER

  
这两个别名需要改垂直化,其他不改,consumer都要改

‍

交易worker别名只有

jsf.provider.ptrip.trade.service.alias              = ENV_PRD

要改,其他不改,consumer全要改

‍

dist consumer全改,provider不改,

jsf.provider.ptrip.trade.order.service.alias        = ENV_PRD_ORDER_DIST告诉供货不改

‍

最后上worker

# 健康度治理

trip-search jmq4 应该用jmq2

‍

# 内容平台:改成廊坊汇天

​​

# blender大搜去除jmq4的所有依赖

​​
