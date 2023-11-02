<h1>事务</h1>
<hr />
<ul>
<li><a href="https://www.liaoxuefeng.com/wiki/1177760294764384/1179611198786848">https://www.liaoxuefeng.com/wiki/1177760294764384/1179611198786848</a></li>
<li>零基础起步的SQL教程</li>
<li>2023-01-17 09:18:24</li>
</ul>
<hr />
<p>在执行SQL语句的时候，某些业务要求，一系列操作必须全部执行，而不能仅执行一部分。例如，一个转账操作：</p>
<pre><code>-- 从id=1的账户给id=2的账户转账100元
-- 第一步：将id=1的A账户余额减去100
UPDATE accounts SET balance = balance - 100 WHERE id = 1;
-- 第二步：将id=2的B账户余额加上100
UPDATE accounts SET balance = balance + 100 WHERE id = 2;
</code></pre>
<p>这两条SQL语句必须全部执行，或者，由于某些原因，如果第一条语句成功，第二条语句失败，就必须全部撤销。</p>
<p>这种把多条语句作为一个整体进行操作的功能，被称为数据库​<em>事务</em>​。数据库事务可以确保该事务范围内的所有操作都可以全部成功或者全部失败。如果事务失败，那么效果就和没有执行这些SQL一样，不会对数据库数据有任何改动。</p>
<p>可见，数据库事务具有ACID这4个特性：</p>
<ul>
<li>A：Atomic，原子性，将所有SQL作为原子工作单元执行，要么全部执行，要么全部不执行；</li>
<li>C：Consistent，一致性，事务完成后，所有数据的状态都是一致的，即A账户只要减去了100，B账户则必定加上了100；</li>
<li>I：Isolation，隔离性，如果有多个事务并发执行，每个事务作出的修改必须与其他事务隔离；</li>
<li>D：Duration，持久性，即事务完成后，对数据库数据的修改被持久化存储。</li>
</ul>
<p>对于单条SQL语句，数据库系统自动将其作为一个事务执行，这种事务被称为​<em>隐式事务</em>​。</p>
<p>要手动把多条SQL语句作为一个事务执行，使用<code>BEGIN</code>​开启一个事务，使用<code>COMMIT</code>​提交一个事务，这种事务被称为​<em>显式事务</em>​，例如，把上述的转账操作作为一个显式事务：</p>
<pre><code>BEGIN;
UPDATE accounts SET balance = balance - 100 WHERE id = 1;
UPDATE accounts SET balance = balance + 100 WHERE id = 2;
COMMIT;
</code></pre>
<p>很显然多条SQL语句要想作为一个事务执行，就必须使用显式事务。</p>
<p>​<code>COMMIT</code>​是指提交事务，即试图把事务内的所有SQL所做的修改永久保存。如果<code>COMMIT</code>​语句执行失败了，整个事务也会失败。</p>
<p>有些时候，我们希望主动让事务失败，这时，可以用<code>ROLLBACK</code>​回滚事务，整个事务会失败：</p>
<pre><code>BEGIN;
UPDATE accounts SET balance = balance - 100 WHERE id = 1;
UPDATE accounts SET balance = balance + 100 WHERE id = 2;
ROLLBACK;
</code></pre>
<p>数据库事务是由数据库系统保证的，我们只需要根据业务逻辑使用它就可以。</p>
<h3>隔离级别</h3>
<p>对于两个并发执行的事务，如果涉及到操作同一条记录的时候，可能会发生问题。因为并发操作会带来数据的不一致性，包括脏读、不可重复读、幻读等。数据库系统提供了隔离级别来让我们有针对性地选择事务的隔离级别，避免数据不一致的问题。</p>
<p>SQL标准定义了4种隔离级别，分别对应可能出现的数据不一致的情况：</p>
<table>
<thead>
<tr>
<th>Isolation Level</th>
<th>脏读（Dirty Read）</th>
<th>不可重复读（Non Repeatable Read）</th>
<th>幻读（Phantom Read）</th>
</tr>
</thead>
<tbody>
<tr>
<td>Read Uncommitted</td>
<td>Yes</td>
<td>Yes</td>
<td>Yes</td>
</tr>
<tr>
<td>Read Committed</td>
<td>-</td>
<td>Yes</td>
<td>Yes</td>
</tr>
<tr>
<td>Repeatable Read</td>
<td>-</td>
<td>-</td>
<td>Yes</td>
</tr>
<tr>
<td>Serializable</td>
<td>-</td>
<td>-</td>
<td>-</td>
</tr>
</tbody>
</table>
<p>我们会依次介绍4种隔离级别的数据一致性问题。</p>
<h3>小结</h3>
<p>数据库事务具有ACID特性，用来保证多条SQL的全部执行。</p>
