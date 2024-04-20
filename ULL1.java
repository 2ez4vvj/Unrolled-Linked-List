import java.util.*;
// A class named practice is created that will have all the utility Functions of the Unrolled Linked List 
class practice{
    //A class named ULLNode is created that will act as single node of the Unrolled Linked List 
    class ULLNode {
        //A variable named next of the ULLNode type is created that will be used to store the address of the number of in that node of the Unrolled Linked List 
        int numElements;
        int array[];
        ULLNode next;
        

        //A parameterized constructor is written that will be used to initialize the class variables of the ULLNode class
        public ULLNode (int n){
            next = null;
            numElements = 0;
            array = new int[n];
        }
    }
    //A private variable named start of the ULLNode type is created that will be used to represent the start of the Unrolled Linked List
    private ULLNode start ;
    //A private variable named end of the ULLNode type is created that will be used to represent the the end of the Unrolled Linked List 
    private ULLNode end;
    private int sizeNode ;
    private int nNode ;
    
    //A parameterized constructor is written that will be used to initialize the class variables of the Unrolled Linked List Class
    public practice(int capacity){
        start = null;
        end = null;
        nNode =0;
        sizeNode = capacity + 1;
    }
    
    //A public Function named isEmpty() is written that will be used to check whether the Unrolled Linked List is empty or not
    public boolean isEmpty(){
        return start == null;
    }
    //A public Function named getSize() is written that will be used to get the size of the Unrolled Linked List 
    public int getSize(){
        return nNode;
    }
    //A public Function named makeEmpty() is written that will be used to empty the Unrolled Linked List 

    public void makeEmpty(){
        start = null;
        end = null;
        nNode = 0;
    }
    // A public Function named insert() is written that will be used to a new element to the Unrolled Linked List
    public void insert(int x){
        nNode++;
        if(start == null){
            start = new ULLNode(sizeNode);
            start.array[0] = x;
            start.numElements++;
            end = start;
        }
        else if(end.numElements<sizeNode){
            end.array[end.numElements] = x;
            end.numElements++;
        } else{
            ULLNode nptr = new ULLNode(sizeNode);
            nptr.array[0] = x;
            end.next = nptr;
            end = nptr;
            nptr.numElements++;
        }
    }
    //A public Function named display() is written that will be used to print all the elements of the Unrolled Linked List 
    public void display(){
        System.out.print("\nUnrolled Linked List = ");
        if(nNode == 0){
            System.out.print("There is no data to display\n");
            return;
        } 
        System.out.println();
        ULLNode ptr = start;
        while (ptr!=null) {
            for(int i = 0;i<ptr.numElements;i++) {
                System.out.print(ptr.array[i]+" ");
            }
            System.out.println();
            ptr=ptr.next;
        }
    }
    //A public Function named remove is written that will be used to remove a given element
    public void remove(int n){
        if(nNode == 0){
            System.out.println("empty");
            return;
        } System.out.println();
        ULLNode ptr = start;
        while(ptr!=null){
            for(int i =0;i<ptr.numElements;i++){
                if(ptr.array[i]==n){
                    ptr.array[i] = 0;
                    if(i!=ptr.numElements-1){
                        for(int j =0;j<ptr.numElements-i-1;j++){
                            int c = ptr.array[i+j];
                            ptr.array[i+j] = ptr.array[i+j+1];
                            ptr.array[i+j+1] = c;
                        }
                    }
                }
            }
            ptr=ptr.next;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array size of each node");
        /* Creating object of class UnrolledLinkedList */
        practice ull = new practice(3);
        char ch;
        /* Perform list operations */
        do{  
            System.out.println("Please Choose one of the Operations::");  
            System.out.println("1. To insert Data in the Unrolled Linked List.");  
            System.out.println("2. To Check List is empty or not.");  
            System.out.println("3. To get the size of the Unrolled Linked List.");  
            System.out.println("4. To clear the Unrolled Linked List.");  
            System.out.println("5. To print/display the Data in the Unrolled Linked List.");  
            System.out.println("6. To remove the data in the unrolled linked list.");
            int choice = scan.nextInt();  
            switch (choice)  
                {  
                    case 1 :  
                        System.out.println("Enter integer element to insert");  
                        ull.insert( scan.nextInt() );  
                        ull.nNode++;
                        break;  
                    case 2 :  
                        System.out.println("Empty status = "+ ull.isEmpty());  
                        break;  
                    case 3 :  
                        System.out.println("Size = "+ ull.getSize() +"\n");  
                        break;  
                    case 4 :  
                        System.out.println("List Cleared\n");  
                        ull.makeEmpty();  
                        break;  
                    case 5 :  
                        System.out.println("Contents of Unrolled Linked List are::");  
                        ull.display();  
                        break;
                    case 6 :
                        System.out.println("Enter the element to be removed ");
                        int n = scan.nextInt();
                        ull.remove(n);
                        break;
                    default :  
                        System.out.println("Wrong Entry\n ");  
                        break;  
                }  
                System.out.println("\nType y to continue \n");  
                ch = scan.next().charAt(0);  
            } while (ch == 'Y'|| ch == 'y');  
    }  
}
