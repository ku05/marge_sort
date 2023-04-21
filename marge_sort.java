import java.util.*;
class marge_sort{
    public static void merge(int a[],int si,int mid,int ei){
        int b[]=new int[ei-si+1];
        int idx1=si;
        int idx2=mid+1;
        int j=0;
        while(idx1<=mid&&idx2<=ei){
            if(a[idx1]<a[idx2]){
                b[j++]=a[idx1++];
            }else{
                b[j++]=a[idx2++];
            }
        }
        while(idx1<=mid){
            b[j++]=a[idx1++];
        }
        while(idx2<=ei){
            b[j++]=a[idx2++];
        }
        for(int i=0,k=si;i<b.length;i++){
            a[k]=b[i];
            k++;
        }
    }
    public static void divide(int a[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        divide(a,si,mid);
        divide(a,mid+1,ei);
        merge(a,si,mid,ei);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array :");
        int a[]=new int[5];
        for(int i=0;i<5;i++){
            a[i]=sc.nextInt();
        }
        int n=a.length;
        divide(a,0,n-1);
        System.out.println("Afted merge sort:");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}