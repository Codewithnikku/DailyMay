import java.util.*;

class MJTREVPT{
    int getmaxVal(int[] nums){
        int maxVal=0;
        for(int x:nums){
            maxVal=Math.max(maxVal,x);
        }
        return maxVal;
    }

    int[] buildSPF(int maxVal){
        int[] spf=new int[maxVal+1];

        for(int i=0;i<=maxVal;i++){
            spf[i]=i;
        }

        if(maxVal>=1){
            spf[1]=1;
        }

        for(int i=2;i*i<=maxVal;i++){
            if(spf[i]==i){
                for(int j=i*i;j<=maxVal;j+=i){
                    if(spf[j]==j){
                        spf[j]=i;
                    }
                }
            }
        }

        return spf;
    }

    boolean[] getpresentprimes(int[] nums,int[] spf,int maxVal){
        boolean[] presentPrimes=new boolean[maxVal+1];

        for(int x:nums){
            if(x>1&&spf[x]==x){
                presentPrimes[x]=true;
            }
        }

        return presentPrimes;
    }

    List<Integer>[] buildGraph(int[] nums,boolean[] presentPrimes,int[] spf,int maxVal){
        List<Integer>[] graph=new ArrayList[maxVal+1];

        for(int i=0;i<=maxVal;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            int lastPrime=0;

            while(temp>1){
                int p=spf[temp];

                if(p!=lastPrime){
                    if(presentPrimes[p]){
                        graph[p].add(i);
                    }

                    lastPrime=p;
                }

                temp/=p;
            }
        }

        return graph;
    }

    public int minJumps(int[] nums){
        int n=nums.length;

        if(n==1){
            return 0;
        }

        int maxVal=getmaxVal(nums);
        int[] spf=buildSPF(maxVal);

        boolean[] presentPrimes=getpresentprimes(nums,spf,maxVal);
        List<Integer>[] graph=buildGraph(nums,presentPrimes,spf,maxVal);
        Queue<Integer> queue=new LinkedList<>();

        boolean[] visited=new boolean[n];
        boolean[] usedPrime=new boolean[maxVal+1];

        queue.offer(0);
        visited[0]=true;
        int jumps=0;

        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
                int index=queue.poll();

                if(index==n-1){
                    return jumps;
                }

                if(index-1>=0&&!visited[index-1]){
                    visited[index-1]=true;
                    queue.offer(index-1);
                }

                if(index+1<n&&!visited[index+1]){
                    visited[index+1]=true;
                    queue.offer(index+1);
                }

                int value=nums[index];

                if(value>1&&spf[value]==value&&!usedPrime[value]){
                    usedPrime[value]=true;

                    for(int nextIndex:graph[value]){
                        if(!visited[nextIndex]){
                            visited[nextIndex]=true;
                            queue.offer(nextIndex);
                        }
                    }
                }
            }

            jumps++;
        }

        return -1;
    }
}

public class MinimumJumpsToReachEndViaPrimeTeleportation{
    public static void main(String[] args){

        int[] nums={1, 2, 4, 6};
        MJTREVPT obj=new MJTREVPT();
        int ans=obj.minJumps(nums);

        System.out.println(ans);
    }
}