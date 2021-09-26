package com.Stockers.Stockmanagement;

public class SortStocksAscending{
	public void merge(double arr[],int first,int mid,int last) {

		int len1 = mid-first+1;
		int len2 = last-mid;
		double[] la= new double[len1];
		double[] ra= new double[len2];

		for(int i=0; i<len1;i++) {
			la[i]=arr[first+i];
		}
		for(int i=0; i<len2;i++) {
			ra[i]=arr[mid+1+i];
		}
		int i=0, j=0, k=first;
		while (i<len1 && j<len2) {
			if(la[i]<=ra[j]) {

				arr[k]= la[i];
				i++;
			}
			else {
				arr[k]= ra[j];
				j++;		
			}
			k++;
		}
		while(i< len1){
			arr[k]= la[i];
			k++;
			i++;
		}
		while(j<len2) {
			arr[k]= ra[j];
			k++;
			j++;
		}	
	}


	public void stocksAscending(double[] todaysPrices, int first, int last ) {
		int mid;
		if(first<last) {
			mid = (first+last)/2;

			stocksAscending(todaysPrices,first,mid);
			stocksAscending(todaysPrices,mid+1,last);
			merge(todaysPrices,first,mid,last);
		}
	}
}




