<h1>Untitled</h1>
<h1>垂直化调用</h1>
<p>feat_jsf_alias_zptian_0913</p>
<ol>
<li>别名改与不改</li>
<li>上线顺序</li>
<li>配置文件&amp;别名后缀</li>
<li>单分组至少两台应用</li>
</ol>
<p>每个分组只上一台,前端上完切流量,然后再上后面的,</p>
<p>交易web的别名只有</p>
<h1>jsf-provider</h1>
<p>jsf.provider.ptrip.trade.service.alias              = ENV_PRD</p>
<p>jsf.provider.ptrip.trade.order.service.alias        = ENV_PRD_ORDER</p>
<p>这两个别名需要改垂直化,其他不改,consumer都要改</p>
<p>‍</p>
<p>交易worker别名只有</p>
<p>jsf.provider.ptrip.trade.service.alias              = ENV_PRD</p>
<p>要改,其他不改,consumer全要改</p>
<p>‍</p>
<p>dist consumer全改,provider不改,</p>
<p>jsf.provider.ptrip.trade.order.service.alias        = ENV_PRD_ORDER_DIST告诉供货不改</p>
<p>‍</p>
<p>最后上worker</p>
<h1>健康度治理</h1>
<p>trip-search jmq4 应该用jmq2</p>
<p>‍</p>
<h1>内容平台:改成廊坊汇天</h1>
<p>​​</p>
<h1>blender大搜去除jmq4的所有依赖</h1>
<p>​​</p>
