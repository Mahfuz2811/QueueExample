import java.util.Arrays;

public class TheQueue {
	
	private String[] queueArray;
	private int queueSize;
	private int front, rear, noOfItems = 0;
	
	TheQueue(int size)
	{
		queueSize = size;
		queueArray = new String[size];
		Arrays.fill(queueArray, "-1");
	}
	
	public void insert(String input)
	{
		if( (noOfItems + 1) <= queueSize )
		{
			queueArray[rear] = input;
			rear++;
			noOfItems++;
			System.out.println("Item " + input + " was added.");
		}
		else
		{
			System.out.println("There is no space for added.");
		}
	}
	
	public void insertMany(String multipleValues)
	{
		String[] tempString = multipleValues.split(" ");
		int length = tempString.length;
		if((noOfItems+length)<queueSize)
		{
			for(int i = 0; i < length; i++)
			{
				insert(tempString[i]);
			}
			
		}
		else
		{
			System.out.println("There is no space for push String");
		}
	}
	
	public void remove()
	{
		if(noOfItems > 0)
		{
			System.out.println("Item " + queueArray[front] + " was removed.");
			queueArray[front] = "-1";
			front++;
			noOfItems--;
		}
	}
	
	public void removeAll()
	{
		for(int i = front; i <= queueSize; i++)
		{
			remove();
		}
	}
	
	public void display()
	{
		DisplayQueue displayQueue = new DisplayQueue();
		displayQueue.displayQueue(queueArray,queueSize);
	}
	
	public static void main(String[] arg)
	{
		TheQueue theQueue = new TheQueue(10);
		theQueue.insertMany("10 20 30 40");
		theQueue.display();
		theQueue.removeAll();
		theQueue.display();
	}

}
