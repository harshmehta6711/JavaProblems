import java.util.List;
import java.util.ArrayList;

public class QueueTest implements Comparable {
	List<Object> queueList;
	long first=0;
	int priority;
	QueueTest()
	{
		queueList=new ArrayList<Object>();
	}
	public void addItem(Object obj)
	{
		queueList.add(obj);
	}
	public Object removeItem()
	{		
		Object temp=queueList.get((int)first);
		queueList.remove(first);
		first++;
		return temp;		
	}
	public Object peekFirst()
	{
		Object temp=queueList.get((int)first);
		return temp;		
	}
	public Object peekLast()
	{
		int size=queueList.size();
		Object temp=queueList.get(size);
		return temp;
	}
	public void printAll()
	{
		for(int i=0;i<queueList.size();i++)
		{
			System.out.println(queueList.get(i));
		}
		for(int i=1;i<queueList.size();i++)
		{
			for(int j=i;j>0;j--)
			{
				Object obj1=queueList.get(j-1);
				Object obj2=queueList.get(i);
				if(((Comparable) obj1).compareTo(obj2)>0)
				{
					Object temp=obj1;
					obj1=obj2;
					obj2=temp;
				}
			}
		}
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
