package javaapplication4;

// LinkedList.java
// 
// This version uses three instance variables,
// a pointer to the first node, a pointer to
// the last node, and length, to make our
// append and getLength methods more efficient
// than the would be if our only instance
// variable were a pointer to the first node.
//
// This version uses a dummy first node.  Hence
// it needs less decision-making than it would
// need if a dummy first node were not used.
//

/**
 * Encapsulates a linked list of <code>String</code>.
 */
public class UserList  {

/**  First node in linked list - dummy node  */
   private UserNode first = new UserNode(null);
   //private
/**  Last node in linked list  */
   private UserNode last = first;

/**  Number of data items in the list.  */
   private int length = 0;

  /**
    * Gets the number of data values currently
    * stored in this LinkedList.
    *
    * @return the number of elements in the list.
    */

   public UserNode getFirst(){
	   return first;
	   
   }
   
   public int getLength()  { 
      return length; 
   }


   /**
    * Appends a String data element to this
    * LinkedList.
    *
    * @param data the data element to be appended.
    */

   
   
   public void append(User d)
   {

     //  write the code here for append
	   UserNode toAppend=new UserNode(d);
	   last.next=toAppend;
	   last=toAppend;
	   length++;
   }  // method append(String)

   
   /**
    * Prepends (adds to the beginning) a String data element to this
    * LinkedList.
    *
    * @param data the data element to be prepended.
    */
   public void prepend(User d)
   {
	   UserNode toPrepend=new UserNode(d);
	   if(first==last){
		   last.next=toPrepend;
		   last=toPrepend; 
		   length++;
	   }
	   else{
		   toPrepend.next=first.next;
		   first.next=toPrepend;
	       length++;
	   }
     //  write the code here for prepend

   }  // method append(String)

   /**
    * Inserts player into correct alphabetical order in the list.
    * @param d Player to be inserted.
    */
   public void insertPlayer(User d){
	   UserNode f = first; 
		while (f.next != null && ((f.next).data).compareTo(d) < 0)
			f = f.next;
		UserNode n = new UserNode(d, f.next);
		f.next = n; 
		
   }

  /**
   *  Prints the contents of the Linked List
   *
   */
   public String toString() {
      UserNode p = first.next;
      String returnString = "";
      while (p != null) {
         returnString += p.data+" ";
         p=p.next;
      }
      return returnString;
   }

  
   /**
    * Determines whether this ShortSequenceLinkedList is
    * equal in value to the parameter object.
    * They are equal if the parameter is of
    * class ShortSequenceLinkedList and the two objects
    * contain the same short integer values at
    * each index.
    *
    * @param other the object to be compared
    *          to this ShortSequenceLinkedList
    *
    * @return <code>true</code> if the parameter
    *        object is a ShortSequenceLinkedList containing
    *        the same numbers at each index as
    *        this ShortSequenceLinkedList, <code>false</code>
    *        otherwise.
    */
   public boolean equals(Object other)
   {
      if ( other == null 
              || getClass() != other.getClass()
              || length != ((UserList) other).length )
          return false;

      UserNode nodeThis = first;
      UserNode nodeOther = ((UserList) other).first;
      while ( nodeThis != null )
      {
          // Since the two linked lists are the same length,
          // they should reach null on the same iteration.

          if ( nodeThis.data != nodeOther.data )
             return false;

          nodeThis = nodeThis.next;
          nodeOther = nodeOther.next;
      }  // while

      return true;
   }  // method equals

  

}  // class LinkedList

