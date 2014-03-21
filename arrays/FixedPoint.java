//a fixed point in an array is an element succh that arr[ele] = ele
public class FixedPoint
{
  public static void main(String args[])
  {
    int arr[] = {-5, -3, 1, 0, 3, 5, 10, 18};
    System.out.println(find(arr, 0, arr.length-1));
  }
  
  private static int find(int arr[], int start, int end)
  {
    if ( start > end ) return -1;
    int mid = start + (end-start)/2;
    if ( arr[mid] == mid )
      return mid;
    
    if ( arr[mid] > mid )
      return find(arr, start, mid-1);
    else
      return find(arr, mid+1, end);
    
  }
}