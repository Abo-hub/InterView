[toc]
# 跳台阶
## 【标签】 
递归
## 【题目】
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
## 【分析】
如果台阶只有1级，方法只有一种。如果台阶有2级，方法有两种。如果台阶有N级，最后跳上第N级的情况，要么是从N-2级台阶直接跳2级台阶，要么是从N-1级台阶跳一级台阶，所以台阶有N级的方法数为跳到N-2级台阶的方法数加上跳到N-1级台阶的方法数，即 F(N) = F(N-1) + F(N-2)，初始项F(1)==1,F(2)==2。所以类似斐波那契数列，唯一的不同就是初始项不同
## 【解答】
### 方法一  O(2^N^)