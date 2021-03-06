
public class mymaxheap
{  
   private int[] H;
   private int s;
   private int ts;
   public static int currentSize=0;
   public mymaxheap(int n)
// constructing an empty heap
   {
      s = 0;
      ts = n;
      H = new int[ts];
   }
 /*public mymaxheap(int[] A)
//  n log n version
   {
      ts = A.length;
	  int original[]=new int[A.length];
      H = new int[A.length];
      for (int i = 0; i < A.length; i++) 

	     original[i]=A[i];

		 for (int j=0;j< A.length;j++)

         this.insert(A[i]);
		 this.printheap1();

  } */
  


 

  public mymaxheap(int[] A)
  // n version
   {
      ts = A.length;int temp;
      H = new int[A.length];
	  for(int i=0;i<A.length;i++)
	      H[i]=A[i];
		  currentSize=A.length;
		//  this.printheap1();
	  int lastInnerNode=A.length/2;
      for (int i =lastInnerNode; i >0; i--) {
         int t=i-1;
		 int j=i*2-1;
		 while (H[t]<H[j] || H[t]<H[j+1])
		 {
		  if(H[t]<H[j])
		  { 
		   if(H[j]>H[j+1])
		  {
		  swap(t,j);
		    t=j;
		   j=t*2+1;
		  if(j>=A.length)
		  break;
		  }
		   else
		   {
		    swap(t,j+1); 
			 t=j+1;
			 j=t*2+1;
			if(j>=A.length)
			break;
			}
			}
			else
			{swap(t,j+1);
			 t=j+1;
			 j=t*2+1;
			if(j>=A.length)
			break;
			}
		}
		// this.printheap1();
   } 
   }
   public void insert(int a)
   { // open insert method
   	 currentSize++;
      if (s  <= ts) { //open if statement
           H[s] = a;
	   int i = s;
	   int j = s/2;
	   while (j >= 0 && H[i] > H[j]){	   //open while statement

	    swap(i,j);
	    i = j;
	    j = i/2;
	   } // close while statement
        s = s + 1;
		// this.printheap();
      }  //close if statement
      else
        System.out.println("heap is full");
   } //close insert method
   
   private void swap(int i, int j)
   {
       int t = H[i];
       H[i] = H[j];
       H[j] = t;
   }
   public boolean isminheap()
   {
       int j = 0;
       boolean c = true;
       for (int i = 0; i < s/2; i++)
       {
          j = i + 1;
	  if (2*j - 1 < s)	  
            if (H[j-1] > H[2*j-1])
              c = false;
	  if (2*j < s)
            if (H[j-1] > H[2*j])
              c = false;
       }
       return c;
   }
   public int findmin()
   {
       return H[0];
   }

   public int heapsize()
   {
       return s;
   }

   public int delmax()
   {
       int ans = H[0];
	    s=H.length-1;
       if (s == 0)
          System.out.println("heap is empty!");
       else {

	  s = s - 1;
	  H[0] = H[s];
	  int c = 0;
	  int chmin = 0;
	  boolean conti = true;
	  while (conti) {
	     if (s <= 2*(c+1))    // only one child case. 
		if (H[2*(c+1)-1] > H[c]) {
		   this.swap(c, 2*(c+1)-1);
		   conti = false;
		}
		else
		   conti = false;
	     else {
	      if (H[2*(c+1)-1] > H[2*(c+1)]) {
	         if (H[2*(c+1)-1] >H[c]) {
		    this.swap(c, 2*(c+1)-1);
		    c = 2*(c+1)-1;
		 }
		 else
		    conti = false;
 	      }
	      else {
	        if (H[2*(c+1)] > H[c]) {
		   this.swap(c, 2*(c+1));
		   c = 2*(c+1);
		}
		else
		   conti = false;
	      }   
             }
	    if (2*c >= s)
		conti = false; 
	  }

       }
	return ans;
   }
   public void printheap1()
   {
    for (int i = 0; i < H.length; i++)
	   System.out.print(H[i] + " ");
	   System.out.println();
	    int nBlanks = 32;
      int itemsPerRow = 1;
      int column = 0;
      int j = 0;                          // current item
      String dots = "...............................";
      System.out.println(dots+dots);      // dotted top line

      while(currentSize > 0)              // for each heap item
         {
         if(column == 0)                  // first item in row?
            for(int k=0; k<nBlanks; k++)  // preceding blanks
               System.out.print(' ');
                                          // display item
         System.out.print(H[j]);

         if(++j == currentSize)           // done?
            break;

         if(++column==itemsPerRow)        // end of row?
            {
            nBlanks /= 2;                 // half the blanks
            itemsPerRow *= 2;             // twice the items
            column = 0;                   // start over on
            System.out.println();         //    new row
            }
         else                             // next item on row
            for(int k=0; k<nBlanks*2-2; k++)
               System.out.print(' ');     // interim blanks
         }  // end for
      System.out.println("\n"+dots+dots); // dotted bottom line
      }  // end displayHeap()
   
   

   
}
