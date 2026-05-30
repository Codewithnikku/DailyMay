import java.util.*;

class BPQ {
    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[n << 2];
        }

        void update(int idx, int val) {
            update(1, 0, n, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }
            int mid = (l + r) >>> 1;
            if (idx <= mid) {
                update(node << 1, l, mid, idx, val);
            } else {
                update(node << 1 | 1, mid + 1, r, idx, val);
            }
            tree[node] = Math.max(tree[node << 1], tree[node << 1 | 1]);
        }

        int query(int ql, int qr) {
            if (ql > qr) return 0;
            return query(1, 0, n, ql, qr);
        }

        private int query(int node, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) >>> 1;
            int ans = 0;
            if (ql <= mid) ans = query(node << 1, l, mid, ql, qr);
            if (qr > mid) ans = Math.max(ans, query(node << 1 | 1, mid + 1, r, ql, qr));
            return ans;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int mx = 0;
        for (int[] q : queries) {
            mx = Math.max(mx, q[1]);
        }

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(mx + 1);

        SegmentTree seg = new SegmentTree(mx + 1);
        seg.update(mx + 1, mx + 1);

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];

                int prev = obstacles.lower(x);
                int next = obstacles.higher(x);

                seg.update(x, x - prev);
                seg.update(next, next - x);

                obstacles.add(x);
            } else {
                int x = q[1];
                int sz = q[2];

                int prev = obstacles.floor(x);
                int best = Math.max(seg.query(0, prev), x - prev);

                ans.add(best >= sz);
            }
        }

        return ans;
    }
}

public class BlockPlacementQueries {
    public static void main(String[] args) {
        BPQ bpq = new BPQ();

        int[][] queries = {
            {1, 2},
            {2, 3, 3},
            {2, 3, 1},
            {2, 2, 2}
        };

        List<Boolean> result = bpq.getResults(queries);

        System.out.println(result);
    }
}