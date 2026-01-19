import java.util.*;
public class Main
{
	public static int max0(Queue<Integer> q)
	{
		int max = 0;

		while (!q.isEmpty() && q.head() != 0)
		{
			int x = q.remove();
			if (x > max)
				max = x;
		}

		if (!q.isEmpty() && q.head() == 0)
			q.remove();

		return max;
	}



	public static Node<Integer> copyList(Queue<Integer> q)
	{
		Queue<Integer> c = copyQ(q);

		Node<Integer> p1 = new Node<>(-1);
		Node<Integer> p2 = p1;

		while (!c.isEmpty())
		{
			int x = max0(c);
			p2.setNext(new Node<>(x));
			p2 = p2.getNext();
		}

		return p1.getNext();
	}






	public static <T> Queue<T> copyQ(Queue<T> other)
	{
		Queue<T> copy = new Queue<>();
		Queue<T> temp = new Queue<>();

		while (!other.isEmpty())
		{
			T value = other.remove();
			copy.insert(value);
			temp.insert(value);
		}

		while (!temp.isEmpty())
		{
			other.insert(temp.remove());
		}

		return copy;
	}


	static Scanner reader=new Scanner(System.in);
	public static void main(String[] args)
	{
		Queue<Integer> q1=new Queue<>();
		q1.insert(10);
		q1.insert(37);
		q1.insert(0);
		q1.insert(63);
		q1.insert(0);
		q1.insert(2);
		q1.insert(7);
		q1.insert(13);
		q1.insert(0);
		q1.insert(11);
		q1.insert(23);
		System.out.println(copyList(q1));
	}
}
