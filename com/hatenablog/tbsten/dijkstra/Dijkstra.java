package com.hatenablog.tbsten.dijkstra;

public class Dijkstra {
    public static void main(String[] args) {
    	new Dijkstra() ;
    }

    int pointCnt = 4 ;
    int[] num = {999,999,999,999} ;
    String[] point = {"A","B","C","D"} ;
    int[] flg = new int[pointCnt] ;
    int[][] con = {
    		{1,2,3},
    		{0,2},
    		{0,1,3},
    		{0,2}
    } ;
    int[] conCnt = {3,2,3,2} ;
    int[][] cost = {
    		{50,40,10},
    		{50,30},
    		{40,30,20},
    		{10,20}
    } ;

    int s = 0 ;
    int e = 2 ;

    Dijkstra(){

    	int cnt = 0 ;

    	num[s] = 0 ;

    	while(cnt < pointCnt) {
	    	int minIdx = -1 ;
	    	int min = 999 ;
	    	for(int i = 0 ; i < pointCnt ;i++) {
	    		if(flg[i] == 0 && min > num[i]) {
	    			minIdx = i ;
	    			min = num[i] ;
	    		}
	    	}
	    	flg[minIdx] = 1 ;
	    	cnt ++;

	    	for(int i = 0;i < conCnt[minIdx];i++) {
	    		if(flg[con[minIdx][i]] == 0) {
	    			//con[minIdx][i] のnum計算
	    			int w = num[minIdx] + cost[minIdx][i] ;
	    			if(w < num[con[minIdx][i]]) {
	    				num[con[minIdx][i]] = w ;
	    			}
	    		}
	    	}
    	}


    	System.out.println("\n"+point[s]+"から"+point[e]+"までの最短距離は"+num[e]);

    }
}
