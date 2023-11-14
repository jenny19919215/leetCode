package hsbc;

import java.util.*;

public class MaxAttendings2 {
    List<Integer>[] rg;
    int[] deg;

    public int maximumInvitations(int[] g) { // favorite 就是内向基环森林 g
        int n = g.length;
        rg = new List[n]; // g 的反图
        Arrays.setAll(rg, e -> new ArrayList<>());
        deg = new int[n]; // g 上每个节点的入度
        for (int v = 0; v < n; ++v) {
            int w = g[v];
            rg[w].add(v);
            ++deg[w];
        }

        // 拓扑排序，剪掉 g 上的所有树枝
        Deque q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i)
            if (deg[i] == 0) q.push(i);
        while (!q.isEmpty()) {
            Integer v = (Integer) q.pop();
            int w = g[v]; // v 只有一条出边
            if (--deg[w] == 0) q.push(w);
        }

        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; ++i) {
            if (deg[i] <= 0) continue;
            // 遍历基环上的点（拓扑排序后入度大于 0）
            deg[i] = -1;
            int ringSize = 1;
            for (int v = g[i]; v != i; v = g[v]) {
                deg[v] = -1; // 将基环上的点的入度标记为 -1，避免重复访问
                ++ringSize;
            }
            if (ringSize == 2) sumChainSize += rdfs(i) + rdfs(g[i]); // 基环大小为 2，累加两条最长链的长度
            else maxRingSize = Math.max(maxRingSize, ringSize); // 取所有基环的最大值
        }
        return Math.max(maxRingSize, sumChainSize);
    }

    int rdfs(int v) {
        int maxDepth = 1;
        for (Integer w : rg[v])
            if (deg[w] == 0)  // 树枝上的点在拓扑排序后，入度均为 0
                maxDepth = Math.max(maxDepth, rdfs(w) + 1);
        return maxDepth;
    }

}
