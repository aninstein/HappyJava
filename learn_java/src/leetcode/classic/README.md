## 1. 最长递增子序列问题
题目链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/
最长递增子序列问题，一般有两种解法
- 动态规划
- LIS算法（贪心+二分查找）

### 1.1 动态规划
#### 1.1.1 题目解析
动态规划题最重要的就是明确状态标识。
- 状态：即dp函数所代表的含义，注意一个题目里面可能不会只有一种状态
- 集合：即需要遍历的那些数据，比如我们一般用i，j去遍历数据，同时dp函数也保存了当第i个，第j个这个时候的状态
- 状态转移：当符合条件的时候，dp函数的数据变更，比如dp[j]满足可以向dp[i]状态进行转移的条件，则进行状态转移，这个条件就是状态转移方程

以此题为例：
- 确定状态：
在这个题里面，我们确定两个状态的值：
1. dp[i]方法值得确认：我们定义dp[i]函数所代表的值是：以第i个元素nums[i]结尾的，最长递增子序列的长度，且nums[i]必须被选择。
2. 最长上升子序列LISlength值

- 数据集合：
此题的数据集合，即一个数组，i遍历这个数据，而j遍历i之前的元素。

- 状态转移：
1. 第一个状态的转移：

我们从小到大计算 dp[i] 数组的值，在计算 dp[i]之前，我们已经计算出 dp[0…i−1]的值，则状态转移方程为：
即考虑往 dp[0…i−1]中最长的上升子序列后面再加一个 nums[i]。

我们一般用另个循环j来遍历[0...i-1]的数据内容，因此：

由于 dp[j]代表 nums[0…j]中以nums[j]结尾的最长上升子序列，
所以如果能从dp[j]这个状态转移过来，那么nums[i]必然要大于nums[j]，
才能将nums[i]放在nums[j]后面以形成更长的上升子序列。

```python
dp[i] = max(dp[j]) + 1  # 其中 0≤j<i 且 num[j]<num[i]
```
即在0-j的循环里寻找：
```
dp[i] = max(dp[i], dp[j] + 1)
```

2. 第二个状态的转移：
经过第一个状态的状态转移之后，dp数组中的数据，即以nums数组上以nums[i]结尾的最长递增子序列长度，第二个状态计算则直接找到最长那个即可。
```python
LISlength = max(dp[i])
```

#### 1.1.2 代码实现
代码实现上述的流程和逻辑：
```java
public static int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    int maxLen = 0;
    int[] dp = new int[nums.length + 2];
    for (int i = 0; i < nums.length; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        maxLen = Math.max(maxLen, dp[i]);
    }
    return maxLen;
}
```


### 1.2 LIS算法
LIS算法其实就是**贪心+二分查找**的算法。我们把这个分为两部分去看：
- 贪心算法
- 查找

#### 1.2.1 贪心
贪心算法的流程首先要确定贪心策略，贪心策略。

**本题的贪心策略：**
想要这个递增子序列尽可能的长，则需要这个子序列的数据增长的尽可能的慢。
换言之，同一个长度的子序列，我们选择结尾数据最小的那个数据。

有了这个贪心策略，我们维护一个数组d[i]，表示：**长度为i的最长递增子序列的最后一个数据的最小值**

#### 1.2.2 二分查找
易证：数组d一定是一个递增数组。为什么？

如果d[j] >= d[i]且j < i，
那么在长度为i的LIS中，一定能够找到一个长度为j的LIS，
又因为d[i]是这个LIS的最后一个值（即最大值），
按照上述的贪心策略，这个值应该把大于d[i]的那个d[j]替换掉。

由于这是一个递增序列，所以可以进行二分查找。

#### 1.2.3 LIS算法流程
1. 我们维护一个d[i]数组，存**长度为i的最长递增子序列的最后一个数据的最小值**
2. 遍历nums
    - 如果这个数据nums[i]比d[i-1]的元素大，证明nums[i]可以与长度为i的最长递增子序列组成更长的子序列，
      因此只需要把d[i]更新为nums[i]，LISlength+1即可
    - 如果这个数据nums[i]比d[i-1]的元素小，证明nums[i]可能能够代替d[0···i-1]中的某一个数据，
      我们使用二分查找来在d数组中找到比这个数据小的数据d[k]，更新到d[k+1]即可。
      也就是说当前这个数据顶多只能组成k+1长度的LISlength。
3. 返回d[i]中的i
      
代码实现
```java
public static int lengthOfLISByGreedy(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }

    int[] d = new int[nums.length + 2];
    int len = 1;
    d[len] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > d[len]) {
            d[++len] = nums[i];  // ++len是先返回len+1，再执行len+1；len++是先返回len，再执行len+1
            continue;
        }
        searchTwo(nums, d, len, i);
    }
    return len;
}

public static void searchTwo(int[] nums, int[] d, int len, int i) {
    // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
    int l = 1, r = len, pos = 0;
    while (l <= r) {
        int mid = (l + r) >> 1;
        if (d[mid] < nums[i]) {
            pos = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    d[pos + 1] = nums[i];
}
```